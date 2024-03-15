package consola

import Enemigo
import Estadisticas
import Player
import Transacciones
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.Whitespace
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.widgets.Panel
import com.github.ajalt.mordant.widgets.Text
import EquipablesPrecioEstadisticas
import com.github.ajalt.mordant.animation.progressAnimation
import com.github.ajalt.mordant.widgets.progressLayout
import org.practicatrim2.InformePartida
import kotlin.concurrent.thread
/**
 * es el objeto que muestra por pantalla
 * @property terminal me sirve para modificar la estetica de la pantalla
 * */
object TextoConsola {
    val terminal = Terminal()

    /**
     * Muestra la tienda del juego.
     *
     * @param nombreJugador Nombre del jugador.
     */
    fun mostrarTienda(nombreJugador: String){
        println("\nBienvenido a NAYD3C SHOPS")
        println("¿Que deseas $nombreJugador?")
        println("(1) vender Objeto")
        println("(2) Comprar Armaduras")
        println("(3) Salir de la tienda")
    }

    /**
     * Muestra el menú de compra del juego.
     */
    fun menuComprar(){
        println("(1) Comprar Armas")
        println("(2) Comprar Armaduras")
        println("(3) No hacer nada")
    }

    /**
     * Informa al jugador que no ha comprado nada.
     */
    fun jugadorNoCompraNada(){
        println("bueno otro dia sera...")
    }

    /**
     * Informa al jugador que ha recibido un objeto equipable.
     *
     * @param objeto Objeto equipable recibido.
     */
    fun jugadorRecibeEquipable(objeto: EquipablesPrecioEstadisticas){
            println("El jugador se equipa el ${objeto.nombre()}.")

    }

    /**
     * Informa al jugador que ha vendido un objeto equipable.
     *
     * @param objeto Objeto equipable vendido.
     */
    fun jugadorVendeEquipable(objeto: EquipablesPrecioEstadisticas) {
        println("El ${objeto.nombre()} ha sido vendido, has ganado ${objeto.precio()}")
    }

    /**
     * Muestra los objetos que el jugador puede vender.
     *
     * @param listaObjetoJugador Lista de objetos que el jugador puede vender.
     */
    fun mostrarObjetosVentaJugador(listaObjetoJugador: List<EquipablesPrecioEstadisticas>) {
        var contador= 0
        if (listaObjetoJugador.isEmpty()) {
            println("No hay objetos en el inventario.")
        } else {
            println("que objeto quieres vender inventario:")
            for (objeto in listaObjetoJugador) {
                println("(${contador++}). ${objeto.nombre()}: ${objeto.precio()}")
            }
        }
    }

    /**
     * Muestra las opciones de tratamiento disponibles.
     */
    fun mostrarTratamientos(){
        val terminal = Terminal()
        terminal.println(
            Panel(
                borderStyle = TextColors.blue,
                content = Text(
                    TextColors.brightGreen(
                        "¿Que quieres hacer?\n"+
                                "(1) curarte tu mismo\n"+
                                "(2) ir al doctor\n"+
                                "(3) no hacer nada\n"), whitespace = Whitespace.PRE_WRAP),
                title = Text(TextColors.brightCyan("Hospital"))))
    }

    /**
     * Muestra una animación de progreso.
     */
     fun animacion(){

         val progreso = terminal.progressAnimation {
             text("cargando")
             percentage()
             progressBar()
             completed()
         }
         progreso.start()
         for (i in (1..100)){
             progreso.update(i.toLong(),100)
             Thread.sleep(9)
         }
         progreso.stop()

    }

    /**
     * Muestra el escenario de la batalla entre el jugador y el enemigo.
     *
     * @param jugador Jugador actual.
     * @param enemigo Enemigo actual.
     */
    fun mostrarEscenario(jugador: Player, enemigo: Enemigo)  {
        val terminal = Terminal()
        terminal.println(
            Panel(
                borderStyle = TextColors.blue,
                content = Text(
                    TextColors.brightGreen(
                        "\n-------------------------------------------------------\n" +
                            "-Enemigo: ${enemigo.nombre}\n"+
                            "-Monedas: ${enemigo.cartera}\n"+
                            "arma: ${jugador.arma} (${jugador.arma.estadistica()}\n"+
                                "-Vida: ${mostrarvida(enemigo.vida,0f)}\n"+
                             "-Tu: ${jugador.nombre}\n"+
                             "-Monedas: ${jugador.cartera}\n"+
                             "-Vida: ${jugador.vida}\n"+
                             "-------------------------------------------------------\n"+
                             "-Selecciona una opcion:\n"+
                             "- (1)Atacar (2)Huir\n"+
                             "-------------------------------------------------------\n"), whitespace = Whitespace.PRE_WRAP),
                title = Text(TextColors.brightCyan("\nBatalla"))))

    }

    /**
     * Muestra la vida del jugador en forma de corazones.
     *
     * @param vida Vida máxima del jugador.
     * @param vidaActual Vida actual del jugador.
     * @return String que representa la vida del jugador en forma de corazones.
     */

    fun mostrarvida(vida:Float,vidaActual:Float):String{

        var corazones= ""
        for (i in 1.. (vida.toInt())){
            corazones+= "*"
        }
        if (vidaActual != 0f){
            for(i in 1..(vidaActual - vida).toInt()){
                corazones+= "-"
            }
        }
        return corazones
    }

