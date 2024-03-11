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