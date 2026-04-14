# Portada

**Evidencia:** Diseno y codificacion de servicio web para registro e inicio de sesion  
**Proyecto:** TuConjunto App  
**Programa:** Analisis y Desarrollo de Software  
**Aprendiz:** Daniel Solarte  
**Ficha:** GFPI-F-135 V01  
**Fecha:** 13 de abril de 2026  

# Introduccion

Con base en lo visto en el componente formativo **Construccion de API**, se desarrollo un servicio web para el proyecto **TuConjunto App** encargado del registro e inicio de sesion de usuarios. La solucion fue implementada sobre Spring Boot, utilizando una arquitectura organizada por controlador, servicio, repositorio, DTOs y utilidades de apoyo.

# Objetivo

Construir un servicio web que permita registrar usuarios y autenticar el inicio de sesion mediante el envio de un usuario y una contrasena, devolviendo mensajes de exito o error segun el resultado de la autenticacion.

# Diseno Del Servicio

Se implementaron dos endpoints REST:

- `POST /api/auth/register`
- `POST /api/auth/login`

La API trabaja con respuestas en formato JSON y utiliza la tabla `usuarios` de la base de datos `tuconjuntoapp`.

# Estructura Del Codigo

La codificacion fue organizada de la siguiente manera:

- `controller/AuthController.java`: define los endpoints del servicio.
- `service/AuthService.java`: contiene la logica de registro y autenticacion.
- `repository/AuthRepository.java`: realiza las consultas JDBC sobre MySQL.
- `dto/`: clases para peticiones y respuestas JSON.
- `util/PasswordEncoderUtil.java`: transforma la contrasena antes de almacenarla.
- `config/ApiExceptionHandler.java`: centraliza los errores y validaciones de la API.

# Endpoints

## Registro

**URL:** `POST /api/auth/register`

Ejemplo de cuerpo JSON:

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

Respuesta esperada:

```json
{
  "autenticado": true,
  "mensaje": "Registro satisfactorio.",
  "usuario": "residente1@tuconjunto.com",
  "idUsuario": 25
}
```

## Inicio De Sesion

**URL:** `POST /api/auth/login`

Ejemplo de cuerpo JSON:

```json
{
  "usuario": "residente1@tuconjunto.com",
  "password": "1234"
}
```

Respuesta exitosa:

```json
{
  "autenticado": true,
  "mensaje": "Autenticacion satisfactoria.",
  "usuario": "residente1@tuconjunto.com",
  "idUsuario": 25
}
```

Respuesta de error:

```json
{
  "fecha": "2026-04-13T20:10:00",
  "mensaje": "Error en la autenticacion.",
  "errores": []
}
```

# Validaciones Aplicadas

- Usuario obligatorio y con formato de correo.
- Contrasena obligatoria con longitud entre 4 y 60 caracteres.
- Nombres y apellidos obligatorios.
- Numero de documento obligatorio.
- Validacion de usuario duplicado.
- Validacion de documento duplicado.
- Validacion del estado del usuario durante el inicio de sesion.

# Comentarios Y Estandares

El codigo contiene comentarios puntuales en la logica del servicio, el controlador y el repositorio. Ademas, se aplicaron estandares de codificacion como nombres descriptivos, separacion por capas, paquetes organizados y responsabilidad unica por clase.

# Versionamiento

La implementacion se realizo dentro del proyecto versionado con Git, lo cual permite mantener trazabilidad de cambios y preparar la entrega academica en repositorio local y remoto.
