import org.practicatrim2.Armas

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
class Enemigos(Nombre: String,nivel: Int,dano: Float,vida: Float,vidaActual: Float,experiencia: Float,arma: Armas):Personajes(Nombre,nivel,dano,vida,vidaActual,experiencia,arma),Peleas{

    override fun atacar() = dano + arma.dañoExtra() +(nivel*0.1f)

    override fun defensa()= nivel*0.2f

    override fun toString() = "el enemigo es ${this.Nombre} de nivel ${this.nivel} y su arma es ${this.arma}"
}