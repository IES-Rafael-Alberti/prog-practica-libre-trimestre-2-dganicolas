package org.practicatrim2

// el set de armas del jugador
// puede elegir entre espada, garra o lanza
// puedo crear una interfaz que tenga los trers metodos,
// si tiene una espada que ataque mas rapido o que como esta mas cerca que reciba mas daño que una lanza
enum class Armas{
    Puños,Espada,Hacha,Lanza;

    fun dañoExtra(): Int {
        return when (this){
            Puños -> 0
            Espada -> 5
            Hacha -> 10
            Lanza -> 15
        }
        
    }
}
enum class Armaduras{
    Puños,Espada,Hacha,Lanza;

    fun dañoExtra(): Int {
        return when (this){
            Puños -> 0
            Espada -> 5
            Hacha -> 10
            Lanza -> 15
        }

    }
}