    /**
     * Muestra el menú del juego.
     *
     * @param jugador Jugador actual.
     */
    fun mostrarMenu(jugador: Player){
            terminal.println(
                Panel(
                    borderStyle = TextColors.blue,
                    content = Text(
                        TextColors.brightGreen("\nNombre: ${jugador.nombre}\n" +
                                        "Monedas: ${jugador.cartera}€\n"+
                                        "Vida: ${mostrarvida(jugador.vida,jugador.vidaMaxima)}\n"+
                                        "arma: ${jugador.arma} (${jugador.arma.estadistica()}\n"+
                                        "armadura:  ${jugador.armadura} (${jugador.armadura.estadistica()}\n"+
                                        "Bolsa: ${jugador.inventario.size} objetos\n"+
                                        "¿Que quieres hacer joven aventurero?\n"+
                                        "(1) Pelea\n"+
                                        "(2) Recuperar vida\n"+
                                        "(3) ir al vendedor\n" +
                                        "(4) ver Historial\n" +
                                        "(5) salir del juego"), whitespace = Whitespace.PRE_WRAP,),
                    title = Text(TextColors.brightCyan("BIENVENIDO A NAYD3C WORLDS"))
                )
            )
        }

    /**
     * Recupera una cantidad de puntos de salud.
     *
     * @param recuperado Cantidad de puntos de salud recuperados.
     */
    fun curarVida(recuperado:Float){
        animacion()
        println("has recuperado $recuperado puntos de salud")
    }

    /**
     * Guarda un objeto ganado en el inventario del jugador.
     *
     * @param objeto Objeto ganado.
     */
    fun elJugadorSeGuardaElItemDelEnemigo(objeto: EquipablesPrecioEstadisticas) {
        println("has ganado $objeto, lo guardas en el inventario")
    }

    /**
     * Recibe un ataque.
     *
     * @param nombre Nombre del que recibe el ataque.
     * @param ataque Cantidad de puntos de daño recibidos.
     */
    fun recibirAtaque(nombre:String, ataque:Float){
        println("$nombre recibe un daño de $ataque puntos")
    }

    /**
     * Realiza un ataque.
     *
     * @param nombre Nombre del que realiza el ataque.
     * @param ataque Cantidad de puntos de daño realizados.
     */
    fun hacerAtaque(nombre:String, ataque:Float){
        println("$nombre lanza un ataque de $ataque puntos")
    }

    /**
     * Finaliza la batalla.
     *
     * @param ganador Ganador de la batalla.
     * @param perdedor Perdedor de la batalla.
     */
    fun <T>finalBatalla(ganador : T, perdedor:T) where T: Estadisticas, T: Transacciones {
        when(ganador){
            is Player -> { println("${ganador.nombre} ha sido debilitado, has perdido ${ganador.pagar(ganador.cartera/2)}") }
            else -> { println("${ganador.nombre} ha sido debilitado, has ganado ${perdedor.ingreso(ganador.cartera)}") }
        }
    }

    /**
     * Informa al jugador que ha podido huir de la batalla.
     */
    fun huidaPelea(){
        println("Has podido huir de la batalla")
    }


    /**
     * Pide al jugador que pulse ENTER para continuar.
     */
    fun enterparacontinuar() {
        println("pulsa ENTER para continuar")
        readlnOrNull()
    }

    /**
     * Devuelve un mensaje de error cuando las opciones válidas son 1, 2 o 3.
     *
     * @return Mensaje de error.
     */
    fun mensajeDeError()= "ERROR,Las Opciones validas son 1, 2 o 3"

    /**
     * Muestra una lista de armas disponibles para comprar.
     *
     * @param armas Lista de armas disponibles para comprar.
     */
    fun mostrarArmas(armas: List<EquipablesPrecioEstadisticas>) {
        var contador= 0
        armas.forEach{
            println("(${contador++}). ${it.nombre()}  ${it.precio()}€ (${it.estadistica()} PD)")
        }
        println("(6). no comprar nada")
    }

    /**
     * Muestra la base de datos de la partida.
     *
     * @param basesDeDatos Informe de la partida actual.
     */
    fun mostrarBaseDeDatos(basesDeDatos: InformePartida) {
        terminal.println(
            Panel(
                borderStyle = TextColors.blue,
                content = Text(
                    TextColors.brightGreen("nombre: ${basesDeDatos.nombre}\n" +
                            "vida: ${basesDeDatos.vida}\n"+
                            "vida maxima: ${basesDeDatos.vidaMaxima}\n"+
                            "cartera: ${basesDeDatos.totalMonedas}\n"+
                            "combates totales: ${basesDeDatos.combatesTotales}\n"+
                            "combates ganados: ${basesDeDatos.combatesGanados}\n"+
                            "combates perdidos: ${basesDeDatos.combatesPerdidos}\n"+
                            "enemgios derrotados: ${basesDeDatos.enemigos}\n"
                    ), whitespace = Whitespace.PRE_WRAP,),
                title = Text(TextColors.brightCyan("\nBase de datos:"))
            )
        )
    }

    /**
     * Informa que el jugador no se ha curado.
     *
     * @param jugador Jugador actual.
     */
    fun jugadorNoSeCura(jugador: Player) {
        println("el ${jugador.nombre} no se ha curado")
    }


}



