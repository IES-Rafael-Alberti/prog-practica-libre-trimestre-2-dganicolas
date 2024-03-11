//esta clase se encarga de curar a personas
class RecibirTratamiento() { // clase terminada
    fun<T:Curarse> darTratamiento(persona:T, porcentaje:Int=100):Float{
        return persona.curar(porcentaje)

    }
    fun <T:Any>empezarTratamiento(persona:T){
        if (persona is Curarse &&
            persona is TransaccionesObjetos &&
            persona is TratamientoRecibido)
            queTipoDeTratamiento(persona)


    }
    fun <T> queTipoDeTratamiento(personaACurar:T):Float where T:TratamientoRecibido,T:Curarse, T:TransaccionesObjetos{

        while (true){
            TextoConsola.mostrarTratamientos()
            val opciones = EntradasUsuario().tresOpciones()
            if(opciones != 0){
                if (opciones == 1){ // se cura el solo, no gasta dinero
                    TextoConsola.curarVida(darTratamiento(personaACurar,(5..70).random()))
                }
                if (opciones == 2){ // recibe tratamiento, gasta dinero
                    val coste = personaACurar.medicoPreguntaPorTuCondicionFisica()
                    val dinero = personaACurar.medicoPreguntaPorTuDinero(coste)
                    if(dinero != null){
                        personaACurar.pagarAlmedico(coste)
                        TextoConsola.curarVida(darTratamiento(personaACurar,100))
                    }

                }
                if(opciones == 3){
                    return 0f
                }

        }}}}
