# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Evidencia de producto:** GA7-220501096-AA2-EV02  
**Documento:** Modulos de software codificados y probados  
**Proyecto formativo:** TuConjunto App  
**Modulo desarrollado:** Gestion web de residentes con Servlets, JSP y JDBC  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

La presente evidencia corresponde a la construccion del modulo web del proyecto **TuConjunto App**, desarrollado con Java, Servlets, JSP y conexion a base de datos mediante JDBC. La solucion toma como referencia los artefactos definidos previamente en el ciclo de vida del software, especialmente el modelo de base de datos, el prototipo frontend y los requerimientos funcionales del modulo del residente.

Para esta entrega se implemento un CRUD web de residentes, utilizando formularios HTML, metodos GET y POST, y paginas JSP como capa de presentacion.

# Objetivo

Codificar y dejar probado un modulo web del proyecto TuConjunto App utilizando Servlets, JSP y JDBC, permitiendo registrar, consultar, actualizar y eliminar residentes desde formularios HTML conectados a base de datos.

# Relacion con artefactos previos

El desarrollo del modulo se apoya en:

1. Historias de usuario de gestion de residentes.
2. Casos de uso relacionados con registro y administracion de usuarios.
3. Modelo relacional de la base de datos `tuconjuntoapp`.
4. Prototipo frontend del modulo del residente.
5. Plan de trabajo de construccion del software.

# Tecnologias utilizadas

1. Java
2. JDBC
3. Servlets
4. JSP
5. HTML
6. MySQL con XAMPP
7. Git y GitHub

# Estructura implementada

## Capa de configuracion

- `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/config/ConexionDB.java`

Responsable de establecer la conexion con MySQL usando JDBC.

## Capa modelo

- `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/model/Usuario.java`

Representa la entidad `Usuario` del sistema.

## Capa de acceso a datos

- `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/dao/UsuarioDAO.java`

Contiene las operaciones CRUD del modulo:

1. Registrar residente.
2. Buscar por id.
3. Buscar por correo.
4. Listar residentes.
5. Actualizar residente.
6. Eliminar residente.

## Capa web

- `Backend/TuConjuntoJDBC/src/com/tuconjuntoapp/web/UsuarioServlet.java`

El servlet recibe las solicitudes HTTP, procesa la logica del modulo y se comunica con `UsuarioDAO`.

## Vistas JSP

1. `Backend/TuConjuntoJDBC/webapp/index.jsp`
2. `Backend/TuConjuntoJDBC/webapp/WEB-INF/views/usuarios/lista.jsp`
3. `Backend/TuConjuntoJDBC/webapp/WEB-INF/views/usuarios/formulario.jsp`

## Configuracion web

- `Backend/TuConjuntoJDBC/webapp/WEB-INF/web.xml`

# Funcionamiento del modulo

## Uso del metodo GET

El servlet utiliza `doGet()` para:

1. Mostrar el listado de residentes.
2. Filtrar residentes por correo.
3. Cargar el formulario de registro.
4. Cargar el formulario de edicion.

## Uso del metodo POST

El servlet utiliza `doPost()` para:

1. Guardar un nuevo residente.
2. Actualizar un residente existente.
3. Eliminar un residente.

De esta forma se cumple el requerimiento de usar metodos GET y POST.

# Formularios HTML implementados

El modulo incluye formularios HTML dentro de JSP para:

1. Registrar residentes.
2. Editar residentes.
3. Buscar por correo.
4. Eliminar registros mediante formulario POST.

Estos formularios se comunican con el servlet `UsuarioServlet`.

# Elementos JSP utilizados

En las vistas JSP se aplicaron:

1. Directivas JSP `<%@ page %>`
2. Scriptlets `<% %>`
3. Expresiones JSP `<%= %>`
4. Atributos enviados desde el servlet mediante `request.setAttribute()`

Esto permite que las paginas muestren informacion dinamica del modulo.

# Flujo del modulo web

1. El usuario ingresa a `index.jsp`.
2. La pagina redirige al servlet `/residentes`.
3. El servlet consulta la base de datos mediante `UsuarioDAO`.
4. Los datos se envian a `lista.jsp` o `formulario.jsp`.
5. El usuario realiza acciones de registro, consulta, edicion o eliminacion.
6. El servlet procesa la solicitud y actualiza la base de datos.

# Pruebas realizadas

El modulo fue probado previamente a nivel JDBC con la clase `TestCrudUsuario`, verificando:

1. Insercion.
2. Consulta.
3. Actualizacion.
4. Eliminacion.

Adicionalmente, el modulo web quedo preparado para pruebas en servidor Java web como Apache Tomcat, usando el mismo acceso a datos validado en JDBC.

# Versionamiento

El desarrollo se mantuvo dentro del repositorio del proyecto, haciendo uso de Git como herramienta local y GitHub como repositorio remoto. Tambien se agrego un archivo `.gitignore` para evitar subir instaladores y archivos innecesarios al repositorio.

# Evidencias sugeridas

Se recomienda anexar pantallazos de:

1. La estructura del proyecto en el IDE.
2. La clase `UsuarioServlet`.
3. El archivo `web.xml`.
4. La vista `lista.jsp`.
5. La vista `formulario.jsp`.
6. La base de datos `tuconjuntoapp` en phpMyAdmin.
7. La ejecucion de pruebas del CRUD JDBC.
8. El despliegue en Tomcat si el entorno ya se encuentra configurado.

# Conclusiones

Con esta evidencia se desarrollo un modulo web funcional para la gestion de residentes, aplicando Servlets, JSP, formularios HTML y JDBC. La solucion responde al requerimiento del proyecto y prepara la base para continuar con otros procesos del sistema, como autenticacion, pagos, reservas y gestion de noticias.
