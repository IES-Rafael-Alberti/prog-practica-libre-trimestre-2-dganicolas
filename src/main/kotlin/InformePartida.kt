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

    override fun registrarResultadoCombate(personaDerrotada: Player?) {
        if (personaDerrotada != null){
            basesDeDatos.nombre = personaDerrotada.nombre
            basesDeDatos.vida = personaDerrotada.vida
            basesDeDatos.vidaActual = personaDerrotada.vidaMaxima
            basesDeDatos.totalMonedas = personaDerrotada.cartera
            basesDeDatos.combatesGanados++
            basesDeDatos.combatesTotales++
            basesDeDatos.enemigos++
        }
        else{
            basesDeDatos.combatesPerdidos++
            basesDeDatos.combatesTotales++
        }
    }


}

interface InteractuarBasesDeDatos{
    fun mostrarBaseDeDatos()
    fun registrarResultadoCombate(personaDerrotada:Player?)
}