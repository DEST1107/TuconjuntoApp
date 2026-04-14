# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Evidencia de producto:** GA7-220501096-AA3-EV02  
**Documento:** Modulos de software codificados y probados  
**Proyecto formativo:** TuConjunto App  
**Modulo probado:** Gestion web de residentes con Spring Boot  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

La presente evidencia documenta las pruebas funcionales y de validacion aplicadas al modulo web de gestion de residentes del proyecto **TuConjunto App**, desarrollado con **Spring Boot**, **Thymeleaf** y **JDBC**. Las pruebas se definieron con base en los requerimientos del proyecto, las historias de usuario, los casos de uso y los artefactos construidos en fases anteriores del ciclo de vida del software.

El objetivo de esta evidencia es demostrar que el modulo cumple con los procesos principales del CRUD y que responde adecuadamente frente a entradas invalidas relacionadas con textos, correos, numeros y longitudes de campos.

# Objetivo

Realizar y documentar las pruebas del modulo web de residentes de TuConjunto App, verificando su funcionamiento segun los requerimientos y validaciones definidas para el sistema.

# Herramientas utilizadas

1. Spring Boot
2. Thymeleaf
3. Java 8
4. MySQL con XAMPP
5. Navegador web
6. Git y GitHub

# Modulo probado

El modulo probado corresponde a la gestion de residentes, disponible en la ruta:

- `http://localhost:8081/residentes`

Este modulo permite:

1. Listar residentes.
2. Buscar residentes por correo.
3. Registrar nuevos residentes.
4. Editar residentes.
5. Eliminar residentes.

# Historias de usuario o casos de uso probados

## Historia de usuario 1: Listar residentes

**Descripcion:** Como administrador del sistema, deseo visualizar el listado de residentes registrados para consultar su informacion.

**Resultado esperado:** El sistema muestra una tabla con los residentes registrados y sus datos principales.

**Pantallazo sugerido:** Vista principal del modulo con el listado de residentes.

## Historia de usuario 2: Registrar residente

**Descripcion:** Como administrador, deseo registrar un nuevo residente para almacenar sus datos en el sistema.

**Resultado esperado:** El sistema guarda correctamente el residente y lo muestra en el listado.

**Pantallazo sugerido:** Formulario diligenciado y mensaje de registro exitoso.

## Historia de usuario 3: Buscar residente por correo

**Descripcion:** Como administrador, deseo buscar un residente por correo para localizarlo rapidamente.

**Resultado esperado:** El sistema filtra el listado mostrando solo el residente cuyo correo coincide con el criterio de busqueda.

**Pantallazo sugerido:** Resultado del filtro por correo.

## Historia de usuario 4: Editar residente

**Descripcion:** Como administrador, deseo editar la informacion de un residente para mantener los datos actualizados.

**Resultado esperado:** El sistema actualiza los datos y muestra un mensaje de confirmacion.

**Pantallazo sugerido:** Formulario en modo edicion y mensaje de actualizacion exitosa.

## Historia de usuario 5: Eliminar residente

**Descripcion:** Como administrador, deseo eliminar un residente para depurar el registro cuando ya no corresponda al sistema.

**Resultado esperado:** El sistema elimina el registro y actualiza la tabla principal.

**Pantallazo sugerido:** Listado despues de eliminar el residente.

# Pruebas de validacion de la aplicacion

## Validacion 1: Campos obligatorios

**Caso probado:** Enviar el formulario vacio.

**Resultado esperado:** El sistema debe mostrar mensajes de error en nombres, apellidos, tipo de documento, numero de documento, correo, contrasena y estado.

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Formulario con errores de campos obligatorios.

## Validacion 2: Correo invalido

**Caso probado:** Ingresar un correo sin formato valido, por ejemplo `residenteprueba`.

**Resultado esperado:** El sistema debe mostrar el mensaje `Debe ingresar un correo valido.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Campo correo mostrando error.

## Validacion 3: Texto con caracteres no permitidos en nombres

**Caso probado:** Ingresar en nombres un valor como `Juan123`.

**Resultado esperado:** El sistema debe rechazar el valor y mostrar el mensaje `Los nombres solo deben contener letras y espacios.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error de validacion en nombres.

