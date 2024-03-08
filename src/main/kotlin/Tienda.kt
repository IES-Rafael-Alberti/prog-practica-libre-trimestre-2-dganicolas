class Tienda():curarse {
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
    private fun dormirHostal(huesped:Jugador) {
        val costeNoche = DormirHostal(huesped.nivel)
        if (huesped.monedas > costeNoche) {
            huesped.pagar(costeNoche)
            ManejoVida().curar(huesped)
            Textojuego().duermeHostal(costeNoche)
        }
    }
}