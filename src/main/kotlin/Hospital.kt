import consola.EntradasUsuario
import consola.TextoConsola

/**
 * esta es la clase Hospital
 * revisa si el jugador se cura mediante un medico o si el jugador se cura solo por su cuenta
 * */
class Hospital() { // clase terminada
    /**
     * esta es la funcion donde se cura a una entidad
     * donde es una funcion generica
     * @param persona es la persona a curar que debe de implementar la interfaz curarse
     * @param porcentaje es el porcentaje de vida que se va a curar por defecto es un 100
     * @return numero de puntos de vida que ha recuperado la entidad
     * */
    fun<T:Curarse> darTratamiento(persona:T, porcentaje:Int=100):Float{
        return persona.curar(porcentaje)

    }
    /**
     * aqui elijo si el jugador elige recuperarse el mismo un porcentaje de vida aleatorio
     * o si en cambio el jugador decide de ir al doctor
     *
     * @param personaACurar es la persona a curar que debe de implementar la interfaz curarse
     * @author Nicolas De Gomar
     * */
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
