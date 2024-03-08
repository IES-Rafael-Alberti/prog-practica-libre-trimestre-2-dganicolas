import org.practicatrim2.Armas
import org.practicatrim2.estadisticas
import org.practicatrim2.redondear

// este es el personaje principal, aqui llevara el puntuaje de exp, el multiplicador de daño
// el arma que lleva y el ratio de armadura que lleva
object Jugador :Peleas,curarse,transacciones<Float>, aparencia, levelear,registrarAccion,estadisticas{
    var nombre:String= "troy"
        private set
    var monedas: Float = 10f
        private set
    var nivel: Int = 1
            private set
    var experiencia: Float = 0f
            private set
    var dano:Float = 3f
            private set
    var vida: Float = 5f
            private set
    var vidaActual:Float = 50f
        private set
    var arma: Armas = Armas.Espada
        private set

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
        when (porcentajeQueSeVaACurar){
            in 0..100 -> {

                if (recuperar+ vida<vidaActual){
                    Textojuego().curarVida(nombre, recuperar)
                    Textojuego().aparenciaTroy()
                    vida += recuperar
                }else {
                    Textojuego().curarVida(nombre, vidaActual-vida)
                    Textojuego().aparenciaTroy()
                    vida = vidaActual
                }
            }
        }

        Textojuego().enterparacontinuar()

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