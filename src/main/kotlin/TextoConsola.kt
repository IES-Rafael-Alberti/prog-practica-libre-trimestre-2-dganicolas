import org.practicatrim2.Armas
import org.practicatrim2.EquipablesPrecioEstadisticas

object TextoConsola {

    /**
     * FUNCIONES VARIAS
     * */
    private fun limpiarConsola(){
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
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
    fun menuComprar(){
        println("(1) Comprar Armas")
        println("(2) Comprar Armaduras")
        println("(3) No hacer nada")
    }
    fun jugadorRecibeArma(arma: Armas?) {
        if (arma != null){
            println("El jugador se equipa el ${arma.name}.")
        }else{
            println("El jugador no pudo equiparse el arma.")
        }
    }
    fun jugadorNoCompraNada(){
        println("bueno otro dia sera...")
    }
    fun errorObjetos() {
        println("Objeto no encontrado, por favor introduce el numero del objeto que quieres")
    }

    fun <T:Enum<T>>jugadorRecibeEquipable(objeto: EquipablesPrecioEstadisticas?){
        if (objeto != null){
            println("El jugador se equipa el objeto.")
        }else{
            println("El jugador no pudo comprar la armadura.")
        }
    }

    fun objetoVendido(objeto: EquipablesPrecioEstadisticas) {
        println("El objeto ha sido vendido con exito, has ganado ${objeto.precio()}")
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

    fun <T:Peleas>mostrarEscenario(jugador: T, enemigo: T)  {
        if (jugador is Estadisticas &&
            enemigo is Estadisticas)
            mostrarEscenarioEnPantalla(jugador,enemigo)
    }
    fun <T>mostrarEscenarioEnPantalla(jugador:T,enemigo:T)where T:Estadisticas{
        limpiarConsola()
        println("-------------------------------------------------------")
        println("-Enemigo: ${enemigo.nombre}")
        println("-Nivel: ${enemigo.nivel}")
        println("-Vida: ${mostrarvida(enemigo.vida,0f)}")
        println("-Tu: ${jugador.nombre}")
        println("-Nivel: ${jugador.nivel}")
        println("-Vida: ${jugador.vida}")
        println("-------------------------------------------------------")
        println("-Selecciona una opcion:")
        println("- (1)Atacar (2)Defenderse (3)Huir")
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

    fun subirDeNivel(jugador:Estadisticas){
        println("${jugador.nombre} se volvio mas fuerte")
    }
    fun <T>mostrarMenu(jugador:T) where T:Peleas{
        if(jugador is Estadisticas){
            mostrarMenuenPantalla(jugador)
        }

    }
    fun <T:Estadisticas>mostrarMenuenPantalla(jugador: T){
        limpiarConsola()
        println("BIENVENIDO A NAYD3C WORLDS")
        println("Nombre: ${jugador.nombre}")
        println("Nivel: ${jugador.nivel}")
        println("Vida: ${mostrarvida(jugador.vida,jugador.vidaActual)}")
        println("¿Que quieres hacer joven aventurero?")
        println("(1) Pelea")
        println("(2) Recuperar vida")
        println("(3) ir al vendedor")
        println("(4) fin del juego")
    }

    fun mostrarTienda(){
        println("Bienvenido a NAYD3C SHOPS")
        println("¿Que deseas?")
        println("(1) Comprar")
        println("(2) vender Objeto")
        println("(3) Salir de la tienda")
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


    fun recibirAtaque(nombre:String, ataque:Float){
        println("$nombre recibe un daño de $ataque puntos")
    }

    fun hacerAtaque(nombre:String, ataque:Float){
        println("$nombre lanza un ataque de $ataque puntos")
    }

    fun <T>finalBatalla(jugador : T,luchador:T){
        if (jugador is Estadisticas && luchador is Estadisticas &&
            jugador is TransaccionesPeleas && luchador is TransaccionesPeleas)
            finalBatallaTexto(jugador,luchador)
    }
    fun <T>finalBatallaTexto(jugador : T,luchador:T) where T:Estadisticas, T:TransaccionesPeleas{
        when(jugador){
            is Jugador -> { println("${jugador.nombre} ha sido debilitado, has perdido ${jugador.pagarPelea(jugador.totalMonedas/2)}") }
            else -> { println("${jugador.nombre} ha sido debilitado, has ganado ${jugador.ingresoPelea(luchador.totalMonedas)}") }
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
        for (i in (0..armaduras.size-1)){
            println("${i+1}. ${armaduras[i].nombre()}  ${armaduras[i].precio()}€ (${armaduras[i].estadistica()} PD)")
        }
        println("6. no comprar nada")
    }

    fun mostrarArmas(armas: List<EquipablesPrecioEstadisticas>) {
        for (i in (0..armas.size-1)){
            println("${i+1}. ${armas[i].nombre()}  ${armas[i].precio()}€ (${armas[i].estadistica()} PD)")
        }
        println("6. no comprar nada")
    }
}



