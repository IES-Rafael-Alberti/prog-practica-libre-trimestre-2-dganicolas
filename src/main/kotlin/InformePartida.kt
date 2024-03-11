package org.practicatrim2

import Enemigo
import Jugador
import Player
import TextoConsola

data class InformePartida(
    var nombre:String?,
    var vida: Float?,
    var vidaActual:Float?,
    var totalMonedas:Float?,
    var combatesTotales: Int,
    var combatesGanados:Int,
    var combatesPerdidos: Int,
    var enemigos:Int)
class GestioninfoJuego(var basesDeDatos:InformePartida):
    InteractuarBasesDeDatos
{

    override fun  mostrarBaseDeDatos() {
        TextoConsola.mostrarBaseDeDatos(basesDeDatos)
    }

    override fun registrarResultadoCombate(jugador: Player) {

    }


}

interface InteractuarBasesDeDatos{
    fun mostrarBaseDeDatos()
    fun registrarResultadoCombate(personaDerrotada:Player)
}