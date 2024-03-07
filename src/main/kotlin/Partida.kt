import org.practicatrim2.informePartidas

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(val jugador: Jugador, val vendedor:Vendedor, val enemigo: List<Luchadores>, val informePartidas:
informePartidas)
{

    companion object{
        var PARTIDA = true
        var DEFENSA= false
        var PELEA =true
    }
    fun <T:Peleas>atacar(atacante:T, objetivo:T){
        objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
    }

    fun elegirOpcion()= Opciones().opciones()

    private fun huida(){
        PELEA = false
    }

    fun comienzaJuego(){
        while (PARTIDA) {
            Textojuego().mostrarmenu()
            val opcion = elegirOpcion()
            escogerOpcion(opcion)
        }
    }

    fun escogerOpcion(opcion:Int){
        when(opcion){
            1 -> batalla()
            2 -> jugador.curar()
            3 -> PARTIDA= false
        }
    }
    fun batalla(){
        val luchador = enemigo.random()
        while (PELEA) {

            Textojuego().mostrarEscenario(Jugador, luchador)
            val opcion = elegirOpcion()
            when (opcion) {
                1 -> {
                    atacar(jugador, luchador); atacar(luchador, jugador)
                }

                2 -> {
                    DEFENSA = true; atacar(luchador, jugador); DEFENSA = false
                }

                3 -> {
                    huida()
                }
            }
            Textojuego().enterparacontinuar()

        }
    }
}