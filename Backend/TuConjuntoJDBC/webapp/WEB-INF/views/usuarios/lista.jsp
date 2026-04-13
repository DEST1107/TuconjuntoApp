<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tuconjuntoapp.model.Usuario" %>
<%
    List<Usuario> residentes = (List<Usuario>) request.getAttribute("residentes");
    String mensaje = (String) request.getAttribute("mensaje");
    String correoBuscado = (String) request.getAttribute("correoBuscado");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Residentes</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background: #f4f6f8; color: #22303a; }
        .container { max-width: 1100px; margin: 0 auto; padding: 32px 20px 40px; }
        .panel { background: #ffffff; border-radius: 18px; padding: 24px; box-shadow: 0 10px 28px rgba(34,48,58,.08); }
        .header { display: flex; justify-content: space-between; align-items: center; gap: 16px; margin-bottom: 24px; }
        .header h1 { margin: 0; }
        .actions, .search-form { display: flex; gap: 12px; flex-wrap: wrap; }
        input, select, button { padding: 12px 14px; border-radius: 10px; border: 1px solid #cfd8df; font: inherit; }
        button, .link-btn { background: #0f766e; color: #fff; border: none; text-decoration: none; display: inline-flex; align-items: center; justify-content: center; }
        .secondary { background: #ffffff; color: #22303a; border: 1px solid #cfd8df; }
        table { width: 100%; border-collapse: collapse; margin-top: 18px; }
        th, td { padding: 14px 10px; border-bottom: 1px solid #e6ebef; text-align: left; }
        th { color: #54636c; font-size: 12px; text-transform: uppercase; letter-spacing: .06em; }
        .message { background: #e7f7f2; color: #0f766e; padding: 12px 16px; border-radius: 12px; margin-bottom: 18px; }
        .row-actions { display: flex; gap: 8px; }
        .row-actions form { margin: 0; }
    </style>
</head>
<body>
    <div class="container">
        <div class="panel">
            <div class="header">
                <div>
                    <p>Modulo web con Servlet, JSP y JDBC</p>
                    <h1>Gestion de Residentes</h1>
                </div>
                <a class="link-btn" href="<%= request.getContextPath() %>/residentes?accion=nuevo">Nuevo residente</a>
            </div>

            <% if (mensaje != null && !mensaje.isEmpty()) { %>
                <div class="message"><%= mensaje %></div>
            <% } %>

            <form class="search-form" method="get" action="<%= request.getContextPath() %>/residentes">
                <input type="text" name="correo" placeholder="Buscar por correo"
                       value="<%= correoBuscado == null ? "" : correoBuscado %>">
                <button type="submit">Buscar</button>
                <a class="link-btn secondary" href="<%= request.getContextPath() %>/residentes">Limpiar</a>
            </form>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Documento</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <% if (residentes == null || residentes.isEmpty()) { %>
                    <tr>
                        <td colspan="8">No se encontraron residentes registrados.</td>
                    </tr>
                <% } else { %>
                    <% for (Usuario residente : residentes) { %>
                        <tr>
                            <td><%= residente.getIdUsuario() %></td>
                            <td><%= residente.getNombres() %></td>
                            <td><%= residente.getApellidos() %></td>
                            <td><%= residente.getTipoDocumento() %> - <%= residente.getNumeroDocumento() %></td>
                            <td><%= residente.getCorreo() %></td>
                            <td><%= residente.getTelefono() == null ? "" : residente.getTelefono() %></td>
                            <td><%= residente.getEstado() %></td>
                            <td>
                                <div class="row-actions">
                                    <a class="link-btn secondary"
                                       href="<%= request.getContextPath() %>/residentes?accion=editar&id=<%= residente.getIdUsuario() %>">
                                        Editar
                                    </a>
                                    <form method="post" action="<%= request.getContextPath() %>/residentes">
                                        <input type="hidden" name="accion" value="eliminar">
                                        <input type="hidden" name="id" value="<%= residente.getIdUsuario() %>">
                                        <button type="submit">Eliminar</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    <% } %>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
