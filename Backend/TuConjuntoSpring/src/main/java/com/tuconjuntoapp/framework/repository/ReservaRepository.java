package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.model.Reserva;
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
public class ReservaRepository {

    private static final String SQL_LISTAR =
            "SELECT id_reserva, id_usuario, area_comun, fecha_reserva, hora_reserva, estado, "
                    + "observaciones, fecha_solicitud FROM reservas ORDER BY fecha_reserva, hora_reserva";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT id_reserva, id_usuario, area_comun, fecha_reserva, hora_reserva, estado, "
                    + "observaciones, fecha_solicitud FROM reservas WHERE id_reserva = ?";

    private static final String SQL_INSERTAR =
            "INSERT INTO reservas (id_usuario, area_comun, fecha_reserva, hora_reserva, estado, observaciones, fecha_solicitud) "
                    + "VALUES (?, ?, ?, ?, ?, ?, NOW())";

    private static final String SQL_ACTUALIZAR =
            "UPDATE reservas SET id_usuario = ?, area_comun = ?, fecha_reserva = ?, hora_reserva = ?, "
                    + "estado = ?, observaciones = ? WHERE id_reserva = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM reservas WHERE id_reserva = ?";

    private final JdbcTemplate jdbcTemplate;

    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reserva> listarTodas() {
        return jdbcTemplate.query(SQL_LISTAR, rowMapper());
    }

    public Optional<Reserva> buscarPorId(Integer idReserva) {
        List<Reserva> resultados = jdbcTemplate.query(SQL_BUSCAR_POR_ID, rowMapper(), idReserva);
        return resultados.stream().findFirst();
    }

    public Reserva guardar(Reserva reserva) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reserva.getIdUsuario());
            preparedStatement.setString(2, reserva.getAreaComun());
            preparedStatement.setObject(3, reserva.getFechaReserva());
            preparedStatement.setObject(4, reserva.getHoraReserva());
            preparedStatement.setString(5, reserva.getEstado());
            preparedStatement.setString(6, reserva.getObservaciones());
            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            reserva.setIdReserva(keyHolder.getKey().intValue());
        }
        return reserva;
    }

    public boolean actualizar(Reserva reserva) {
        int filas = jdbcTemplate.update(
                SQL_ACTUALIZAR,
                reserva.getIdUsuario(),
                reserva.getAreaComun(),
                reserva.getFechaReserva(),
                reserva.getHoraReserva(),
                reserva.getEstado(),
                reserva.getObservaciones(),
                reserva.getIdReserva()
        );
        return filas > 0;
    }

    public boolean eliminar(Integer idReserva) {
        return jdbcTemplate.update(SQL_ELIMINAR, idReserva) > 0;
    }

    private BeanPropertyRowMapper<Reserva> rowMapper() {
        return new BeanPropertyRowMapper<Reserva>(Reserva.class);
    }
}
