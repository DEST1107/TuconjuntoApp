package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.model.Incidencia;
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
public class IncidenciaRepository {

    private static final String SQL_LISTAR =
            "SELECT id_incidencia, id_usuario_reporta, id_apartamento, categoria, titulo, descripcion, "
                    + "prioridad, estado, ubicacion, fecha_reporte, fecha_cierre "
                    + "FROM incidencias ORDER BY fecha_reporte DESC";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT id_incidencia, id_usuario_reporta, id_apartamento, categoria, titulo, descripcion, "
                    + "prioridad, estado, ubicacion, fecha_reporte, fecha_cierre "
                    + "FROM incidencias WHERE id_incidencia = ?";

    private static final String SQL_INSERTAR =
            "INSERT INTO incidencias (id_usuario_reporta, id_apartamento, categoria, titulo, descripcion, "
                    + "prioridad, estado, ubicacion, fecha_reporte, fecha_cierre) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";

    private static final String SQL_ACTUALIZAR =
            "UPDATE incidencias SET id_usuario_reporta = ?, id_apartamento = ?, categoria = ?, titulo = ?, "
                    + "descripcion = ?, prioridad = ?, estado = ?, ubicacion = ?, fecha_cierre = ? "
                    + "WHERE id_incidencia = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM incidencias WHERE id_incidencia = ?";

    private final JdbcTemplate jdbcTemplate;

    public IncidenciaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Incidencia> listarTodas() {
        return jdbcTemplate.query(SQL_LISTAR, rowMapper());
    }

    public Optional<Incidencia> buscarPorId(Integer idIncidencia) {
        List<Incidencia> resultados = jdbcTemplate.query(SQL_BUSCAR_POR_ID, rowMapper(), idIncidencia);
        return resultados.stream().findFirst();
    }

    public Incidencia guardar(Incidencia incidencia) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, incidencia.getIdUsuarioReporta());
            preparedStatement.setObject(2, incidencia.getIdApartamento());
            preparedStatement.setString(3, incidencia.getCategoria());
            preparedStatement.setString(4, incidencia.getTitulo());
            preparedStatement.setString(5, incidencia.getDescripcion());
            preparedStatement.setString(6, incidencia.getPrioridad());
            preparedStatement.setString(7, incidencia.getEstado());
            preparedStatement.setString(8, incidencia.getUbicacion());
            preparedStatement.setObject(9, incidencia.getFechaCierre());
            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            incidencia.setIdIncidencia(keyHolder.getKey().intValue());
        }
        return incidencia;
    }

    public boolean actualizar(Incidencia incidencia) {
        int filas = jdbcTemplate.update(
                SQL_ACTUALIZAR,
                incidencia.getIdUsuarioReporta(),
                incidencia.getIdApartamento(),
                incidencia.getCategoria(),
                incidencia.getTitulo(),
                incidencia.getDescripcion(),
                incidencia.getPrioridad(),
                incidencia.getEstado(),
                incidencia.getUbicacion(),
                incidencia.getFechaCierre(),
                incidencia.getIdIncidencia()
        );
        return filas > 0;
    }

    public boolean eliminar(Integer idIncidencia) {
        return jdbcTemplate.update(SQL_ELIMINAR, idIncidencia) > 0;
    }

    private BeanPropertyRowMapper<Incidencia> rowMapper() {
        return new BeanPropertyRowMapper<Incidencia>(Incidencia.class);
    }
}
