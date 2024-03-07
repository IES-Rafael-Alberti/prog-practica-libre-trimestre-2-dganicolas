import org.practicatrim2.Armas
import org.practicatrim2.redondear

// este es el personaje principal, aqui llevara el puntuaje de exp, el multiplicador de daño
// el arma que lleva y el ratio de armadura que lleva
object Jugador :Personajes("Troy"), Peleas{
    var jugador:String= "Troy"
    var nivel: Int = 1
    var dano:Float = 3f
    var vida: Float = 10f
    var vidaActual:Float = 10f
    var monedas: Float = 10000f
    var arma: Armas = Armas.Espada


    fun dormirSuelo(){
        println("$nombre está durmiendo")
        vidaActual = (vida*0.85f).redondear()
        println("\n\n\n\n\n\n\n\ndormir al aire libre, es malo, -15% puntos de vida")
    }
    override fun recibirAtaque(ataqueRecibido: Float): Float{
        vidaActual -= ataqueRecibido
        return ataqueRecibido
    }

    override fun hacerAtaque() = dano + arma.dañoExtra()

    override fun toString() = "El ${this.nombre} de nivel ${this.nivel}, su experiencia es ${this.monedas} y su arma es ${this.arma}, el daño es ${hacerAtaque()}"
}