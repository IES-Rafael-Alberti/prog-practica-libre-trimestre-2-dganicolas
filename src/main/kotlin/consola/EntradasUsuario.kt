package consola

class EntradasUsuario() {

    /**
     * @param numeroOpciones son el numero opciones disponible
     * @return devuelve el numero de opcion escogido o un 0 como que ha habido un error
     * @throws lanza un error de que el usuario no  ha metido una opcion valida
     * */
    fun opciones(numeroOpciones:Int):Int{
        return try {
            val opcion = readln().toInt()
            if (opcion > numeroOpciones || opcion < 0) {
                throw IllegalArgumentException()
            }
            opcion
        }catch (e:IllegalArgumentException){
            println(TextoConsola.mensajeDeError())
            0
        }
    }

    /**
     * @param listaObjetos son el numero de objetos disponibles
     * @return devuelve el numero de opcion escogido o un null como que ha habido un error
     * @throws lanza un error de que el usuario no  ha metido una opcion valida
     * */
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