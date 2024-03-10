import org.practicatrim2.Objetos

class EntradasUsuario() {

    fun usuarioIntroduceNombre(nombre:String):String{
        while(true){
            try {
                Textojuego().textoNombre(nombre)
                val nombre = readln()
            }catch (e:IllegalArgumentException){
                Textojuego().nombreMalTecleado(nombre)
                Textojuego().enterparacontinuar()
            }finally {

            }
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
            println(Textojuego().mensajeDeError())
            Textojuego().enterparacontinuar()
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
            println(Textojuego().mensajeDeError())
            Textojuego().enterparacontinuar()
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
            println(Textojuego().mensajeDeError())
            Textojuego().enterparacontinuar()
            0
        }

    }

    fun variasOpciones(listaObjetos: List<String>, listaObjetoJugador: Map<String, Objetos>): Objetos? {
        while (true){
            try {
                val opcion = readln().toInt()
                if (opcion > listaObjetos.size || opcion < 0) {
                    throw IllegalArgumentException()
                }
                return listaObjetoJugador[listaObjetos[opcion]]
            }catch (e:IllegalArgumentException){
                println(Textojuego().mensajeDeError())
                Textojuego().enterparacontinuar()
                0
            }
        }
        }

}