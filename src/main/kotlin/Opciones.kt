class Opciones() {
    fun opciones():Int{
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
}