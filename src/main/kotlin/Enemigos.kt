import org.practicatrim2.Armas

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
class Enemigos(Nombre: String,nivel: Int,dano: Float,vida: Float,vidaActual: Float,experiencia: Float,arma: Armas):Personajes(Nombre,nivel,dano,vida,vidaActual,experiencia,arma),Peleas{

    /**
     * el danio se basa en el danio por defecto del enemigo
     * mas la arma equipada
     * mas el nivel por 0,1f
     *
     * @return los puntos de danio que tiene el enemigo
     *
     * ejemplo:
     * el zombie nivel 2, danio 3 , lanza (15PV)
     * 3 + 15 + (2 * 0.1) =  18.2
     * */
    override fun atacar() = dano + arma.dañoExtra() +(nivel*0.1f)

    /**
     * Cuanto mas nivel tenga el enemigo, mayor sera su defensa
     *
     * @return los puntos de defensa que tiene el enemigo
     * ejemplo:
     * si el zombie es de nivel 2, su defensa sera de 0.4f
     * */
    override fun defensa()= nivel*0.2f

    fun mostrarNombre() = "el ${this.Nombre}"


}