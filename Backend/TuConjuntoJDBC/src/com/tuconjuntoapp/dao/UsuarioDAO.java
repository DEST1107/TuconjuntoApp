package com.tuconjuntoapp.dao;

import com.tuconjuntoapp.config.ConexionDB;
import com.tuconjuntoapp.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO usuarios ("
                    + "id_rol, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_BUSCAR_POR_CORREO =
            "SELECT id_usuario, id_rol, nombres, apellidos, tipo_documento, "
                    + "numero_documento, correo, password_hash, telefono, estado "
                    + "FROM usuarios WHERE correo = ?";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT id_usuario, id_rol, nombres, apellidos, tipo_documento, "
                    + "numero_documento, correo, password_hash, telefono, estado "
                    + "FROM usuarios WHERE id_usuario = ?";

    private static final String SQL_LISTAR_POR_ROL =
            "SELECT u.id_usuario, u.id_rol, u.nombres, u.apellidos, u.tipo_documento, "
                    + "u.numero_documento, u.correo, u.password_hash, u.telefono, u.estado "
                    + "FROM usuarios u "
                    + "INNER JOIN roles r ON r.id_rol = u.id_rol "
                    + "WHERE r.nombre = ? "
                    + "ORDER BY u.nombres, u.apellidos";

    private static final String SQL_ACTUALIZAR =
            "UPDATE usuarios SET id_rol = ?, nombres = ?, apellidos = ?, tipo_documento = ?, "
                    + "numero_documento = ?, correo = ?, password_hash = ?, telefono = ?, estado = ? "
                    + "WHERE id_usuario = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM usuarios WHERE id_usuario = ?";

    private static final String SQL_BUSCAR_ID_ROL =
            "SELECT id_rol FROM roles WHERE nombre = ?";

    public boolean registrarResidente(Usuario usuario) {
        try {
            usuario.setIdRol(buscarIdRol("RESIDENTE"));
            usuario.setEstado(usuario.getEstado() == null ? "ACTIVO" : usuario.getEstado());
            return registrar(usuario);
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible registrar el residente", e);
        }
    }

    public boolean actualizarResidente(Usuario usuario) {
        try {
            usuario.setIdRol(buscarIdRol("RESIDENTE"));
            usuario.setEstado(usuario.getEstado() == null ? "ACTIVO" : usuario.getEstado());
            return actualizarUsuario(usuario);
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible actualizar el residente", e);
        }
    }

    public boolean registrar(Usuario usuario) throws SQLException {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, usuario.getIdRol());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getTipoDocumento());
            ps.setString(5, usuario.getNumeroDocumento());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getPasswordHash());
            ps.setString(8, usuario.getTelefono());
            ps.setString(9, usuario.getEstado());

            boolean insertado = ps.executeUpdate() > 0;

            if (insertado) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        usuario.setIdUsuario(generatedKeys.getInt(1));
                    }
                }
            }

            return insertado;
        }
    }

    public Optional<Usuario> buscarPorId(int idUsuario) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_BUSCAR_POR_ID)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible consultar el usuario por identificador", e);
        }

        return Optional.empty();
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_BUSCAR_POR_CORREO)) {

            ps.setString(1, correo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible consultar el usuario por correo", e);
        }

        return Optional.empty();
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_ACTUALIZAR)) {

            ps.setInt(1, usuario.getIdRol());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getTipoDocumento());
            ps.setString(5, usuario.getNumeroDocumento());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getPasswordHash());
            ps.setString(8, usuario.getTelefono());
            ps.setString(9, usuario.getEstado());
            ps.setInt(10, usuario.getIdUsuario());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible actualizar el usuario", e);
        }
    }

    public boolean eliminarPorId(int idUsuario) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_ELIMINAR)) {

            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible eliminar el usuario", e);
        }
    }

    public int obtenerIdRolPorNombre(String nombreRol) {
        try {
            return buscarIdRol(nombreRol);
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible consultar el rol solicitado", e);
        }
    }

    public List<Usuario> listarResidentes() {
        return listarPorRol("RESIDENTE");
    }

    public List<Usuario> listarPorRol(String nombreRol) {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_LISTAR_POR_ROL)) {

            ps.setString(1, nombreRol);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(mapearUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible listar usuarios", e);
        }

        return usuarios;
    }

    private int buscarIdRol(String nombreRol) throws SQLException {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_BUSCAR_ID_ROL)) {

            ps.setString(1, nombreRol);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_rol");
                }
            }
        }

        throw new SQLException("El rol " + nombreRol + " no existe en la base de datos");
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));
        usuario.setIdRol(rs.getInt("id_rol"));
        usuario.setNombres(rs.getString("nombres"));
        usuario.setApellidos(rs.getString("apellidos"));
        usuario.setTipoDocumento(rs.getString("tipo_documento"));
        usuario.setNumeroDocumento(rs.getString("numero_documento"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setPasswordHash(rs.getString("password_hash"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setEstado(rs.getString("estado"));
        return usuario;
    }
}
