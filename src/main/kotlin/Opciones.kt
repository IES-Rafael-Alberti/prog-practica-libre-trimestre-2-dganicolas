class Opciones() {
    fun opciones():Int{
        try {
            val opcion = readln().toInt()
            if (opcion > 3) {
                throw IllegalArgumentException()
            }
            return opcion
        }catch (e:IllegalArgumentException){
            println(Textojuego().mensajeDeError())
            return 0
        }
    }
}