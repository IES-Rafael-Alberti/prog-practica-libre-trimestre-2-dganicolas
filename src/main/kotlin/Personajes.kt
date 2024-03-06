import org.practicatrim2.Armas
import org.practicatrim2.calcularExperiencia
import kotlin.random.Random

// la clase padre de enemigos, jugador y cualquier entidad viviente
abstract class Personajes(val Nombre:String, var nivel: Int, var dano:Float, var vida: Float, var vidaActual:Float, var experiencia: Float, var arma: Armas): Peleas {
    companion object {
        const val  EXPCAMBIODEARMA = 100f
    }

    /**
     * su funcionalidad es poder cambiar de arma aleatoriamente
     *
     * @return retorna un string donde dice si ha sido posible el cambio o no
     * */
    fun cambiarArma():String{
        return if (this.experiencia > EXPCAMBIODEARMA){
            println("Asignando una nueva arma a tu jugador.")
            this.experiencia -= EXPCAMBIODEARMA
            val armas = Armas.values()
            val numero = Random.nextInt(armas.size)
            this.arma = armas[numero]
            "Ahora tienes la arma: ${this.arma}(${this.arma.dañoExtra()} PV)"
        }else{
            "Experiencia insuficiente para el cambio, te faltan ${experiencia.calcularExperiencia(EXPCAMBIODEARMA)}"
        }
    }
}