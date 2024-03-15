import consola.EntradasUsuario
import consola.TextoConsola


class RecibirTratamiento() { // clase terminada
    fun<T:Curarse> darTratamiento(persona:T, porcentaje:Int=100):Float{
        return persona.curar(porcentaje)

    }

    fun queTipoDeTratamiento(personaACurar:Player){
        TextoConsola.animacion()
        while (true){
            TextoConsola.mostrarTratamientos()
            val opciones = EntradasUsuario().opciones(3)
            if(opciones != 0){
                if (opciones == 1){ // se cura el solo, no gasta dinero
                    TextoConsola.curarVida(darTratamiento(personaACurar,(5..70).random()))
                    break
                }
                if (opciones == 2){ // recibe tratamiento, gasta dinero
                    val coste = personaACurar.medicoPreguntaPorTuCondicionFisica()
                    val dinero = personaACurar.medicoPreguntaPorTuDinero(coste)
                    if(dinero != null){
                        personaACurar.pagarAlmedico(coste)
                        TextoConsola.curarVida(darTratamiento(personaACurar,100))
                    }
                    break
                }
                if(opciones == 3){
                    TextoConsola.jugadorNoSeCura(personaACurar)
                    break
                }

        }}}}
