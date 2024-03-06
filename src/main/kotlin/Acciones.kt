import org.practicatrim2.calcularExperiencia
import org.practicatrim2.redondear

/**
 * Interfaz Peleas 
 * la usa la clase Personajes
 * */
interface Peleas {
    fun atacar(): Float
    fun defensa(): Float
}

/**
 * Interfaz Estadisticas
 * la puede usar solo jugador
 *
 * Sirve para mejorar las estadisticas o recuperar la vida del jugador
 *
 * metodos:
 * fun mejorarEstadistica(opcion:String, jugador: Jugador,experiencia: Int)
 *              Su funcion es para mejorar la vida o el daño del jugador
 *
 * fun comprobarOpcion()
 *          comprueba si el usuario a tecleado la opcion correcta
 *
 * fun dormir(jugador: Jugador)
 *                  El jugador recupera vida al dormir
 *
 * fun subirDenivel(jugador: Jugador, experiencia: Int)
 *                  comprueba si el jugador tiene la experiencia suficiente para subir de nivel
 *
 *
interface Estadisticas{


}*/
