# Proyecto Renzo Costa

Este proyecto Java, desarrollado con la estructura clásica de NetBeans, permite gestionar empleados, usuarios, productos y estadísticas empresariales. Utiliza una arquitectura modular basada en clases, controladores y formularios gráficos (`JFrame`) para su interfaz de usuario.

## Autor

- [Yannick Yasuhiro Funes Chavez](https://www.linkedin.com/in/yannick-yasuhiro-funes-chavez/)

## Estructura del Proyecto

```bash
Proyecto-Renzo-Costa/
├── build.xml # Script de construcción (Apache Ant)
├── manifest.mf # Manifest para ejecución del JAR
├── documentos/ # Carpeta para documentación o archivos auxiliares
├── nbproject/ # Archivos de configuración de NetBeans
├── src/ # Código fuente Java
└── build/
└── classes/
├── Clases/ # Clases principales (Empleado, Producto, Usuario, etc.)
├── ClasesListas/ # Estructuras de datos tipo lista (ListaDeAlmacenes, NodoAlmacen)
├── ConexionDB/ # Conexión a la base de datos (Conexion.class)
├── Controladores/ # Controladores de lógica del sistema y gráficos
├── DB/ # Archivos de datos persistentes en formato texto
├── Frames/ # Formularios gráficos (JFrames)
└── Imagenes/ # Recursos gráficos
```

## Componentes principales

### 📦 Clases

Este paquete contiene las clases fundamentales del modelo del sistema. Cada clase representa una entidad o componente central del negocio y define sus atributos y métodos asociados.

#### `Empleado.java`
Representa a un trabajador de la empresa. Incluye información como:

- DNI
- Nombres y apellidos
- Fecha de nacimiento
- Sexo
- Edad
- Dirección
- Número de celular
- Área de trabajo
- Fecha de ingreso
- Nivel académico

Se encarga de almacenar y validar los datos de los empleados que serán gestionados dentro del sistema.

#### `Persona.java`
Clase base genérica que representa a una persona. Es probable que sea una clase padre que contenga atributos comunes como:

- DNI
- Nombre
- Apellido
- Edad

Sirve como superclase para `Empleado` y `Usuario`, promoviendo la reutilización de código mediante herencia.

#### `Usuario.java`
Representa a un usuario del sistema (por ejemplo, quien inicia sesión). Incluye:

- Nombre de usuario
- Contraseña
- Rol o tipo de usuario

Permite gestionar el acceso y los permisos dentro del sistema.

#### `Producto.java`
Gestiona la información relacionada con los productos que se manejan en el almacén. Contiene atributos como:

- Código o ID de producto
- Nombre
- Categoría o tipo
- Precio
- Cantidad en stock
- Fecha de ingreso o caducidad

Es clave para el módulo de inventario o almacén.

#### `OperacionesData.java`
Clase encargada de manejar operaciones generales del sistema, tales como:

- Lectura y escritura de archivos de datos (`.txt`)
- Validaciones
- Conversión de tipos de datos
- Funciones utilitarias que son compartidas por distintas clases

Centraliza lógica común, promoviendo la modularidad y la reutilización del código.

### 📂 ClasesListas

Este paquete contiene las estructuras de datos personalizadas utilizadas para organizar y manejar colecciones de objetos relacionados con almacenes. Se implementan listas enlazadas para facilitar operaciones como inserción, búsqueda y recorrido.

#### `ListaDeAlmacenes.java`
Implementa una **lista enlazada** que almacena objetos del tipo `Almacen`. Proporciona métodos para:

- Agregar nuevos almacenes a la lista
- Buscar un almacén por su código o nombre
- Eliminar almacenes
- Mostrar todos los almacenes registrados

Esta clase encapsula la lógica para manejar múltiples almacenes de manera ordenada y eficiente, permitiendo su gestión dinámica dentro del sistema.

#### `NodoAlmacen.java`
Representa un **nodo individual** dentro de la lista enlazada de almacenes. Contiene:

- Una referencia a un objeto `Almacen`
- Un puntero o referencia al siguiente nodo de la lista

Es la base estructural que permite construir y recorrer la lista enlazada de almacenes. Cada nodo mantiene la conexión con el siguiente, formando una secuencia dinámica de almacenes.

### 🌐 ConexionDB

Este paquete está encargado de gestionar la conexión con la base de datos, asegurando la comunicación efectiva y segura entre la aplicación y el sistema gestor de base de datos.

#### `Conexion.java`
Clase principal que maneja la **conexión a la base de datos**. Sus responsabilidades incluyen:

- Configurar los parámetros de conexión (URL, usuario, contraseña, driver).
- Establecer y abrir la conexión con la base de datos.
- Proveer métodos para obtener la conexión activa y cerrarla cuando sea necesario.
- Manejar excepciones relacionadas con la conexión, garantizando la estabilidad de la aplicación.
- Facilitar la reutilización de la conexión para operaciones de consulta o actualización.

Esta clase es fundamental para que las demás capas del sistema puedan interactuar con la base de datos de forma transparente y eficiente.

### 🧠 Controladores

El paquete **Controladores** agrupa las clases que se encargan de coordinar la lógica del sistema, gestionar la interacción entre la interfaz de usuario y la capa de datos, y controlar la generación de elementos visuales y funcionales clave. Actúan como intermediarios que reciben las solicitudes del usuario, procesan la información y devuelven las respuestas o resultados esperados.

---

#### `ControladorData`

Esta clase es el **núcleo de la lógica del sistema**. Su función principal es administrar y coordinar las operaciones internas relacionadas con los datos y reglas de negocio, actuando como puente entre la capa de datos y la interfaz de usuario. Sus responsabilidades incluyen:

- **Procesamiento de datos:** Recibe información de las interfaces o directamente de la base de datos, y la transforma o valida según las reglas del negocio.
- **Manejo de operaciones CRUD:** Facilita la creación, lectura, actualización y eliminación de datos en el sistema.
- **Gestión de eventos y acciones:** Interpreta las acciones del usuario (como botones, formularios, filtros) y ejecuta las operaciones correspondientes.
- **Control de flujo:** Decide qué información mostrar y cómo debe ser procesada en función de la lógica definida.
- **Comunicación con otras clases:** Trabaja en conjunto con clases de acceso a datos y controladores auxiliares para asegurar la integridad y consistencia del sistema.

Esta clase es vital para mantener el sistema organizado y modular, evitando que la lógica de negocio se disperse en diferentes partes del código.

---

#### `ControladorDeGraficas`

Encargado de la **generación y gestión de gráficos estadísticos** dentro de la aplicación. Su misión es transformar datos numéricos o categóricos en representaciones visuales claras y comprensibles para el usuario. Entre sus funciones destacan:

- **Preparación de datos:** Recopila, agrupa y procesa los datos necesarios para la creación de gráficos.
- **Configuración de gráficos:** Define tipos de gráficos (barras, líneas, pasteles, etc.), colores, leyendas y estilos visuales.
- **Generación dinámica:** Permite crear gráficos de forma dinámica según la información actual y los parámetros definidos por el usuario.
- **Actualización en tiempo real:** Soporta la actualización de gráficos en función de nuevas entradas o cambios en los datos subyacentes.
- **Integración con la interfaz:** Proporciona los gráficos generados para que sean incorporados en los paneles o vistas del sistema.

Este controlador es clave para facilitar la interpretación visual de datos complejos, mejorando la experiencia del usuario y apoyando la toma de decisiones basada en información estadística.

---

#### Elementos auxiliares visuales

##### `PlaceHolder`

Clase que representa un **elemento visual temporal o de relleno** dentro de la interfaz, utilizado para mantener la estructura o el diseño cuando no hay contenido disponible o mientras se carga información. Sus características principales:

- **Visualización temporal:** Muestra un espacio reservado que indica al usuario que allí se cargará contenido.
- **Mejora de experiencia:** Evita que la interfaz se vea vacía o desordenada durante la carga o la ausencia de datos.
- **Personalización:** Puede adaptarse en tamaño, forma o color según el contexto en que se utilice.

##### `Plantilla`

Clase que define una **estructura o diseño base reutilizable** para la presentación de contenido visual. Facilita la creación coherente y uniforme de vistas o componentes en la interfaz. Entre sus responsabilidades están:

- **Definición de layout:** Especifica la organización visual de los elementos dentro de una sección o ventana.
- **Estilos predefinidos:** Contiene estilos, colores, y formatos para mantener la consistencia gráfica.
- **Reutilización:** Permite que diferentes partes del sistema utilicen el mismo diseño base, acelerando el desarrollo y mantenimiento.
- **Adaptabilidad:** Soporta modificaciones para ajustarse a distintos contextos o requerimientos específicos.

---

En conjunto, estas clases en el paquete de **Controladores** aseguran que el sistema funcione de manera coherente, eficiente y visualmente atractiva, separando claramente las responsabilidades de procesamiento, visualización y soporte gráfico, para mantener una arquitectura limpia y modular.

### 🗃️ DB

El directorio **DB** es el espacio dedicado a la **persistencia de datos** del sistema, donde se almacenan archivos que contienen información fundamental para la operación y funcionamiento continuo de la aplicación. Esta persistencia es clave para garantizar que los datos no se pierdan al cerrar el programa y puedan ser recuperados y utilizados en sesiones posteriores.

---

#### Archivos de almacenamiento

Este directorio contiene principalmente archivos con extensiones `.txt` y `.data`, que funcionan como bases de datos simples y planos para guardar información estructurada en texto. Estos archivos permiten un acceso rápido y sencillo a los datos sin necesidad de un sistema gestor de base de datos complejo, lo que facilita la portabilidad y el mantenimiento en proyectos más pequeños o educativos.

---

#### Descripción de los archivos:

- **`dataUsuario.txt`**

  Archivo que almacena los datos relacionados con los **usuarios del sistema**. Aquí se registran detalles tales como:

  - Identificadores únicos (ID de usuario).
  - Nombres y apellidos.
  - Credenciales (usuario, contraseña cifrada).
  - Roles o permisos asignados.
  - Información adicional relevante para la gestión de usuarios.

  Su estructura suele ser lineal y organizada en registros separados por líneas o delimitadores específicos para facilitar la lectura y escritura.

- **`dataProducto.txt`**

  Contiene la información referente a los **productos gestionados por el sistema**. En este archivo se guarda:

  - Código o ID del producto.
  - Nombre y descripción.
  - Precio o valor.
  - Stock o cantidad disponible.
  - Categorías o atributos especiales.

  Es fundamental para mantener actualizada la base de datos de inventario y facilitar operaciones comerciales o administrativas.

- **`dataEmpleado.txt`**

  Guarda los datos sobre los **empleados de la organización o sistema**, tales como:

  - Identificación laboral o código único.
  - Datos personales (nombre, contacto).
  - Puesto o rol dentro de la empresa.
  - Estado laboral (activo, inactivo).
  - Información adicional necesaria para recursos humanos o administración.

  Este archivo ayuda en la gestión interna y el control del personal.

- **`dataAlmacen`**

  Este archivo (o conjunto de archivos) registra la información sobre los **almacenes o lugares físicos de almacenamiento**. Contiene:

  - Identificadores de almacén.
  - Ubicación o dirección.
  - Capacidad o volumen.
  - Inventario específico asociado a cada almacén.
  - Estado y condiciones relevantes para la logística.

  Sirve para controlar el flujo y ubicación física de los productos dentro de la cadena de suministro o gestión de inventarios.

---

#### Ventajas y características del sistema de almacenamiento en DB:

- **Simplicidad:** Uso de archivos planos para facilitar el acceso y modificación directa sin configuraciones complejas.
- **Portabilidad:** Los archivos `.txt` y `.data` pueden ser transportados fácilmente entre sistemas sin dependencia de software adicional.
- **Facilidad de lectura:** Los archivos pueden ser inspeccionados y editados manualmente para tareas rápidas o depuración.
- **Persistencia básica:** Permiten guardar datos de manera persistente entre sesiones del programa.

---

Este sistema de almacenamiento es ideal para proyectos que no requieren bases de datos sofisticadas o que están en etapas iniciales de desarrollo, asegurando la conservación y accesibilidad de datos clave con un esquema simple y efectivo.

### 🖼️ Frames

Este módulo contiene los **formularios Swing** basados en `JFrame` que forman la **interfaz gráfica de usuario (GUI)** del sistema. Estos frames representan las ventanas principales que interactúan con el usuario, facilitando la entrada, búsqueda y visualización de datos, así como la presentación de estadísticas y pruebas dentro de la aplicación.

---

#### Descripción de los formularios principales:

- **`frmAgregarProductoYusuario`**

  Este formulario está diseñado para la **gestión y registro de nuevos productos y usuarios**. Proporciona campos de entrada para capturar la información relevante y botones para ejecutar acciones como agregar, modificar o cancelar registros.

  Funciones principales:
  - Entrada de datos para productos (nombre, descripción, precio, etc.).
  - Registro de usuarios (credenciales, datos personales, roles).
  - Validaciones básicas para asegurar la integridad de los datos ingresados.
  - Interacción con la base de datos para almacenar los nuevos registros.

- **`frmBuscarUsuario`**

  Ventana destinada a la **búsqueda y consulta de usuarios existentes** en el sistema. Permite al usuario filtrar y localizar usuarios específicos mediante criterios como nombre, ID, o rol.

  Funciones principales:
  - Campos de búsqueda con diferentes filtros.
  - Resultados en forma de listas o tablas para fácil visualización.
  - Opciones para seleccionar un usuario y realizar acciones adicionales (editar, eliminar, ver detalles).

- **`frmEstadisticaEmpresariales`**

  Este frame está enfocado en mostrar **estadísticas generales relacionadas con la empresa**, basándose en los datos almacenados.

  Funciones principales:
  - Visualización gráfica (barras, tortas, líneas) de indicadores empresariales clave.
  - Resumen de métricas como ventas, rendimiento, usuarios activos, etc.
  - Opciones para refrescar o exportar los datos mostrados.

- **`frmEstadisticasDeAlmacen`**

  Formulario especializado en mostrar **estadísticas relacionadas con los almacenes y la gestión de inventarios**.

  Funciones principales:
  - Reportes sobre stock, movimientos de productos, entradas y salidas.
  - Gráficos para facilitar el análisis visual de los datos.
  - Posibilidad de generar informes o resúmenes para la toma de decisiones logísticas.

- **`Testing`**

  Frame utilizado para **pruebas y desarrollo**, donde se pueden validar funcionalidades específicas o realizar tests manuales dentro del entorno gráfico.

  Funciones principales:
  - Espacio flexible para comprobar componentes nuevos o modificados.
  - Herramientas para debugging visual y validación de interacciones.
  - Uso temporal durante la fase de desarrollo o mantenimiento.

---

#### Consideraciones generales:

- Cada formulario está basado en `JFrame`, lo que significa que cada uno representa una ventana independiente dentro de la aplicación.
- Estos frames manejan eventos de usuario, validación de datos y comunicación directa con las capas de lógica y datos.
- La estructura modular facilita la extensión y mantenimiento del sistema, permitiendo agregar o modificar funcionalidades sin afectar el conjunto completo.
- La interfaz está diseñada para ser intuitiva y accesible, facilitando el flujo de trabajo de los usuarios finales.

---

Este conjunto de frames constituye la base visual para la interacción humana con el sistema, asegurando un manejo eficiente y claro de las funcionalidades principales.

### 🛠️ build.xml

Script para compilar el proyecto usando Apache Ant.

## Requisitos

- Java JDK 8 o superior
- NetBeans (opcional, facilita edición y ejecución)
- Apache Ant (si se desea compilar con `build.xml`)

## Ejecución

Puedes compilar y ejecutar el proyecto de las siguientes formas:

### Desde NetBeans

1. Abre el proyecto.
2. Click derecho > `Run`.

### Desde línea de comandos

```bash
ant clean
ant build
java -cp build/classes MainClass