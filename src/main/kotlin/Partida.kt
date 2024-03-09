import org.practicatrim2.Armas
import org.practicatrim2.GestioninfoJuego
import org.practicatrim2.enemigoAleatorio

//la clase donde se hara toda la partida
//controlando si el jugador esta en una montaña, campo o ciudad
// aqui tambien controlara el informe de partida
class Partida(private var personajes: List<Personas>) {

    companion object{

        var PARTIDA = true
    }
     private lateinit var jugador:Personas
    private lateinit var persona2OVendedor:Personas
    fun elegirOpcion()= EntradasUsuario().cuatroOpciones()

    fun prepararJuego(){
        var gestioninfoJuego: GestioninfoJuego
        jugador = Personas.Jugador(EntradasUsuario().usuarioIntroduceNombre("Jugador"),0f,1,0f,5f,10f,10f, Armas.Puños,
        mutableListOf())
        persona2OVendedor= Personas.Vendedor(EntradasUsuario().usuarioIntroduceNombre("Vendedor"),10f,10f, 10f, mutableListOf())
        comienzaJuego()
    }

    fun comienzaJuego(){
        while (PARTIDA) {
            Textojuego().mostrarMenu(jugador)
            escogerOpcion1Jugador(elegirOpcion())
        }
    }
    fun irATienda(){
        val primeroJugadorSegundoVendedor = listOf(jugador,persona2OVendedor)
        primeroJugadorSegundoVendedor= Tienda().tienda(primeroJugadorSegundoVendedor)

    }

    fun escogerOpcion1Jugador(opcion:Int){
        when(opcion){
            1 -> RealizarBatalla().batalla(jugador,personajes.enemigoAleatorio())
            2 -> RecibirTratamiento().queTipoDeTratamiento(jugador)
            3 -> irATienda()
            4 -> PARTIDA= false
        }
    }



}