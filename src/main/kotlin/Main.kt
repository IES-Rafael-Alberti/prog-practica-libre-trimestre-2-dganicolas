package org.practicatrim2
import Luchadores
import Jugador
import Partida
import Vendedor
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
    if (posiciones > 0){
        val factor = 10.0.pow(posiciones.toDouble()).toFloat()
        return (this * factor).roundToInt() / factor
    }else{
        return this/100
    }

}
fun main() {
   val personas = listOf<Luchadores>(Luchadores.Zombie("zombie",2f,2,1f,1f,1f,Armas.Hacha,5f))
    val gestioninfoJuego = GestioninfoJuego()
    gestioninfoJuego.iniciarJuego(personas,Jugador)
    val partida = Partida(Jugador,Vendedor, personas, gestioninfoJuego)
   partida.comienzaJuego()
}