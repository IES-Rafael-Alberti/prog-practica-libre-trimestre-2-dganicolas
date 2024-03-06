import org.practicatrim2.calcularExperiencia
import org.practicatrim2.redondear

/**
 * Interfaz Peleas 
 * la usa la clase Personajes
 * */
interface Peleas {
    fun atacar(): Float
    fun defensa(): Float
}

/**
 * Interfaz Estadisticas
 * la puede usar solo jugador
 *
 * Sirve para mejorar las estadisticas o recuperar la vida del jugador
 *
 * metodos:
 * fun mejorarEstadistica(opcion:String, jugador: Jugador,experiencia: Int)
 *              Su funcion es para mejorar la vida o el daño del jugador
 *
 * fun comprobarOpcion()
 *          comprueba si el usuario a tecleado la opcion correcta
 *
 * fun dormir(jugador: Jugador)
 *                  El jugador recupera vida al dormir
 *
 * fun subirDenivel(jugador: Jugador, experiencia: Int)
 *                  comprueba si el jugador tiene la experiencia suficiente para subir de nivel
 *
 * */
interface Estadisticas{

    /**
     * esta funcion, sirve para subir de nivel al jugador, y mejora el daño o vida del mismo
     * @param opcion es la opcion que se mejora, si es una opcion valida
     * @param jugador es el jugador que mejorara sus estadisticas y su nivel
     * @return retorna un mensaje avisando que accion se tomo
     * */
    fun mejorarEstadistica(opcion:String, jugador: Jugador,experiencia: Float):String {
        return when (opcion) {
            "vida" -> {
                jugador.nivel ++
                jugador.experiencia -= experiencia
                jugador.vida += 2
                "tu vida aumenta en +2 PV, Tu nivel es ${jugador.nivel}."
            }
            "daño" -> {
                jugador.nivel ++
                jugador.experiencia -= experiencia
                jugador.dano += 1
                "Tu daño aumenta en +1 PA, Tu nivel es ${jugador.nivel}."
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
        if (jugador.vida > jugador.vidaActual + (jugador.vida *0.2f)){
            jugador.vidaActual += (jugador.vida *0.2f).redondear()
        }
        else{
            jugador.vidaActual = jugador.vida
        }
    }

    /**
     * esta funcion se encarga de la logistica de subir de nivel, daño o vida del player
     * @param jugador el jugador que subira sus estadisticas
     * @return retorna si ha podido subir sus estadisticas o en cambio no ha podido
     * */
    fun subirDenivel(jugador: Jugador, experiencia: Float): String{
        return if (jugador.experiencia > experiencia){

            println("¿Que quieres mejorar (1)vida o (2)daño?")

            val Opcion = comprobarOpcion()
            mejorarEstadistica(Opcion,jugador,experiencia)
        }else {
            "experiencia insuficiente, Necesitas ${jugador.experiencia.calcularExperiencia(experiencia)} más."
        }
    }
}
