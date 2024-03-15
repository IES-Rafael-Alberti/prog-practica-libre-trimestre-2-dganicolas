import consola.EntradasUsuario
import consola.TextoConsola

//se encarga de la logistica de la tienda
class Tienda() {
        private var JUGADORESTAADENTRO = true
    /**
     * esta funcion es para si el jugador compra una armadura o una arma
     * @param jugador es el jugador
     * @param vendedor es el vendedor
     * */
    fun comprar(jugador:Player,vendedor:Seller){
        while (true){
            TextoConsola.menuComprar()
            when (EntradasUsuario().opciones(3)){
                //venta de armaduras
                1 ->{
                    TextoConsola.mostrarArmas(vendedor.armaduras)
                    var opcion = EntradasUsuario().variasOpcionesTienda(vendedor.armaduras.size)
                    if(opcion != null){
                        opcion = opcion.toString().toInt()
                        val armadura=vendedor.armaduras[opcion]
                        vendedor.ingreso(armadura.precio())
                        jugador.pagar(armadura.precio())
                        jugador.armadura = armadura
                        TextoConsola.jugadorRecibeEquipable(jugador.armadura)
                    }else{
                        TextoConsola.jugadorNoCompraNada()
                    }
                    break
                }
                //venta de armas
                2->{
                    TextoConsola.mostrarArmas(vendedor.armaduras)
                    var opcion = EntradasUsuario().variasOpcionesTienda(vendedor.armas.size)
                    if(opcion != null){
                        val arma=vendedor.armas[opcion]
                        vendedor.ingreso(arma.precio())
                        jugador.pagar(arma.precio())
                        jugador.armadura = arma
                        TextoConsola.jugadorRecibeEquipable(jugador.arma)
                    }else{
                        TextoConsola.jugadorNoCompraNada()
                    }
                    break
                }
                //no hace nada
                3->{
                    TextoConsola.jugadorNoCompraNada()
                    break
                }
            }
        }

    }

    /**
     * esta funcion es para si el jugador vende los objetos obtenidos en la batalla
     * @param jugador es el jugador
     * @param vendedor es el vendedor
     * */
    fun vender(jugador: Player, vendedor: Seller){
        while (true){
            TextoConsola.mostrarObjetosVentaJugador(jugador.inventario)
            if(jugador.inventario.isNotEmpty()){
                var opcion = EntradasUsuario().variasOpcionesTienda(jugador.inventario.size)
                //el jugador vende sus objetos
                if (opcion != null){
                    opcion = opcion.toString().toInt()
                    val objeto=jugador.inventario[opcion]
                    TextoConsola.jugadorVendeEquipable(objeto)
                    vendedor.pagar(objeto.precio())
                    jugador.ingreso(objeto.precio())
                    jugador.inventario.remove(objeto)
                    break
                }
                //el jugador no decidio vender sus objetos
                else{
                    TextoConsola.jugadorNoCompraNada()
                    break
                }
            }
            //jugador no tiene objetos en el inventario
            else{
                TextoConsola.enterparacontinuar()
                break
            }

        }
    }

    /**
     * esta funcion es para si el jugador compra una armadura o una arma
     * @param jugador es el jugador
     * @param vendedor es el vendedor
     * */
    fun tienda(jugador:Player,vendedor: Seller){
        while(JUGADORESTAADENTRO){
            TextoConsola.mostrarTienda(jugador.nombre)
            val opcion = EntradasUsuario().opciones(3)
            when (opcion){
                //jugador decide vender
                1 -> vender(jugador,vendedor)
                //jugador decide comprar
                2 -> comprar(jugador,vendedor)
                //jugador se va de la tienda
                3 -> JUGADORESTAADENTRO = false
            }
        }
        JUGADORESTAADENTRO = true
    }
}