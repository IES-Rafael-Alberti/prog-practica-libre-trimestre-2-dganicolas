class Textojuego {

    /**
     * FUNCIONES VARIAS
     * */
    fun limpiarConsola(){
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }

    fun <T>imprimir(imprimir:T){
        println(imprimir)
    }

    fun animacion(){
        var puntos = "*"
        limpiarConsola()
        println(puntos)
        Thread.sleep(1000)

        for (i in 1..5) {
            // Espera un segundo
            puntos += "."
            limpiarConsola()
            println(puntos)
            Thread.sleep(500)
        }
        puntos += "*"
        Thread.sleep(500)
        println(puntos)
    }

    /**
     * Mostrar pantalla
     * */

    fun mostrarEscenario(jugador: Jugador, enemigo: Luchadores) {
        limpiarConsola()
        val escenario = arrayOf(
            "-------------------------------------------------------",
            "-Enemigo: ${enemigo.nombre}",
            "-Nivel: ${enemigo.nivel}",
            "-Vida: ${enemigo.vida}",
            "-   ....   ...   ... ...  ..",
            "-  ...  ...   ...       .. .",
            "- ... ........     ...     .",
            "-Tu: ${jugador.nombre}",
            "-Nivel: ${jugador.nivel}",
            "-Vida: ${jugador.vida}",
            "-------------------------------------------------------",
            "-Selecciona una opcion:      Arma: ${jugador.arma}",
            "- (1)atacar      (2)huir",
            "-------------------------------------------------------"
        )
        for (lineas in escenario) {
            println(lineas)
        }
    }

    fun mostrarvida():String{
        var corazones= ""
        for (i in 0.. (Jugador.vida.toInt()-1){
            corazones+= "♥"
        }
        for(i in 0..(((Jugador.vidaActual).toInt() - Jugador.vida)-1).toInt()){
            corazones+= "*"
        }
        return corazones
    }

    fun mostrarmenu(){
        limpiarConsola()
        println("BIENVENIDO A NAYD3C WORLDS")
        println("Nombre: ${Jugador.nombre}")
        println("Nivel: ${Jugador.nivel}")
        println("Vida: ${mostrarvida()}")
        println("¿Que quieres hacer joven aventurero?")
        println("(1)Pelea")
        println("(2)Recuperar vida")
        println("(3)Fin del juego")
    }

    /**
     * Acciones
     * */
    fun<T> curarVida(nombre:T){
        println("$nombre se ha curado sus heridas")
    }
    /**
     * BATALLAS
     * */


    fun recibirAtaque(nombre:String, ataque:Float){
        println("$nombre recibe un daño de $ataque puntos")
    }

    fun hacerAtaque(nombre:String, ataque:Float){
        println("$nombre lanza un ataque de $ataque puntos")
    }

    fun huidaPelea() = "Has podido huir de la batalla"

    fun enterparacontinuar() {
        println("pulsa ENTER para continuar")
        readlnOrNull()
    }

    fun mensajeDeError()= "ERROR,Las Opciones validas son 1, 2 o 3"

}