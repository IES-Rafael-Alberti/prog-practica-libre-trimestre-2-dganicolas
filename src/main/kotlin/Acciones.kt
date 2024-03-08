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
    fun recibirAtaque(ataqueRecibido:Float,defenderse:Boolean)
}

interface curarse{
    fun curar()
}
interface transacciones{
    fun pagar(coste:Float):Float
    fun ingreso(coste:Float):Float
}