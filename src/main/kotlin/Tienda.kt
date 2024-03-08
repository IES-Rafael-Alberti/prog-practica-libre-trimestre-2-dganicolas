class Tienda() {
    companion object{
        var JUGADORESTAADENTRO = true
    }
    fun comprobarOpciones(opcion:Int){
        when (opcion){
            1 -> print(" ")//comprar()
            2 -> print(" ")//vender()
            3 -> dormirHostal(Jugador)
            4 -> JUGADORESTAADENTRO = false
        }
    }
    fun DormirHostal(nivel: Int) = nivel * 3f

    fun tienda(){
        while(JUGADORESTAADENTRO){
            Textojuego().mostrarTienda()
            comprobarOpciones(Opciones().opciones())
        }
        JUGADORESTAADENTRO = true
    }
    fun dormirHostal(jugador: Jugador) {
        val costeNoche = DormirHostal(jugador.nivel)
        if (jugador.monedas > costeNoche) {
            jugador.pagar(costeNoche)
            ManejoVida().curar(jugador)
            Textojuego().duermeHostal(costeNoche)
        }
    }
}