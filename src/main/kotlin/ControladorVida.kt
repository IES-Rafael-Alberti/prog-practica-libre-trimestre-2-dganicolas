class ControladorVida(){
     fun <T:Peleas>recibirAtaque(atacante:T,objetivo: T){
         val tipo =  atacante::class
         val lista = tipo.toString()
        atacante.recibirAtaque(objetivo.hacerAtaque())
    }

}