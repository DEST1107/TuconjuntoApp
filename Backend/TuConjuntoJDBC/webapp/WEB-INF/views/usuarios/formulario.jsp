<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.tuconjuntoapp.model.Usuario" %>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario == null) {
        usuario = new Usuario();
    }
    String tituloFormulario = (String) request.getAttribute("tituloFormulario");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= tituloFormulario %></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background: #f4f6f8; color: #22303a; }
        .container { max-width: 760px; margin: 0 auto; padding: 32px 20px 40px; }
        .panel { background: #ffffff; border-radius: 18px; padding: 24px; box-shadow: 0 10px 28px rgba(34,48,58,.08); }
        .actions, .grid { display: grid; gap: 16px; }
        .grid { grid-template-columns: repeat(2, minmax(0, 1fr)); }
        input, select, button { padding: 12px 14px; border-radius: 10px; border: 1px solid #cfd8df; font: inherit; width: 100%; }
        button, .back-link { background: #0f766e; color: #fff; border: none; text-decoration: none; display: inline-flex; align-items: center; justify-content: center; }
        .back-link { width: 160px; }
        .error { background: #fdecec; color: #b73f3f; padding: 12px 16px; border-radius: 12px; margin-bottom: 18px; }
        .full { grid-column: 1 / -1; }
        label { display: block; margin-bottom: 8px; font-weight: bold; }
        .header { display: flex; justify-content: space-between; align-items: center; gap: 16px; margin-bottom: 24px; }
        @media (max-width: 700px) { .grid { grid-template-columns: 1fr; } }
    </style>
</head>
<body>
    <div class="container">
        <div class="panel">
            <div class="header">
                <div>
                    <p>Formulario HTML conectado a Servlet</p>
                    <h1><%= tituloFormulario %></h1>
                </div>
                <a class="back-link" href="<%= request.getContextPath() %>/residentes">Volver</a>
            </div>

            <% if (error != null && !error.isEmpty()) { %>
                <div class="error"><%= error %></div>
            <% } %>

            <form method="post" action="<%= request.getContextPath() %>/residentes">
                <input type="hidden" name="accion" value="guardar">
                <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">

                <div class="grid">
                    <div>
                        <label for="nombres">Nombres</label>
                        <input id="nombres" name="nombres" type="text" required
                               value="<%= usuario.getNombres() == null ? "" : usuario.getNombres() %>">
                    </div>
                    <div>
                        <label for="apellidos">Apellidos</label>
                        <input id="apellidos" name="apellidos" type="text" required
                               value="<%= usuario.getApellidos() == null ? "" : usuario.getApellidos() %>">
                    </div>
                    <div>
                        <label for="tipoDocumento">Tipo de documento</label>
                        <select id="tipoDocumento" name="tipoDocumento" required>
                            <option value="CC" <%= "CC".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>CC</option>
                            <option value="CE" <%= "CE".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>CE</option>
                            <option value="TI" <%= "TI".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>TI</option>
                            <option value="PASAPORTE" <%= "PASAPORTE".equals(usuario.getTipoDocumento()) ? "selected" : "" %>>PASAPORTE</option>
                        </select>
                    </div>
                    <div>
                        <label for="numeroDocumento">Numero de documento</label>
                        <input id="numeroDocumento" name="numeroDocumento" type="text" required
                               value="<%= usuario.getNumeroDocumento() == null ? "" : usuario.getNumeroDocumento() %>">
                    </div>
                    <div>
                        <label for="correo">Correo</label>
                        <input id="correo" name="correo" type="email" required
                               value="<%= usuario.getCorreo() == null ? "" : usuario.getCorreo() %>">
                    </div>
                    <div>
                        <label for="telefono">Telefono</label>
                        <input id="telefono" name="telefono" type="text"
                               value="<%= usuario.getTelefono() == null ? "" : usuario.getTelefono() %>">
                    </div>
                    <div>
                        <label for="passwordHash">Contrasena</label>
                        <input id="passwordHash" name="passwordHash" type="text" required
                               value="<%= usuario.getPasswordHash() == null ? "" : usuario.getPasswordHash() %>">
                    </div>
                    <div>
                        <label for="estado">Estado</label>
                        <select id="estado" name="estado">
                            <option value="ACTIVO" <%= "ACTIVO".equals(usuario.getEstado()) ? "selected" : "" %>>ACTIVO</option>
                            <option value="INACTIVO" <%= "INACTIVO".equals(usuario.getEstado()) ? "selected" : "" %>>INACTIVO</option>
                            <option value="BLOQUEADO" <%= "BLOQUEADO".equals(usuario.getEstado()) ? "selected" : "" %>>BLOQUEADO</option>
                        </select>
                    </div>
                    <div class="full">
                        <button type="submit">Guardar residente</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
