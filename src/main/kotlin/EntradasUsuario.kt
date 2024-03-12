class EntradasUsuario() {

    fun opciones(numeroOpciones:Int):Int{
        return try {
            val opcion = readln().toInt()
            if (opcion > numeroOpciones || opcion < 0) {
                throw IllegalArgumentException()
            }
            opcion
        }catch (e:IllegalArgumentException){
            println(TextoConsola.mensajeDeError())
            TextoConsola.enterparacontinuar()
            0
        }
    }

    fun variasOpcionesTienda(listaObjetos: Int):Int?{
        while (true) {
            try {
                 val opcion= readln().toInt()
                if (opcion > listaObjetos || opcion < 0) {
                    throw IllegalArgumentException()
                }
                return opcion
            }catch (e:IllegalArgumentException){
                return null
            }
        }
    }

}