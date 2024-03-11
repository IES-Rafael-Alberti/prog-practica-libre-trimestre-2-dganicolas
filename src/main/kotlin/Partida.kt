import org.practicatrim2.GestioninfoJuego
import org.practicatrim2.Objetos

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(private var jugador: Player,
              private var vendedor:Seller,
              private var personajes: List<Enemigos>,
              private var informePartida: GestioninfoJuego) {

    companion object{
        val listaObjetos= listOf(
            Objetos.DAGA_DEL_SUSPENSO,
            Objetos.APROBADO_DE_DIEGO,
            Objetos.ESCUDO_DE_TOMAS,
            Objetos.CODIGO_DE_DIEGO,
            Objetos.INVESTIGARESPONDE_DE_ELOY)
    }
    var PARTIDA = true
    fun prepararJuego(){
        comienzaJuego()
    }
    fun comienzaJuego(){
        while (PARTIDA) {
            TextoConsola.mostrarMenu(jugador)
            escogerOpcion(EntradasUsuario().opciones(5))
        }
    }
    fun escogerOpcion(opcion:Int){
        when(opcion){
            1 -> batallaComienza()
            2 -> RecibirTratamiento().queTipoDeTratamiento(jugador)
            3 -> irATienda()
            4 -> informePartida.mostrarBaseDeDatos()
            5 -> PARTIDA = false
        }
    }
    fun irATienda(){
        Tienda().tienda(jugador,vendedor)

    }

    fun batallaComienza(){
        val enemigo = personajes.random()
        enemigo.objeto = listaObjetos.random()
        val resultado = RealizarBatalla().batalla(jugador,enemigo)
        informePartida.basesDeDatos.totalMonedas = jugador.totalMonedas
        informePartida.basesDeDatos.vida = jugador.vida
        informePartida.registrarResultadoCombate(resultado)
    }





}