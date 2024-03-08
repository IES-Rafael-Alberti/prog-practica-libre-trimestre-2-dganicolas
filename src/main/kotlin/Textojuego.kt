class Textojuego:mostrarMenus {

    /**
     * FUNCIONES VARIAS
     * */
    private fun limpiarConsola(){
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
    }


    fun duermeHostal(coste:Float){
        println("Has dormido en el hostal NXDXG, coste de la noche: $coste" +
                "${Jugador.nombre} se recupero completamente")
    }
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

    fun <T:Luchadores>mostrarEscenario(jugador: Jugador, enemigo: T) {
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
    fun <T:Luchadores>mostrarpng(persona: T){
        when (persona){
            is Luchadores.Zombie -> aparenciaZombie()
            is Luchadores.Arquero -> aparenciaZombie()
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
    fun mostrarMenu(){
        limpiarConsola()
        println("BIENVENIDO A NAYD3C WORLDS")
        println("Nombre: ${Jugador.nombre}")
        println("Nivel: ${Jugador.nivel}")
        println("Vida: ${mostrarvida(Jugador.vida,Jugador.vidaActual)}")
        println("¿Que quieres hacer joven aventurero?")
        println("(1) Pelea")
        println("(2) Recuperar vida")
        println("(3) ir al vendedor")
        println("(4) fin del juego")
    }

    fun mostrarTienda(){
        println("Bienvenido a NAYD3C SHOPS")
        println("¿Que deseas ${Jugador.nombre}?")
        println("(1) Comprar")
        println("(2) vender")
        println("(3) Dormir en Hostal")
        println("(4) Salir de la tienda")
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
            is Luchadores -> { println("${jugador.nombre} ha sido debilitado, has ganado ${Jugador.ingreso(monedasContricante)}") }
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
}