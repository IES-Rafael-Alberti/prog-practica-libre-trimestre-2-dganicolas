import org.practicatrim2.EquipablesPrecioEstadisticas


interface Player:
    Estadisticas,
    Peleas,
    Curarse,
    Transacciones,
    TratamientoRecibido{
    var arma:EquipablesPrecioEstadisticas
    var armadura:EquipablesPrecioEstadisticas
    var inventario:MutableList<EquipablesPrecioEstadisticas>
    }

interface Seller:Transacciones{
    val nombre:String
    var monedas: Float
    val armas:List<EquipablesPrecioEstadisticas>
    val armaduras:List<EquipablesPrecioEstadisticas>
    }
interface Enemigo:
    Estadisticas,
    Curarse,
    Transacciones,Peleas{
        var objeto:EquipablesPrecioEstadisticas
    }

interface Estadisticas{
    val nombre:String
    var vida:Float
    val vidaActual:Float
    var totalMonedas:Float

}

interface Peleas {
    var dano:Float
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

interface Transacciones{
    fun pagar(coste:Float):Float
    fun ingreso(coste:Float):Float
}

/**
 * Esta interfaz me sirveen peleas para cuand oun enemigo tenga una probalididad de darme e lobjeto que tenga en su cuerpo
 * */
/**
 * Esta interfaz me sirveen peleas para cuando un enemigo tenga una probalididad de darme el objeto que tenga en su cuerpo
 * añadirlo a la lista inventario del jugador
 * */

/**
 * Esta interfaz me sirve en Tiendas para cuando un enemigo tenga una probalididad de darme el objeto que tenga en su cuerpo
 * añadirlo a la lista inventario del jugador
 * */


