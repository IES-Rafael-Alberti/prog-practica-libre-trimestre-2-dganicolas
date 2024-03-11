package org.practicatrim2

import Estadisticas
data class InformePartida(
    var nombre:String?,
    var nivel:Int?,
    var vida: Float?,
    var vidaActual:Float?,
    var experiencia:Float?,
    var totalMonedas:Float?,
    var combatesTotales: Int,
    var combatesGanados:Int,
    var combatesPerdidos: Int)
class GestioninfoJuego(var basesDeDatos:InformePartida):
    InteractuarBasesDeDatos
{

    override fun  actualizarBaseDeDatos(jugador: Estadisticas) {
        basesDeDatos.nombre = jugador.nombre
        basesDeDatos.nivel = jugador.nivel
        basesDeDatos.vida = jugador.vida
        basesDeDatos.vidaActual = jugador.vidaActual
        basesDeDatos.experiencia = jugador.experiencia
        basesDeDatos.totalMonedas = jugador.totalMonedas
    }

    override fun registrarResultadoCombte(comproba: Boolean) {
        basesDeDatos.combatesTotales++
        if(comproba){
            basesDeDatos.combatesGanados++
        }else{
            basesDeDatos.combatesPerdidos++
        }
    }


}

interface InteractuarBasesDeDatos{
    fun actualizarBaseDeDatos(jugador:Estadisticas)
    fun registrarResultadoCombte(comproba:Boolean)
}