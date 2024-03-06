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
fun Int.ExperienciaRequeridaPorNivel():Float {
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
fun main() {

    val enemigos = listOf(Enemigos("zombie",2,2f,1f,1f,1f,Armas.Hacha))
    val jugador = Jugador("nico",23,23f,23f,23f,440f,Armas.Hacha)
    val informe = informePartidas(jugador.Nombre.nombreCorrecto(),jugador.nivel,jugador.vida,jugador.vidaActual,jugador.experiencia)
    val partida = Partida(jugador, enemigos,informe)


    //esto de aqui abajo es de prueba
    //preguntar a diego sobre los tests
    println(jugador.cambiarArma())
    println(jugador.arma)
    println(jugador.cambiarArma())
    println(jugador.arma)
    println(jugador.cambiarArma())
    println(jugador.arma)
    println(jugador.cambiarArma())
    println(jugador.arma)
    println(jugador.cambiarArma())
    println(jugador.arma)
    partida.batalla()
    println("${jugador.experiencia.calcularExperiencia(jugador.nivel.ExperienciaRequeridaPorNivel())}")
}