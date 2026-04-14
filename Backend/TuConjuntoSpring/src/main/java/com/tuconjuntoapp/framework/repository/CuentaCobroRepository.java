package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.model.CuentaCobro;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaCobroRepository {

    private static final String SQL_BASE =
            "SELECT cc.id_cuenta_cobro, cc.id_apartamento, cc.id_concepto, cp.nombre AS concepto, "
                    + "cc.periodo, cc.fecha_emision, cc.fecha_vencimiento, cc.valor_total, "
                    + "cc.saldo_pendiente, cc.estado, cc.observaciones "
                    + "FROM cuentas_cobro cc "
                    + "INNER JOIN conceptos_pago cp ON cc.id_concepto = cp.id_concepto ";

    private static final String SQL_LISTAR =
            SQL_BASE + "ORDER BY cc.periodo DESC, cc.fecha_vencimiento DESC";

    private static final String SQL_BUSCAR_POR_ID =
            SQL_BASE + "WHERE cc.id_cuenta_cobro = ?";

    private static final String SQL_BUSCAR_POR_APARTAMENTO =
            SQL_BASE + "WHERE cc.id_apartamento = ? ORDER BY cc.periodo DESC, cc.fecha_vencimiento DESC";

    private final JdbcTemplate jdbcTemplate;

    public CuentaCobroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CuentaCobro> listarTodas() {
        return jdbcTemplate.query(SQL_LISTAR, rowMapper());
    }

    public List<CuentaCobro> listarPorApartamento(Integer idApartamento) {
        return jdbcTemplate.query(SQL_BUSCAR_POR_APARTAMENTO, rowMapper(), idApartamento);
    }

    public Optional<CuentaCobro> buscarPorId(Integer idCuentaCobro) {
        List<CuentaCobro> resultados = jdbcTemplate.query(SQL_BUSCAR_POR_ID, rowMapper(), idCuentaCobro);
        return resultados.stream().findFirst();
    }

    private BeanPropertyRowMapper<CuentaCobro> rowMapper() {
        return new BeanPropertyRowMapper<CuentaCobro>(CuentaCobro.class);
    }
}
