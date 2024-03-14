package org.practicatrim2

import Player
import consola.TextoConsola

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
        basesDeDatos.nombre = jugador.nombre
        basesDeDatos.vida = jugador.vida
        basesDeDatos.vidaActual = jugador.vidaActual
        basesDeDatos.totalMonedas = jugador.totalMonedas
        if(jugador.vida< 0){
            basesDeDatos.combatesPerdidos++
            basesDeDatos.combatesTotales++
        }else{
            basesDeDatos.combatesGanados++
            basesDeDatos.combatesTotales++
            basesDeDatos.enemigos++
        }
    }


}

interface InteractuarBasesDeDatos{
    fun mostrarBaseDeDatos()
    fun registrarResultadoCombate(personaDerrotada:Player)
}