import consola.EntradasUsuario
import consola.TextoConsola

/**
 * @property PELEA me sirve para saber si la batalla esta en funcionamiento o ha terminado
 * @property HUIDA me sirve por si el jugador quiere huir de la pelea
 * */
class RealizarBatalla() {
    companion object{
        var PELEA =true
        var HUIDA = false
    }

    /**
     * funcion que se encarga de quien le toca atacar
     * @param atacante es el que va a realizar le ataque
     * @param objetivo es el que va a recibir el ataque
     * */
    private fun <T>atacar(atacante:T, objetivo:T) where T:Peleas,T:Estadisticas{
        TextoConsola.hacerAtaque(atacante.nombre,atacante.hacerAtaque())
        objetivo.recibirAtaque(atacante.hacerAtaque())
        TextoConsola.recibirAtaque(objetivo.nombre,atacante.hacerAtaque())
    }

    /**
     * es la funcion principal de batalla
     * se encarga de determinar quien ha ganado
     * @param jugador es el jugador que necesita la interfaz Player
     * @param luchador es el enemigo que implemente la interfaz Enemigo
     * @return devuelve el Player si ha ganado o null si ha perdido
     * */
    fun batalla(jugador:Player, luchador:Enemigo):Player?{
        PELEA =true
        while (PELEA && luchador.saberVida() >= 0 && jugador.saberVida() >= 0 && !HUIDA) {
            TextoConsola.mostrarEscenario(jugador, luchador)
            val opcion = EntradasUsuario().opciones(2)
            when (opcion) {
                //atacar
                1 -> {
                    atacar(jugador, luchador)
                }
                //huir
                2 -> {
                    HUIDA = true
                }

            }
            if (luchador.saberVida() >= 0 && !HUIDA){
                atacar(luchador, jugador)
                TextoConsola.enterparacontinuar()
            }else{
                TextoConsola.enterparacontinuar()
            }


        }
        return finalBatalla(jugador,luchador)
    }

    /**
     * esta funcion revisa si el que ha perdido es el enemigo
     * curo al enemigo
     * y reviso si el jugador ha ganado
     * @param jugador es el jugador que necesita la interfaz Player
     * @param luchador es el enemigo que implemente la interfaz Enemigo
     * @return devuelve el Player si ha ganado o null si ha perdido
     * */
    private fun finalBatalla(jugador:Player,luchador: Enemigo):Player?{
        luchador.curar(100)
        if (HUIDA){
            HUIDA = false
            TextoConsola.huidaPelea()
            return jugador
        }
        return if (jugador.saberVida() <= 0){
            TextoConsola.finalBatalla(jugador,luchador)
            if (80 > (0..100).random()){
                TextoConsola.elJugadorSeGuardaElItemDelEnemigo(luchador.objeto)
                jugador.inventario.add(luchador.objeto)
            }
            jugador
        } else{
            TextoConsola.finalBatalla(luchador,jugador)
            null
        }
    }
}