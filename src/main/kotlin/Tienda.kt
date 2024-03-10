//se encarga de la logistica de la tienda
class Tienda() {
        var JUGADORESTAADENTRO = true
    fun <T>comprobarOpciones(opcion:Int, jugador: Personas.Jugador, vendedor: Personas.Vendedor){
        when (opcion){
            1 -> vender(jugador,vendedor)
            2 -> comprar(jugador,vendedor)
            3 -> JUGADORESTAADENTRO = false
        }
    }
    fun comprar(jugador:Personas.Jugador,vendedor:Personas.Vendedor):String{
        while (true){
            Textojuego().menuComprar()
            when (EntradasUsuario().tresOpciones()){
                1 ->{
                    val armaduras = vendedor.mostrarArmaduras()
                    Textojuego().mostrarArmaduras(armaduras)
                    val opcion =EntradasUsuario().seisOpciones()
                    jugador.equiparArmadura(vendedor.darArmadura(armaduras[opcion-1]))


                }
                2->{
                    val armas = vendedor.mostrarArmas()
                    Textojuego().mostrarArmas(armas)
                    val opcion =EntradasUsuario().seisOpciones()
                    jugador.equiparArma(vendedor.darArma(armas[opcion-1]))
                }
                3->{
                    break
                }
            }
        }

    }

    fun vender(jugador: Personas.Jugador, vendedor: Personas.Vendedor) {
        val listaObjetoJugador= jugador.mostrarObjetos()
        val listaObjetos= List<String>()
        listaObjetoJugador.keys.forEach{ listaObjetos.addLast(it)}
        Textojuego.mostrarObjetosVentaJugador(listaObjetoJugador)
        val opcion = EntradasUsuario().variasOpciones(listaObjetos,listaObjetoJugador)
        if (opcion != null){
            jugador.darObjeto(listaObjetoJugador[opcion])
        }
    }
    fun <T>tienda(jugador:Personas<T>,vendedor: Personas<T>){
        while(JUGADORESTAADENTRO){
            Textojuego().mostrarTienda(jugador)
            val opcion = EntradasUsuario().tresOpciones()
            comprobarOpciones(opcion,jugador,vendedor)
        }
        JUGADORESTAADENTRO = true
    }
}