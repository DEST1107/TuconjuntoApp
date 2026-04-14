# Portada

**Evidencia:** Codificacion del modulo del proyecto aplicando React JS  
**Proyecto:** TuConjunto App  
**Programa:** Analisis y Desarrollo de Software  
**Aprendiz:** Daniel Solarte  
**Ficha:** GFPI-F-135 V01  
**Fecha:** 13 de abril de 2026  

# Introduccion

El presente documento describe la codificacion del modulo frontend del proyecto **TuConjunto App** usando **React JS**, tomando como base los artefactos definidos previamente en el ciclo de desarrollo del software, tales como historias de usuario, casos de uso, disenos de interfaz, prototipos y plan de trabajo tecnico. La solucion se enfoca en el modulo del residente, ya que corresponde a la primera experiencia funcional priorizada dentro del proyecto.

La implementacion en React permite organizar la interfaz en componentes reutilizables, mantener una navegacion clara, mejorar la usabilidad y preparar el sistema para una futura integracion con servicios backend desarrollados en Java.

# Objetivo

Codificar el modulo frontend del residente para el proyecto **TuConjunto App** mediante React JS, aplicando buenas practicas de estructura, comentarios, estandares de codificacion y control de versiones.

# Relacion Con Artefactos Previos

El modulo desarrollado toma como referencia:

- Historias de usuario del residente.
- Casos de uso relacionados con consulta de pagos, noticias, reservas y contacto.
- Diseno frontend elaborado previamente en HTML, CSS y JS.
- Prototipos visuales del portal del residente.
- Plan de trabajo tecnico para construccion del software.

Estas definiciones permitieron mantener coherencia funcional y visual entre la propuesta inicial y la version codificada en React.

# Tecnologia Seleccionada

Para esta evidencia se selecciono:

- **React JS** como libreria principal para la construccion de interfaces basadas en componentes.
- **Vite** como herramienta de arranque del proyecto frontend.
- **CSS** para el diseno visual y responsivo del modulo.
- **JavaScript moderno** para manejo de estado, navegacion local y validaciones.

# Estructura Del Proyecto

La implementacion se ubico en la carpeta:

`Frontend/TuConjuntoReact`

Archivos principales:

- `package.json`: dependencias y scripts del proyecto.
- `src/main.jsx`: punto de entrada de React.
- `src/App.jsx`: contenedor principal del modulo.
- `src/components/`: componentes por seccion funcional.
- `src/data/mockData.js`: datos simulados para la evidencia.
- `src/styles.css`: hoja de estilos general.

# Modulos Codificados

El frontend React incluye las siguientes secciones:

- Inicio del residente con resumen general.
- Pagos y estado de cuenta.
- Reservas de zonas comunes.
- Horarios de espacios compartidos.
- Noticias del conjunto.
- Contacto con administracion, contador y porteria.
- Perfil del residente.

Cada seccion fue separada en componentes con el fin de facilitar mantenimiento, lectura del codigo y escalabilidad del proyecto.

# Estandares De Codificacion Aplicados

Durante la construccion del modulo se aplicaron los siguientes criterios:

- Nombres de componentes en PascalCase.
- Variables y funciones en camelCase.
- Separacion por componentes reutilizables.
- Uso de comentarios breves en partes clave de validacion o logica.
- Organizacion del codigo por responsabilidad.
- Estructura clara de carpetas para datos, componentes y estilos.

# Comentarios En El Codigo

El codigo contiene comentarios puntuales en secciones que lo requieren, especialmente en validaciones y comportamiento del formulario de reservas. Esto permite comprender la intencion de la logica sin sobrecargar la lectura del proyecto.

# Funcionalidades Incluidas

- Navegacion entre secciones sin recargar la pagina.
- Cambio de vista por medio de estado en React.
- Filtrado del estado de cuenta.
- Formulario de reservas con validaciones basicas.
- Busqueda de noticias.
- Visualizacion de horarios por dia.
- Resumen de perfil y datos del residente.

# Herramienta De Versionamiento

El proyecto se mantiene dentro de un repositorio Git, lo cual permite:

- Registrar cambios del desarrollo.
- Tener trazabilidad de avances.
- Preparar la entrega academica en repositorio local y remoto.

# Ejecucion Del Proyecto

Para ejecutar el modulo frontend React en el equipo local:

1. Abrir una terminal en la carpeta `Frontend/TuConjuntoReact`.
2. Ejecutar `npm install`.
3. Ejecutar `npm run dev`.
4. Abrir la URL local mostrada por Vite en el navegador.

# Conclusiones

La implementacion del modulo del residente en React JS permite evidenciar el uso de una tecnologia moderna de frontend aplicada al proyecto **TuConjunto App**. La solucion mantiene coherencia con los artefactos previos, aplica estandares de codificacion, mejora la organizacion del codigo y deja una base escalable para futuras integraciones con el backend del sistema.
