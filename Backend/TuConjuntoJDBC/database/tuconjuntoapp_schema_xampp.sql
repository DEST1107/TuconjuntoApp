DROP DATABASE IF EXISTS tuconjuntoapp;

CREATE DATABASE tuconjuntoapp
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE tuconjuntoapp;

CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(120) NULL,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL DEFAULT 'ACTIVO',
    CONSTRAINT uq_roles_nombre UNIQUE (nombre)
) ENGINE=InnoDB;

CREATE TABLE conjuntos (
    id_conjunto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) NULL,
    direccion VARCHAR(150) NOT NULL,
    ciudad VARCHAR(60) NOT NULL,
    telefono VARCHAR(20) NULL,
    email_contacto VARCHAR(100) NULL,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL DEFAULT 'ACTIVO',
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_conjuntos_nombre UNIQUE (nombre),
    CONSTRAINT uq_conjuntos_nit UNIQUE (nit)
) ENGINE=InnoDB;

CREATE TABLE torres (
    id_torre INT AUTO_INCREMENT PRIMARY KEY,
    id_conjunto INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    cantidad_pisos INT NOT NULL DEFAULT 1,
    estado ENUM('ACTIVA', 'INACTIVA') NOT NULL DEFAULT 'ACTIVA',
    CONSTRAINT uq_torres_nombre UNIQUE (id_conjunto, nombre),
    CONSTRAINT fk_torres_conjuntos
        FOREIGN KEY (id_conjunto)
        REFERENCES conjuntos (id_conjunto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE apartamentos (
    id_apartamento INT AUTO_INCREMENT PRIMARY KEY,
    id_torre INT NOT NULL,
    numero VARCHAR(10) NOT NULL,
    piso INT NOT NULL,
    coeficiente DECIMAL(6,2) NOT NULL DEFAULT 0.00,
    estado ENUM('DISPONIBLE', 'OCUPADO', 'INACTIVO') NOT NULL DEFAULT 'DISPONIBLE',
    CONSTRAINT uq_apartamentos_numero UNIQUE (id_torre, numero),
    CONSTRAINT fk_apartamentos_torres
        FOREIGN KEY (id_torre)
        REFERENCES torres (id_torre)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    id_rol INT NOT NULL,
    nombres VARCHAR(60) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,
    tipo_documento ENUM('CC', 'CE', 'TI', 'PASAPORTE') NOT NULL DEFAULT 'CC',
    numero_documento VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NULL,
    estado ENUM('ACTIVO', 'INACTIVO', 'BLOQUEADO') NOT NULL DEFAULT 'ACTIVO',
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ultimo_acceso DATETIME NULL,
    CONSTRAINT uq_usuarios_documento UNIQUE (numero_documento),
    CONSTRAINT uq_usuarios_correo UNIQUE (correo),
    CONSTRAINT fk_usuarios_roles
        FOREIGN KEY (id_rol)
        REFERENCES roles (id_rol)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE usuarios_apartamentos (
    id_usuario_apartamento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_apartamento INT NOT NULL,
    tipo_residencia ENUM('PROPIETARIO', 'ARRENDATARIO', 'RESIDENTE') NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NULL,
    es_principal BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT uq_usuario_apartamento_inicio UNIQUE (id_usuario, id_apartamento, fecha_inicio),
    CONSTRAINT fk_usuarios_apartamentos_usuarios
        FOREIGN KEY (id_usuario)
        REFERENCES usuarios (id_usuario)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_usuarios_apartamentos_apartamentos
        FOREIGN KEY (id_apartamento)
        REFERENCES apartamentos (id_apartamento)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE conceptos_pago (
    id_concepto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NULL,
    periodicidad ENUM('MENSUAL', 'EXTRAORDINARIA', 'ANUAL', 'UNICA') NOT NULL DEFAULT 'MENSUAL',
    valor_base DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL DEFAULT 'ACTIVO',
    CONSTRAINT uq_conceptos_pago_nombre UNIQUE (nombre)
) ENGINE=InnoDB;

CREATE TABLE cuentas_cobro (
    id_cuenta_cobro INT AUTO_INCREMENT PRIMARY KEY,
    id_apartamento INT NOT NULL,
    id_concepto INT NOT NULL,
    periodo DATE NOT NULL,
    fecha_emision DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    saldo_pendiente DECIMAL(10,2) NOT NULL,
    estado ENUM('PENDIENTE', 'PAGADA', 'VENCIDA', 'ANULADA') NOT NULL DEFAULT 'PENDIENTE',
    observaciones VARCHAR(200) NULL,
    CONSTRAINT uq_cuentas_periodo UNIQUE (id_apartamento, id_concepto, periodo),
    CONSTRAINT fk_cuentas_apartamentos
        FOREIGN KEY (id_apartamento)
        REFERENCES apartamentos (id_apartamento)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_cuentas_conceptos
        FOREIGN KEY (id_concepto)
        REFERENCES conceptos_pago (id_concepto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_cuenta_cobro INT NOT NULL,
    id_usuario INT NOT NULL,
    fecha_pago DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    valor_pagado DECIMAL(10,2) NOT NULL,
    medio_pago ENUM('EFECTIVO', 'TRANSFERENCIA', 'PSE', 'TARJETA') NOT NULL,
    referencia_transaccion VARCHAR(80) NULL,
    estado ENUM('PENDIENTE', 'APROBADO', 'RECHAZADO') NOT NULL DEFAULT 'PENDIENTE',
    comprobante_url VARCHAR(255) NULL,
    CONSTRAINT uq_pagos_referencia UNIQUE (referencia_transaccion),
    CONSTRAINT fk_pagos_cuentas
        FOREIGN KEY (id_cuenta_cobro)
        REFERENCES cuentas_cobro (id_cuenta_cobro)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_pagos_usuarios
        FOREIGN KEY (id_usuario)
        REFERENCES usuarios (id_usuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE incidencias (
    id_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_reporta INT NOT NULL,
    id_apartamento INT NULL,
    categoria ENUM('RUIDO', 'DANOS', 'ILUMINACION', 'SEGURIDAD', 'OTRO') NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    prioridad ENUM('BAJA', 'MEDIA', 'ALTA') NOT NULL DEFAULT 'MEDIA',
    estado ENUM('ABIERTA', 'EN_PROCESO', 'CERRADA', 'CANCELADA') NOT NULL DEFAULT 'ABIERTA',
    ubicacion VARCHAR(120) NULL,
    fecha_reporte DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre DATETIME NULL,
    CONSTRAINT fk_incidencias_usuarios
        FOREIGN KEY (id_usuario_reporta)
        REFERENCES usuarios (id_usuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_incidencias_apartamentos
        FOREIGN KEY (id_apartamento)
        REFERENCES apartamentos (id_apartamento)
        ON UPDATE CASCADE
        ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE noticias (
    id_noticia INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_autor INT NOT NULL,
    titulo VARCHAR(120) NOT NULL,
    contenido TEXT NOT NULL,
    fecha_publicacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_expiracion DATETIME NULL,
    prioridad ENUM('BAJA', 'MEDIA', 'ALTA') NOT NULL DEFAULT 'MEDIA',
    publicada BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_noticias_usuarios
        FOREIGN KEY (id_usuario_autor)
        REFERENCES usuarios (id_usuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE INDEX idx_usuarios_id_rol ON usuarios (id_rol);
CREATE INDEX idx_usuarios_apartamentos_id_usuario ON usuarios_apartamentos (id_usuario);
CREATE INDEX idx_usuarios_apartamentos_id_apartamento ON usuarios_apartamentos (id_apartamento);
CREATE INDEX idx_cuentas_cobro_estado ON cuentas_cobro (estado);
CREATE INDEX idx_pagos_estado ON pagos (estado);
CREATE INDEX idx_incidencias_estado ON incidencias (estado);
CREATE INDEX idx_noticias_publicada ON noticias (publicada);

INSERT INTO roles (nombre, descripcion) VALUES
('ADMINISTRADOR', 'Gestiona la operacion general del conjunto'),
('RESIDENTE', 'Usuario propietario o habitante del apartamento'),
('PORTERIA', 'Controla accesos y eventos del conjunto');

INSERT INTO conceptos_pago (nombre, descripcion, periodicidad, valor_base) VALUES
('Administracion', 'Cuota mensual ordinaria de administracion', 'MENSUAL', 120000.00),
('Parqueadero', 'Cobro por uso o mantenimiento de parqueadero', 'MENSUAL', 45000.00),
('Cuota extraordinaria', 'Cobro ocasional aprobado por la administracion', 'EXTRAORDINARIA', 0.00);
