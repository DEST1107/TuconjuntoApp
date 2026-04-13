# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Evidencia de desempeno:** GA7-220501096-AA3-EV01  
**Documento:** Codificacion de modulos del software con framework Java  
**Proyecto formativo:** TuConjunto App  
**Modulo desarrollado:** Gestion web de residentes con Spring Boot  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

La presente evidencia corresponde a la codificacion de un modulo del proyecto **TuConjunto App** utilizando un framework Java orientado al desarrollo agil. Para esta entrega se selecciono la opcion **web**, implementando un CRUD de residentes mediante **Spring Boot**, **Spring MVC**, **Thymeleaf** y conexion a base de datos con **JDBC**.

La solucion toma como base los artefactos desarrollados en etapas anteriores, tales como historias de usuario, diseno de base de datos, prototipos frontend y plan de trabajo tecnico del proyecto.

# Objetivo

Codificar un modulo del software aplicando un framework Java, respetando estandares de codificacion, comentarios en el codigo y uso de versionamiento para el control de cambios.

# Framework seleccionado

Se selecciono **Spring Boot** como framework de desarrollo por las siguientes razones:

1. Facilita la construccion de aplicaciones web en Java.
2. Organiza la solucion por capas.
3. Reduce la configuracion manual.
4. Permite integrar vistas HTML y acceso a base de datos.
5. Es apropiado para el desarrollo agil de modulos del proyecto.

# Relacion con artefactos previos

El modulo desarrollado se fundamenta en:

1. Historias de usuario de administracion de residentes.
2. Casos de uso asociados al registro y consulta de usuarios.
3. Modelo relacional de la base de datos `tuconjuntoapp`.
4. Disenos y prototipos del frontend del residente.
5. Plan tecnico de construccion del software.

# Tecnologias utilizadas

1. Java 8
2. Spring Boot
3. Spring MVC
4. Thymeleaf
5. Spring JDBC
6. MySQL
7. Git y GitHub

# Estructura del proyecto framework

El proyecto fue creado en una carpeta independiente dentro del backend:

- `Backend/TuConjuntoSpring`

## Archivos principales

1. `pom.xml`
2. `TuConjuntoFrameworkApplication.java`
3. `Residente.java`
4. `ResidenteRepository.java`
5. `ResidenteService.java`
6. `ResidenteController.java`
7. `application.properties`
8. `templates/residentes/lista.html`
9. `templates/residentes/formulario.html`
10. `static/css/app.css`

# Arquitectura aplicada

## Capa controlador

`ResidenteController` recibe las solicitudes HTTP, gestiona las rutas y comunica la interfaz con la logica del modulo.

## Capa servicio

`ResidenteService` centraliza la logica funcional del modulo y coordina las operaciones del CRUD.

## Capa repositorio

`ResidenteRepository` accede a la base de datos mediante JDBC y ejecuta las consultas SQL sobre la tabla `usuarios`.

## Capa vista

Las vistas HTML con Thymeleaf presentan la informacion en navegador y permiten interactuar con el modulo a traves de formularios.

# Funcionalidades implementadas

El modulo permite:

1. Listar residentes.
2. Buscar residentes por correo.
3. Registrar nuevos residentes.
4. Editar residentes existentes.
5. Eliminar residentes.

# Estandares de codificacion aplicados

## Nombramiento de clases

Se uso PascalCase:

1. `ResidenteController`
2. `ResidenteService`
3. `ResidenteRepository`
4. `Residente`

## Nombramiento de metodos

Se uso camelCase:

1. `listar()`
2. `buscarPorId()`
3. `guardar()`
4. `eliminar()`
5. `obtenerIdRolResidente()`

## Nombramiento de variables

Se utilizaron nombres descriptivos y coherentes:

1. `residenteService`
2. `residenteRepository`
3. `correoBuscado`
4. `tituloFormulario`
5. `redirectAttributes`

## Nombramiento de paquetes

Se organizaron los paquetes en minuscula:

1. `controller`
2. `service`
3. `repository`
4. `model`

# Comentarios en el codigo

El proyecto incluye comentarios puntuales para explicar decisiones funcionales importantes, por ejemplo:

1. Captura del identificador generado al guardar un residente.
2. Uso del metodo GET para listar y filtrar.
3. Uso del metodo POST para crear o actualizar.

Esto responde al requerimiento de incluir comentarios en el codigo.

# Versionamiento

El desarrollo se realizo dentro del repositorio versionado del proyecto, utilizando Git como herramienta local y GitHub como herramienta remota. Esto garantiza trazabilidad de cambios y respaldo del codigo.

# Evidencias sugeridas

Se recomienda adjuntar pantallazos de:

1. La estructura de `Backend/TuConjuntoSpring`.
2. El archivo `pom.xml`.
3. El controlador `ResidenteController`.
4. El repositorio `ResidenteRepository`.
5. El formulario HTML con Thymeleaf.
6. El listado de residentes en navegador.
7. El repositorio Git con los cambios del proyecto.

# Conclusiones

La evidencia desarrollada demuestra la aplicacion de un framework Java para la construccion de un modulo web del proyecto TuConjunto App. La solucion cumple con estandares de codificacion, contiene comentarios, utiliza versionamiento y organiza el desarrollo en capas, lo que facilita el mantenimiento y la evolucion futura del sistema.
