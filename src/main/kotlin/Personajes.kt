import org.practicatrim2.Armas
import org.practicatrim2.ExperienciaRequeridaPorNivel
import org.practicatrim2.calcularExperiencia
import kotlin.random.Random

// la clase padre de enemigos, jugador y cualquier entidad viviente
abstract class Personajes(val Nombre:String, var nivel: Int, var dano:Float, var vida: Float, var vidaActual:Float, var experiencia: Float, var arma: Armas): Peleas {
    companion object {
        const val  EXPCAMBIODEARMA = 100f
    }
    override fun atacar() = dano + arma.dañoExtra()

    override fun defensa() = nivel.ExperienciaRequeridaPorNivel()

    /**
     * retorna una arma aleatoria
     * @return la arma seleccionada
     * */
    fun darArmaJugador(){
        this.experiencia -= EXPCAMBIODEARMA
        val armas = Armas.entries.toTypedArray()
        val numero = Random.nextInt(armas.size)
        this.arma = armas[numero]
    }

    /**
     * su funcionalidad es poder cambiar de arma aleatoriamente
     *
     * @return retorna un string donde dice si ha sido posible el cambio o no
     * */
    fun cambiarArma():String{
        return if (this.experiencia > EXPCAMBIODEARMA){
            println("Asignando una nueva arma a tu jugador.")
            darArmaJugador()
            "Ahora tienes la arma: ${this.arma}(${this.arma.dañoExtra()} PV)"
        }else{
            "Experiencia insuficiente para el cambio, te faltan ${experiencia.calcularExperiencia(EXPCAMBIODEARMA)}"
        }
    }

    /**
     * esta funcion la utilizo para describir a los personajes
     * */

    override fun toString() = "el ${this.Nombre} de nivel ${this.nivel}, su experiencia es ${this.experiencia} y su arma es ${this.arma}, el daño es ${atacar()}"
}