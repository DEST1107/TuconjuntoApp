# Portada

**Evidencia:** Diseno y codificacion de API del proyecto TuConjunto App  
**Proyecto:** TuConjunto App  
**Programa:** Analisis y Desarrollo de Software  
**Aprendiz:** Daniel Solarte  
**Ficha:** GFPI-F-135 V01  
**Fecha:** 13 de abril de 2026  

# Introduccion

Tomando como referencia el componente formativo **Construccion de API**, se desarrollo una capa de servicios web para **TuConjunto App** con el fin de cubrir funcionalidades esenciales del proyecto: autenticacion, administracion de residentes, noticias, incidencias, reservas y estado de cuenta.

La implementacion fue realizada con **Spring Boot**, **JDBC** y **MySQL**, organizando el codigo en controladores, servicios, repositorios, modelos, DTOs y manejo centralizado de errores. Esta estructura mejora la mantenibilidad del sistema y facilita la futura integracion con frontend web o movil.

# Objetivo

Disenar y codificar las API necesarias para soportar las caracteristicas principales del software del conjunto residencial, documentando cada servicio y manteniendo el proyecto bajo versionamiento con Git.

# Arquitectura Implementada

El proyecto fue estructurado por capas:

- `controller`: endpoints REST.
- `service`: logica de negocio.
- `repository`: acceso a base de datos con JDBC.
- `model`: entidades del sistema.
- `dto`: objetos para peticiones y respuestas de autenticacion.
- `config`: manejo de errores y configuracion auxiliar.
- `util`: apoyo para transformacion segura de contrasenas.

# Modulos API Implementados

## 1. Autenticacion

### POST `/api/auth/register`

Registra un nuevo usuario residente.

Ejemplo:

```json
{
  "usuario": "residente1@tuconjunto.com",
  "password": "1234",
  "nombres": "Nazar",
  "apellidos": "Solarte",
  "tipoDocumento": "CC",
  "numeroDocumento": "123456789",
  "telefono": "3001112233"
}
```

Respuesta:

```json
{
  "autenticado": true,
  "mensaje": "Registro satisfactorio.",
  "usuario": "residente1@tuconjunto.com",
  "idUsuario": 25
}
```

### POST `/api/auth/login`

Valida usuario y contrasena.

Ejemplo:

```json
{
  "usuario": "residente1@tuconjunto.com",
  "password": "1234"
}
```

Respuesta:

```json
{
  "autenticado": true,
  "mensaje": "Autenticacion satisfactoria.",
  "usuario": "residente1@tuconjunto.com",
  "idUsuario": 25
}
```

## 2. Residentes

### GET `/api/residentes`

Lista todos los residentes o filtra por correo.

Parametro opcional:

- `correo`

### GET `/api/residentes/{id}`

Consulta un residente por identificador.

### POST `/api/residentes`

Crea un residente.

### PUT `/api/residentes/{id}`

Actualiza la informacion de un residente.

### DELETE `/api/residentes/{id}`

Elimina un residente del sistema.

## 3. Noticias

### GET `/api/noticias`

Lista las noticias registradas.

### GET `/api/noticias/{id}`

Consulta una noticia especifica.

### POST `/api/noticias`

Registra una nueva noticia.

Ejemplo:

```json
{
  "idUsuarioAutor": 1,
  "titulo": "Mantenimiento preventivo de ascensores",
  "contenido": "Se realizara mantenimiento por torres durante la jornada de la manana.",
  "fechaExpiracion": "2026-05-30T18:00:00",
  "prioridad": "ALTA",
  "publicada": true
}
```

### PUT `/api/noticias/{id}`

Actualiza la noticia seleccionada.

### DELETE `/api/noticias/{id}`

Elimina la noticia.

## 4. Incidencias

### GET `/api/incidencias`

Lista las incidencias reportadas.

### GET `/api/incidencias/{id}`

Consulta una incidencia por id.

### POST `/api/incidencias`

Registra una incidencia nueva.

Ejemplo:

```json
{
  "idUsuarioReporta": 2,
  "idApartamento": 1,
  "categoria": "RUIDO",
  "titulo": "Ruido excesivo en la noche",
  "descripcion": "Se presenta musica a alto volumen despues de las 11 p. m.",
  "prioridad": "MEDIA",
  "estado": "ABIERTA",
  "ubicacion": "Torre B - piso 3"
}
```

### PUT `/api/incidencias/{id}`

Actualiza la incidencia.

### DELETE `/api/incidencias/{id}`

Elimina la incidencia.

## 5. Reservas

### GET `/api/reservas`

Lista las reservas de zonas comunes.

### GET `/api/reservas/{id}`

Consulta una reserva puntual.

### POST `/api/reservas`

Registra una nueva reserva.

Ejemplo:

```json
{
  "idUsuario": 2,
  "areaComun": "Salon comunal",
  "fechaReserva": "2026-05-18",
  "horaReserva": "18:00:00",
  "estado": "PENDIENTE",
  "observaciones": "Reunion familiar de maximo 20 personas."
}
```

### PUT `/api/reservas/{id}`

Actualiza el estado o la informacion de una reserva.

### DELETE `/api/reservas/{id}`

Elimina una reserva.

## 6. Cuentas De Cobro

### GET `/api/cuentas-cobro`

Lista las cuentas de cobro registradas.

Parametro opcional:

- `idApartamento`

### GET `/api/cuentas-cobro/{id}`

Consulta una cuenta de cobro especifica.

# Validaciones Aplicadas

Las API incluyen validaciones como:

- campos obligatorios;
- formato correcto para correo electronico;
- longitud minima y maxima en contrasena;
- validacion de duplicados en usuario y documento;
- validacion de fechas futuras o presentes para reservas;
- manejo de errores 400, 401 y 404;
- mensajes JSON para errores y validaciones.

# Comentarios Y Estandares De Codificacion

El codigo contiene comentarios puntuales en metodos clave del servicio, el repositorio y la configuracion. Ademas, se aplicaron estandares de codificacion relacionados con:

- nombres de clases en PascalCase;
- nombres de variables y metodos en camelCase;
- paquetes organizados por responsabilidad;
- separacion clara entre controlador, servicio y acceso a datos.

# Persistencia Y Base De Datos

La API trabaja sobre la base `tuconjuntoapp` en MySQL. Para soportar el modulo de reservas se agrego el archivo:

`Backend/TuConjuntoSpring/database/api_reservas.sql`

Adicionalmente, el proyecto crea automaticamente la tabla `reservas` al iniciar la aplicacion si esta no existe.

# Versionamiento

El proyecto fue desarrollado dentro de un repositorio Git, lo que permite mantener historial de cambios, control de versiones y preparacion de la entrega academica en entorno local y remoto.

# Conclusion

La capa de APIs construida para **TuConjunto App** permite cubrir servicios esenciales del sistema y deja una base organizada para la integracion con frontend React, aplicaciones moviles o futuras ampliaciones del proyecto.
