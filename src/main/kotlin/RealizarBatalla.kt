//esta clase se encarga de toda logistica de la batalla
class RealizarBatalla {
        var PELEA =true
        var HUIDA = false
        var COMBATEGANADO = true
    fun <T:Peleas>atacar(atacante:T, objetivo:T){
        objetivo.recibirAtaque(atacante.hacerAtaque())
    }

    fun<T> comprobarAtacar(atacante: T,objetivo:T){
        if (atacante is Peleas && objetivo is Peleas){
                atacar(atacante,objetivo)
        }
    }

    fun elegirOpcion() = EntradasUsuario().tresOpciones()

    /**
     * retorna el enemigo que se ha debilitado
     * */
    fun batalla(jugador:Personas,enemigo:Personas):Personas{
        PELEA =true
        HUIDA = false
        COMBATEGANADO = true

        while (PELEA && jugador.vida >= 0 && enemigo.vida >= 0) {

            Textojuego().mostrarEscenario(jugador, enemigo)
            val opcion = elegirOpcion()
            when (opcion) {
                1 -> { //atacar
                    comprobarAtacar(jugador, enemigo); comprobarAtacar(enemigo, jugador)
                }
                2 -> { // huir
                    HUIDA = true
                }
            }
            Textojuego().enterparacontinuar()


        }
        return quienSeDebilito(jugador,enemigo)


    }
    fun quienSeDebilito(jugador:Personas,enemigo:Personas):Personas{
        if(jugador.vida <= 0){
            return jugador
        }
        else{
            return enemigo
        }
    }
}