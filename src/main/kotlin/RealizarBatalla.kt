//esta clase se encarga de toda logistica de la batalla
class RealizarBatalla {
    companion object{
        var DEFENSA= false
        var PELEA =true
        var HUIDA = false
        var COMBATEGANADO = true
    }
    private fun huida(luchador: Personas){
        if (50 >= (0..100).random()){
            PELEA = false
            Textojuego().huidaPelea()
        }else{
            Textojuego().bloqueoEnemigo()
            comprobarAtacar(luchador,Jugador)
        }

    }
    fun <T:Peleas>atacar(atacante:T, objetivo:T){
        when (atacante){
            is Jugador -> objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
            is Personas -> objetivo.recibirAtaque(atacante.hacerAtaque(),DEFENSA)
        }
    }
    fun<T> comprobarAtacar(atacante: T,objetivo:T){
        if (atacante is Peleas && objetivo is Peleas){
            atacar(atacante,objetivo)
        }
    }

    fun elegirOpcion() = EntradasUsuario().tresOpciones()
    fun batalla(jugador:Jugador,enemigo:Personas){
        val luchador = enemigo
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
            }
            Textojuego().enterparacontinuar()
            finalBatalla(luchador)
        }



    }

    private fun finalBatalla(luchador:Personas) {

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
            RecibirTratamiento().darTratamiento(luchador)
        }
        curarContricante(luchador)
        if (!HUIDA || Jugador.vida >= 0 || luchador.vida >= 0){
            Textojuego().enterparacontinuar()
        }

    }

    private fun curarContricante(luchador :Personas) {

    }

    private fun registrarCombate(luchador: Personas) {
        RegistrarCombate().combateRealizado(luchador, COMBATEGANADO)
    }
}