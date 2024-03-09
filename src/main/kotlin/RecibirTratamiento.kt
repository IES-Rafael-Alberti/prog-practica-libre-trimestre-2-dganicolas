import org.practicatrim2.costeTratamiento

//esta clase se encarga de curar a personas
class RecibirTratamiento() { // clase terminada
    fun<T> darTratamiento(persona:T, porcentaje:Int=100){
        if(persona is curarse){
            persona.curar(porcentaje)
        }
    }
    fun <T:Personas>queTipoDeTratamiento(personaACurar:T){

        while (true){
            val opciones = EntradasUsuario().tresOpciones()
            Textojuego().mostrarTratamientos()
            if(opciones != 0){
                if (opciones == 1){ // se cura el solo, no gasta dinero
                    darTratamiento(personaACurar,(5..70).random())
                    break
                }
                if (opciones == 2){ // recibe tratamiento, gasta dinero
                    when (personaACurar){

                        is Personas.Jugador ->{
                            val coste = personaACurar.nivel.costeTratamiento()
                            if(personaACurar.monedas > coste){
                                darTratamiento(personaACurar,100)
                                personaACurar.pagar(coste)
                                Textojuego().recibeTratamiento(personaACurar.nombre,coste)
                            }else{
                                Textojuego().noRecibeTratamiento(coste,personaACurar.monedas)
                            }

                        }
                        else -> darTratamiento(personaACurar,100)
                    }
                    break
                }
                if(opciones == 3){
                    Textojuego().noRealizarNingunaAccion(personaACurar.nombre)
                    break
                }
            }

        }
    }
}