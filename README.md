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
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.
- El ide me ha ayudado en el uso de la visibilidad de las variables/metodos, por ejemplo si veia que esa variable o metodo se usaba solo dentro de una clase/objeto, me alertaa que se podia poner privada, tambien en el modo debug o depuracion tenia un bucle infinito en Partida.kt, el cual es el siguiente:
  - codigo erroneo resumido:
  - 
  - **companion object**{
    var HUIDA = false
    }
  - 
  - **fun batalla**(){
    while (PELEA && luchador.vida > 0 && jugador.vida > 0) {
         Textojuego().mostrarEscenario(Jugador, luchador)
         val opcion = elegirOpcion()
         when (opcion) {
                3 -> {
                    **HUIDA = true**
                }
  - }
  - 
  - **private fun finalBatalla(luchador:Luchadores)** {
    if (**!HUIDA**){
      huida(luchador)
      HUIDA = false 
    }
  }
  - donde este codiog resumido, cuando el usuario apretaba la opcion 3, 
  - que era huida,
  - entonces en el if marcado ateriormente, estaba la condicion distinto de true de HUID, entonces me geneor un bucle infinito
  - que gracias al ide pude solucionar

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?
- pues he implementado algunas funciones genericos, en cuestion de ahorro de codigo 
- como puede ser:
  - para los turnos de ataque primero pense
    - fun ataqueJugador(jugador:Jugador,enemigo:Luchadores)
    - fun ataqueJugador(enemigo:Luchadores,jugador:Jugador)
  - entonces, lo podre hacer en una sola funcion y llegue a la siguiente funcion:
    ````
    fun <T: Peleas>atacar(atacante:T, objetivo:T){
         objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
    }
  entonces gracias a esta funcion pude lograr ahorrarme unas cuantas lineas de codigos en mi proyecto
    
- tambien tengo otro ejemplo:
- en la clase textoJuego() que su unica responsabilidad es mostrar texto en pantalla
- tengo la siguiente funcion:
  - fun <T>finalBatalla(jugador : T){
      when(jugador){
         is Jugador -> { "${Jugador.nombre} ha sido debilitado, has perdido ${Jugador.pagar(Jugador.monedas/2)}" }
         is Luchadores -> { "${jugador.nombre} ha sido debilitado, has ganado ${Jugador.pagar(Jugador.monedas/2)}" }
    }
    }
- la cual me compacto dos funciones en una, y lo mismo me ahorro unas cuantas lineas de codigos en el proyecto

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