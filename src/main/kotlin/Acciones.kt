import org.practicatrim2.EquipablesPrecioEstadisticas
import org.practicatrim2.Objetos

/**
 * Interfaz Peleas 
 * la usa la clase Personajes
 * */

interface Estadisticas{
    val nombre:String
    val nivel:Int
    var vida:Float
    val vidaActual:Float
    var experiencia:Float
    var totalMonedas:Float

}
interface Peleas {
    /**
     * en la vida real tu tienes que saber cuand oesta muy mal y detener la pelea
     * */
    fun saberVida():Float
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
    fun recibirAtaque(ataqueRecibido:Float):Float
}

interface TratamientoRecibido{
    fun medicoPreguntaPorTuCondicionFisica():Float
    fun medicoPreguntaPorTuDinero(coste: Float):Float?

    fun pagarAlmedico(coste: Float):Float

}
interface Curarse {
    fun curar(porcentajeQueSeVaACurar:Int= 100):Float
}

interface TransaccionesPeleas{
    fun pagarPelea(coste:Float):Float
    fun ingresoPelea(coste:Float):Float
}
interface TransaccionesObjetos{
    fun pagarEquipable(coste:EquipablesPrecioEstadisticas):Float
    fun ingresoEquipable(coste:EquipablesPrecioEstadisticas):Float
}

/**
 * Esta interfaz me sirveen peleas para cuand oun enemigo tenga una probalididad de darme e lobjeto que tenga en su cuerpo
 * */
interface ComprobarObjeto{
    fun comprobarObjetos ():Objetos?
}
/**
 * Esta interfaz me sirveen peleas para cuando un enemigo tenga una probalididad de darme el objeto que tenga en su cuerpo
 * añadirlo a la lista inventario del jugador
 * */
interface RecibirObjeto{

    fun recibirobjeto(objeto:Objetos):Objetos

}

/**
 * Esta interfaz me sirve en Tiendas para cuando un enemigo tenga una probalididad de darme el objeto que tenga en su cuerpo
 * añadirlo a la lista inventario del jugador
 * */
interface MostrarDarObjeto{
    fun mostrarObjetos():List<EquipablesPrecioEstadisticas>
    fun darObjeto(objeto:EquipablesPrecioEstadisticas):EquipablesPrecioEstadisticas?
}

interface SubirDeNivel{
    fun subirDeNivel():Int?
    fun ComprobarSiTieneExpSuficiente(nivel: Float):Float
}
interface MostrarDarEquipables{
    fun mostrarArmaduras():List<EquipablesPrecioEstadisticas>
    fun darArma(nombreArma:EquipablesPrecioEstadisticas):EquipablesPrecioEstadisticas?
    fun darArmadura(nombreArmadura: EquipablesPrecioEstadisticas):EquipablesPrecioEstadisticas?
    fun mostrarArmas():List<EquipablesPrecioEstadisticas>
}

interface EquiparEquipables {
    fun equiparArma(armaNueva:EquipablesPrecioEstadisticas?):EquipablesPrecioEstadisticas?
    fun equiparArmadura(armaduraNueva: EquipablesPrecioEstadisticas?):EquipablesPrecioEstadisticas?

}

