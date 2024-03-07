import org.practicatrim2.Armas

class Zombie(nombre: String,monedas: Float,
             nivel: Int,dano: Float,
             vida: Float,
             vidaActual: Float,
             arma: Armas, var defensa: Float):Luchadores(nombre,monedas,nivel,dano,vida,vidaActual,arma),Peleas {
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
}