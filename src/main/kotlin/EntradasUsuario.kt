import org.practicatrim2.Objetos

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

    fun Opciones(numeroOpciones:Int):Int{
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


    fun cuatroOpciones():Int{
        return try {
            val opcion = readln().toInt()
            if (opcion > 4 || opcion < 0) {
                throw IllegalArgumentException()
            }
            opcion
        }catch (e:IllegalArgumentException){
            println(TextoConsola.mensajeDeError())
            TextoConsola.enterparacontinuar()
            0
        }

    }

    fun seisOpciones():Int{
        return try {
            val opcion = readln().toInt()
            if (opcion > 6 || opcion < 0) {
                throw IllegalArgumentException()
            }
            opcion
        }catch (e:IllegalArgumentException){
            println(TextoConsola.mensajeDeError())
            TextoConsola.enterparacontinuar()
            0
        }

    }

    fun tresOpciones():Int{
        return try {
            val opcion = readln().toInt()
            if (opcion > 4) {
                throw IllegalArgumentException()
            }
            opcion
        }catch (e:IllegalArgumentException){
            println(TextoConsola.mensajeDeError())
            TextoConsola.enterparacontinuar()
            0
        }

    }

    fun variasOpciones(listaObjetos: Int): Int?{
        while (true){
            try {
                val opcion = readln().toInt()
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