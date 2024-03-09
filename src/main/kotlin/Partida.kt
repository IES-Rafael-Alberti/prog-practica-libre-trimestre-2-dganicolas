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

    fun elegirOpcion()= EntradasUsuario().cuatroOpciones()


    fun prepararJuego(){
        var gestioninfoJuego: GestioninfoJuego
        val Jugador = Personas.Jugador(EntradasUsuario().usuarioIntroduceNombre("Jugador"),0f,1,0f,5f,10f,10f, Armas.Puños,
            mutableListOf())
        val Vendedor = Personas.Vendedor(EntradasUsuario().usuarioIntroduceNombre("Vendedor"),10f,10f, 10f, mutableListOf())
        personajes.addFirst(Vendedor)
        personajes.addFirst(Jugador)
    }
    fun comienzaJuego(){
        while (PARTIDA) {
            Textojuego().mostrarMenu(personajes[0])
            escogerOpcion(elegirOpcion())
        }
    }

    fun escogerOpcion(opcion:Int){
        when(opcion){
            1 -> RealizarBatalla().batalla(personajes[0],personajes.enemigoAleatorio())
            2 -> RecibirTratamiento().queTipoDeTratamiento(personajes[0])
            3 -> Tienda().tienda(personajes)
            4 -> PARTIDA= false
        }
    }



}