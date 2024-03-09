import org.practicatrim2.Armas
import org.practicatrim2.estadisticas
import org.practicatrim2.redondear

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
sealed class Personas(val nombre: String, var vida: Float, var vidaActual: Float){

    class Jugador(nombre:String,var monedas:Float,var nivel: Int,var experiencia: Float,var dano:Float,vida: Float,vidaActual:Float,var arma:Armas,val inventario:MutableList<Objetos>) :
        Personas(nombre,vida,vidaActual),Peleas,curarse,Transacciones<Float>, Aparencia, levelear,registrarAccion,estadisticas{

        private var DEFENSA = 5


        override fun pagar(coste:Float):Float {
            monedas -= coste.redondear()
            return coste

        }

        override fun ingreso(coste:Float):Float{
            monedas+= coste.redondear()
            return coste
        }

        override fun curar(porcentajeQueSeVaACurar:Int){
            val porcentaje= porcentajeQueSeVaACurar.toFloat().redondear(-2)
            val recuperar = (vidaActual*porcentaje).redondear()
            if (recuperar+ vida<vidaActual){
                Textojuego().curarVida(nombre, recuperar)
                vida += recuperar
            }else {
                Textojuego().curarVida(nombre, vidaActual-vida)
                vida = vidaActual
            }

        }



    override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
        var dano = 0f
        if (defenderse){
            vida -= ataqueRecibido - DEFENSA
            dano = ataqueRecibido - DEFENSA
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
        Textojuego().aparenciaTroy()
    }

    override fun subirDeNivel() {
        val costePorSubirDeNivel = ComprobarSiTieneExpSuficiente(nivel.toFloat())
        if (experiencia > costePorSubirDeNivel){
            experiencia -= costePorSubirDeNivel
            nivel ++
            Textojuego().subirDeNivel(true)
        }else {
            Textojuego().subirDeNivel(false)
        }
    }

    override fun ComprobarSiTieneExpSuficiente(nivel: Float): Float = ((nivel/2) * 3.01f).redondear()
    override fun haMatadoOHeMuerto() {
        TODO("Not yet implemented")
    }

    override fun estadisticas(): List<String> = listOf("Jugador","nombre: ${this.nombre}","monedas: ${this.monedas}","Nivel: ${this.nivel}","Daño: ${this.dano}","Vida: ${this.vida}","${this.vida}","${this.arma}")
}

    class Vendedor(nombre:String,val monedas: Float,vida: Float,vidaActual: Float,val inventario:MutableList<Objetos>):Personas(nombre,vida,vidaActual): Intercambio  {
        override fun pagar(coste: Int): Float {
            TODO("Not yet implemented")
        }

        override fun ingreso(coste: Int): Float {
            TODO("Not yet implemented")
        }

        override fun darObjeto(destinatario: Any) {
            TODO("Not yet implemented")
        }


    }

    final class Zombie(nombre: String,var monedas: Float, var nivel: Int,var dano: Float, vida: Float, vidaActual: Float,var arma: Armas, var defensa: Float):
            Personas(nombre,vida,vidaActual),Peleas,curarse,Aparencia {
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

    class Arquero(nombre: String,monedas: Float, nivel: Int,dano: Float, vida: Float, vidaActual: Float,val arma: Armas, var defensa: Float):
        Personas(nombre,monedas,nivel,dano,vida,vidaActual,arma),Peleas,Aparencia {
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