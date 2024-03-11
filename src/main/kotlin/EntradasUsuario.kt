class EntradasUsuario() {

    fun usuarioIntroduceNombre(nombre:String):String{
        while(true){
            try {
                TextoConsola.textoNombre(nombre)
                val nombre = readln()

            }catch (e:IllegalArgumentException){
                TextoConsola.nombreMalTecleado(nombre)
                TextoConsola.enterparacontinuar()
            }
        }
    }

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

    fun variasOpcionesTienda(listaObjetos: Int):Any{
        while (true) {
            var opcion:Any = readln()
            try {
                 opcion=opcion.toString().toInt()
                if (opcion > listaObjetos || opcion < 0) {
                    throw IllegalArgumentException()
                }
                return opcion
            }catch (e:IllegalArgumentException){
                return ""
            }catch (e:NumberFormatException){
                return opcion.toString()
            }
        }
    }

}