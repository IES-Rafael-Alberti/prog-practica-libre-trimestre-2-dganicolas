class ManejoVida() {
    fun<T> curar(persona:T,porcentaje:Int=100){
        if(persona is curarse){
            persona.curar(porcentaje)
        }
    }
}