//se encarga de la logistica de la tienda
class Tienda() {
        private var JUGADORESTAADENTRO = true
    fun <T>comprobarOpciones(opcion:Int, jugador: T, vendedor: T)where T:MostrarDarObjeto, T:TransaccionesObjetos, T:MostrarDarEquipables, T:EquiparEquipables{
        when (opcion){
            1 -> vender(jugador,vendedor)
            2 -> comprar(jugador,vendedor)
            3 -> JUGADORESTAADENTRO = false
        }
    }
    /**
     * esta completada :D
     * */
    fun <T>comprar(jugador:T,vendedor:T) where T:MostrarDarEquipables, T:EquiparEquipables, T:TransaccionesObjetos{
        while (true){
            TextoConsola.menuComprar()
            when (EntradasUsuario().tresOpciones()){
                1 ->{
                    val armas = vendedor.mostrarArmas()
                    TextoConsola.mostrarArmas(armas)
                    val opcion =EntradasUsuario().seisOpciones()
                    var arma = vendedor.darArma(armas[opcion-1])
                    arma = jugador.equiparArma(arma)
                    if(arma != null){
                        vendedor.ingresoEquipable(arma)
                        jugador.pagarEquipable(arma)
                    }
                    TextoConsola.jugadorRecibeEquipable(arma)
                    break
                }
                2->{
                    val armaduras = vendedor.mostrarArmaduras()
                    TextoConsola.mostrarArmaduras(armaduras)
                    val opcion =EntradasUsuario().seisOpciones()
                    var armadura = vendedor.darArmadura(armaduras[opcion-1])
                    armadura = jugador.equiparArmadura(armadura)
                    if(armadura != null){
                        vendedor.ingresoEquipable(armadura)
                        jugador.pagarEquipable(armadura)
                    }
                    TextoConsola.jugadorRecibeEquipable(armadura)
                    break
                }
                3->{
                    TextoConsola.jugadorNoCompraNada()
                    break
                }
            }
        }

    }

    fun <T>vender(jugador: T, vendedor: T) where T:MostrarDarObjeto,T:TransaccionesObjetos {
        while (true){
            val inventarioDisponible= (jugador.mostrarObjetos())
            TextoConsola.mostrarObjetosVentaJugador(inventarioDisponible)
            if(inventarioDisponible.isNotEmpty()){
                val opcion = EntradasUsuario().variasOpciones(inventarioDisponible.size)
                if (opcion != null){
                    TextoConsola.objetoVendido(inventarioDisponible[opcion])
                    vendedor.pagarEquipable(inventarioDisponible[opcion])
                    jugador.ingresoEquipable(inventarioDisponible[opcion])
                    jugador.darObjeto(inventarioDisponible[opcion])
                    break
                }else{
                    TextoConsola.errorObjetos()
                }
            } else{
                break
            }

        }
    }
    fun <T>tienda(jugador:T,vendedor: T)
    where T:Any{
        if (
            jugador is EquiparEquipables &&
            jugador is MostrarDarEquipables &&
            jugador is MostrarDarObjeto &&
            jugador is TransaccionesObjetos &&
            vendedor is EquiparEquipables &&
            vendedor is MostrarDarEquipables &&
            vendedor is MostrarDarObjeto &&
            vendedor is TransaccionesObjetos)
        while(JUGADORESTAADENTRO){
            TextoConsola.mostrarTienda()
            val opcion = EntradasUsuario().tresOpciones()
            comprobarOpciones(opcion,jugador,vendedor)
        }
        JUGADORESTAADENTRO = true
    }
}