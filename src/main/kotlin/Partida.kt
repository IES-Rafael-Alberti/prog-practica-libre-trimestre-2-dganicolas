import org.practicatrim2.informePartidas

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(val jugador: Jugador, val enemigos: List<Enemigos>, val informePartidas: informePartidas){
    fun batalla(){
        val enemigo = enemigos[0]
        println(enemigo.toString())
        jugador.vidaActual-= enemigo.atacar()- jugador.defensa()
    }
}