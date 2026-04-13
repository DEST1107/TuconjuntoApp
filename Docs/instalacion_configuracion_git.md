# Portada

**Servicio Nacional de Aprendizaje - SENA**  
**Analisis y Desarrollo de Software - ADSO**  
**Componente formativo:** Integracion continua  
**Nombre del programa:** Git  
**Documento:** Instalacion y configuracion de herramienta de versionamiento local y web  
**Proyecto formativo:** TuConjunto App  
**Aprendiz:** [Completar nombre del aprendiz]  
**Instructor:** [Completar nombre del instructor]  
**Fecha:** 2026-04-13  
**Ciudad:** [Completar ciudad]

---

# Introduccion

El control de versiones es un proceso fundamental en el desarrollo de software, ya que permite registrar cambios, recuperar versiones anteriores, trabajar de forma organizada y mantener respaldo del proyecto tanto en un entorno local como en un entorno remoto.

En esta evidencia se presenta la instalacion y configuracion de la herramienta de versionamiento **Git** como entorno local, junto con la configuracion del repositorio remoto en **GitHub** como plataforma web. El procedimiento se aplico sobre el proyecto **TuConjunto App**, permitiendo gestionar el codigo fuente de forma segura y ordenada.

# Objetivo

Instalar y configurar la herramienta de control de versiones Git en entorno local y enlazarla con una plataforma remota web, permitiendo el seguimiento y sincronizacion del proyecto TuConjunto App.

# Herramientas utilizadas

## Herramienta local

- Git

## Herramienta web o remota

- GitHub

# Evidencia del entorno configurado

Durante la revision del entorno de trabajo se identifico lo siguiente:

- Git instalado localmente: `git version 2.47.1.windows.2`
- Usuario global configurado: `Daniel`
- Correo global configurado: `nazar@example.com`
- Rama actual del proyecto: `main`
- Repositorio remoto configurado:
  `https://github.com/DEST1107/TuconjuntoApp.git`

# Paso a paso de instalacion y configuracion local

## 1. Descarga de Git

Se debe ingresar al sitio oficial de Git y descargar el instalador para Windows:

- [https://git-scm.com/](https://git-scm.com/)

**Pantallazo sugerido:** pagina de descarga de Git.

## 2. Instalacion de Git

Una vez descargado el instalador:

1. Ejecutar el archivo de instalacion.
2. Aceptar la licencia.
3. Seleccionar la ubicacion de instalacion.
4. Mantener las opciones recomendadas del asistente.
5. Finalizar la instalacion.

**Pantallazo sugerido:** ventana del asistente de instalacion de Git.

## 3. Verificacion de la instalacion

Para verificar que Git quedo correctamente instalado, se abre la terminal y se ejecuta:

```bash
git --version
```

Resultado evidenciado en el entorno:

```bash
git version 2.47.1.windows.2
```

**Pantallazo sugerido:** terminal mostrando el comando `git --version`.

## 4. Configuracion del usuario global

Despues de instalar Git, se configura el nombre de usuario y el correo electronico que identificaran los commits:

```bash
git config --global user.name "Daniel"
git config --global user.email "nazar@example.com"
```

Para verificar la configuracion se usan los comandos:

```bash
git config --global user.name
git config --global user.email
```

**Pantallazo sugerido:** terminal mostrando la configuracion global del usuario.

## 5. Inicializacion o uso del repositorio local

En el proyecto TuConjunto App ya existe un repositorio Git local. Para un proyecto nuevo, el procedimiento seria:

```bash
git init
```

En este caso, el proyecto ya se encuentra versionado, por lo que Git permite llevar control de cambios sobre todos los archivos del sistema.

Para verificar el estado del repositorio se usa:

```bash
git status
```

**Pantallazo sugerido:** terminal mostrando el estado del repositorio.

## 6. Flujo basico de versionamiento local

Los comandos basicos de uso local son:

```bash
git add .
git commit -m "Descripcion del cambio realizado"
```

Con estos comandos se agregan los archivos modificados y se registra una nueva version del proyecto.

**Pantallazo sugerido:** terminal mostrando `git add` y `git commit`.

# Paso a paso de configuracion remota en GitHub

## 1. Creacion de cuenta o acceso a GitHub

Se debe ingresar a:

- [https://github.com/](https://github.com/)

Si el usuario no tiene cuenta, debe registrarse. Si ya la tiene, debe iniciar sesion.

**Pantallazo sugerido:** inicio de sesion o pagina principal de GitHub.

## 2. Creacion del repositorio remoto

Dentro de GitHub se crea un nuevo repositorio:

1. Clic en `New repository`.
2. Asignar nombre al repositorio.
3. Definir visibilidad publica o privada.
4. Crear el repositorio.

En este proyecto ya existe el repositorio remoto:

- [https://github.com/DEST1107/TuconjuntoApp.git](https://github.com/DEST1107/TuconjuntoApp.git)

**Pantallazo sugerido:** vista del repositorio creado en GitHub.

## 3. Enlace entre repositorio local y remoto

Para enlazar el repositorio local con GitHub se utiliza:

```bash
git remote add origin https://github.com/DEST1107/TuconjuntoApp.git
```

En este proyecto el remoto ya estaba configurado. La verificacion se realiza con:

```bash
git remote -v
```

Resultado evidenciado:

```bash
origin  https://github.com/DEST1107/TuconjuntoApp.git (fetch)
origin  https://github.com/DEST1107/TuconjuntoApp.git (push)
```

**Pantallazo sugerido:** terminal mostrando `git remote -v`.

## 4. Envio del proyecto al repositorio remoto

Una vez enlazado el repositorio remoto, se puede subir la rama principal usando:

```bash
git push -u origin main
```

Este comando envia los cambios del proyecto local al repositorio remoto en GitHub.

**Pantallazo sugerido:** terminal mostrando el `push` exitoso.

## 5. Actualizacion del repositorio local desde GitHub

Para traer cambios desde GitHub al entorno local se utiliza:

```bash
git pull origin main
```

Este comando sincroniza el repositorio local con la ultima version disponible en el repositorio remoto.

**Pantallazo sugerido:** terminal mostrando `git pull`.

# Integracion del control de versiones en el proyecto

La herramienta Git permite que el proyecto TuConjunto App mantenga organizados sus cambios en frontend, backend y documentacion. Esto facilita:

1. Registrar versiones del avance del proyecto.
2. Recuperar estados anteriores si ocurre un error.
3. Mantener un respaldo remoto en GitHub.
4. Preparar el proyecto para trabajo colaborativo y futuras practicas de integracion continua.

# Recomendaciones de uso

1. Realizar commits frecuentes y con mensajes claros.
2. Mantener sincronizado el proyecto con GitHub.
3. Verificar el estado del repositorio antes de hacer commit.
4. No eliminar ni modificar archivos del directorio `.git`.
5. Mantener el repositorio remoto como respaldo permanente del proyecto.

# Conclusiones

La instalacion y configuracion de Git como herramienta de versionamiento local y GitHub como plataforma remota web permitio establecer un entorno de trabajo adecuado para el proyecto TuConjunto App. Esta configuracion garantiza control de cambios, respaldo del codigo y organizacion del proceso de desarrollo.

Ademas, el uso de versionamiento prepara el proyecto para etapas posteriores de integracion entre frontend, backend y base de datos, fortaleciendo las buenas practicas de desarrollo de software.
