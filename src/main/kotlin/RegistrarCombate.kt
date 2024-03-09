class RegistrarCombate() {
    fun <T:Personas>combateRealizado(luchador:T, resultadoCombate: Boolean){
        if (resultadoCombate){
            when (luchador){
                is Personas.Zombie ->Partida.informePartidas.zombies ++
            }

        }
    }

}