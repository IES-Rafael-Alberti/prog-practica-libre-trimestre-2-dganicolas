import consola.EntradasUsuario
import consola.TextoConsola

//esta clase se encarga de toda logistica de la batalla
class RealizarBatalla() {
    companion object{
        var DEFENSA= false
        var PELEA =true
        var HUIDA = false
        var COMBATEGANADO = true
    }

    fun <T>atacar(atacante:T, objetivo:T) where T:Peleas,T:Estadisticas{
        TextoConsola.hacerAtaque(atacante.nombre,atacante.hacerAtaque())
        objetivo.recibirAtaque(atacante.hacerAtaque())
        TextoConsola.recibirAtaque(objetivo.nombre,atacante.hacerAtaque())
    }

    fun batalla(jugador:Player, luchador:Enemigo):Player?{
        DEFENSA= false
        PELEA =true
        COMBATEGANADO = true
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