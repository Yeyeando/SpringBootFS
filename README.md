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

## Introducción
La eficiencia en los procesos de cocina es clave para el éxito de cualquier restaurante, y uno de los puntos más críticos es la comunicación entre el personal de sala y cocina. En muchos establecimientos, la toma de comandas y su envío a cocina puede resultar lenta, propensa a errores y generar retrasos en la atención al cliente. Ante esta necesidad, surge la idea de crear una aplicación que facilite el envío de comandas de manera simple, rápida y precisa.

Esta app está pensada para restaurantes y bares de cualquier tamaño que busquen optimizar el flujo de trabajo entre el área de servicio y la cocina. Su objetivo es reducir los tiempos de espera, minimizar los errores en las comandas y mejorar la experiencia tanto para los clientes como para los empleados. Mediante una interfaz intuitiva, los camareros pueden enviar las órdenes directamente a la cocina con solo unos clics, garantizando que cada plato llegue de forma exacta y a tiempo.


## Modelo de datos

Estos son los modelos utilizados para el desarrollo de la app

### Diagrama E/R

![er_fastservicecoop](https://github.com/user-attachments/assets/8ce46e53-6411-41b0-b3ff-08d52a52e865)

En este diagrama se aprecia todas las entidades de nuestra app. Tenemos a los camareros que atienden varias mesas, la mesa pide varios platos y los platos contienen varios ingredientes.

### Diagrama UML

En el diagrama UML podemos apreciar todas las clases que debería tener la app junto a sus atributos y operaciones.

Ahora podemos ver que los ingredientes  tiene funciones públicas para obtener el conjunto o un solo ingrediente específico.

En platos, se aprecia que a parte de obtener los platos, tiene una función para abrir el modificador del plato.

Contiene es el que muestra las modificaciones del plato y te permite hacer un CRUD de los ingredientes que contiene cualquier plato.

La clase pedido tiene operaciones para enviar el pedido a cocina o eliminar el pedido a parte de cargar todos los platos del pedido.

La mesa tiene las funciones de leer, eliminar o añadir una mesa.
Los camareros tienen todas las funciones del CRUD.


![uml_fastservicecoop- ](https://github.com/user-attachments/assets/ecbdd08c-a927-4d45-abfc-3c168144a02e)


### Diagrama Relacional
...

## Requisitos de usuarios
...

## Casos de uso
...

## Descripción del sistema y especificaciones técnicas
### Descripción general del sistema
...

### Arquitectura del sistema
...

### Especificaciones técnicas
...

## Interfaces
### Usabilidad y accesibilidad
...

## Manuales
...

## Tests
...

## Pila tecnológica
### Frontend
...

### Backend
...

## Comparación de pila tecnológica
...

## Repositorios
...

## Planificación
...

## Conclusiones
...

## Enlaces
...
