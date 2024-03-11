//esta clase se encarga de toda logistica de la batalla
class RealizarBatalla {
    companion object{
        var DEFENSA= false
        var PELEA =true
        var HUIDA = false
        var COMBATEGANADO = true
    }

    fun <T>atacar(atacante:T, objetivo:T) where T:Peleas,T:Estadisticas{
        TextoConsola.hacerAtaque(atacante.nombre,atacante.hacerAtaque())
        objetivo.recibirAtaque(atacante.hacerAtaque())
        TextoConsola.recibirAtaque(objetivo.nombre,atacante.hacerAtaque())
    }

    fun <T:Any>comienzaBatalla(jugador:T,luchador:T):Boolean{
        return if (jugador is Peleas && jugador is Curarse && jugador is Estadisticas && luchador is Estadisticas && luchador is Peleas && luchador is Curarse )
            batalla(jugador,luchador)
        else{false}
    }

    fun elegirOpcion() = EntradasUsuario().tresOpciones()
    fun <T>batalla(jugador:T,luchador:T):Boolean where T:Peleas,T:Curarse,T:Estadisticas{
        DEFENSA= false
        PELEA =true
        COMBATEGANADO = true
        while (PELEA && luchador.saberVida() >= 0 && jugador.saberVida() >= 0 && !HUIDA) {
            TextoConsola.mostrarEscenario(jugador, luchador)
            val opcion = EntradasUsuario().Opciones(2)
            when (opcion) {
                //atacar
                1 -> {
                    atacar(jugador, luchador)
                }
                //huir
                2 -> {
                    HUIDA = true
                }

            }
            if (luchador.saberVida() >= 0 && !HUIDA){
                atacar(luchador, jugador)
                TextoConsola.enterparacontinuar()
            }else{
                TextoConsola.enterparacontinuar()
            }


        }
        return finalBatalla(luchador,jugador)
    }

    private fun <T>finalBatalla(luchador:T,jugador: T):Boolean where T:Peleas, T:Curarse {

        luchador.curar(100)
        if (HUIDA){
            HUIDA = false
            TextoConsola.huidaPelea()
            return false
        }
        if (jugador.saberVida() <= 0){
            TextoConsola.finalBatalla(jugador,luchador)
            TextoConsola.enterparacontinuar()
            return false
        }
        else{
            TextoConsola.finalBatalla(luchador,jugador)
            TextoConsola.enterparacontinuar()
            return true
        }
    }
}