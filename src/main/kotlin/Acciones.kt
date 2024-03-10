/**
 * Interfaz Peleas 
 * la usa la clase Personajes
 * */
interface Peleas {
    /**
     * funcion que determina el daño que hace la entidad
     * @param ataqueRecibido el ataque que hace
     * @return retorna el daño del ataque recibido
     * */
    fun hacerAtaque():Float

    /**
     * funcion que determina el daño que recibe la entidad
     * @param ataqueRecibido el ataque que recibe
     * @return retorna el daño del ataque recibido
     * */
    fun recibirAtaque(ataqueRecibido:Float)
}

interface curarse{
    fun curar()
}

interface Aparencia{
    fun mostrarAparencia()
}

interface SubirDeNivel{
    fun subirDeNivel(experienciaQuitadaPorNivel:Int)
    fun queNivelTengo():Int

    fun<T:Number> calcularSubidaEstadistica(Estadistica:Int)
}