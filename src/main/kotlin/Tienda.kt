//se encarga de la logistica de la tienda
class Tienda() {
        private var JUGADORESTAADENTRO = true
    /**
     * esta completada :D
     * */
    fun comprar(jugador:Player,vendedor:Seller){
        while (true){
            TextoConsola.menuComprar()
            when (EntradasUsuario().opciones(3)){
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
                3->{
                    TextoConsola.jugadorNoCompraNada()
                    break
                }
            }
        }

    }

    fun vender(jugador: Player, vendedor: Seller){
        while (true){
            TextoConsola.mostrarObjetosVentaJugador(jugador.inventario)
            if(jugador.inventario.isNotEmpty()){
                var opcion = EntradasUsuario().variasOpcionesTienda(jugador.inventario.size)
                if (opcion != null){
                    opcion = opcion.toString().toInt()
                    val objeto=jugador.inventario[opcion]
                    TextoConsola.jugadorVendeEquipable(objeto)
                    vendedor.pagar(objeto.precio())
                    jugador.ingreso(objeto.precio())
                    jugador.inventario.remove(objeto)
                    break
                }else{
                    TextoConsola.jugadorNoCompraNada()
                    break
                }
            } else{
                TextoConsola.enterparacontinuar()
                break
            }

        }
    }
    fun tienda(jugador:Player,vendedor: Seller){
        while(JUGADORESTAADENTRO){
            TextoConsola.mostrarTienda(jugador.nombre)
            val opcion = EntradasUsuario().opciones(3)
            when (opcion){
                1 -> vender(jugador,vendedor)
                2 -> comprar(jugador,vendedor)
                3 -> JUGADORESTAADENTRO = false
            }
        }
        JUGADORESTAADENTRO = true
    }
}