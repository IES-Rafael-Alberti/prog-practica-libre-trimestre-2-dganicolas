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
- **Paso 1**: pienso en las acciones que puedes hacer en una pelea
- en la vida real para hacer una pelea minimo, debe haber 2 personas 
- en la pelea, puedes infligir daño al atacante o que el atacante te dañe a ti, 
- o tambien retirarte si ves que estas a punto de morir, 
- despues de esa pelea tanto tu como el atacante os debeis de curar 
- entonces he creado 2 interfaces que todo jugador o luchador debe de implementar 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Acciones.kt#L4-L26
- la interfaz **player**, que hace referencia a todas las acciones los jugadores que puede haber en la partida,
- y la interfaz **enemigo**, que hace referencia a todas las acciones que puede hacer un enemigo

- la eleccion de que sea una interfaz en vez de una clase que herede de otras, es por que el propio IDE,
- al ver que una clase implementa una interfaz y detecta que esa interfaz tiene variables abstracta el mismo te lo pone en el constructor primario automaticamente, lo que me ahorra tiempo al desarrollar nuevas clases, tambien es una interfaz para cumplir el principio del **DIP**,en este caso con la abstraccion mediante la interfaz, en la clase partida
  https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Partida.kt#L8-L11
- y tambier cumplir con el principio solid **ISP**, ya que las clases clientes que implementen Enemigo, Player o Seller, no tendran metodos que no necesiten 
- **Paso2**: Creacion de clases mediante la dependencia de la interfaz
- creo las clases Jugador, Enemigo, Vendedor que implemente las Interfaces que requieran 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L7-L17
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L73-L80
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/67fa8ec906b169f582d745005f2c9662d5f4433d/src/main/kotlin/Personas.kt#L94-L103

- una vez creadas, desarrollando solo el comportamientos de los  metodos, ya que las variables se definen automaticamente en la clase al implementar la interfaz que necesite, ahorro un poco de tiemnpo al crearlo de esta manera.

- Asi tambien cumplo con el principio SOLID de ISP, 
- ya que la clase cliente Zombie, no tiene los metodos de la interfaz IrAlHospital,
- y solo tiene la interfaz Curarse una vez terminada la pelea que en este caso si es necesario que lo implemente







- Proporciona ejemplos específicos de tu código.
- Tengo dos objetos principales,
- donde uno es Jugador y otro el vendedor,
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/97f3c539266ffdde5bdc0f3ccda3368704d8fdc6/src/main/kotlin/Main.kt#L47-L50
- que jugador sigue la jerarquia de la Interfaz de Player
-https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/97f3c539266ffdde5bdc0f3ccda3368704d8fdc6/src/main/kotlin/Acciones.kt#L4-L13
- vendedor de la interfaz de Seller,
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/97f3c539266ffdde5bdc0f3ccda3368704d8fdc6/src/main/kotlin/Acciones.kt#L15-L20
- 
- y la hora de interactuar con los objetos, lo hago mediantes las dependencias de sus interfaces
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/97f3c539266ffdde5bdc0f3ccda3368704d8fdc6/src/main/kotlin/Tienda.kt#L73-L80

- tambien tengo en el main una lista de tipo interfaz enemigo, donde tengo las clases que implemente la interfaz enemigo, inicializada dentro de una lista
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/97f3c539266ffdde5bdc0f3ccda3368704d8fdc6/src/main/kotlin/Main.kt#L27-L46

a la hora de pasar los parametros al constructor, 
lo he hecho mediante valores constantes que yo previamente pong en el codigo, por falta de tiempo se que se le pueden pasar variables en el constructor principal entonces ahora esta asi:

