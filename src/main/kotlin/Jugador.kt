import org.practicatrim2.Armas
import kotlin.random.Random

// este es el personaje principal, aqui llevara el puntuaje de exp, el multiplicador de daño
// el arma que lleva y el ratio de armadura que lleva
class Jugador(nombre:String, nivel: Int, dano:Float, vida: Float, vidaActual:Float, experiencia: Float, arma: Armas)
    : Personajes (nombre,nivel,dano, vida,vidaActual, experiencia,arma), Estadisticas{


    override fun atacar() = dano + arma.dañoExtra()

    override fun defensa() = nivel.toFloat()* 1.2f






}