## Validacion 4: Texto con caracteres no permitidos en apellidos

**Caso probado:** Ingresar en apellidos un valor como `Perez@`.

**Resultado esperado:** El sistema debe rechazar el valor y mostrar el mensaje `Los apellidos solo deben contener letras y espacios.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error de validacion en apellidos.

## Validacion 5: Numero de documento con letras o caracteres especiales

**Caso probado:** Ingresar `ABC123` o `12-45`.

**Resultado esperado:** El sistema debe mostrar el mensaje `El numero de documento solo debe contener digitos.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error en numero de documento.

## Validacion 6: Longitud minima y maxima del documento

**Caso probado:** Ingresar menos de 5 digitos o mas de 20 caracteres.

**Resultado esperado:** El sistema debe mostrar el mensaje `El documento debe tener entre 5 y 20 caracteres.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error por longitud del documento.

## Validacion 7: Telefono con caracteres no permitidos

**Caso probado:** Ingresar `telefono!`.

**Resultado esperado:** El sistema debe mostrar el mensaje `El telefono solo debe contener numeros, espacios o el signo +.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error en telefono.

## Validacion 8: Longitud de nombres y apellidos

**Caso probado:** Ingresar un texto mayor a 60 caracteres.

**Resultado esperado:** El sistema debe impedir o rechazar la longitud excedida.

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Validacion por longitud en nombres o apellidos.

## Validacion 9: Longitud de la contrasena

**Caso probado:** Ingresar una contrasena menor a 4 caracteres.

**Resultado esperado:** El sistema debe mostrar el mensaje `La contrasena debe tener entre 4 y 255 caracteres.`

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Error por longitud de contrasena.

## Validacion 10: Busqueda sin resultados

**Caso probado:** Buscar un correo inexistente.

**Resultado esperado:** El sistema no debe fallar y debe mostrar el mensaje de tabla vacia o sin coincidencias.

**Resultado obtenido:** [Completar segun prueba realizada]

**Pantallazo sugerido:** Vista de busqueda sin resultados.

# Resumen de resultados

| Item | Prueba | Resultado esperado | Estado |
|---|---|---|---|
| 1 | Listar residentes | Mostrar tabla de residentes | [Completar] |
| 2 | Registrar residente | Guardar y listar nuevo residente | [Completar] |
| 3 | Buscar por correo | Filtrar coincidencias | [Completar] |
| 4 | Editar residente | Actualizar informacion | [Completar] |
| 5 | Eliminar residente | Remover registro | [Completar] |
| 6 | Campos obligatorios | Mostrar errores | [Completar] |
| 7 | Correo invalido | Mostrar error de formato | [Completar] |
| 8 | Documento invalido | Mostrar error de digitos | [Completar] |
| 9 | Longitudes | Mostrar error segun limite | [Completar] |
| 10 | Telefono invalido | Mostrar error | [Completar] |

# Video de evidencia

El video debe mostrar de forma continua:

1. Inicio de la aplicacion Spring Boot.
2. Acceso al modulo en navegador.
3. Listado de residentes.
4. Registro de un nuevo residente.
5. Validacion de campos vacios.
6. Validacion de correo invalido.
7. Validacion de documento no numerico.
8. Edicion de un residente.
9. Eliminacion de un residente.
10. Confirmacion final del funcionamiento del modulo.

# Versionamiento

El modulo probado fue desarrollado y gestionado mediante herramientas de versionamiento, utilizando Git como herramienta local y GitHub como repositorio remoto. Esto garantiza control de cambios y respaldo del proyecto.

# Conclusiones

Las pruebas realizadas permiten evidenciar que el modulo web de residentes cumple con los requerimientos funcionales principales del CRUD y responde de manera adecuada frente a entradas invalidas. El uso de Spring Boot, Thymeleaf y JDBC facilita la construccion y prueba del modulo, dejando una base solida para la evolucion futura del sistema TuConjunto App.
