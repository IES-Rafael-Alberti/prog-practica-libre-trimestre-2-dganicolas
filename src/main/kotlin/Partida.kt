import org.practicatrim2.informePartidas
import kotlin.random.Random

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(val jugador: Jugador, val enemigos: List<Enemigos>, val informePartidas: informePartidas){

    /**
     *  funcion generica
     *  que nos da a quien le toca el turno,
     *  es generica por que ya sea jugador o enemigo
     *
     *  @return la entidad que le ha tocado el turno
     * */
    fun <T> asignarTurno(t1: T, t2: T): T {
        return when (Random(0).nextInt(2)) {
            0 -> t1
            1 -> t2
            else -> t1
        }
    }
    fun <T> mostrarParticipantes(t1: T, t2: T){
        println(t1.toString())
        println(t2.toString())
    }
    //se puede mejorar con el ejercicio 3
    fun turnoAtaque(turno: Personajes,enemigo: Enemigos):String{
        return when(turno){
            is Jugador ->{ enemigo.vidaActual -= jugador.atacar()
                "${enemigo.mostrarNombre()} ha sufrido un ataque de ${jugador.atacar()}"}
            is Enemigos -> {jugador.vidaActual -= enemigo.atacar()
                "${jugador.Nombre} ha sufrido un ataque de ${enemigo.atacar()}"}

            else -> ""
        }
        }




    fun batalla(){
        val enemigo = enemigos[0]
        while (jugador.vidaActual > 0 && enemigo.vidaActual > 0) {
            mostrarParticipantes(jugador,enemigo)
            val turno = asignarTurno(enemigo ,jugador) //mira omo aqui no me llora  si cambio el orden
            println(turnoAtaque(turno,enemigo))
            println(enemigo.toString())
            jugador.vidaActual -= enemigo.atacar() - jugador.defensa()
        }
    }
}