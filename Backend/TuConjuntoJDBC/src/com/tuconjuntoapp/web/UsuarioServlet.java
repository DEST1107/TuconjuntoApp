package com.tuconjuntoapp.web;

import com.tuconjuntoapp.dao.UsuarioDAO;
import com.tuconjuntoapp.model.Usuario;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/residentes")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("nuevo".equalsIgnoreCase(accion)) {
            mostrarFormulario(request, response, new Usuario(), "Registrar residente");
            return;
        }

        if ("editar".equalsIgnoreCase(accion)) {
            editarResidente(request, response);
            return;
        }

        listarResidentes(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("eliminar".equalsIgnoreCase(accion)) {
            eliminarResidente(request, response);
            return;
        }

        guardarResidente(request, response);
    }

    private void listarResidentes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = limpiar(request.getParameter("correo"));
        List<Usuario> residentes = new ArrayList<>();

        if (correo == null || correo.isEmpty()) {
            residentes = usuarioDAO.listarResidentes();
        } else {
            Optional<Usuario> residente = usuarioDAO.buscarPorCorreo(correo);
            residente.ifPresent(residentes::add);
            request.setAttribute("correoBuscado", correo);
        }

        request.setAttribute("residentes", residentes);
        request.setAttribute("mensaje", request.getParameter("mensaje"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/usuarios/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void editarResidente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = parseEntero(request.getParameter("id"));
        Optional<Usuario> usuario = usuarioDAO.buscarPorId(idUsuario);

        if (!usuario.isPresent()) {
            redirigirConMensaje(response, request, "No se encontro el residente solicitado.");
            return;
        }

        mostrarFormulario(request, response, usuario.get(), "Editar residente");
    }

    private void guardarResidente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = construirUsuarioDesdeFormulario(request);

        if (!validarUsuario(usuario)) {
            request.setAttribute("error", "Todos los campos obligatorios deben estar diligenciados.");
            request.setAttribute("tituloFormulario",
                    usuario.getIdUsuario() > 0 ? "Editar residente" : "Registrar residente");
            request.setAttribute("usuario", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/usuarios/formulario.jsp");
            dispatcher.forward(request, response);
            return;
        }

        boolean exito;
        if (usuario.getIdUsuario() > 0) {
            exito = usuarioDAO.actualizarResidente(usuario);
            redirigirConMensaje(response, request,
                    exito ? "Residente actualizado correctamente." : "No fue posible actualizar el residente.");
            return;
        }

        exito = usuarioDAO.registrarResidente(usuario);
        redirigirConMensaje(response, request,
                exito ? "Residente registrado correctamente." : "No fue posible registrar el residente.");
    }

    private void eliminarResidente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idUsuario = parseEntero(request.getParameter("id"));
        boolean eliminado = usuarioDAO.eliminarPorId(idUsuario);

        redirigirConMensaje(response, request,
                eliminado ? "Residente eliminado correctamente." : "No fue posible eliminar el residente.");
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response,
                                   Usuario usuario, String titulo)
            throws ServletException, IOException {
        request.setAttribute("usuario", usuario);
        request.setAttribute("tituloFormulario", titulo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/usuarios/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private Usuario construirUsuarioDesdeFormulario(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(parseEntero(request.getParameter("idUsuario")));
        usuario.setNombres(limpiar(request.getParameter("nombres")));
        usuario.setApellidos(limpiar(request.getParameter("apellidos")));
        usuario.setTipoDocumento(limpiar(request.getParameter("tipoDocumento")));
        usuario.setNumeroDocumento(limpiar(request.getParameter("numeroDocumento")));
        usuario.setCorreo(limpiar(request.getParameter("correo")));
        usuario.setPasswordHash(limpiar(request.getParameter("passwordHash")));
        usuario.setTelefono(limpiar(request.getParameter("telefono")));
        usuario.setEstado(limpiar(request.getParameter("estado")));
        return usuario;
    }

    private boolean validarUsuario(Usuario usuario) {
        return usuario.getNombres() != null
                && !usuario.getNombres().isEmpty()
                && usuario.getApellidos() != null
                && !usuario.getApellidos().isEmpty()
                && usuario.getTipoDocumento() != null
                && !usuario.getTipoDocumento().isEmpty()
                && usuario.getNumeroDocumento() != null
                && !usuario.getNumeroDocumento().isEmpty()
                && usuario.getCorreo() != null
                && !usuario.getCorreo().isEmpty()
                && usuario.getPasswordHash() != null
                && !usuario.getPasswordHash().isEmpty();
    }

    private int parseEntero(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(valor.trim());
    }

    private String limpiar(String valor) {
        return valor == null ? null : valor.trim();
    }

    private void redirigirConMensaje(HttpServletResponse response, HttpServletRequest request, String mensaje)
            throws IOException {
        response.sendRedirect(request.getContextPath() + "/residentes?mensaje="
                + URLEncoder.encode(mensaje, "UTF-8"));
    }
}
