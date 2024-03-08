package org.practicatrim2

import Jugador
import Luchadores

class GestioninfoJuego() : InformacionJuego{

    data class InformePartida(
        val nombre:String,
        var nivel:Int,
        var vida: Float,
        var vidaActual:Float,
        var experiencia:Float,
        val enemigos: List<String>,
        var acciones: List<String>,
        var combatesTotales: Int,
        var combatesGanados:Int,
        var combatesPerdidos:Int,
        var zombiesMuertos:Int,
        var aranas:Int,
        var esqueletos: Int)

    fun iniciarInforme(){
        private val informePartida =  InformePartida(personas[0]=,jugador.nivel,jugador.vida,jugador.vidaActual,jugador.experiencia,enemigos,)
    }

    override var personas = mutableMapOf<String, List<String>>()

   //esta generica por si en un futuro hay una actualizacion y recibe una lista que no sea de enemigo o un jugador que no sea enemigo
    // tengo que crear un map of de un map of
    override fun <T : estadisticas> iniciarJuego(luchadores: List<T>,jugador:T) {
        personas[jugador.estadisticas()[0]]=jugador.estadisticas().subList(1,jugador.estadisticas().size)
        luchadores.forEach { personas[it.estadisticas()[0]] = it.estadisticas().subList(1,it.estadisticas().size)
        }
       iniciarInforme()
    }

    override fun sumarLuchadorDerrotado(luchador:Luchadores) {
        when (luchador){
            is Luchadores.Zombie -> informePartida.zombiesMuertos ++
            else ->
        }
    }

}


// esta interfaz es una jerarquia de clase para que todos los luchadores o Jugador, tenga estadisticas

interface InformacionJuego{
    var personas: MutableMap<String, List<String>>
    fun <T:estadisticas>iniciarJuego(luchadores: List<T>,jugador: T)
    fun sumarLuchadorDerrotado(luchador:Luchadores)
}

interface estadisticas{
    fun estadisticas(): List<String>
}