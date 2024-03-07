# LABORATORIO 5 - SPRING MVC INTRODUCTION

#### INTRODUCCIÓN A PROYECTOS WEB

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP
Usaremos las siguientes aplicaciones como cliente HTTP
- Postman
- Telnet

Abre la aplicación Postman, lo usaremos para hacer una solicitud a un servidor HTTP, al abrirlo indentifica qué controles de Postman corresponde a los elementos de entrada y salida de un servicio HTTP:

<img width="803" alt="image" src="https://github.com/PDSW-ECI/labs/assets/4140058/49acba5d-2f26-4515-96e9-af7aa50f89d4">

Has un request GET a la URL https://www.escuelaing.edu.co/es/ y verifica el body de respuesta en las opciones Pretty, Raw, Preview.

Ahora has otro request GET al recurso https://dummyjson.com/todos, nuevamente verifica el body en varias opciones.

Responde las siguientes preguntas:
- ¿Qué pasa si no envío el método correcto?
    En caso de no enviar el metodo correcto veremos que la aplicacion de Postaman nos envia el siguiente error}
    ![img.png](img.png)
- ¿Qué pasa si al body response HTML lo fuerzo a leerse como JSON?
    Al forzar la lecutra de un HTML como JSON vemos como se intenta interpretar el HTML como JSON en este proceso vemos como existen malas interpretaciones, como por ejemplo que el archivo en HTML tiene 4995 y el JSON en cambio reduce este numero a 4550 por ende se envidencia que el archivo se corrompio.
- ¿Por qué el preview de HTML no se ve igual a cuando accedo a la URL en un navegador web?
    Esto sucede debido a los estilos usados por la pagina no estan siendo usados todos los css y js que puedan modificar la apariencia del sitio web en este caso no se aplican al preview
- ¿Qué pasa si le envías un body a una solicitud GET?
    En caso de mandarle un body a una solicitud get y el body mandado da informacion relevante este se aplicara por ejemplo
![img_1.png](img_1.png)
    en caso contrario ignorara el body

Como parte del laboratorio en casa has los dos request anteriores pero ahora usando la herramienta Telnet, ya que esta no funciona adecuadamente en los equipos del laboratorio.

### PARTE II. - CLIENT SIDE RENDERING CON REACT
Para iniciar verifica que tengas alguna de estas herramientas:
- NPM o YARN

Verificando en terminal sería `$ npm init`

La siguiente misión es ejecutar una aplicación react localmente:
- Abre la aplicación https://codesandbox.io/s/react-js-simple-calculator-pefmr, loguéate con GitHub y juega cambiando los parámetros como colores y duplicando las líneas del archivo App.js con tags como `<ResultComponent ...>` en la función render.

- ¿Qué hace cada uno de los archivos en la aplicación?
  .
  ├── package.json
  ├── public
  │   └── index.html
  └── src
  ├── App.js
  ├── components
  │   ├── KeyPadComponent.js
  │   └── ResultComponent.js
  ├── index.js
  └── styles.css

package.json: El archivo package.json describe un proyecto de calculadora simple en React, con dependencias y scripts para desarrollo y construcción.
index.html: index.html es la página principal de la aplicación React. Define metadatos, enlaces a recursos como manifest.json y favicon.ico, y tiene un contenedor (div con id "root") donde la aplicación React se renderizará dinámicamente.

App.js: Es un componente de clase en React que implementa una calculadora simple. Gestiona el estado del resultado y define métodos para realizar cálculos, restablecer y retroceder. Utiliza componentes secundarios, "ResultComponent" y "KeyPadComponent", para mostrar el resultado y los botones de la calculadora.

KeyPadComponent.js: Este archivo define un componente de clase en React llamado "KeyPadComponent". Este componente representa los botones de una calculadora, donde cada botón tiene un valor asociado. Al hacer clic en un botón, se activa la función proporcionada por el componente principal a través de this.props.onClick, pasando el valor del botón como argumento. Los botones incluyen dígitos, operadores y funciones especiales como "CE" (borrado), "=" (igual) y paréntesis.

