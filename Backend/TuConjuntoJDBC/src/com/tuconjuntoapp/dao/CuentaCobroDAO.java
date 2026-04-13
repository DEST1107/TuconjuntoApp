package com.tuconjuntoapp.dao;

import com.tuconjuntoapp.config.ConexionDB;
import com.tuconjuntoapp.model.CuentaCobroResumen;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaCobroDAO {

    private static final String SQL_LISTAR_PENDIENTES_POR_USUARIO =
            "SELECT cc.id_cuenta_cobro, cp.nombre AS concepto, cc.periodo, "
                    + "cc.fecha_vencimiento, cc.valor_total, cc.saldo_pendiente, cc.estado "
                    + "FROM cuentas_cobro cc "
                    + "INNER JOIN conceptos_pago cp ON cp.id_concepto = cc.id_concepto "
                    + "INNER JOIN apartamentos a ON a.id_apartamento = cc.id_apartamento "
                    + "INNER JOIN usuarios_apartamentos ua ON ua.id_apartamento = a.id_apartamento "
                    + "WHERE ua.id_usuario = ? "
                    + "AND (ua.fecha_fin IS NULL OR ua.fecha_fin >= CURRENT_DATE) "
                    + "ORDER BY cc.fecha_vencimiento ASC";

    public List<CuentaCobroResumen> listarPendientesPorUsuario(int idUsuario) {
        List<CuentaCobroResumen> cuentas = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_LISTAR_PENDIENTES_POR_USUARIO)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cuentas.add(mapearCuenta(rs));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible listar las cuentas de cobro del residente", e);
        }

        return cuentas;
    }

    private CuentaCobroResumen mapearCuenta(ResultSet rs) throws SQLException {
        CuentaCobroResumen cuenta = new CuentaCobroResumen();
        cuenta.setIdCuentaCobro(rs.getInt("id_cuenta_cobro"));
        cuenta.setConcepto(rs.getString("concepto"));

        Date periodo = rs.getDate("periodo");
        if (periodo != null) {
            cuenta.setPeriodo(periodo.toLocalDate());
        }

        Date fechaVencimiento = rs.getDate("fecha_vencimiento");
        if (fechaVencimiento != null) {
            cuenta.setFechaVencimiento(fechaVencimiento.toLocalDate());
        }

        cuenta.setValorTotal(rs.getBigDecimal("valor_total"));
        cuenta.setSaldoPendiente(rs.getBigDecimal("saldo_pendiente"));
        cuenta.setEstado(rs.getString("estado"));
        return cuenta;
    }
}
