import org.practicatrim2.Armas
import org.practicatrim2.estadisticas

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
sealed class Luchadores(val nombre: String,var monedas: Float, var nivel: Int, var dano: Float, var vida: Float, var vidaActual: Float, var arma: Armas):registrarAccion,estadisticas{



    final class Zombie(nombre: String,monedas: Float, nivel: Int,dano: Float, vida: Float, vidaActual: Float, arma: Armas, var defensa: Float):
            Luchadores(nombre,monedas,nivel,dano,vida,vidaActual,arma),Peleas,curarse,aparencia {
        override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
            var dano = 0f
            if (defenderse){
                vida -= ataqueRecibido - defensa
                dano = ataqueRecibido - defensa
            } else{
                vida -= ataqueRecibido
                dano = ataqueRecibido
            }

            Textojuego().recibirAtaque(nombre,dano)
        }

        override fun hacerAtaque():Float{
            Textojuego().hacerAtaque(nombre,dano + arma.dañoExtra())
            return dano + arma.dañoExtra()
        }

        override fun mostrarAparencia() {
            Textojuego().aparenciaZombie()
        }

        override fun estadisticas() = listOf(this.nombre,"nombre: ${this.nombre}","monedas: ${this.monedas}","Nivel: ${this.nivel}","Daño: ${this.dano}","Vida: ${this.vida}","${this.vida}","${this.arma}")

        override fun haMatadoOHeMuerto() {
            TODO("Not yet implemented")
        }

        override fun curar(porcentajeQueSeVaACurar: Int) {
            vida = vidaActual
        }
    }

    class Arquero(nombre: String,monedas: Float, nivel: Int,dano: Float, vida: Float, vidaActual: Float, arma: Armas, var defensa: Float):
        Luchadores(nombre,monedas,nivel,dano,vida,vidaActual,arma),Peleas,aparencia {
        override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
            var dano = 0f
            if (defenderse){
                vida -= ataqueRecibido - defensa
                dano = ataqueRecibido - defensa
            } else{
                vida -= ataqueRecibido
                dano = ataqueRecibido
            }

            Textojuego().recibirAtaque(nombre,dano)
        }

        override fun hacerAtaque():Float{
            Textojuego().hacerAtaque(nombre,dano + arma.dañoExtra())
            return dano + arma.dañoExtra()
        }

        override fun mostrarAparencia() {
            Textojuego().aparenciaZombie()
        }

        override fun haMatadoOHeMuerto() {
            TODO("Not yet implemented")
        }

    }
}