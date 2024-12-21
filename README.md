# Actividad JDBC - Unidad 2

Este proyecto es parte de la asignatura **Acceso a Datos (ADAT)** y muestra cómo trabajar con una base de datos PostgreSQL utilizando JDBC, leer datos desde un archivo XML y cargarlos en la base de datos. Incluye la creación de tablas, lectura de datos XML y manejo de inserciones.

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Archivos Clave](#archivos-clave)
- [Ejecución del Proyecto](#ejecución-del-proyecto)
- [Descripción del Funcionamiento](#descripción-del-funcionamiento)
- [Notas Adicionales](#notas-adicionales)

---

## Requisitos
1. **JDK 17+**
2. **PostgreSQL**
    - Servidor PostgreSQL en funcionamiento.
    - Base de datos llamada `alumnosdb`.
    - Usuario `postgres` con contraseña `------`.
3. **Gradle** (para compilar y ejecutar el proyecto).
4. **Archivo XML** ubicado en `src/main/resources/alumnos.xml`.

---

## Estructura del Proyecto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/kodeleku/
│   │       ├── JDBCinit.java        # Inicialización de la base de datos
│   │       ├── XMLReader.java       # Lectura y parseo de XML
│   │       ├── AlumnoDAO.java       # Interacción con la base de datos
│   │       ├── modelo/              # Modelos de datos
│   │       └── Main.java            # Punto de entrada principal
│   └── resources/
│       └── alumnos.xml              # Archivo de datos de alumnos en XML
└── test/
    └── java/
        └── com/kodeleku/
            └── AlumnoDAOTest.java    # Pruebas unitarias
```


---

## Archivos Clave

### `JDBCinit.java`
- Configura la conexión con la base de datos y crea la tabla `alumnos` si no existe.

### `XMLReader.java`
- Lee y parsea el archivo XML `alumnos.xml` en objetos Java (`Alumno`).

### `AlumnoDAO.java`
- Inserta los datos leídos del XML en la tabla `alumnos` usando JDBC.
- Maneja conflictos en claves únicas (DNI) para evitar inserciones duplicadas.

### `alumnos.xml`
- Archivo con la lista de alumnos en formato XML.

### `Main.java`
- Coordina todo el proceso:
    1. Inicializa la base de datos.
    2. Lee datos del XML.
    3. Inserta los datos en la tabla.

---

## Ejecución del Proyecto

1. **Configura PostgreSQL:**
    - Asegúrate de tener PostgreSQL en funcionamiento.
    - Crea una base de datos llamada `alumnosdb` y un usuario `postgres` con contraseña `------`.

2. **Clona este repositorio:**
   ```bash
   git clone <URL-del-repositorio>
   cd <nombre-del-directorio>
   ```

3. **Ejecuta el proyecto:**
    - Compila y ejecuta con Gradle:
      ```bash
      ./gradlew run
      ```
    - Alternativamente, compila y ejecuta desde IntelliJ IDEA.

---

Aunque realmente sería mejor si se usara un archivo `.env` para almacenar las credenciales de la base de datos. A continuación se detalla este proceso:

### Configuración del Archivo `.env`

Para configurar las credenciales de la base de datos, crea un archivo `.env` en el directorio raíz del proyecto y añade las siguientes variables:

```plaintext
POSTGRES_URL=jdbc:postgresql://localhost:5433/alumnosdb
POSTGRES_USER=postgres
POSTGRES_PASSWORD=tu_contraseña_segura
```

---
Aquí tienes una sección que puedes añadir al **README.md** para explicar la importancia del archivo `.gitignore` y cómo asegurarte de que el archivo `.env` no sea subido accidentalmente a un repositorio público:

---

### **Protección del Archivo `.env`**

Para evitar exponer credenciales sensibles en repositorios públicos, es fundamental incluir el archivo `.env` en el archivo `.gitignore`. Esto asegura que no se suba accidentalmente a GitHub u otros sistemas de control de versiones.

#### **Pasos para Configurar `.gitignore`**

1. Si no tienes un archivo `.gitignore` en la raíz de tu proyecto, créalo.
2. Abre el archivo `.gitignore` y añade la siguiente línea:
   ```plaintext
   # Ignorar el archivo .env
   .env
   ```

3. Guarda los cambios en `.gitignore`.

#### **Cómo Verificar**
- Antes de subir cambios al repositorio, usa el siguiente comando para verificar que el archivo `.env` no está siendo rastreado:
   ```bash
   git status
   ```
- Si ves el archivo `.env` en la lista de cambios a ser añadidos, elimina su rastreo con:
   ```bash
   git rm --cached .env
   ```
  Esto detendrá el seguimiento del archivo sin eliminarlo del sistema de archivos local.

---

### **Nota Importante**
**Nunca incluyas credenciales o información sensible directamente en tu código fuente o en repositorios públicos.** Usar un archivo `.env` combinado con un archivo `.gitignore` es una buena práctica para mantener tus datos seguros.

---

### **Ventajas de Usar `.env`**
1. **Separación de Configuración y Código:**
    - Las credenciales y configuraciones sensibles no están en el código fuente.

2. **Flexibilidad:**
    - Puedes cambiar las configuraciones sin modificar el código.

3. **Seguridad:**
    - Al ignorar el archivo `.env` en Git, reduces el riesgo de exponer datos sensibles.

---

### **Resumen de Pasos**
1. Crea el archivo `.env` en el directorio raíz del proyecto.
2. Añade las variables necesarias (URL, usuario, contraseña).
3. Ajusta las clases `JDBCinit` y `AlumnoDAO` para cargar estas variables usando `dotenv`.
4. Asegúrate de incluir `.env` en el `.gitignore`.
5. Documenta estas instrucciones en el `README.md`.

--- 

## Descripción del Funcionamiento

1. **Inicialización de la Base de Datos (`JDBCinit.java`):**
    - Se conecta a PostgreSQL.
    - Crea la tabla `alumnos` con las siguientes columnas:
        - `id` (clave primaria, autoincremental).
        - `nombre`, `apellido`, `curso`, `dni` (clave única).

2. **Lectura del Archivo XML (`XMLReader.java`):**
    - Carga el archivo `alumnos.xml` de la carpeta `resources`.
    - Convierte los datos del XML en una lista de objetos `Alumno`.

3. **Inserción en la Base de Datos (`AlumnoDAO.java`):**
    - Inserta los datos en la tabla `alumnos`.
    - Ignora los registros duplicados basados en la clave única `dni`.

4. **Resultado Final:**
    - Muestra en la consola la cantidad de registros insertados.

---


