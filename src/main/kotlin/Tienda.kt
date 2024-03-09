//se encarga de la logistica de la tienda
class Tienda() {
    companion object{
        var JUGADORESTAADENTRO = true
    }
    fun comprobarOpciones(opcion:Int){
        when (opcion){
            1 -> print(" ")//comprar()
            2 -> comprar()
            3 -> JUGADORESTAADENTRO = false
        }
    }
    fun comprar(){

    }
    fun tienda(jugador:Jugador){
        while(JUGADORESTAADENTRO){
            Textojuego().mostrarTienda(jugador)
            comprobarOpciones(EntradasUsuario().tresOpciones())
        }
        JUGADORESTAADENTRO = true
    }
}