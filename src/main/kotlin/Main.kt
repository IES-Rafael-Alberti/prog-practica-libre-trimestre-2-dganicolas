package org.practicatrim2
import Arquero
import Jugador
import Partida
import RealizarBatalla
import Vendedor
import Zombie
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * la funcion realiza un redondeo de un float
 * @param posiciones son los decimales que quiera que tenga el numero a redondear
 * @return el numero redondeado
 *
 * ejemplo:
 * entra 10.123123f.redondear()
 * retorna 10.12
 * */
fun Float.redondear(posiciones: Int = 2): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}
fun Float.dividirEntreCien():Float{
    return this/100
}
fun main() {
    val personajes =
        mutableListOf(
            Arquero(
                "Arquero",
                15f,
                15f,
                Objetos.APROBADO_DE_DIEGO,
                20f,
                20f

            ),Zombie(
                "Zombie",
                5f,
                12f,
                Objetos.CODIGO_DE_DIEGO,
                10f,
                10f
            )
        )
    val jugador = Jugador(
        "Nicolas",
        10000000000f,
        1f,
        10f,
        10f,
        Armaduras.ARMADURA_DE_DRAGON,
        Armas.ANILLO_UNICO,
        mutableListOf(Objetos.INVESTIGARESPONDE_DE_ELOY)
    )
    val vendedor = Vendedor(
        "Troy",
        10f,
        listOf<EquipablesPrecioEstadisticas>(
            Armaduras.ARMADURA_DE_DRAGON,
            Armaduras.ARMADURA_DE_MITHRIL,
            Armaduras.ARMADURA_DE_PLATINO,
            Armaduras.ARMADURA_DE_ADAMANTIO,
            Armaduras.ARMADURA_DE_ACHILLES),
        listOf<EquipablesPrecioEstadisticas>(
            Armas.ANILLO_UNICO,
            Armas.DAGA_DE_ALTÄIR,
            Armas.ARCO_DE_LEGOLAS,
            Armas.VARITA_DE_SAUCO,
            Armas.ESPADA_EXCALIBUR))
    val bdRpg = InformePartida(jugador.nombre,jugador.vida,jugador.vidaActual,jugador.totalMonedas,0,0,0,0)
    val bdLocal = GestioninfoJuego(bdRpg)
    val partida = Partida(jugador,vendedor,personajes,bdLocal)
    partida.prepararJuego()
}