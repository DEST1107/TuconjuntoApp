package com.tuconjuntoapp;

import com.tuconjuntoapp.dao.UsuarioDAO;
import com.tuconjuntoapp.model.Usuario;
import java.util.List;
import java.util.Optional;

public class TestCrudUsuario {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String sufijo = String.valueOf(System.currentTimeMillis());
        Usuario usuario = new Usuario(
                "Residente",
                "Prueba",
                "CC",
                "DOC" + sufijo,
                "residente" + sufijo + "@example.com",
                "1234",
                "3001112233",
                "ACTIVO"
        );

        boolean insertado = usuarioDAO.registrarResidente(usuario);
        System.out.println("Insercion realizada: " + insertado + " | id generado: " + usuario.getIdUsuario());

        Optional<Usuario> usuarioEncontrado = usuarioDAO.buscarPorId(usuario.getIdUsuario());
        System.out.println("Consulta por id: " + usuarioEncontrado.orElse(null));

        usuario.setTelefono("3009998877");
        usuario.setEstado("INACTIVO");
        boolean actualizado = usuarioDAO.actualizarUsuario(usuario);
        System.out.println("Actualizacion realizada: " + actualizado);

        List<Usuario> residentes = usuarioDAO.listarResidentes();
        System.out.println("Total residentes consultados: " + residentes.size());

        boolean eliminado = usuarioDAO.eliminarPorId(usuario.getIdUsuario());
        System.out.println("Eliminacion realizada: " + eliminado);
    }
}
