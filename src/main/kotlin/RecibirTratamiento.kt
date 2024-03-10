import org.practicatrim2.costeTratamiento

//esta clase se encarga de curar a personas
class RecibirTratamiento() {
    fun<T:curarse> darTratamiento(persona:T){
            persona.curar()
    }
}