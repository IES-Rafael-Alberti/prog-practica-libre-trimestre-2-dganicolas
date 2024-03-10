import org.practicatrim2.costeTratamiento

//esta clase se encarga de curar a personas
class RecibirTratamiento() { // clase terminada
    fun<T:TratamientoRecibido> darTratamiento(persona:T, porcentaje:Int=100):Float{
        return persona.curar(porcentaje)

    }
    fun <T> queTipoDeTratamiento(personaACurar:T):Float where T:Personas<T>, T:TratamientoRecibido, T:Transacciones{

        while (true){
            val opciones = EntradasUsuario().tresOpciones()
            Textojuego().mostrarTratamientos()
            if(opciones != 0){
                if (opciones == 1){ // se cura el solo, no gasta dinero
                    return darTratamiento(personaACurar,(5..70).random())
                }
                if (opciones == 2){ // recibe tratamiento, gasta dinero
                    val coste = personaACurar.medicoPreguntaPorTuCondicionFisica()
                    val dinero = personaACurar.medicoPreguntaPorTuDinero(coste)
                    if(dinero != null){
                        personaACurar.pagar(coste)
                        return darTratamiento(personaACurar,100)

                    }
                    return 0f
                }
                if(opciones == 3){
                    return 0f
                }

        }}}}
