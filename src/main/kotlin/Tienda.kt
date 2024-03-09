//se encarga de la logistica de la tienda
class Tienda() {
        var JUGADORESTAADENTRO = true
    lateinit var jugador: Personas
    lateinit var vendedor: Personas
    fun comprobarOpciones(opcion:Int){
        when (opcion){
            1 -> vender()
            2 -> comprar()
            3 -> JUGADORESTAADENTRO = false
        }
    }
    fun crearInstanciasTemporales(compradorVendedor:List<Personas>){
        jugador = compradorVendedor[0]
        vendedor = compradorVendedor[1]
    }
    fun comprar(){
        Textojuego().menuComprar()
    }

    fun vender(){

    }
    fun tienda(compradorVendedor: List<Personas>):List<Personas>{
        while(JUGADORESTAADENTRO){
            crearInstanciasTemporales(compradorVendedor)
            Textojuego().mostrarTienda(jugador)
            comprobarOpciones(EntradasUsuario().tresOpciones())
        }
        JUGADORESTAADENTRO = true
        return listOf(jugador,vendedor)
    }
}