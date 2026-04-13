# Estado actual y siguiente paso del backend

## Que tienes hoy

El proyecto ya tiene una idea funcional clara:

1. Los residentes deben consultar noticias, pagos, reservas, horarios y datos del conjunto.
2. La administradora debe publicar informacion, consultar residentes, gestionar pagos y revisar novedades.
3. Porteria debe poder consultar datos de contacto para comunicarse con residentes.

En codigo, el backend existe pero estaba en una fase muy temprana:

1. Conexion JDBC basica a MySQL.
2. Pruebas sueltas de conexion e insercion.
3. Sin una estructura consistente entre paquetes, modelos y DAO.

## Que se mejoro en esta iteracion

Se dejo una base mas ordenada para seguir creciendo sin rehacer todo:

1. Se corrigio la ubicacion de `ConexionDB` para que coincida con su paquete.
2. Se creo el modelo `Usuario` real.
3. Se reescribio `UsuarioDAO` para registrar y consultar residentes de forma coherente con la base de datos.
4. Se agrego `NoticiaDAO` para listar noticias publicadas.
5. Se agrego `CuentaCobroDAO` para consultar cuentas de cobro del residente.
6. Se corrigieron los nombres de clases de prueba `TestConexion` y `TestInsert`.

## Que aun no esta resuelto

Todavia no esta completo el modulo del residente. Falta definir o desarrollar:

1. Inicio de sesion.
2. Reserva de salon comunal, piscina y canchas.
3. Horarios de zonas comunes.
4. Contactos de administracion, contabilidad y porteria.
5. Consulta de multas y acuerdos de pago.
6. Consulta del balance financiero del conjunto.
7. API o capa de controladores para conectar frontend y backend.

## Lo que no se sabe todavia

Hay decisiones que debemos cerrar antes de seguir construyendo mas rapido:

1. Si el login se hara solo con correo y contrasena.
2. Si el residente vera solo su apartamento o varios apartamentos.
3. Quien puede ver el balance general del conjunto: todos los residentes o solo administracion.
4. Si las reservas requeriran aprobacion de administracion.
5. Si multas y acuerdos de pago seran visibles solo para administracion o tambien para el residente.

## Siguiente paso recomendado

El siguiente paso debe ser construir el **MVP del modulo residente**. Para entrega, yo recomiendo este orden:

1. Login del residente.
2. Perfil del residente y datos del apartamento.
3. Noticias publicadas.
4. Estado de cuentas de cobro y pagos.
5. Registro de incidencias o contacto con administracion.

## Por que este orden

Porque con esos cinco puntos ya puedes demostrar:

1. Autenticacion.
2. Lectura real desde base de datos.
3. Funcionalidad util para el residente.
4. Integracion entre frontend, backend y MySQL.

## Despues del MVP

Cuando el MVP funcione, el segundo bloque debe ser:

1. Reservas de zonas comunes.
2. Horarios de piscina y canchas.
3. Multas y acuerdos de pago.
4. Contactos del conjunto.
5. Balance financiero.

## Regla de trabajo para seguir

Cada vez que avancemos, vamos a trabajar asi:

1. Definir una sola funcionalidad.
2. Ajustar o crear las tablas necesarias.
3. Crear el modelo Java.
4. Crear el DAO JDBC.
5. Probar la consulta o insercion en consola.
6. Luego conectar esa funcionalidad al frontend.

Ese orden evita que el proyecto se vuelva desordenado y hace que cada entrega sea defendible.
