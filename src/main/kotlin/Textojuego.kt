class Textojuego {
    fun limpiarConsola(){
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }

    fun mostrarMenu(){

        println("que quieres hacer ${Jugador.nombre}")
        println("(1) ir a luchar")
        println("(2) ir al vendedor")
        println("(3) dormir en el suelo")
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
            Thread.sleep(1000)
        }
        puntos += "*"
        Thread.sleep(1000)
        println(puntos)
    }

    fun mostrarEscenario(jugador: Jugador, enemigo: Enemigos) {
        val escenario = arrayOf(
            "-------------------------------------------------------",
            "-${enemigo.nombre}",
            "-${enemigo.nivel}",
            "-${enemigo.vida}",
            "-   ....   ...   ... ...  ..",
            "-  ...  ...   ...       .. .",
            "- ... ........     ...     .",
            "-------------------------------------------------------",
            "-${jugador.nombre} Selecciona una opcion:",
            "- (1) atacar (2) defensa      Arma: ${jugador.arma}",
            "-------------------------------------------------------"
        )
        for (lineas in escenario) {
            println(lineas)
        }
    }

    fun jugadorAtaca(jugador: Jugador,enemigo: Enemigos,frase:Int):String{
        if (frase ==1){
            if (enemigo.vidaActual < 0){enemigo.vidaActual= 0f}
            return "${jugador.nombre} ha causado un daño de ${jugador.hacerAtaque()} al ${enemigo.nombre}, vida restante ${enemigo.vidaActual}"
        }
        if (frase ==2){
            if (jugador.vidaActual < 0){jugador.vidaActual= 0f}
            return "el ${enemigo.nombre} ha causado un daño de ${enemigo.hacerAtaque()} al ${jugador.nombre}, vida restante ${jugador.vidaActual}"
        }else {return ""}

    }

    fun huidaPelea() = "Has podido huir de la batalla"

    fun huidaPeleaFracasa() = "no has podido escapar"

    fun jugadorSeProtegue(jugador: Jugador) = "${jugador.nombre} se esta protegiendo"

    fun enterparacontinuar() {
        println("pulsa ENTER para continuar")
        readLine()
    }

    fun mensajeDeError()= "ERROR has introducido un dato erroneo, escribe \"1\" \"2\" \"3\", para ir a las opcion querida, ENTER PARA CONTINUAR"
}