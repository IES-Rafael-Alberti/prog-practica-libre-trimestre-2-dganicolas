/**
 * Interfaz Peleas 
 * la usa la clase Personajes
 * */

interface mostrarMenus{
    fun mostrarMenuPrincipal(){
        Textojuego().mostrarMenu()
    }
}

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
    fun curar(porcentajeQueSeVaACurar:Int= 100)
}
interface transacciones<T>{
    fun pagar(coste:T):Float
    fun ingreso(coste:T):Float
}
interface darObjeto<T> {
    fun darObjeto(destinatario:T)
}

interface recibirObjeto{
    fun recibirobjeto(objeto:Objetos)
}

interface aparencia{
    fun mostrarAparencia()
}

interface levelear{
    fun subirDeNivel()
    fun ComprobarSiTieneExpSuficiente(nivel: Float):Float
}

interface registrarAccion{
    fun haMatadoOHeMuerto()
}