import consola.EntradasUsuario
import consola.TextoConsola
import org.practicatrim2.InteractuarBasesDeDatos

/**
 * esta es la clase partida donde se hara lo referido a una partida
 *
 * @constructor el constructor necesita
 * 1. una entidad que implemente Player
 * 2. una entidad que implemente Seller
 * 3. una lista de entidades que implemente Enemigo
 * 4. una entidad que implemente InteractuarBasesDeDatos
 * @property jugador es la entidad controlable
 * @property vendedor el la entidad que el jugador le puede comprar o vender
 * @property personajes es la lista de enemigo donde el jugador se puede enfrentar
 * @property informePartida es donde se registraran todas las acciones del jugador
 * @author Nicolas De Gomar
 * */
class Partida(private var jugador: Player,
              private var vendedor:Seller,
              private var personajes: List<Enemigo>,
              private var informePartida: InteractuarBasesDeDatos) {

    /**
     * companion object
     * que tiene una lista con todos los objetos que puede tener un enemigo
     * @author Nicolas De Gomar
     * */
    companion object{
        val listaObjetos= listOf(
            Objetos.DAGA_DEL_SUSPENSO,
            Objetos.APROBADO_DE_DIEGO,
            Objetos.ESCUDO_DE_TOMAS,
            Objetos.CODIGO_DE_DIEGO,
            Objetos.INVESTIGARESPONDE_DE_ELOY)
    }

    /**
     * con esta variable controlo si la partida esta en funcionamiento o se termina
     * @author Nicolas De Gomar
     * */
    private var PARTIDA = false

    /**
     * funcion que empiezo la partida
     * poniendo la variable partida en true
     * @author Nicolas De Gomar
     * */
    fun prepararJuego(){
        PARTIDA = true
        comienzaJuego()
    }

    /**
     * funcion que controla la opciones del usuario
     * @author Nicolas De Gomar
     * */
    fun comienzaJuego(){
        while (PARTIDA) {
            TextoConsola.mostrarMenu(jugador)
            escogerOpcion(EntradasUsuario().opciones(5))
            TextoConsola.enterparacontinuar()
        }
    }

    /**
     * funcion que llama a las diferentes opciones disponible en la partida
     * @author Nicolas De Gomar
     * */
    fun escogerOpcion(opcion:Int){
        when(opcion){
            1 -> batallaComienza()
            2 -> RecibirTratamiento().queTipoDeTratamiento(jugador)
            3 -> irATienda()
            4 -> {
                TextoConsola.animacion()
                informePartida.mostrarBaseDeDatos()}
            5 -> PARTIDA = false
        }
    }
    /**
     * funcion llama a la clase tienda
     * @author Nicolas De Gomar
     * */
    fun irATienda(){
        TextoConsola.animacion()
        Tienda().tienda(jugador,vendedor)

    }

    /**
     *
     * funcion llama a la clase batalla
     * @author Nicolas De Gomar
     * */
    fun batallaComienza(){
        TextoConsola.animacion()
        /**
         * escoge un enemigo aleatorio
         * */
        val enemigo = personajes.random()
        /**
         * le pone un objeto aleatorio al enemigo
         * */
        enemigo.objeto = listaObjetos.random()
        /**
         * devuelve null en caso de que el player haya perdido
         * o el jugador si el jugador a ganado
         * */
        val resultado = RealizarBatalla().batalla(jugador,enemigo)
        informePartida.registrarResultadoCombate(resultado)
    }





}