ResultComponent.js: Este archivo define un componente de clase en React llamado "ResultComponent". Este componente representa el área de visualización del resultado de la calculadora. Recibe el resultado como una propiedad (this.props.result) y lo muestra en un párrafo dentro de un contenedor.

index.js: Este archivo utiliza React y ReactDOM para renderizar la aplicación React llamada "App" en el elemento con el id "root" de la página, configurando el modo estricto de React para resaltar posibles problemas en el código.

styles.css: Este archivo de estilos establece reglas de estilo para la aplicación React de la calculadora.

- Después de haber visto los cambios, vuelve a abrir la URL original https://codesandbox.io/s/react-js-simple-calculator-pefmr y sigue los siguientes pasos:
1) Descargar código en un Zip
2) Descomprimir el Zip en la carpeta de proyectos de software, (en ciertos PC solo funciona 7-Zip)
3) Abrir una terminal de Git Bash en la carpeta descomprimida
4) Instalar las dependencias con `npm install`
5) Iniciar la aplicación con `npm star`, en algunos computadores con versiones antiguas de nodejs hay que agregar `NODE_OPTIONS=--openssl-legacy-provider npm run start`
6) Si te sale el Firewall dale click en cancelar
7) Abrir la ruta http://localhost:3000/ en un navegador web como Firefox o Google Chrome

Ahora, haz el request GET http://localhost:3000/ usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?

Cuando intentamos hacer el preview nos indica que necesita JavaScript para dar una preview por ende podemos definir que lso recursos para la visualizacion son static

### PARTE III. - HACIENDO UNA APLICACIÓN WEB DINÁMICA USANDO EL PATRÓN MVC
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de spring MVC.

Para esto usaremos la documentación oficial de Spring con que que aprenderemos las funciones básicas de este framework https://spring.io/guides/gs/serving-web-content/

Después de terminar el aprendizaje analice:
- ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial)
- ¿Cuáles son las ventajas de usar MVC?
- ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)?
- ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?
- Ahora, haz el request GET http://localhost:8080/greeting usando Postman, y revisa si el body de la respuesta es igual a alguno de los archivos del proyecto. Significa eso que es un recurso web dinámico o estático?

### PARTE IV. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful
Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API
https://jsonplaceholder.typicode.com/todos/1, puede guiarse de tutoriales como https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0

Luego de terminada esta parte responda:
- ¿Qué es RESTful?
- Si utilizo un framework como [Boostrap CSS](https://getbootstrap.com/) para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?

### PARTE V. - APLICACIÓN MVC JUEGO
¡Llego la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo `/guess`, y agrege formulario básico con un campo llamado "número" (guía de como crear formularios HTML https://www.w3schools.com/html/)

Y vamos a implementar la lógica de nuestro juego:
1. Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio
   se reduce en $10.000, como en los juegos de apuesta, es natural qué quede en saldos negativos.
2. El número a adivinar debe ser generado en cada intento y comparado con el número qué el usuario está insertando, es un número de 1 a 10.
3. Debe existir un botón de reset, qué permita al jugador iniciar de nuevo.
4. La capa de controlador debe procer el número del usuario mediante método `POST`.

Analice las siguientes situaciones:
- ¿Qué pasa si abro el sitio de juegos en dos navegadores difententes?
- Si quisiera qué a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?

## ENTREGA
- En un README.md colocar lo siguiente:
- Una sección llamada “INTEGRANTES” y allícolocar el listado de los integrantes del taller (máximo 2).
- Una sección llamada “RESPUESTAS” colocar lasrespuestas a las preguntas:
- Configurar el archivo .gitignore para excluir del repositorio los archivos no relevantes.
- En una carpeta en la raiz del repositorio llamada diagrams y allí realizar un diagrama de clases del proyecto.
