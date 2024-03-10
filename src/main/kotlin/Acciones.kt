import org.practicatrim2.Armaduras
import org.practicatrim2.Armas
import org.practicatrim2.Objetos

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

interface TratamientoRecibido{
    fun medicoPreguntaPorTuCondicionFisica():Float
    fun medicoPreguntaPorTuDinero(coste: Float):Float?
    fun curar(porcentajeQueSeVaACurar:Int= 100):Float
}

interface Transacciones{
    fun pagar(coste:Float):Float
    fun ingreso(coste:Float):Float
}

interface RecibirObjeto{
    fun comprobarObjetos (nombreObjetos:String):Objetos?
    fun recibirobjeto(objeto:Objetos):Objetos

}
interface MostrarDarObjeto{
    fun mostrarObjetos():Map<String,Objetos>
    fun darObjeto(objeto:Objetos):Objetos?
}

interface SubirDeNivel{
    fun subirDeNivel():Int?
    fun ComprobarSiTieneExpSuficiente(nivel: Float):Float
}
interface MostrarDarEquipables{
    fun mostrarArmaduras():List<Armaduras>
    fun darArma(arma:Armas):Armas
    fun darArmadura(armadura: Armaduras):Armaduras
    fun mostrarArmas():List<Armas>
}

interface EquiparEquipables {
    fun equiparArma(arma:Armas)
    fun equiparArmadura(armadura: Armaduras)

}

