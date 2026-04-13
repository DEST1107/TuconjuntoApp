# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Proyecto formativo:** TuConjunto App  
**Documento:** Diseno frontend del proyecto  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

El frontend de TuConjunto App fue disenado para responder a las necesidades del proyecto formativo, priorizando la experiencia del residente como primer modulo funcional. La interfaz busca centralizar en una sola plataforma la consulta de pagos, noticias, reservas, horarios de zonas comunes, contactos y datos del inmueble.

Para el desarrollo se aplicaron HTML, CSS y JavaScript, incorporando criterios de usabilidad, jerarquia visual, navegacion consistente y acceso rapido a las tareas mas frecuentes del usuario.

# Objetivo

Disenar la interfaz frontend de TuConjunto App cumpliendo con los requerimientos funcionales del proyecto y aplicando principios de usabilidad, organizacion visual y desarrollo web con HTML, CSS y JavaScript.

# Requerimientos atendidos en el diseno

El diseno frontend propuesto cubre los procesos principales del residente:

1. Visualizacion del panel principal.
2. Consulta de pagos y estado de cuenta.
3. Solicitud de reservas de zonas comunes.
4. Consulta de horarios de piscina, cancha y otras zonas.
5. Consulta de noticias y comunicados.
6. Acceso a canales de contacto con administracion, contabilidad y porteria.
7. Visualizacion del perfil del residente y datos del apartamento.

# Criterios de usabilidad aplicados

## Navegacion clara

La interfaz utiliza una navegacion lateral en escritorio y una navegacion inferior en dispositivos moviles. Esto permite acceder rapidamente a cada seccion sin perder el contexto de uso.

## Jerarquia visual

El panel de inicio resalta primero la informacion prioritaria para el residente:

1. Saldo pendiente.
2. Noticias nuevas.
3. Proxima reserva.

Despues se muestran accesos rapidos a tareas frecuentes como pagar administracion, reservar espacios o contactar administracion.

## Consistencia visual

Se mantuvieron colores, componentes y estilos repetibles para botones, tarjetas, tablas, etiquetas de estado y formularios. Esto mejora el reconocimiento visual y reduce la curva de aprendizaje del usuario.

## Retroalimentacion al usuario

JavaScript se utilizo para brindar respuestas inmediatas en la navegacion y en acciones como el envio de una solicitud de reserva, mejorando la interaccion del usuario con el sistema.

## Diseno responsive

La propuesta se adapta a pantallas de escritorio y dispositivos moviles, reorganizando la navegacion y las tarjetas de contenido para mantener legibilidad y facilidad de uso.

# Tecnologias utilizadas

## HTML

Se utilizo para estructurar semanticamente el contenido de la aplicacion, organizando secciones como inicio, pagos, reservas, horarios, noticias, contacto y perfil.

## CSS

Se utilizo para definir identidad visual, distribucion, tipografia, colores, tarjetas, formularios, tablas y comportamiento responsive.

## JavaScript

Se utilizo para:

1. Cambiar entre secciones del sistema.
2. Activar accesos rapidos desde el panel principal.
3. Filtrar horarios por dia.
4. Mostrar mensajes de confirmacion en formularios.

# Estructura de archivos del frontend

El diseno fue desarrollado en los siguientes archivos:

1. `Frontend/index.html`
2. `Frontend/styles.css`
3. `Frontend/app.js`

# Descripcion general de la interfaz

## Inicio

Presenta un resumen ejecutivo del residente con indicadores de pagos, noticias y reservas, ademas de accesos directos a los procesos principales.

## Pagos

Permite visualizar cuotas pendientes, acuerdos de pago, multas y una tabla con el historial de cobros.

## Reservas

Incluye un formulario para solicitar reservas y una lista de proximas reservas del usuario.

## Horarios

Muestra los horarios de uso de zonas comunes y permite filtrar la informacion por dia.

## Noticias

Presenta comunicados destacados de la administracion y del area contable.

## Contacto

Facilita la comunicacion con administradora, contador y porteria.

## Perfil

Resume la informacion personal del residente y los datos principales del apartamento.

# Conclusiones

El diseno frontend desarrollado para TuConjunto App responde a los requerimientos del proyecto al integrar en una sola interfaz las necesidades principales del residente. La propuesta mejora la accesibilidad a la informacion, organiza mejor las tareas frecuentes y sirve como base visual para la futura integracion con el backend en JDBC y la base de datos del sistema.
