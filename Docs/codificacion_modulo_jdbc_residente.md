# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Componente formativo:** Construccion de aplicaciones con JAVA  
**Evidencia de desempeno:** GA7-220501096-AA2-EV01  
**Documento:** Codificacion de modulos del software segun requerimientos del proyecto  
**Proyecto formativo:** TuConjunto App  
**Modulo desarrollado:** Gestion de usuarios residentes con JDBC  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

La presente evidencia corresponde a la codificacion de un modulo del proyecto **TuConjunto App** utilizando Java y conexiones a base de datos mediante **JDBC**, de acuerdo con los requerimientos definidos previamente en artefactos del ciclo de vida del software como historias de usuario, prototipos, disenos frontend, modelo de base de datos y plan de trabajo.

Para esta entrega se selecciono el **modulo de gestion de usuarios residentes**, ya que es la base funcional para el acceso al sistema y permite demostrar operaciones completas de insercion, consulta, actualizacion y eliminacion sobre una base de datos MySQL.

# Objetivo

Codificar un modulo funcional del proyecto TuConjunto App aplicando Java y JDBC, implementando operaciones CRUD y respetando estandares de nombramiento de clases, paquetes, variables y metodos.

# Relacion con artefactos previos del proyecto

La construccion de este modulo toma como referencia:

1. Historias de usuario relacionadas con registro y consulta de residentes.
2. Casos de uso asociados a gestion de usuarios.
3. Modelo de base de datos del proyecto.
4. Diseno frontend del modulo del residente.
5. Plan de trabajo de construccion del software.

La entidad `usuarios` definida en la base de datos sirve como base para el desarrollo del modulo de residentes en el backend.

# Herramientas y tecnologias utilizadas

1. Java
2. JDBC
3. MySQL con XAMPP
4. phpMyAdmin
5. Git como herramienta de versionamiento local
6. GitHub como herramienta de versionamiento remoto

# Estructura del modulo desarrollado

El modulo fue organizado respetando convenciones de nombramiento y separacion por capas:

## Paquetes

1. `com.tuconjuntoapp.config`
2. `com.tuconjuntoapp.dao`
3. `com.tuconjuntoapp.model`

## Archivos principales

1. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/config/ConexionDB.java`
2. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/model/Usuario.java`
3. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/dao/UsuarioDAO.java`
4. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/TestConexion.java`
5. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/TestInsert.java`
6. `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/TestCrudUsuario.java`

# Estandares de codificacion aplicados

## Nombramiento de clases

Se utilizo nomenclatura tipo PascalCase:

1. `ConexionDB`
2. `Usuario`
3. `UsuarioDAO`
4. `TestCrudUsuario`

## Nombramiento de metodos

Se utilizo nomenclatura camelCase:

1. `conectar()`
2. `registrarResidente()`
3. `registrar()`
4. `buscarPorId()`
5. `buscarPorCorreo()`
6. `listarResidentes()`
7. `actualizarUsuario()`
8. `eliminarPorId()`

## Nombramiento de variables

Las variables fueron nombradas de forma descriptiva y en camelCase:

1. `usuarioDAO`
2. `usuarioEncontrado`
3. `idUsuario`
4. `nombreRol`
5. `insertado`
6. `actualizado`
7. `eliminado`

## Nombramiento de paquetes

Los paquetes fueron nombrados en minuscula y con una estructura organizada:

1. `config`
2. `dao`
3. `model`

# Descripcion funcional del modulo

## Conexion con base de datos

La clase `ConexionDB` realiza la conexion con la base de datos `tuconjuntoapp` mediante JDBC, usando la URL local de MySQL en XAMPP.

## Modelo de datos

La clase `Usuario` representa la entidad del sistema y contiene atributos como:

1. Identificador del usuario.
2. Rol.
3. Nombres.
4. Apellidos.
5. Tipo y numero de documento.
6. Correo.
7. Contrasena.
8. Telefono.
9. Estado.

## Acceso a datos

La clase `UsuarioDAO` implementa las operaciones del modulo y concentra las sentencias SQL necesarias para interactuar con la tabla `usuarios`.

# Operaciones CRUD implementadas

## Insercion

Se implemento el registro de usuarios residentes mediante el metodo:

```java
registrarResidente(Usuario usuario)
```

Este metodo asigna el rol `RESIDENTE` y luego ejecuta la insercion del usuario en base de datos.

## Consulta

Se implementaron consultas por diferentes criterios:

1. `buscarPorId(int idUsuario)`
2. `buscarPorCorreo(String correo)`
3. `listarResidentes()`
4. `listarPorRol(String nombreRol)`

Estas operaciones permiten recuperar informacion individual o listados de residentes.

## Actualizacion

Se implemento la actualizacion de informacion del usuario mediante:

```java
actualizarUsuario(Usuario usuario)
```

Este metodo permite modificar datos como nombres, correo, telefono, estado y demas atributos del usuario.

## Eliminacion

Se implemento la eliminacion por identificador mediante:

```java
eliminarPorId(int idUsuario)
```

Con esto se cumple el requerimiento de eliminacion del modulo.

# Clases de prueba implementadas

## `TestConexion`

Permite verificar que la conexion JDBC con MySQL funciona correctamente.

## `TestInsert`

Permite probar la insercion de un residente y mostrar el identificador generado.

## `TestCrudUsuario`

Permite demostrar en un solo flujo:

1. Insercion del usuario.
2. Consulta por identificador.
3. Actualizacion de datos.
4. Consulta de la lista de residentes.
5. Eliminacion del usuario.

Esta clase sirve como evidencia tecnica del cumplimiento del CRUD.

# Uso del versionamiento

El proyecto fue desarrollado sobre un repositorio Git, cumpliendo con el requerimiento de trabajar con herramientas de versionamiento. El repositorio se encuentra conectado a un remoto en GitHub, lo que facilita el control de cambios y el respaldo del codigo fuente.

# Resultado de la implementacion

Con esta codificacion el proyecto TuConjunto App cuenta con un modulo funcional de gestion de residentes, estructurado y preparado para integrarse posteriormente con formularios, interfaces y otros procesos del sistema como autenticacion, pagos, reservas y notificaciones.

# Evidencias sugeridas para anexar

Para fortalecer la sustentacion del trabajo se recomienda adjuntar pantallazos de:

1. La estructura del proyecto en el entorno de desarrollo.
2. La clase `ConexionDB`.
3. La clase `Usuario`.
4. La clase `UsuarioDAO`.
5. La clase `TestCrudUsuario`.
6. La base de datos `tuconjuntoapp` en phpMyAdmin.
7. Las tablas relacionadas con el modulo.
8. La ejecucion de pruebas en consola si el entorno ya tiene Java configurado.

# Conclusiones

La evidencia desarrollada demuestra la construccion de un modulo de software utilizando Java y JDBC, aplicando buenas practicas de organizacion del codigo, acceso a datos y estandares de nombramiento. Ademas, cumple con el requerimiento de implementar operaciones CRUD sobre la base de datos del proyecto.

Este modulo representa una base tecnica importante para continuar con el desarrollo del sistema TuConjunto App y con futuras integraciones entre frontend, backend y base de datos.
