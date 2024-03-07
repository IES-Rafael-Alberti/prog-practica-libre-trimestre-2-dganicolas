import org.practicatrim2.informePartidas
import kotlin.random.Random

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(val jugador: Jugador, val vendedor:Vendedor, val enemigos: List<Enemigos>, val informePartidas:
informePartidas)
{
    companion object{
        val estado = true
    }








    fun hacerAccion(opcion: Int){
        when (opcion){
            1 -> Pelear()
            2 -> irAlVendedor()
            3 -> { Textojuego().animacion()
                jugador.dormirSuelo()}
        }
    }

        fun Pelear(){
            val enemigo = enemigos.random()

            informePartidas.acciones.add(Enfretamientos().pelea(jugador,enemigo))
        }
        fun irAlVendedor(){
            println("")
        }


    fun comienzajuego(){
        while (estado) {
            Textojuego().limpiarConsola()
            Textojuego().mostrarMenu()
            val opcion =Opciones().opciones()
            if (opcion != 0){
                hacerAccion(opcion)
            }else{
                Textojuego().enterparacontinuar()
            }



        }
    }
}
/**
    /**
     *  funcion generica
     *  que nos da a quien le toca el turno,
     *  es generica por que ya sea jugador o enemigo
     *
     * */
    fun asignarTurno(jugador1:Jugador,jugador2:Enemigos) {
        val numero = Random.nextInt(2)
        when (numero){
            0 -> turnoJugador(jugador1,jugador2)
            1 -> turnoMaquina(jugador2,jugador1)
        }
    }

    /**
     * Funcion genercia
     * que muestra la informacion de los participantes
     * @param jugador1 la entidad seleccionada que muestra la informacion
     * @param jugador2 la entidad seleccionada que muestra la informacion
     * */
    fun <T> mostrarParticipantes(jugador1:T ,jugador2:T ){
        println(jugador1.toString())
        println(jugador2.toString())
    }
    fun turnoMaquina(atacante: Enemigos, objetivo: Jugador){
        ControladorVida().recibirAtaque(atacante,objetivo)
        imprimirAccion(atacante,objetivo)
        }

    fun imprimirVida(entidad:Personajes):String{
        return when (entidad){
            is Jugador -> "${entidad.vidaActual}"
            is Enemigos -> "${entidad.vidaActual}"
            else ->""
        }
    }
    fun imprimirAccion(atacante: Personajes,objetivo: Personajes){

        when (atacante){
            is Jugador -> println("El ${atacante.nombre} le causo un ataque de ${atacante.hacerAtaque()} a ${objetivo.nombre}, vida restante ${imprimirVida(objetivo)}")
            is Enemigos -> println("El ${atacante.nombre} le causo un ataque de ${atacante.hacerAtaque()} a ${objetivo.nombre}, vida restante ${imprimirVida(objetivo)}")
        }
    }
    fun turnoJugador(atacante: Jugador, objetivo: Enemigos){
        ControladorVida().recibirAtaque(atacante,objetivo)
        imprimirAccion(atacante,objetivo)
    }
    fun batalla(jugador: Jugador,enemigo: Enemigos){
        mostrarParticipantes(jugador,enemigo)
        while (jugador.vidaActual > 0 && enemigo.vidaActual > 0) {

            asignarTurno(jugador,enemigo)
            println(enemigo.toString())
        }
    }
}*/