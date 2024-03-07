import org.practicatrim2.Armas

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
abstract class Luchadores(val nombre: String,var monedas: Float,
                          var nivel: Int, var dano: Float,
                          var vida: Float,
                          var vidaActual: Float,
                          var arma: Armas):Peleas{

}