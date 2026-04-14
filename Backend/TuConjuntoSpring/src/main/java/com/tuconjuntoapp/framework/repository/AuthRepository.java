package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.dto.AuthRegisterRequest;
import com.tuconjuntoapp.framework.model.UsuarioAuth;
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
public class AuthRepository {

    private static final String SQL_BUSCAR_POR_CORREO =
            "SELECT id_usuario, correo, password_hash, estado FROM usuarios WHERE correo = ? LIMIT 1";

    private static final String SQL_EXISTE_CORREO =
            "SELECT COUNT(*) FROM usuarios WHERE correo = ?";

    private static final String SQL_EXISTE_DOCUMENTO =
            "SELECT COUNT(*) FROM usuarios WHERE numero_documento = ?";

    private static final String SQL_INSERTAR =
            "INSERT INTO usuarios (id_rol, nombres, apellidos, tipo_documento, numero_documento, "
                    + "correo, password_hash, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'ACTIVO')";

    private static final String SQL_ID_ROL_RESIDENTE =
            "SELECT id_rol FROM roles WHERE nombre = 'RESIDENTE' LIMIT 1";

    private final JdbcTemplate jdbcTemplate;

    public AuthRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<UsuarioAuth> buscarPorCorreo(String correo) {
        List<UsuarioAuth> resultados = jdbcTemplate.query(
                SQL_BUSCAR_POR_CORREO,
                new BeanPropertyRowMapper<UsuarioAuth>(UsuarioAuth.class),
                correo
        );
        return resultados.stream().findFirst();
    }

    public boolean existeCorreo(String correo) {
        Integer cantidad = jdbcTemplate.queryForObject(SQL_EXISTE_CORREO, Integer.class, correo);
        return cantidad != null && cantidad > 0;
    }

    public boolean existeDocumento(String numeroDocumento) {
        Integer cantidad = jdbcTemplate.queryForObject(SQL_EXISTE_DOCUMENTO, Integer.class, numeroDocumento);
        return cantidad != null && cantidad > 0;
    }

    public Integer registrar(AuthRegisterRequest request, String passwordHash) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Se usa rol residente porque este es el primer modulo funcional del proyecto.
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, obtenerIdRolResidente());
            preparedStatement.setString(2, request.getNombres());
            preparedStatement.setString(3, request.getApellidos());
            preparedStatement.setString(4, request.getTipoDocumento());
            preparedStatement.setString(5, request.getNumeroDocumento());
            preparedStatement.setString(6, request.getUsuario());
            preparedStatement.setString(7, passwordHash);
            preparedStatement.setString(8, request.getTelefono());
            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : null;
    }

    private Integer obtenerIdRolResidente() {
        return jdbcTemplate.queryForObject(SQL_ID_ROL_RESIDENTE, Integer.class);
    }
}
