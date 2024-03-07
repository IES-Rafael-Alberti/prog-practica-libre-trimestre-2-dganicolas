class Enfretamientos() {

    companion object{
        var DEFENSA = false
        var ESTADO = true
    }

    fun <T:Peleas>realizarAccion(opcion:Int,jugador:Jugador, enemigo:Enemigos):String{
        return when(opcion){
            1 -> {enemigo.recibirAtaque(jugador.hacerAtaque())
                  Textojuego().jugadorAtaca(jugador, enemigo)}
            2 -> {DEFENSA = true
                  Textojuego().jugadorSeProtegue(jugador)}
            3 -> {
                if ((0..100).random() < 70){
                    ESTADO= false
                    Textojuego().huidaPelea()
                }
                4 -> {enemigo.recibirAtaque(jugador.hacerAtaque())
                    Textojuego().jugadorAtaca(jugador, enemigo)}
                5 -> {DEFENSA = true
                    Textojuego().jugadorSeProtegue(jugador)}
                else{
                    Textojuego().huidaPeleaFracasa()
                }

            }
            else -> ""

        }
    }

    fun enemigoAtaca(jugador:Jugador, enemigo:Enemigos){

    }

     fun pelea(jugador: Jugador, enemigo: Enemigos): String {


        while (ESTADO && jugador.vidaActual > 0 && enemigo.vidaActual > 0) {
            Textojuego().mostrarEscenario(jugador,enemigo)
            val opcion = Opciones().opciones()
            println(realizarAccion(opcion,jugador, enemigo))
            println(enemigoAtaca(jugador, enemigo))
            Textojuego().enterparacontinuar()
        }

         ESTADO=true
        return ""
    }
}



