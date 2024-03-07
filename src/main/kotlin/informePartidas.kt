package org.practicatrim2
//esta clase es una data class
// donde lleva el conteo de, veces en peleas
//monstruos matados, ETC
data class informePartidas(val Nombre:String, var Nivel: Int, var Vida: Float,var vidaActual:Float, var Experiencia: Float) {
    var acciones = mutableListOf<String>()
    var zombies = 0
    var arañas = 0
    var esqueletos = 0
}