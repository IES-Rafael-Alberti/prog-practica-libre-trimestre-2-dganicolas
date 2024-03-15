[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? 
- Proporciona ejemplos específicos de tu código.
- **Paso 1**Definir acciones en el juego: 
  - Anoto todas las acciones que puedes hacer en una pelea,
  - En la vida real para hacer una pelea minimo, debe haber 2 personas,
  - En la pelea, puedes infligir daño al atacante o que el atacante te dañe a ti, 
  - O tambien debes saber cuando retirarte si ves que estas a punto de morir, 
  - Despues de esa pelea tanto tu como el atacante os debeis de curar, 
  - Entonces he creado 2 interfaces que todo jugador o luchador debe de implementar. 
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Acciones.kt#L4-L26
  - La interfaz **player**, que hace referencia a todas las acciones que puede realizar los jugadores,
  - Y la interfaz **enemigo**, que hace referencia a todas las acciones que puede realizar un enemigo

  - La eleccion de que sea una interfaz en vez de una clase que herede de otras, es por que el propio IDE,
  - Al ver que una clase implementa una interfaz y detecta que esa interfaz tiene variables abstracta,
  - El mismo te lo pone en el constructor primario automaticamente,
  - Lo que me ahorra tiempo al desarrollar nuevas clases.
  - Tambien es una interfaz para cumplir el principio del **DIP**,en este caso con la abstraccion mediante la interfaz, en la clase partida
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Partida.kt#L8-L11
  - y tambien cumplir con el principio solid **ISP**, ya que las clases clientes que implementen Enemigo, Player o Seller, no tendran metodos que no necesiten 
- **Paso2** Creacion de clases: 
  - Creacion de clases mediante la dependencia de la interfaz
  - creo las clases Jugador, Enemigo, Vendedor que implemente las Interfaces que requieran 
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L7-L17
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L73-L80
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L94-L103

  - Una vez creadas, desarrollando solo el comportamientos de los  metodos, 
  - ya que las variables se definen automaticamente en la clase al implementar la interfaz que necesite, 
  - ahorro un poco de tiemnpo al crearlo de esta manera.
  - 
  - Asi tambien cumplo con el principio SOLID de ISP, 
  - ya que la clase cliente Zombie, no tiene los metodos de la interfaz IrAlHospital,
  - y solo tiene la interfaz Curarse una vez terminada la pelea que en este caso si es necesario que lo implemente
- **Paso 3**: Instanciar objetos
  - a la hora instanciar los objetos he igualado la variable jugador y vendedor a sus respectivas clases,
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Main.kt#L67-L110
  - tambien los objetos que implementen la interfaz Enemigo, los he metido en una lista de tipo Enemigo
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Main.kt#L111-L113
  - tambien instancio como la base de datos del juego 
  - el gestor de la base de datos
  - y la partida 


#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? 
- ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- si he definido 2 metodos estaticos,
- uno es el de dividir entre 100,
- que es tu le pasas un numero ya sea negativo o positivo,
- y te lo divide entre cien 
- ejemplo: 
- le entra un numero entero 60 
- y te devuelve 
- 0,6
- tambien tengo el otro metod estatico
- redondear
- que lo utilizo para cuando el jugaodr se cure, su vida no aparezca 
- 34.555444333365555
- si no que me aparezca 
- 34.55
- entonces por que uso los metodos estaticos en vez de en lugar de un método/propiedad de instancia,
- por dos razones:
- **Razon numero 1**:
  - esos metodos lo deberian de usar tanto
  - la interfaz Enemigo al curarse,
  - como la interfaz Seller al recibir monedas y
  - el jugador al curarse o recibir monedas.
  
  - **lo implementare mas a futuros algunas modificaciones de las clases para que use mas metodos pero por falta de tiempo lo he entregado asi,** 
  
  - entonces pensando de esa manera 
  - esos metodos forman en comun con otras clases o interfaces
  - entonces para ahorrarme codigo repetido de funciones de diferentes clases con la misma funcion,
  - lo he creado de esa manera para no hacer la practica de  Don’t Repeat Yourself de clean code
  - mi objetivo es transforma la vida cuando el jugador se cura,
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/4eb8a1d1312fca7efbe6ef37c5529cdcc8296954/src/main/kotlin/Main.kt#L20-L26
- **Razon numero 2**:
  - por temas de mantenibilidad del codigo 
  - nos ponemos en un caso hipotetico que a futuro, mi proyecto necesita,
  - dividir el porcentaje de vida entre 200, por que queremos añadirle un poco de dificultad a la partida,
  - pues por mantenibilidad del codigo y por futuras modificaciones
  - esta modificacion tardo en cambiarlo en una sola linea de codigo, en vez de estar mirando todo el proyecto

- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?
  
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/4eb8a1d1312fca7efbe6ef37c5529cdcc8296954/src/main/kotlin/Personas.kt#L46-L56
  - en este caso, lo llamo aqui las dos funciones, 
  - para calcular la vida que el personaje recupera,
  - entonces el parametro porcentajeQueSeVaACurar, 
  - lo divido entre 100, por que me entra una numero entero,
  - un numero entero, ya sea positivo o negativo, 
  - por si tengo que implementar que un mal curamiento a futuro en el proyecto,
  - te haga daño y te reste vida 
  - y tambien tengo el redondear para que mi variable vida no se gurade asi,
  - 6.33333333333333
  - si no asi 
  - 6.33

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? 
- Describe el proceso de creación, compilación, y prueba de tu programa.

- en el proceso de creacion de clases, al crear las diferentes clases padres,
- el IDE me ayudaba en errores comunes como el no poner que tipo de variables que es en el constructor
- cosa que ya no me es necesario mirar gracias al uso de interfaces,
- ya que el ide me implementa automaticamente las variables que usa esa clase que hereda de esa interfaz.
-
- Tambien me decia en todo momento los errores de sintaxis o que un metodo o clase no estaba cerrado,
- avisandome del error diciendome,
- en el archivo tal, hay un error en la linea 95:100, el primer numero es la linea y el segundo el caracter

- en las pruebas del programa utilize el modo debug directamente:
- donde ide me ha ayudado con su modo debug al hacer pruebas, 
- tantos como formulas matematicas que puse de manera erronea, 
- donde me decia en todo momento con el watch, 
- los valores de variables, como el poder asignar el valor en el propio tiempo de ejecucion. 
- El ide me ha ayudado en el uso de la visibilidad de las variables/metodos, 
- por ejemplo si veia que esa variable o metodo se usaba solo dentro de una clase/objeto, 
- me alertaba que se podia poner privada.
- 
- tambien en el modo debug o depuracion tenia un bucle infinito en Partida.kt, el cual es el siguiente:
  - codigo erroneo resumido:
    ````
    companion object{
       var HUIDA = false
    }
    fun batalla(){
    while (PELEA && luchador.vida > 0 && jugador.vida > 0) {
         Textojuego().mostrarEscenario(Jugador, luchador)
         val opcion = elegirOpcion()
         when (opcion) {
                3 -> {
                    **HUIDA = true**
                }
    } 
    private fun finalBatalla(luchador:Luchadores){
    if (!HUIDA){
      huida(luchador)
      HUIDA = false 
    }
    }
- donde este codiog resumido, cuando el usuario apretaba la opcion 3, 
- que era huida,
- entonces en el if marcado ateriormente,
- estaba la condicion distinto de true de HUIDA, entonces me genero un bucle infinito
- que gracias al modo debug del IDE pude solucionar, con rapidez

- el propio IDE ,me ha ayudado en solucionar errores comunes de manera muy rapida,
- ya que me avisaba donde estaba ese error y me decia tambien algunas mejoras de codigo, 
- entonces me ayudo de manera de ser mas eficiente a la hora de desarrollar.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, 
- cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, 
- métodos y constructores y modificadores del control de acceso a métodos y propiedades, 
- para representar al objeto del mundo real.
- ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Acciones.kt#L4-L74
- aqui tengo todas las acciones que puede hacerm is clases donde 
- en la vida real tu en una pelea puedes lanzar un objeto o un puñetazo o apuñalar al otro
- o te pueden hacer daño a ti 
- y cuando tu estas muy mal, pues puedes saber tu estado y retirarte antes de que mueras por las heridas
- entonces en la interfaz Peleas lo he representado de esta manera
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Acciones.kt#L37-L57
- el hacerAtaque() representa:
  - en una pelea puedes lanzar un objeto o un puñetazo o apuñalar al otro.
- el recibirAtaque() representa:
  - te pueden hacer daño a ti
- el saberVida() representa:
  - saber tu estado y retirarte antes de que mueras por las heridas

- Tambien tengo otra interfaz que es IrAlMedico,
- Donde en la vida real, 
- cuando tu vas al medico, 
- el medico te analiza la condicion fisica,
- el medico te pregunta si tienes dinero para el tratamiento y entonces
- una vez que hayas pagado al medico, entonces es cuando el medico te cura.
- 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Acciones.kt#L60-L66
- entonces mi funciones de esa interfaz son las siguientes:
- el medicoPreguntaPorTuCondicionFisica():
  - representa que el medico te analiza y ve tu estado fisico
- el medicoPreguntaPorTuDinero():
  - el medico pregunta si tienes dinero antes de recibir el tratamiento
- pagarAlmedico(coste: Float):
- una vez que hayas pagado a lmedico, es cuando ya te da el tratamiento y cura tu condicion fisica












#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: 
- Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. 
- ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? 
- ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? 
- ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?
- 
la herencia la he implementado, con las diferentes interfaces, donde en partida 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Partida.kt#L9-L12
  - tengo las siguientes variables:
  - private var jugador: Player : esta variable hace que la clase partida tenga una dependencia de la interfaz Player
  - private var vendedor:Seller : esta variable hace que la clase partida tenga una dependencia de la interfaz Seller
  - private var personajes: List<Enemigo> : esta variable hace que la clase partida tenga una dependencia de la interfaz Enemigo
  - private var informePartida: InteractuarBasesDeDatos : esta variable hace que la clase partida tenga una dependencia de la interfaz InteractuarBasesDeDatos
- entonces en la clase partida cumplo 
- el principio de DIP: que dice que ninguna clase tiene que depender de clases o interfaces abstractas y no de clases o interfaces concretas
  - la clase partida depende de las interfaces en vez de clases concretas
- el principio OCP: que dice una clase debe estar abierta a su modificacion pero cerrado a su modificacion 
  - a la hora de modificar algo del funcionamiento de la partida, yo tengo que modificar las clases que llama partida,
  - pero en ningun momento tengo que modificar partida como tal
- el principio LSP: que dice que cualquier clase padre puede ser sustituido por sus subclases
  - yo puedo reemplazar las diferentes clases o crear nuevas 
  - y la clase partida no se entera, 
  - ya que van a implementar las interfaces que necesiten
- el principio ISP: dice que ninguina interfaz debe estar sobrecargada con metodos innecesarios
  - la Clase partida depende de la interfaz Player, pero
  - Player hereda de otras interfaces que necesita
  - https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Acciones.kt#L4-L13

- Tambien tengo otro principio que cumplo
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/Acciones.kt#L4-L74
- en este cas , implemento una jerarquia de interfaces donde 
- ejemplo:
- interface Player:Estadisticas, Peleas, Curarse, Transacciones, IrAlMedico
- la interfaz Player hereda de las siguientes interfaces Estadisticas, Peleas, Curarse, Transacciones, IrAlMedico
  - el principio ISP: que dice que las interfaces deben ser especificas para sus clases clientes, en vez de tener una interfaz general para todo
    - Player hereda de otras interfaces que realmente necesita

- tambien tengo estas clases 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/85b4672634a48029ac860e906295ddcc786bcb5a/src/main/kotlin/InformePartida.kt#L6-L44
  - la clase InformePartida:
    - el principio de SPR: que dice que una clase solo debe de tener una unica responsabilidad
      - la clase InformePartida la unica responsabilidad que tiene es gestionar la información del informe de partida
    - el principio de OCP: que dice que una clase debe estaer abierta a su extension pero cerrada a su modificacion
      - la clase InformePartida, puedo añadirle funcionalidad pero, no tengo el por que modificarla a futuro
  
    - la clase GestionInfoJuego:
      - el principio SPR: que dice que la clase solo debe tener un motivo para cambiar
        - la clase GestionInfoJuego solo se encarga de la gestion de la informacion

    
#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. 
- ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? 
- ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

- la jerarquia que he presentado es la siguiente
- es la siguiente
![alt imagen de las interfaces](https://docs.google.com/drawings/d/e/2PACX-1vTHG4IYbCmOevr0zFYeg3j-z5IR12AesUpCpEgd8_vdOVbiSdSd4Pu7RSrpKIJUmzTwnHzaPgZJ1Ao6/pub?w=1093&h=337)
- en la cual la Interfaz Player puede salir todas las clases jugables
- en la Interfaz Enemigos puede salir todas las clases que son enemigos de player
- en la interfaz EquipablesPrecioEstadisticas puede salir todas las clase que sean consumibles o equipable.

- primero probe sin interfaces, si no una clase jugador y otra clase enemigo
- depure esas dos clases,
- una vez que me funcionaban correctamente, cogi todo de las diferentes clase y la hize una interfaz 
- despues implemente esas interfaces en partida y consegui un nuevo nivel de abstraccion.

- el tipo de herencia utilizado es Especialización,
- dado que las interfaceses para algo general, per oen cuantro creo una clase derivada de ella
- es algo mas concreto.

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. 
- Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. 
- ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.
- he utilizado la libreria mordant
- la escogi por el diseño de la consola, me gusta que pueda añadirle colores al menu
- la incorpore en la clase TextoConsola
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f8a03fe93f31cec5adf6200958f72f502861bca9/src/main/kotlin/consola/TextoConsola.kt#L126-L147
- la escogi por temas de expandir la funcionalidad de la estetica 
- añadiendo una barra de carga mas estetica o añadiendo que los menus se vean con un borde o con un color diferente


#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. 
- ¿Que herramientas has utilizado? 
- ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?
en estos ejemplos he documentado con Kdoc 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f28502426c6046bc1feb2e8b988844733033c9c8/src/main/kotlin/ArmasyArmaduras.kt#L1-L24
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f28502426c6046bc1feb2e8b988844733033c9c8/src/main/kotlin/Main.kt#L14-L27
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f28502426c6046bc1feb2e8b988844733033c9c8/src/main/kotlin/RealizarBatalla.kt#L14-L23
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f28502426c6046bc1feb2e8b988844733033c9c8/src/main/kotlin/InformePartida.kt#L5-L26
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f28502426c6046bc1feb2e8b988844733033c9c8/src/main/kotlin/InformePartida.kt#L44-L62
- mi documentacion aporta valor a futuro, donde cuando yo no este trabajando en este proyecto o si tengo que retomar este codigo o modificarlo
- me sea mas facil de entender viendo el comentario y viendo lo que pone mas ver el comentario me resultaria mas facil interpretar el codigo 
- 
- a la hora de depurar me puede servir para ayudar a otros programadores a entender el codigo
- a la hora de mantenimiento, me sirve para que otros programadores hagan modificaciones del programa sin complicaciones gracias a la documentacion 
- 

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. 
- ¿Qué beneficio has obtenido?
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f0faa6faa783c04082168be864d5b1a9a59ba8fb/src/main/kotlin/consola/TextoConsola.kt#L171-L176
- aqui he utilizado una funcion generica, 
- ya que a la hora de finalizar la pelea, nose si me entra un Enemigo o un Player como ganador,
- 
- entonces como ganador o perdedor me puede entrar cualquier clase, 
- pero como minimo tiene que cumplir que implemente las interfaces Estadisticas, Transacciones.
-
- esta funcion me soluciona el problema de
- creo dos funcion para ganadorEnemigo, ganadorPlayer
- pues con esta funcion la compacto en una y me soluciono ese problema
- y unas lineas de codigos extras

- tambien tengo esta otra funcion
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f0faa6faa783c04082168be864d5b1a9a59ba8fb/src/main/kotlin/RecibirTratamiento.kt#L6-L7
- donde aqui tengo otra funcion generica donde me pueden pasar cualquier clase para que se cure.
- pero tiene que implementar esa clase como minimo la interfaz Curarse
- 
- esta funcion me soluciona el problema de
- creo dos funcion para curarEnemigo, curarPlayer
- pues con esta funcion la compacto en una y me soluciono ese problema
- y unas lineas de codigos extras

- o esta otra
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/f0faa6faa783c04082168be864d5b1a9a59ba8fb/src/main/kotlin/RealizarBatalla.kt#L13-L17
- donde tengo esta funcion generica para que el Player o el Enemigo se ataque.
- 
- esta funcion me soluciona el problema de 
- creo dos funcion para turnoEnemigo, turnoJugador
- pues con esta funcion la compacto en una y me soluciono ese problema
- y unas lineas de codigos extras 

- los beneficio de esta funcion es en hacer un codigo mas limpio al no repetir tanto codigo similar

