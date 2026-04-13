package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.model.Residente;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ResidenteRepository {

    private static final String SQL_LISTAR =
            "SELECT id_usuario, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado "
                    + "FROM usuarios WHERE id_rol = ? ORDER BY nombres, apellidos";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT id_usuario, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado "
                    + "FROM usuarios WHERE id_usuario = ? AND id_rol = ?";

    private static final String SQL_BUSCAR_POR_CORREO =
            "SELECT id_usuario, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado "
                    + "FROM usuarios WHERE correo LIKE ? AND id_rol = ? ORDER BY nombres, apellidos";

    private static final String SQL_INSERTAR =
            "INSERT INTO usuarios (id_rol, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_ACTUALIZAR =
            "UPDATE usuarios SET nombres = ?, apellidos = ?, tipo_documento = ?, numero_documento = ?, "
                    + "correo = ?, password_hash = ?, telefono = ?, estado = ? "
                    + "WHERE id_usuario = ? AND id_rol = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM usuarios WHERE id_usuario = ? AND id_rol = ?";

    private static final String SQL_ID_ROL =
            "SELECT id_rol FROM roles WHERE nombre = 'RESIDENTE' LIMIT 1";

    private final JdbcTemplate jdbcTemplate;

    public ResidenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Residente> listarTodos() {
        return jdbcTemplate.query(SQL_LISTAR, rowMapper(), obtenerIdRolResidente());
    }

    public List<Residente> buscarPorCorreo(String correo) {
        String criterio = "%" + correo + "%";
        return jdbcTemplate.query(SQL_BUSCAR_POR_CORREO, rowMapper(), criterio, obtenerIdRolResidente());
    }

    public Optional<Residente> buscarPorId(Integer idUsuario) {
        List<Residente> resultados = jdbcTemplate.query(
                SQL_BUSCAR_POR_ID,
                rowMapper(),
                idUsuario,
                obtenerIdRolResidente()
        );
        return resultados.stream().findFirst();
    }

    public Residente guardar(Residente residente) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Integer idRolResidente = obtenerIdRolResidente();

        // Se captura el identificador generado para dejar el objeto listo para futuras operaciones.
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idRolResidente);
            preparedStatement.setString(2, residente.getNombres());
            preparedStatement.setString(3, residente.getApellidos());
            preparedStatement.setString(4, residente.getTipoDocumento());
            preparedStatement.setString(5, residente.getNumeroDocumento());
            preparedStatement.setString(6, residente.getCorreo());
            preparedStatement.setString(7, residente.getPasswordHash());
            preparedStatement.setString(8, residente.getTelefono());
            preparedStatement.setString(9, residente.getEstado());
            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            residente.setIdUsuario(keyHolder.getKey().intValue());
        }
        return residente;
    }

    public boolean actualizar(Residente residente) {
        int filas = jdbcTemplate.update(
                SQL_ACTUALIZAR,
                residente.getNombres(),
                residente.getApellidos(),
                residente.getTipoDocumento(),
                residente.getNumeroDocumento(),
                residente.getCorreo(),
                residente.getPasswordHash(),
                residente.getTelefono(),
                residente.getEstado(),
                residente.getIdUsuario(),
                obtenerIdRolResidente()
        );
        return filas > 0;
    }

    public boolean eliminar(Integer idUsuario) {
        int filas = jdbcTemplate.update(SQL_ELIMINAR, idUsuario, obtenerIdRolResidente());
        return filas > 0;
    }

    private Integer obtenerIdRolResidente() {
        return jdbcTemplate.queryForObject(SQL_ID_ROL, Integer.class);
    }

    private BeanPropertyRowMapper<Residente> rowMapper() {
        return new BeanPropertyRowMapper<Residente>(Residente.class);
    }
}