EJEMPLO HIPOTETICO:
Jugador:Player(var nombre: String,....){...}
yo ahora inicializo las clases asi
jugador= Jugador("nico",....)
pero me hubiera gustado asi 
val nombre = readln()
jugador= Jugador(nombre,....)

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- si he definido 2 metodos estaticos,
- con el objetivo de redondear numeros y dividir entre cien para hacer que se cure un porcentaje de vida
- mi objetivo es transforma la vida cuando el jugador se cura o cuando recibe monedas,
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/4eb8a1d1312fca7efbe6ef37c5529cdcc8296954/src/main/kotlin/Main.kt#L20-L26
- entonces para no poner
- EJEMPLO HIPOTETICO:
- (vidaActual*porcentaje/100).redondear()
- se me facilita la mantenibilidad del codigo, ponerlo en una funcion
- pornerlo asi
- (vidaActual*porcentaje).redondear()
- por que asi tengo que cambiar el numero 100
- lo cambio solo en esta unica funcion y no en tengo que mirar mas partes del codigo :D
- 











- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?
- 
- https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-dganicolas/blob/4eb8a1d1312fca7efbe6ef37c5529cdcc8296954/src/main/kotlin/Personas.kt#L46-L56
- en este caso, lo llamo aqui las dos funciones, para calcular la vida que el personaje recupera,
- entonces el parametro porcentajeQueSeVaACurar, lo divido entre 100, por que me entra una numero entero,
- 0 a un numero entero, ya sea positivo o negativo, por si acaso tengo que implementar que un mal curamiento, te haga daño 











#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

- en el proceso de creacion de clases, al crear las diferentes clases padres, el IDE me ayudaba en errores comunes como el no poner que tipo de variables que es en el constructor
- tambien a la hora de hacer clases heredadas, el ide en todo momento me alertaba de fallos como que en el constructor primario de la clase heredada no era igual que el de la clase padre,
- o que me faltaba importar variables de la clase padre en el proceso de compilacion el propio IDE me decia, aqui hay un error de sistanxis, 
- o en el archivo, en la funcion y en la linea (98:94) se esperaba un valor de tipo Float, pero se ha introducido uno de tipo Int

- en las pruebas del programa utilize el modo debug directamente:
- donde ide me ha ayudado con su modo debug al hacer pruebas, tantos como formulas matematicas que puse de manera erronea, donde me decia en todo momento con el watch, los valores de variables, como el poder asignar el valor en el propio tiempo de ejecucion 
- El ide me ha ayudado en el uso de la visibilidad de las variables/metodos, por ejemplo si veia que esa variable o metodo se usaba solo dentro de una clase/objeto, me alertaa que se podia poner privada, tambien en el modo debug o depuracion tenia un bucle infinito en Partida.kt, el cual es el siguiente:
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
- entonces en el if marcado ateriormente, estaba la condicion distinto de true de HUID, entonces me geneor un bucle infinito
- que gracias al IDE pude solucionar

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, 
- métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. 
- ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?














#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. 
- ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? 
- ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? 
- ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?




















#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. 
- ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? 
- ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?






















#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. 
- Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. 
- ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.























#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? 
- ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?





















#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

























**APUNTES PARA NICOLAS**
CLASES
-class
-abstract class
-enum class
-sealed class
interfaces

Tematica de la practica, 
posible rpg 
con un enum class para el tipo de arma 
una data class para el personaje
una abstract class o interfaz para los enemigo
posible abstract class para los dungeons 
una funcion generica para las batallas
una class juego 
quiero que el personaje pueda tener nombre

principios de responsabilidad unica que debo cumplir


Principio de Responsabilidad Única ("**S**ingle Responsibility Principle" - SRP)
Un módulo o clase debe tener solo una razón para cambiar, lo que significa que debe tener solo una tarea o responsabilidad

Principio de Abierto/Cerrado ("**O**pen/Closed Principle" - OCP)
Definición: Las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas para la extensión, pero cerradas para la modificación. Es decir, se debe poder extender el comportamiento de la entidad pero sin modificar su código fuente.

Principio de Substitución de Liskov ("**L**iskov Substitution Principle" - LSP)
Definición: Los objetos de una superclase deben poder ser reemplazados con objetos de sus subclases sin afectar la correctitud del programa.

Principio de Segregación de la Interfaz ("**I**nterface Segregation Principle" - ISP)
Definición: Los clientes no deben ser forzados a depender de interfaces que no utilizan.
