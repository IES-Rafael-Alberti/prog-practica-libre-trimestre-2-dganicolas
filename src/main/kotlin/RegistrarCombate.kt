class RegistrarCombate() {
    fun <T:Luchadores>combateRealizado(luchador:T,resultadoCombate: Boolean){
        if (resultadoCombate){
            when (luchador){
                is Luchadores.Zombie ->Partida.informePartidas.zombies ++
            }

        }
    }

}