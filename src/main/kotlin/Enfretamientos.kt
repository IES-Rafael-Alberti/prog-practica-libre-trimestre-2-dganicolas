class Enfretamientos() {

    companion object{
        var DEFENSA = false
        var ESTADO = true
    }

    fun realizarAccion(opcion:Int,jugador:Jugador, enemigo:Enemigos):String{
        return when(opcion){
            1 -> {enemigo.recibirAtaque(jugador.hacerAtaque())
                  Textojuego().jugadorAtaca(jugador, enemigo,1)}
            2 -> {DEFENSA = true
                  Textojuego().jugadorSeProtegue(jugador)}
            3 -> {
                if ((0..100).random() < 70){
                    ESTADO= false
                    Textojuego().huidaPelea()
                }else Textojuego().huidaPeleaFracasa()
                }
            //esto esta metido aqui por que nose hacer funciones genericas tan especificas :")
            //simula el turno de la maquina
            else -> {jugador.recibirAtaque(enemigo.hacerAtaque()- (if(DEFENSA){5}else{0}))
            Textojuego().jugadorAtaca(jugador, enemigo,2)}

        }
    }


     fun pelea(jugador: Jugador, enemigo: Enemigos): String {


        while (ESTADO && jugador.vidaActual > 0 && enemigo.vidaActual > 0) {
            Textojuego().mostrarEscenario(jugador,enemigo)
            val opcion = Opciones().opciones()
            println(realizarAccion(opcion,jugador, enemigo))
            if (opcion != 0){println(realizarAccion(5,jugador, enemigo))}
            Textojuego().enterparacontinuar()
        }

         ESTADO=true
        return ""
    }
}



