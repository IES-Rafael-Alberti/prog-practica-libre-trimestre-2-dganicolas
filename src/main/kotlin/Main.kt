package org.practicatrim2
import Arquero
import Jugador
import Partida
import Vendedor
import Zombie
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * esta funcion capitaliza los nombres de los jugadores
 *
 * @return el nombre capitalizado y en minusculas
 *
 * ejemplo:
 * entra NICOLAS    DE    GOMAR
 * sale Nicolas De Gomar
 * */
fun String.nombreCorrecto(): String{
    val cadena = this.lowercase().split(' ')
    return cadena.filter { it.isNotEmpty() }.joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }
}

/**
 * esta funcion es para calcular si tiene la experiencia requerida para subir de nivel
 *
 * solo puedes utilizarlo con la variable del jugador nivel
 *
 * @return retorna la experiencia que necesita para subir de nivel
 *
 * ejemplo:
 * para el nivel 1 necesitas 3 puntos de experiencia
 * nivel 2 necesitas 6 puntos
 * */
fun Int.costeTratamiento():Float {
    return (this * 3).toFloat()
}

/**
 * esta funcion realiza la diferencia entre la experiencia requerida para la accion y la experiencia del jugador
 * @param experiencia es la experiencia a restar
 * @return los puntos de experiencia que le faltan al jugador
 * */

fun Float.calcularExperiencia(experiencia: Float): Float{
    return experiencia-this
}

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
        10f,
        1f,
        0f,
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