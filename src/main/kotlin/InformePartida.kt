package org.practicatrim2

import Player
import consola.TextoConsola
/**
 * es la base de datos de la partida
 * donde guarda informacion sobre el player y
 * cuantas victorias o derrotas a tenido a lo largo de la partida
 * @property nombre es el nombre de la interfaz Player
 * @property vida es la vida de la interfaz Player
 * @property totalMonedas es el total de moneda de la interfaz Player
 * @property combatesTotales son el numero de combate totales que ha tenido el jugador a lo largo de la partida
 * @property combatesGanados son el numero de combate ganados que ha tenido el jugador a lo largo de la partida
 * @property combatesPerdidos son el numero de combate perdidos que ha tenido el jugador a lo largo de la partida
 * @property enemigos son el numero de enemigos que ha derrotado el jugador a lo largo de la partida
 * @author Nicolas De Gomar
 */
data class InformePartida(
    var nombre:String?,
    var vida: Float?,
    var vidaMaxima:Float?,
    var totalMonedas:Float?,
    var combatesTotales: Int,
    var combatesGanados:Int,
    var combatesPerdidos: Int,
    var enemigos:Int)

/**
 * es el gestor de la base de datos
 * @constructor necesita un objeto que sea de tipo InformePartida
 * @property basesDeDatos es la base de datos de tipo clase InformePartida
 * la clase depende de la interfaz InteractuarBasesDeDatos
 * */
class GestioninfoJuego(private var basesDeDatos:InformePartida):
    InteractuarBasesDeDatos
{
    /**
     * llama a la clase texto consola y le pasa la base de datos
     * */
    override fun  mostrarBaseDeDatos() {
        TextoConsola.mostrarBaseDeDatos(basesDeDatos)
    }

    /**
     * registra el resultado del combate
     * @param haGanado puede entrar el player si ha ganado o un null si el player ha perdido
     * */
    override fun registrarResultadoCombate(haGanado: Player?) {
        if (haGanado != null){
            basesDeDatos.nombre = haGanado.nombre
            basesDeDatos.vida = haGanado.vida
            basesDeDatos.vidaMaxima = haGanado.vidaMaxima
            basesDeDatos.totalMonedas = haGanado.cartera
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
    /**
     * muestra la base de datos actual
     * */
    fun mostrarBaseDeDatos()
    /**
     * registra el combate en la base de datos
     * */
    fun registrarResultadoCombate(personaDerrotada:Player?)
}