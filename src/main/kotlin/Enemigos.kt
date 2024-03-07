import org.practicatrim2.Armas

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
class Enemigos(nombre: String,var nivel: Int,var dano: Float,var vida: Float,var vidaActual: Float,var experiencia: Float,var arma: Armas):Personajes(nombre),Peleas{

    override fun recibirAtaque(ataqueRecibido: Float): Float {
        vidaActual -= ataqueRecibido
        return ataqueRecibido
    }

    override fun hacerAtaque() = dano + arma.dañoExtra()

    fun mostrarNombre() = "el ${this.nombre}"


}