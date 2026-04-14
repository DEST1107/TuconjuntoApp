package com.tuconjuntoapp.framework.config;

import javax.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    private static final String SQL_CREAR_TABLA_RESERVAS =
            "CREATE TABLE IF NOT EXISTS reservas ("
                    + "id_reserva INT AUTO_INCREMENT PRIMARY KEY, "
                    + "id_usuario INT NOT NULL, "
                    + "area_comun VARCHAR(60) NOT NULL, "
                    + "fecha_reserva DATE NOT NULL, "
                    + "hora_reserva TIME NOT NULL, "
                    + "estado ENUM('PENDIENTE', 'APROBADA', 'RECHAZADA', 'CANCELADA') NOT NULL DEFAULT 'PENDIENTE', "
                    + "observaciones VARCHAR(200) NULL, "
                    + "fecha_solicitud DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                    + "CONSTRAINT fk_reservas_usuarios "
                    + "FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario) "
                    + "ON UPDATE CASCADE ON DELETE RESTRICT"
                    + ") ENGINE=InnoDB";

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initialize() {
        // Se asegura la tabla de reservas porque este modulo no estaba en el esquema base inicial.
        jdbcTemplate.execute(SQL_CREAR_TABLA_RESERVAS);
    }
}
