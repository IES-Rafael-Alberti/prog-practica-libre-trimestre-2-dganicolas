import org.practicatrim2.EquipablesPrecioEstadisticas
import org.practicatrim2.InformePartida

object TextoConsola {

    /**
     * FUNCIONES VARIAS
     * */
    private fun limpiarConsola(){
        repeat(10){println()}
    }
    /**************** Clase: EntradasUsuario**************************/
    fun textoNombre(nombre:String){
        println("Dime el nombre del $nombre")
    }

    fun nombreMalTecleado(nombre: String){
        println("El nombre no puede estar vacio,Por Favor dime el nombre del $nombre")
    }
    /**************** Fin de la Clase: EntradasUsuario**************************/

    /**************** Clase: Tienda**************************/

    fun mostrarTienda(nombreJugador: String){
        println("Bienvenido a NAYD3C SHOPS")
        println("¿Que deseas $nombreJugador?")
        println("(1) Comprar")
        println("(2) vender Objeto")
        println("(3) Salir de la tienda")
    }

    fun menuComprar(){
        println("(1) Comprar Armaduras")
        println("(2) Comprar Armas")
        println("(3) No hacer nada")
    }
    fun jugadorNoCompraNada(){
        println("bueno otro dia sera...")
    }

    fun <T:Enum<T>>jugadorRecibeEquipable(objeto: EquipablesPrecioEstadisticas){
            println("El jugador se equipa el ${objeto.nombre()}.")

    }

    fun jugadorVendeEquipable(objeto: EquipablesPrecioEstadisticas) {
        println("El ${objeto.nombre()} ha sido vendido, has ganado ${objeto.precio()}")
    }

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
    /**************** Fin de la Clase: Tienda**************************/
    /**************** Clase: RecibirTratamiento**************************/
    fun mostrarTratamientos(){
        println("¿?Que quieres hacer?")
        println("(1) curarte tu mismo")
        println("(2) ir al doctor")
        println("(3) no hacer nada")
    }

    fun recibeTratamiento(nombreJugador:String,coste:Float){
        println("El doctor te curo, coste del tratamiento: $coste" +
                "$nombreJugador se recupero completamente")
    }

    fun noRecibeTratamiento(coste:Float,cartera:Float){
        println("Dinero insuficiente, el tratamiento cuesta $coste y tienes $cartera ")
    }

    fun noRealizarNingunaAccion(nombreJugador:String){
        println("$nombreJugador no realizo ninguna opcion")
    }

    /**************** Fin de la Clase: RecibirTratamiento**************************/
    fun <T>imprimir(imprimir:T){
        println(imprimir)
    }

    private fun animacion(){
        limpiarConsola()
        print("*")
        Thread.sleep(1000)

        for (i in 1..5) {
            print("-")
            Thread.sleep(500)
        }
        print("*")
        Thread.sleep(500)
        limpiarConsola()
    }

    /**
     * Mostrar pantalla
     * */

    fun mostrarEscenario(jugador: Player, enemigo: Enemigos)  {
        limpiarConsola()
        println("-------------------------------------------------------")
        println("-Enemigo: ${enemigo.nombre}")
        println("-Monedas: ${enemigo.totalMonedas}")
        println("-Vida: ${mostrarvida(enemigo.vida,0f)}")
        println("-Tu: ${jugador.nombre}")
        println("-Monedas: ${jugador.totalMonedas}")
        println("-Vida: ${jugador.vida}")
        println("-------------------------------------------------------")
        println("-Selecciona una opcion:")
        println("- (1)Atacar (2)Huir")
        println("-------------------------------------------------------")
    }

    fun mostrarvida(vida:Float,vidaActual:Float):String{

        var corazones= ""
        for (i in 1.. (vida.toInt())){
            corazones+= "♥"
        }
        if (vidaActual != 0f){
            for(i in 1..(vidaActual - vida).toInt()){
                corazones+= "♡"
            }
        }
        corazones += " ($vida)"
        return corazones
    }

    fun mostrarMenu(jugador: Player){
        limpiarConsola()
        println("BIENVENIDO A NAYD3C WORLDS")
        println("Nombre: ${jugador.nombre}")
        println("Monedas: ${jugador.totalMonedas}€")
        println("Vida: ${mostrarvida(jugador.vida,jugador.vidaActual)}")
        println("¿Que quieres hacer joven aventurero?")
        println("(1) Pelea")
        println("(2) Recuperar vida")
        println("(3) ir al vendedor")
        println("(4) ver Historial")
        println("(5) salir del juego")
    }



    /**
     * Acciones
     * */
    fun curarVida(recuperado:Float){
        animacion()
        println("has recuperado $recuperado puntos de salud")
    }
    /**
     * BATALLAS
     * */
    fun elJugadorSeGuardaElItemDelEnemigo(objeto: EquipablesPrecioEstadisticas) {
        println("has ganado $objeto, lo guardas en el inventario")
    }

    fun recibirAtaque(nombre:String, ataque:Float){
        println("$nombre recibe un daño de $ataque puntos")
    }

    fun hacerAtaque(nombre:String, ataque:Float){
        println("$nombre lanza un ataque de $ataque puntos")
    }

    fun <T>finalBatalla(jugador : T,luchador:T){
        if (jugador is Estadisticas && luchador is Estadisticas &&
            jugador is Transacciones && luchador is Transacciones)
            finalBatallaTexto(jugador,luchador)
    }
    fun <T>finalBatallaTexto(jugador : T,luchador:T) where T:Estadisticas, T:Transacciones{
        when(jugador){
            is Jugador -> { println("${jugador.nombre} ha sido debilitado, has perdido ${jugador.pagar(jugador.totalMonedas/2)}") }
            else -> { println("${jugador.nombre} ha sido debilitado, has ganado ${jugador.ingreso(luchador.totalMonedas)}") }
        }
    }
    fun huidaPelea(){
        println("Has podido huir de la batalla")
    }

    fun bloqueoEnemigo(){
        println("intentaste huir pero el enemigo te bloqueo el paso, ataque inminente")
    }

    fun enterparacontinuar() {
        println("pulsa ENTER para continuar")
        readlnOrNull()
    }

    fun mensajeDeError()= "ERROR,Las Opciones validas son 1, 2 o 3"

    fun mostrarArmaduras(armaduras: List<EquipablesPrecioEstadisticas>) {
        var contador= 0
        armaduras.forEach{
            println("${contador++}${it.nombre()}  ${it.precio()}€ (${it.estadistica()} PD)")
        }
        println("6. no comprar nada")
    }

    fun mostrarArmas(armas: List<EquipablesPrecioEstadisticas>) {
        var contador= 0
        armas.forEach{
            println("(${contador++}). ${it.nombre()}  ${it.precio()}€ (${it.estadistica()} PD)")
        }
        println("6. no comprar nada")
    }

    fun mostrarBaseDeDatos(basesDeDatos: InformePartida) {
        println("jugador ${basesDeDatos.nombre}")
        println("jugador ${basesDeDatos.vida}")
        println("jugador ${basesDeDatos.vidaActual}")
        println("jugador ${basesDeDatos.totalMonedas}")
        println("jugador ${basesDeDatos.combatesTotales}")
        println("jugador ${basesDeDatos.combatesPerdidos}")
        println("jugador ${basesDeDatos.enemigos}")

    }

    fun jugadorNoSeCura(jugador: Player) {
        println("el ${jugador.nombre} no se ha curado")
    }


}


