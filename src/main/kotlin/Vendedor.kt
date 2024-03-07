import org.practicatrim2.ExperienciaRequeridaPorNivel
import org.practicatrim2.calcularExperiencia
import org.practicatrim2.redondear

// la clase padre de enemigos, jugador y cualquier entidad viviente
object Vendedor:Personajes("vendedor") {
    fun DormirHostal(nivel: Int) = nivel * 3
    fun dormirHostal(jugador: Jugador) {
        val costeNoche = DormirHostal(jugador.nivel)
        if (jugador.monedas > costeNoche) {
            jugador.monedas -= costeNoche
            jugador.vidaActual = jugador.vida
            println("Has dormido en el hostal NXDXG, coste de la noche: $costeNoche")
        }
    }
}



    /**
     * esta funcion, sirve para subir de nivel al jugador, y mejora el daño o vida del mismo
     * @param opcion es la opcion que se mejora, si es una opcion valida
     * @param jugador es el jugador que mejorara sus estadisticas y su nivel
     * @return retorna un mensaje avisando que accion se tomo
     *
    fun mejorarEstadistica():String {
        return when (opcion) {
            "vida" -> {
                this.nivel ++
                this.experiencia -= nivel
                this.vida += 2
                "tu vida aumenta en +2 PV, Tu nivel es ${this.nivel}."
            }
            "daño" -> {
                this.nivel ++
                this.experiencia -= experiencia
                this.dano += 1
                "Tu daño aumenta en +1 PA, Tu nivel es ${this.nivel}."
            }
            else -> {
                "No se realizó ninguna acción."
            }
        }
    }

    /**
     * esta funcion comprueba, si el usuario mete las opcion valida
     * @return retorna la opcion deseada o ninguna opcion en caso de meter mal la opcion
     * */
    fun comprobarOpcion():String{
        val opcion = readln().lowercase()
        if (opcion == "vida" || opcion == "1" || opcion =="v"){
            return "vida"
        }
        return if (opcion == "daño" || opcion == "2" || opcion =="d"){
            "daño"
        }else {
            ""
        }
    }

    /**
     *
     * pequeña funcion que recupera vida el jugador al dormir
     * @param jugador el jugador que va a dormir
     * */
    fun dormir(jugador: Jugador){
        if (this.vida > this.vidaActual + (this.vida *0.2f)){
            this.vidaActual += (this.vida *0.2f).redondear()
        }
        else{
            this.vidaActual = this.vida
        }
    }

    /**
     * esta funcion se encarga de la logistica de subir de nivel, daño o vida del player
     * @param jugador el jugador que subira sus estadisticas
     * @return retorna si ha podido subir sus estadisticas o en cambio no ha podido
     * */
    fun subirDenivel(jugador: Jugador, experiencia: Float): String{
        return if (this.experiencia > experiencia){

            println("¿Que quieres mejorar (1)vida o (2)daño?")

            val Opcion = comprobarOpcion()
            mejorarEstadistica(Opcion)
        }else {
            "experiencia insuficiente, Necesitas ${experiencia.calcularExperiencia(nivel.ExperienciaRequeridaPorNivel())} más."
        }
    }
}*/