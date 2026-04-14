# Portada

**Evidencia:** Testing de las APIs del proyecto usando Postman  
**Proyecto:** TuConjunto App  
**Programa:** Analisis y Desarrollo de Software  
**Aprendiz:** Daniel Solarte  
**Ficha:** GFPI-F-135 V01  
**Fecha:** 13 de abril de 2026  

# Introduccion

Con base en las APIs construidas para **TuConjunto App**, se realizo la preparacion del proceso de testing mediante **Postman**, definiendo peticiones para autenticacion, residentes, noticias, incidencias, reservas y cuentas de cobro. Las pruebas se orientan a verificar respuestas correctas, validaciones y manejo de errores.

# Objetivo

Realizar el testing funcional de las APIs del proyecto usando Postman, comprobando que los servicios respondan de acuerdo con los requerimientos definidos para el sistema.

# Herramienta Utilizada

- Postman para ejecucion y validacion de endpoints REST.
- Coleccion creada: `Backend/TuConjuntoSpring/postman/TuConjuntoApp_API.postman_collection.json`
- Environment creado: `Backend/TuConjuntoSpring/postman/TuConjuntoApp_API.postman_environment.json`

# Servicios Probados

## 1. Autenticacion

### Prueba 1. Registro correcto

- Metodo: `POST`
- URL: `/api/auth/register`
- Resultado esperado: `201 Created`
- Validacion: el usuario se registra y retorna mensaje `Registro satisfactorio.`

### Prueba 2. Login correcto

- Metodo: `POST`
- URL: `/api/auth/login`
- Resultado esperado: `200 OK`
- Validacion: retorna mensaje `Autenticacion satisfactoria.`

### Prueba 3. Login incorrecto

- Metodo: `POST`
- URL: `/api/auth/login`
- Resultado esperado: `401 Unauthorized`
- Validacion: retorna mensaje `Error en la autenticacion.`

## 2. Residentes

### Prueba 4. Listado de residentes

- Metodo: `GET`
- URL: `/api/residentes`
- Resultado esperado: `200 OK`

### Prueba 5. Consulta de residente por id

- Metodo: `GET`
- URL: `/api/residentes/{id}`
- Resultado esperado: `200 OK`

## 3. Noticias

### Prueba 6. Registro de noticia

- Metodo: `POST`
- URL: `/api/noticias`
- Resultado esperado: `201 Created`

### Prueba 7. Listado de noticias

- Metodo: `GET`
- URL: `/api/noticias`
- Resultado esperado: `200 OK`

## 4. Incidencias

### Prueba 8. Registro de incidencia

- Metodo: `POST`
- URL: `/api/incidencias`
- Resultado esperado: `201 Created`

### Prueba 9. Listado de incidencias

- Metodo: `GET`
- URL: `/api/incidencias`
- Resultado esperado: `200 OK`

## 5. Reservas

### Prueba 10. Registro de reserva

- Metodo: `POST`
- URL: `/api/reservas`
- Resultado esperado: `201 Created`

### Prueba 11. Listado de reservas

- Metodo: `GET`
- URL: `/api/reservas`
- Resultado esperado: `200 OK`

## 6. Cuentas de cobro

### Prueba 12. Consulta de cuentas de cobro

- Metodo: `GET`
- URL: `/api/cuentas-cobro`
- Resultado esperado: `200 OK`

# Validaciones Aplicadas En Postman

La coleccion incluye scripts de prueba para verificar:

- codigos HTTP esperados;
- mensajes de autenticacion;
- captura de `idUsuario` despues del registro;
- persistencia de variables para continuar pruebas relacionadas;
- flujo encadenado entre registro, login y modulos posteriores.

# Procedimiento En Postman

1. Importar la coleccion `TuConjuntoApp_API.postman_collection.json`.
2. Importar el environment `TuConjuntoApp_API.postman_environment.json`.
3. Iniciar la aplicacion Spring Boot en `http://localhost:8081`.
4. Seleccionar el environment `TuConjuntoApp Local`.
5. Ejecutar la coleccion completa o request por request.
6. Tomar pantallazos de cada respuesta para la evidencia.

# Resultados Verificados

Durante la validacion del modulo se obtuvo el siguiente comportamiento esperado:

- `POST /api/auth/register`: registro exitoso con respuesta `201 Created`.
- `POST /api/auth/login` con credenciales correctas: respuesta `200 OK`.
- `POST /api/auth/login` con contrasena incorrecta: respuesta `401 Unauthorized`.
- `GET /api/residentes`: respuesta `200 OK` con residentes registrados.
- `GET /api/residentes/{id}`: respuesta `200 OK`.
- `POST /api/noticias`: respuesta `201 Created`.
- `GET /api/noticias`: respuesta `200 OK`.
- `POST /api/incidencias`: respuesta `201 Created`.
- `GET /api/incidencias`: respuesta `200 OK`.
- `POST /api/reservas`: respuesta `201 Created`.
- `GET /api/reservas`: respuesta `200 OK`.
- `GET /api/cuentas-cobro`: respuesta `200 OK`, incluso cuando no existen registros.

# Ejemplos De Salida Observada

Registro correcto:

```json
{
  "autenticado": true,
  "mensaje": "Registro satisfactorio.",
  "usuario": "residente20260413224801@tuconjunto.com",
  "idUsuario": 5
}
```

Login correcto:

```json
{
  "autenticado": true,
  "mensaje": "Autenticacion satisfactoria.",
  "usuario": "residente20260413224801@tuconjunto.com",
  "idUsuario": 5
}
```

Login invalido:

```json
{
  "fecha": "2026-04-13T22:48:57.783",
  "mensaje": "Error en la autenticacion.",
  "errores": []
}
```

# Pantallazos Recomendados

- Registro exitoso.
- Login exitoso.
- Login fallido.
- Listado de residentes.
- Creacion de noticia.
- Creacion de incidencia.
- Creacion de reserva.
- Consulta de cuentas de cobro.

# Observaciones

La coleccion fue preparada para generar automaticamente un correo y documento unicos durante la prueba de registro, lo cual evita errores por duplicidad cuando se vuelve a ejecutar el flujo.

# Conclusiones

El testing de APIs con Postman permite validar de manera organizada la respuesta de los servicios construidos para **TuConjunto App**, facilitando la comprobacion funcional del sistema y el registro visual de evidencias para la entrega academica.
