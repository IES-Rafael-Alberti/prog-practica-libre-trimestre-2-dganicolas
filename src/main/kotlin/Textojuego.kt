import org.practicatrim2.Armaduras
import org.practicatrim2.Armas
import org.practicatrim2.Objetos

class Textojuego {

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

    fun <T:Personas>mostrarEscenario(jugador: Jugador, enemigo: T) {
        limpiarConsola()
        println("-------------------------------------------------------")
        println("-Enemigo: ${enemigo.nombre}")
        println("-Nivel: ${enemigo.nivel}")
        println("-Vida: ${mostrarvida(enemigo.vida,0f)}")
        mostrarpng(enemigo)
        println("-Tu: ${jugador.nombre}")
        println("-Nivel: ${jugador.nivel}")
        println("-Vida: ${jugador.vida}")
        println("-------------------------------------------------------")
        println("-Selecciona una opcion:      Arma: ${jugador.arma}")
        println("- (1)Atacar (2)Defenderse (3)Huir")
        println("-------------------------------------------------------")
    }
    fun <T:Personas>mostrarpng(persona: T){
        when (persona){
            is Personas.Zombie -> aparenciaZombie()
            is Personas.Arquero -> aparenciaZombie()
        }
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

    fun subirDeNivel(podraSubirNivel: Boolean){
        println("${Jugador.nombre} se volvio mas fuerte")
    }
    fun mostrarMenu(jugador: Jugador){
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

    fun <T>mostrarTienda(jugador:Personas<T>){
        println("Bienvenido a NAYD3C SHOPS")
        println("¿Que deseas ${jugador.nombre}?")
        println("(1) Comprar")
        println("(2) vender Objeto")
        println("(3) Salir de la tienda")
    }

    /**
     * Acciones
     * */
    fun<T> curarVida(nombre:T, recuperado:T){
        animacion()
        println("$nombre se ha curado sus heridas, recupero $recuperado")
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

    fun <T>finalBatallaTexto(jugador : T, monedasContricante: Float=0f){
        when(jugador){
            is Jugador -> { println("${Jugador.nombre} ha sido debilitado, has perdido ${Jugador.pagar(Jugador.monedas/2)}") }
            is Personas -> { println("${jugador.nombre} ha sido debilitado, has ganado ${Jugador.ingreso(monedasContricante)}") }
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

    fun aparenciaTroy(){
        println("                  .:c.                  \n" +
                "                  ,k0:                  \n" +
                "         .'lkOOOx,,kKc'dOOOOo,..        \n" +
                "     'dKWXocxXMWK:,kKc;KMMWO:.,d0k;     \n" +
                "    .lxdO0cl0WM0; ,OKc;KMMMMNk' 'oo'    \n" +
                "  cO,;x:..... 'oxloKXd''lkkko'  ,dc'xd. \n" +
                "  ck,cNNO:.    .clldx00l.    .,xXWd'xd  \n" +
                "  ck,cNWd......,d0XWMMNk;......lXWd'xd. \n" +
                "  ck,cXNl  ||    'xXNO;.    || ;XWo'xd. \n" +
                "  ;d'.c0l  |||    :0Xo.    ||| ;0o..lc  \n" +
                "      .cl,  |||  cXWWNd.  ||| .cl.      \n" +
                "  ':.   ':c'     'cccc,     .:c,.  .;,  \n" +
                "  cX0:.ll''ll.             co;':o''kNd  \n" +
                "  'oo,.;l;.lk.        .   .dx.,l:..ld;  \n" +
                " ,lll'.:oolOk'',.      .,,.d0olol..cll:.\n" +
                "     .'',,'.                 .'','. ")
    }

    fun aparenciaZombie(){
        println("⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷\n" +
                "⣿⣿⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⡟⠉⠉⠉⠉⠉⢻⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿\n")
    }

    fun mostrarArmaduras(armaduras: List<Armaduras>) {
        for (i in (0..armaduras.size-1)){
            println("${i+1}. ${armaduras[i].name}  ${armaduras[i].precio()}€ (${armaduras[i].estadistica()} PD)")
        }
        println("6. no comprar nada")
    }

    fun mostrarArmas(armas: List<Armas>) {
        for (i in (0..armas.size-1)){
            println("${i+1}. ${armas[i].name}  ${armas[i].precio()}€ (${armas[i].estadistica()} PD)")
        }
        println("6. no comprar nada")
    }

    companion object {
        fun mostrarObjetosVentaJugador(listaObjetoJugador: Map<String, Objetos>) {
            listaObjetoJugador.keys.forEachIndexed { index, key ->
                println("${index + 1}. $key")
            }
        }
    }
}