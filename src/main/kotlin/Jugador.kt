import org.practicatrim2.Armas
import org.practicatrim2.redondear

// este es el personaje principal, aqui llevara el puntuaje de exp, el multiplicador de daño
// el arma que lleva y el ratio de armadura que lleva
object Jugador :Peleas,curarse,transacciones{
    var nombre:String= "troy"
        private set
    var monedas: Float = 10f
        private set
    var nivel: Int = 1
            private set
    var dano:Float = 3f
            private set
    var vida: Float = 5f
            private set
    var vidaActual:Float = 10f
        private set
    var arma: Armas = Armas.Espada
        private set

    private var DEFENSA = 5


    override fun pagar(coste: Float) {
        monedas -= coste
    }

    override fun ingreso(coste: Float){
        monedas+= coste
    }

    override fun curar(){
        Textojuego().curarVida(nombre)
        vidaActual = vida
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

    override fun toString() = "El ${this.nombre} de nivel ${this.nivel}, su experiencia es ${this.monedas} y su arma es ${this.arma}, el daño es ${hacerAtaque()}"
}