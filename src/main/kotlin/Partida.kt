import org.practicatrim2.GestioninfoJuego

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(private var jugador: Peleas,
              private var vendedor:TransaccionesObjetos,
              private var personajes: List<Peleas>,
              private var informePartida: GestioninfoJuego) {

    companion object{

        var PARTIDA = true
    }

    fun prepararJuego(){
        comienzaJuego()
    }

    fun comienzaJuego(){
        while (PARTIDA) {
            TextoConsola.mostrarMenu(jugador)
            escogerOpcion1Jugador(EntradasUsuario().Opciones(4))
        }
    }
    fun irATienda(){
        Tienda().tienda(jugador,vendedor)

    }

    fun batallaComienza(){
        val enemigo = personajes.random()
        val resultado = RealizarBatalla().comienzaBatalla(jugador,enemigo)
        informePartida.registrarResultadoCombte(resultado)
    }

    fun escogerOpcion1Jugador(opcion:Int){
        when(opcion){
            1 -> batallaComienza()
            2 -> RecibirTratamiento().empezarTratamiento(jugador)
            3 -> irATienda()
            4 -> PARTIDA= false
        }
    }



}