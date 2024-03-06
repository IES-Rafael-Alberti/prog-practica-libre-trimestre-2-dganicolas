package org.practicatrim2
import Enemigos
import Jugador
import Partida
import Personajes
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * esta funcion capitaliza los nombres de los jugadores
 * @return el nombre capitalizado y en minusculas
 * */
fun String.nombreCorrecto(): String{
    val cadena = this.lowercase().split(' ')
    return cadena.filter { it.isNotEmpty() }.joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }
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
 * */
fun Float.redondear(posiciones: Int = 2): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}
fun main() {

    val enemigos = listOf<Enemigos>(Enemigos("zombie",2,2f,1f,1f,1f,Armas.Hacha))
    val jugador = Jugador("nico",23,23f,23f,23f,0f,Armas.Hacha)
    val informe = informePartidas(jugador.Nombre.nombreCorrecto(),jugador.nivel,jugador.vida,jugador.vidaActual,jugador.experiencia)
    val partida = Partida(jugador, enemigos,informe)
    println(jugador.cambiarArma())
    println(jugador.arma)
    partida.batalla()
}