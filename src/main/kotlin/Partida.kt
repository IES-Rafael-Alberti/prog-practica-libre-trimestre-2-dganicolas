import org.practicatrim2.GestioninfoJuego

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(val jugador: Jugador, val vendedor:Vendedor, val enemigo: List<Luchadores>,private var gestioninfoJuego: GestioninfoJuego):mostrarMenus
{

    companion object{
        var PARTIDA = true
        var DEFENSA= false
        var PELEA =true
        var HUIDA = false
        var COMBATEGANADO = true
    }
    fun <T:Peleas>atacar(atacante:T, objetivo:T){
        when (atacante){
            is Jugador -> objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
            is Luchadores -> objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
        }
    }
    fun<T> comprobarAtacar(atacante: T,objetivo:T){
        if (atacante is Peleas && objetivo is Peleas){
            atacar(atacante,objetivo)
        }
    }

    fun elegirOpcion()= Opciones().opciones()

    private fun huida(luchador: Luchadores){
        if (50 >= (0..100).random()){
            PELEA = false
            Textojuego().huidaPelea()
        }else{
            Textojuego().bloqueoEnemigo()
            comprobarAtacar(luchador,Jugador)
        }

    }

    fun comienzaJuego(){
        while (PARTIDA) {
            escogerOpcion(elegirOpcion())
            mostrarMenuPrincipal()
        }
    }


    fun escogerOpcion(opcion:Int){
        when(opcion){
            1 -> batalla()
            2 -> jugador.curar((0..50).random())
            3 -> Tienda().tienda()
            4 -> PARTIDA= false
        }
    }
    fun batalla(){
        val luchador = enemigo.random()
        PARTIDA = true
        DEFENSA= false
        PELEA =true
        HUIDA = false
        COMBATEGANADO = true
        while (PELEA && luchador.vida > 0 && jugador.vida > 0) {

            Textojuego().mostrarEscenario(Jugador, luchador)
            val opcion = elegirOpcion()
            when (opcion) {
                1 -> {
                    comprobarAtacar(jugador, luchador); comprobarAtacar(luchador, jugador)
                }

                2 -> {
                    DEFENSA = true; comprobarAtacar(luchador, jugador); DEFENSA = false
                }

                3 -> {
                    HUIDA = true
                }
                4->{
                    println("Accion todavia en desarrollo, por favor usuario no me dio tiempo :D")
                    println("escoga una opcion entre las mostrada en pantalla")
                }
            }
            Textojuego().enterparacontinuar()
            finalBatalla(luchador)
       }



    }

    private fun finalBatalla(luchador:Luchadores) {

        if (HUIDA){
            huida(luchador)
        }
        if (Jugador.vida <= 0){
            Textojuego().finalBatallaTexto(Jugador)
            COMBATEGANADO= false
            registrarCombate(luchador)
        }
        if(luchador.vida <= 0){
            Textojuego().finalBatallaTexto(luchador,luchador.monedas)
            registrarCombate(luchador)
            ManejoVida().curar(luchador)
        }
            curarContricante(luchador)
        if (!HUIDA || Jugador.vida >= 0 || luchador.vida >= 0){
            Textojuego().enterparacontinuar()
        }

    }

    private fun curarContricante(luchador :Luchadores) {

    }

    private fun registrarCombate(luchador: Luchadores) {
        RegistrarCombate().combateRealizado(luchador, COMBATEGANADO)
    }


}