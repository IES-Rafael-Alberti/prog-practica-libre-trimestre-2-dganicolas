
/**
 *
 * es la interfaz que toda clase jugable debe cumplir
 *
 * esta interfaz hereda de las siguientes interfaces:
 * - Estadisticas
 * - Peleas
 * - Curarse
 * - Transacciones
 * - IrAlMedico
 *
 * @property arma es la arma que puede llevar el jugador
 * @property armadura es la armadura que puede llevar el jugador
 * @property inventario es el inventario del jugador
 * @author Nicolas De Gomar
 * */
interface Player:
    Estadisticas,
    Peleas,
    Curarse,
    Transacciones,
    IrAlMedico{
    var arma: EquipablesPrecioEstadisticas
    var armadura: EquipablesPrecioEstadisticas
    var inventario:MutableList<EquipablesPrecioEstadisticas>
    }
/**
 *
 * es la interfaz que toda clase que deba ser vendedor debe cumplir
 *
 * esta interfaz hereda de las siguientes interfaces:
 * - Transacciones
 *
 * @property nombre es el nombre que puede llevar el vendedor
 * @property monedas son las monedas que puede disponer el vendedor para inteercambiar
 * @property armas es la lista de armas que ese vendedor puede disponer
 * @property armaduras es la lista de armaduras que ese vendedor puede disponer
 * @author Nicolas De Gomar
 * */
interface Seller:Transacciones{
    //es el nombre que puede llevar el vendedor
    val nombre:String
    var monedas: Float
    val armas:List<EquipablesPrecioEstadisticas>
    val armaduras:List<EquipablesPrecioEstadisticas>
    }
/**
 * es la interfaz que toda clase que deba ser Enemigo debe cumplir
 *
 * esta interfaz hereda de las siguientes interfaces:
 * - Estadisticas
 * - Curarse
 * - Transacciones
 * - Peleas
 *
 * @property objeto es el objeto que el enemigo puede tener en la batalla, y si pierde se lo da al Player al final de la batalla
 * @author Nicolas De Gomar
 * */
interface Enemigo:
    Estadisticas,
    Curarse,
    Transacciones,
    Peleas{
        var objeto: EquipablesPrecioEstadisticas
    }
/**
 * esta interfaz tiene todas las estadisticas de cualquier entidad
 *
 * @property nombre es el nombre de la entidad
 * @property vida es la vida que tiene la entidad actualmente
 * @property vidaMaxima es la vida maxima que tiene la entidad
 * @property cartera es la cantida de monedas que tiene la entidad
 * @author Nicolas De Gomar
 * */
interface Estadisticas{

    val nombre:String
    var vida:Float
    val vidaMaxima:Float
    var cartera:Float

}
/**
 * esta interfaz tiene todas las acciones referido a las peleas
 * @property dano es el daño que puede producir la entidad
 * @author Nicolas De Gomar
 * */
interface Peleas {
    var dano:Float

    /**
     * esta funcion me sirve para conocer la condicion fisica que tiene la entidad
     * @return la vida actual que tiene la entidad
     * */
    fun saberVida():Float
    /**
     * esta funcion me sirve para saber el daño que hara la entidad
     *  @return daño que puede hacer la entidad
     * */
    fun hacerAtaque():Float

    /**
     * esta funcion me sirve para saber el daño que recibira la entidad
     *  @return daño que recibio la entidad
     * */
    fun recibirAtaque(ataqueRecibido:Float):Float
}
/**
 * esta interfaz tiene todas las acciones referido a ir al medico
 * @author Nicolas De Gomar
 * */
interface IrAlMedico{

    /**
     * el medico pregunta por tu estado de salud
     *
     * ejemplo:
     * - la entidad tien 5/10 puntos de vida
     * - despues de preguntar
     * - coste = la vida restante de la entidad * el coste del tratamiento
     * - retorna coste
     *
     * @return el coste del supuesto tratamiento a curar de la entidad
     * @author Nicolas De Gomar
     * */
    fun medicoPreguntaPorTuCondicionFisica():Float

    /**
     * el medico pregunta por tu cartera
     * ejemplo:
     * si el costes cuesta 50 monedas
     * y la entidad tiene 35 monedas devuelve null
     * si la entidad tiene 55 devuelve que el coste a sido 50
     *
     * @return coste del tratamiento o null en caso de que el coste sea mayor del dinero que tiene la entidad
     * @author Nicolas De Gomar
     * */
    fun medicoPreguntaPorTuDinero(coste: Float):Float?

    /**
     * el medico te da el tratamiento, y le resta dinero a tu cartera
     *
     * @param coste el dinero a restar de la cartera de la entidad
     * @return el dinero que te ha costado
     * @author Nicolas De Gomar
     * */
    fun pagarAlmedico(coste: Float):Float

}

/**
 * esta interfaz contiene el metodo el cual una entidad se puede curar
 * @author Nicolas De Gomar
 * */
interface Curarse {

    /**
     * la entidad se podra curar su vida con este metodo
     * @param porcentajeQueSeVaACurar es el pocertanje que se va a curar la entidad
     * @return los puntosde vida que se ha curado
     * @author Nicolas De Gomar
     * */
    fun curar(porcentajeQueSeVaACurar:Int= 100):Float
}
/**
 * esta interfaz tiene los metods para comprar o vender
 * @author Nicolas De Gomar
 * */
interface Transacciones{

    /**
     * esta funcion hace que le reste dinero a la entidad
     *
     * @param coste coste del objeto
     * @return el coste del objeto o la cartera de la entidad
     * @author Nicolas De Gomar
     * */
    fun pagar(coste:Float):Float

    /**
     * esta funcion hace que el sume dinero a la entidad
     *
     * @param coste coste del objeto
     * @return el coste del objeto o la cartera de la entidad
     * @author Nicolas De Gomar
     * */
    fun ingreso(coste:Float):Float
}


