package org.practicatrim2

import Jugador

// el set de armas del jugador
// puede elegir entre espada, garra o lanza
// puedo crear una interfaz que tenga los trers metodos,
// si tiene una espada que ataque mas rapido o que como esta mas cerca que reciba mas daño que una lanza
enum class Armas{
    Puños,Espada,Hacha,Lanza;

    fun dañoExtra(): Int {
        return when (this){
            Puños -> 2
            Espada -> 5
            Hacha -> 10
            Lanza -> 15
        }
        
    }
}