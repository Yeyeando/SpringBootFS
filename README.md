# Indice
1. [Introducción](#introducción)
2. [Modelo de datos](#modelo-de-datos)
    1. [Diagrama E/R](#diagrama-er)
    2. [Diagrama UML](#diagrama-uml)
    3. [Diagrama Relacional](#diagrama-relacional)
3. [Requisitos de usuarios](#requisitos-de-usuarios)
4. [Casos de uso](#casos-de-uso)
5. [Descripción del sistema y especificaciones técnicas](#descripción-del-sistema-y-especificaciones-técnicas)
    1. [Descripción general del sistema](#descripción-general-del-sistema)
    2. [Arquitectura del sistema](#arquitectura-del-sistema)
    3. [Especificaciones técnicas](#especificaciones-técnicas)
6. [Interfaces](#interfaces)
    1. [Usabilidad y accesibilidad](#usabilidad-y-accesibilidad)
7. [Manuales](#manuales)
8. [Tests](#tests)
9. [Pila tecnológica](#pila-tecnológica)
    1. [Frontend](#frontend)
    2. [Backend](#backend)
10. [Comparación de pila tecnológica](#comparación-de-pila-tecnológica)
11. [Repositorios](#repositorios)
12. [Planificación](#planificación)
13. [Conclusiones](#conclusiones)
14. [Enlaces](#enlaces)

## 1. Introducción
La eficiencia en los procesos de cocina es clave para el éxito de cualquier restaurante, y uno de los puntos más críticos es la comunicación entre el personal de sala y cocina. En muchos establecimientos, la toma de comandas y su envío a cocina puede resultar lenta, propensa a errores y generar retrasos en la atención al cliente. Ante esta necesidad, surge la idea de crear una aplicación que facilite el envío de comandas de manera simple, rápida y precisa.

Esta app está pensada para restaurantes y bares de cualquier tamaño que busquen optimizar el flujo de trabajo entre el área de servicio y la cocina. Su objetivo es reducir los tiempos de espera, minimizar los errores en las comandas y mejorar la experiencia tanto para los clientes como para los empleados. Mediante una interfaz intuitiva, los camareros pueden enviar las órdenes directamente a la cocina con solo unos clics, garantizando que cada plato llegue de forma exacta y a tiempo.


## 2. Modelo de datos

Estos son los modelos utilizados para el desarrollo de la app

### 2.1 Diagrama E/R

![er_fastservicecoop](https://github.com/user-attachments/assets/8ce46e53-6411-41b0-b3ff-08d52a52e865)

En este diagrama se aprecia todas las entidades de nuestra app. Tenemos a los camareros que atienden varias mesas, la mesa pide varios platos y los platos contienen varios ingredientes.

### 2.2 Diagrama UML

En el diagrama UML podemos apreciar todas las clases que debería tener la app junto a sus atributos y operaciones.

Ahora podemos ver que los ingredientes  tiene funciones públicas para obtener el conjunto o un solo ingrediente específico.

En platos, se aprecia que a parte de obtener los platos, tiene una función para abrir el modificador del plato.

Contiene es el que muestra las modificaciones del plato y te permite hacer un CRUD de los ingredientes que contiene cualquier plato.

La clase pedido tiene operaciones para enviar el pedido a cocina o eliminar el pedido a parte de cargar todos los platos del pedido.

La mesa tiene las funciones de leer, eliminar o añadir una mesa.
Los camareros tienen todas las funciones del CRUD.


![uml_fastservicecoop- ](https://github.com/user-attachments/assets/ecbdd08c-a927-4d45-abfc-3c168144a02e)


### 2.3 Diagrama Relacional
Aquí se aprecian todas las relaciones que existen entre cada entidad. En este diagrama se especifica la clave tanto única como foránea, y entidades que existen.

Camarero(id_user, username, password)
Ingredientes(id_ingrediente, nombre)
Platos(id_plato, nombre, id_mesa*)
Contiene(id_plato*,id_ingrediente*, cantidad)
Mesa(id_mesa, numero_mesa, disponibilidad, id_user*)
## 3. Requisitos de usuarios

El usuario, para poder utilizar la aplicación, requiere principalmente un navegador web, conexión a internet y una cuenta de usuario activa.
En lo que respecta al backend, es necesario disponer de los siguientes elementos:

Java 17 o superior.

Un IDE compatible con Spring Boot y Java.

Maven como herramienta de gestión de dependencias y construcción.

Para el frontend, se requieren los siguientes requisitos:

Node.js v16 o superior.

Vite como herramienta de construcción y desarrollo.

Un IDE compatible con JavaScript y React.

Por último, se requiere de una base de datos que podría ser  MySQL Workbench.

## 4. Casos de uso
![image](https://github.com/user-attachments/assets/035c4cc3-0fd1-4322-b107-119d9797d07c)


## 5. Descripción del sistema y especificaciones técnicas
### 5.1 Descripción general del sistema

FastService es una plataforma diseñada para optimizar la comunicación entre el personal de servicio y la cocina en restaurantes y bares, mejorando así la eficiencia y reduciendo posibles errores en los pedidos.

Frontend: Es una aplicación web interactiva desarrollada con React para ofrecer una experiencia de usuario fluida.

Backend: El servidor está construido utilizando Spring Boot y Java 17, gestionando la lógica de negocio y las interacciones con la base de datos MySQL.

### 5.2 Arquitectura del sistema
Frontend:

Tecnologías utilizadas: React, Vite, CSS/HTML.

La comunicación con el backend se realiza mediante APIs RESTful.

Backend:

Tecnologías utilizadas: Spring Boot, Java 17.

Base de datos: MySQL.

Repositorio de código disponible en GitHub.


### 5.3 Especificaciones técnicas
Servidor: El sistema está alojado en un servidor compatible con Java y Spring Boot, y cuenta con una base de datos MySQL 8.

Base de Datos: Relacional, con tablas que gestionan datos como Users, Exercises, Routines, entre otras.

Frontend Web: La interfaz está desarrollada en React, con diseño adaptable para dispositivos móviles y de escritorio.

Seguridad: Implementación de autenticación con JWT y almacenamiento seguro de contraseñas mediante bcrypt.

Pruebas: Se utilizan Vitest para la realización de pruebas en el frontend.

## 6 Interfaces
Diseño inicial en [figma](https://www.figma.com/proto/YmeJx71puwIhbEWP09SIhE/restaurapp?node-id=0-1&t=qjselpiCkZ9ZYgjU-1)


### 5.1 Usabilidad y accesibilidad
La aplicación ha sido diseñada con un enfoque en la usabilidad y accesibilidad, asegurando una experiencia inclusiva para todos los usuarios. Las medidas implementadas incluyen:

Navegación en todas las páginas: La estructura permite una navegación fluida y consistente a través de todas las páginas.

Contraste de colores: Se utiliza un contraste adecuado entre el texto y el fondo para facilitar la legibilidad.

Páginas tituladas: Cada página cuenta con un título claro y descriptivo, mejorando la navegación y comprensión.

Simplicidad: El diseño es simple y directo, evitando complejidad innecesaria.

Secuencia significativa: El orden en que se presenta el contenido es lógico y sigue una estructura que respeta su significado.

Elección de colores: Los colores utilizados son seleccionados para garantizar la visibilidad y accesibilidad.

Tamaño del objetivo: Los botones y elementos interactivos tienen un tamaño adecuado para facilitar su selección.

Lenguaje claro: El lenguaje utilizado en el sitio es sencillo y accesible, asegurando su comprensión por una audiencia diversa.

Prevención de errores: Se implementan medidas para prevenir errores comunes y proporcionar retroalimentación clara en caso de que ocurran.


## 7. Manuales
[Manual de instalación](https://docs.google.com/document/d/1rraouQFESCmMG4oPHARUDBl10KeKk-BKeC2EWpplWso/edit?tab=t.0)  
[Manual de usuario](https://docs.google.com/document/d/11mxM69mfPAsmIuoDagRmYYh0QC6FSdItTKOzNDq7ktE/edit?tab=t.0)

## 8. Tests
...

## 9. Pila tecnológica
### 9.1 Frontend
Tecnologías: React, HTML. CSS y Vite,

Comunicación con el backend a través de APIs RESTful.

### 9.2 Backend
Tecnologías: Spring Boot, Java 17.

Conexión a BBDD: MySQL.

Enlace del Repositorio Backend

Seguridad: Autenticación con JWT.


## 10. Comparación de pila tecnológica
Frontend: Se enfoca en la interacción del usuario, utilizando React para interfaces dinámicas y herramientas como Vite para optimización y rapidez en el desarrollo.

Backend: Maneja la lógica de negocio y el almacenamiento de datos, utilizando Spring Boot para la construcción de APIs y Java 17 para asegurar estabilidad y rendimiento, con MySQL como base de datos relacional.

Autenticación: Se gestiona con JWT, con la misma base tecnológica (Java 17), permitiendo seguridad en las interacciones entre el frontend y el backend.

En resumen, el frontend está centrado en la experiencia del usuario, el backend en la lógica y gestión de datos, y la autenticación se maneja de manera segura con JWT sobre Java 17, asegurando la integridad y privacidad de las sesiones de los usuarios.


## 11. Repositorios
[Frontend](https://github.com/Yeyeando/FastServiceCoop)  

[Backend](https://github.com/Yeyeando/SpringBootFS)

## 12. Planificación
Fase de Bocetos (Pincel):

Objetivo: Iniciar el proyecto visualizando ideas y conceptos preliminares.

Herramienta: Usamos Pincel para crear bocetos rápidos y esquemas que nos ayuden a definir la estructura general del diseño.

Actividad: El equipo hace representaciones visuales sencillas para explorar la disposición de los elementos, los colores, y las interacciones iniciales.

Resultado esperado: Tener una guía visual básica de cómo debería lucir el producto final.

Fase de Diseño Final (Figma):

Objetivo: Refinar los bocetos iniciales y crear el diseño visual definitivo.

Herramienta: Figma se utiliza para crear diseños interactivos y detallados con todos los elementos visuales, asegurando que la estética, la usabilidad y la funcionalidad estén bien definidos.

Actividad:Crear maquetas de alta fidelidad, definir la paleta de colores, tipografías y otras directrices visuales. También se pueden hacer prototipos interactivos.

Resultado esperado: Tener una versión final del diseño listo para la implementación en el frontend.

Desarrollo (Frontend y Backend simultáneos):

Objetivo: Desarrollar la funcionalidad del proyecto mientras se trabaja en la parte visual y de servidor.

Herramienta:Usamos GitHub para coordinarnos y gestionar el código de manera eficiente.

Actividad:

El frontend trabaja en la parte visual e interactiva del proyecto, basándose en los diseños finales de Figma.

El backend desarrolla las funcionalidades del servidor, la base de datos y la lógica, para que el sistema sea funcional.

Coordinación:Usamos GitHub para subir avances, gestionar ramas y fusionar los cambios, garantizando que tanto el diseño como la funcionalidad estén alineados y se integren de forma coherente.

Resultado esperado: El proyecto finaliza con una interfaz funcional y bien diseñada, respaldada por una lógica de servidor robusta.

Este enfoque modular, con fases claras de diseño y desarrollo y el uso de herramientas colaborativas como GitHub, asegura un flujo de trabajo ágil y la integración continua de tareas.


## 13. Conclusiones
En conclusión, a lo largo de este proyecto hemos experimentado una notable evolución como equipo, fortaleciendo nuestra capacidad de trabajar colaborativamente y aprendiendo nuevas tecnologías de manera continua. Hemos logrado adquirir habilidades tanto en backend, utilizando Spring Boot y aprendiendo a conectar aplicaciones con bases de datos, como en frontend, con el uso de React y Vitest para garantizar la calidad del código. Este proceso no solo ha sido un reto técnico, sino también una oportunidad para mejorar nuestra capacidad de ser resolutivos, enfrentando desafíos y buscando soluciones de forma ágil y eficiente.

## 14. Enlaces
[Github](https://github.com/)  
[SpringBoot](https://docs.spring.io/spring-boot/documentation.html)  
[Node.js](https://nodejs.org/es/learn/getting-started/introduction-to-nodejs)  
[Figma](https://www.figma.com/)  
[React](https://react.dev/learn)

