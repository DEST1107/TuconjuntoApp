CREATE TABLE IF NOT EXISTS reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    area_comun VARCHAR(60) NOT NULL,
    fecha_reserva DATE NOT NULL,
    hora_reserva TIME NOT NULL,
    estado ENUM('PENDIENTE', 'APROBADA', 'RECHAZADA', 'CANCELADA') NOT NULL DEFAULT 'PENDIENTE',
    observaciones VARCHAR(200) NULL,
    fecha_solicitud DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_reservas_usuarios
        FOREIGN KEY (id_usuario)
        REFERENCES usuarios (id_usuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;
