import org.practicatrim2.Armaduras
import org.practicatrim2.Armas
import org.practicatrim2.Objetos
import org.practicatrim2.redondear

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho
sealed class Personas<out T>(val nombre: String, var vida: Float, var vidaActual: Float){

    class Jugador(nombre:String,var monedas:Float,var nivel: Int,var experiencia: Float,var dano:Float,vida: Float,vidaActual:Float,var armadura : Armaduras,var arma:Armas,val inventario:MutableList<Objetos>) :
        Personas(nombre,vida,vidaActual),Peleas,TratamientoRecibido,Transacciones,MostrarDarObjeto,RecibirObjeto, SubirDeNivel,EquiparEquipables{

        private var DEFENSA = 5


        override fun pagar(coste:Float):Float {
            monedas -= coste.redondear()
            return coste

        }

        override fun ingreso(coste:Float):Float{
            monedas+= coste.redondear()
            return coste
        }

        override fun medicoPreguntaPorTuCondicionFisica(): Float {
            return (vidaActual - vida)*2
        }

        override fun medicoPreguntaPorTuDinero(coste: Float):Float?{
            if(coste < monedas){
                val curacion = vidaActual - vida
                return curacion
            }else {return null}
        }

        override fun curar(porcentajeQueSeVaACurar:Int):Float{
            val vidaPrevia =vida
            val porcentaje= porcentajeQueSeVaACurar.toFloat().redondear(-2)
            val recuperar = (vidaActual*porcentaje).redondear()
            if (recuperar+ vida<vidaActual){
                Textojuego().curarVida(nombre, recuperar)
                vida += recuperar
            }else {
                Textojuego().curarVida(nombre, vidaActual-vida)
                vida = vidaActual
            }
            return vida - vidaPrevia
        }



    override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
        var dano = 0f
        if (defenderse){
            vida -= ataqueRecibido - DEFENSA
            dano = ataqueRecibido - DEFENSA
        } else{
            vida -= ataqueRecibido
            dano = ataqueRecibido
        }

        Textojuego().recibirAtaque(nombre,dano)
    }

    override fun hacerAtaque():Float{
        Textojuego().hacerAtaque(nombre,dano + arma.dañoExtra())
        return dano + arma.dañoExtra()
    }

    override fun subirDeNivel(): Int? {
        val costePorSubirDeNivel = ComprobarSiTieneExpSuficiente(nivel.toFloat())
        return if (experiencia > costePorSubirDeNivel){
            experiencia -= costePorSubirDeNivel
            nivel ++
        }else {
            null
        }
    }
    override fun ComprobarSiTieneExpSuficiente(nivel: Float): Float = ((nivel/2) * 3.01f).redondear()
        override fun comprobarObjetos(nombreObjetos: String): Objetos? {
            val objeto = inventario.find { it.nombre == nombreObjetos }
            if (objeto != null){
                return darObjeto(objeto)
            }else{
                return objeto
            }

        }

        override fun recibirobjeto(objeto: Objetos): Objetos {
            inventario.add(objeto)
            return objeto
        }

        override fun mostrarObjetos(): Map<String, Objetos> {
            val listaObjetos= mutableMapOf<String, Objetos>()
            inventario.forEach{ listaObjetos["Objeto: ${it.name} Precio: ${it.precio}"] = it}
            return listaObjetos
        }

        override fun darObjeto(objeto: Objetos): Objetos {
            inventario.remove(objeto)
            return objeto
        }

        override fun equiparArma(arma: Armas) {
            this.arma= arma
        }

        override fun equiparArmadura(armadura: Armaduras) {
            this.armadura=armadura
        }

    }

    class Vendedor(nombre:String,var monedas: Float,vida: Float,vidaActual: Float,val Armas:List<Armas>,val armaduras:List<Armaduras>):Personas(nombre,vida,vidaActual),Transacciones,MostrarDarEquipables{
        override fun pagar(coste:Float):Float {
            monedas -= coste.redondear()
            return coste

        }

        override fun ingreso(coste:Float):Float{
            monedas+= coste.redondear()
            return coste
        }

        override fun mostrarArmaduras(): List<Armaduras> {
            val listaArmadurasAleatoria= emptyList<Armaduras>()
            var armaduraAleatoria = armaduras.random()
            for (i in (0..5)){
                while(armaduraAleatoria in listaArmadurasAleatoria){
                    armaduraAleatoria = armaduras.random()
                }
                listaArmadurasAleatoria.addFirst()
            }
            return listaArmadurasAleatoria
        }

        override fun darArma(arma: Armas): Armas {
            TODO("Not yet implemented")
        }

        override fun darArmadura(armadura: Armaduras): Armaduras {
            TODO("Not yet implemented")
        }

        override fun mostrarArmas(): List<Armas> {
            TODO("Not yet implemented")
        }

    }

    final class Zombie(nombre: String,var monedas: Float, var nivel: Int,var dano: Float, vida: Float, vidaActual: Float,var arma: Armas, var defensa: Float):
            Personas(nombre,vida,vidaActual),Peleas,TratamientoRecibido,Aparencia {
        override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
            var dano = 0f
            if (defenderse){
                vida -= ataqueRecibido - defensa
                dano = ataqueRecibido - defensa
            } else{
                vida -= ataqueRecibido
                dano = ataqueRecibido
            }

            Textojuego().recibirAtaque(nombre,dano)
        }

        override fun hacerAtaque():Float{
            Textojuego().hacerAtaque(nombre,dano + arma.dañoExtra())
            return dano + arma.dañoExtra()
        }

        override fun mostrarAparencia() {
            Textojuego().aparenciaZombie()
        }

        override fun estadisticas() = listOf(this.nombre,"nombre: ${this.nombre}","monedas: ${this.monedas}","Nivel: ${this.nivel}","Daño: ${this.dano}","Vida: ${this.vida}","${this.vida}","${this.arma}")

        override fun haMatadoOHeMuerto() {
            TODO("Not yet implemented")
        }

        override fun curar(porcentajeQueSeVaACurar: Int) {
            vida = vidaActual
        }
    }

    class Arquero(nombre: String,monedas: Float, nivel: Int,dano: Float, vida: Float, vidaActual: Float,val arma: Armas, var defensa: Float):
        Personas(nombre,monedas,nivel,dano,vida,vidaActual,arma),Peleas,Aparencia {
        override fun recibirAtaque(ataqueRecibido: Float,defenderse:Boolean){
            var dano = 0f
            if (defenderse){
                vida -= ataqueRecibido - defensa
                dano = ataqueRecibido - defensa
            } else{
                vida -= ataqueRecibido
                dano = ataqueRecibido
            }

            Textojuego().recibirAtaque(nombre,dano)
        }

        override fun hacerAtaque():Float{
            Textojuego().hacerAtaque(nombre,dano + arma.dañoExtra())
            return dano + arma.dañoExtra()
        }

        override fun mostrarAparencia() {
            Textojuego().aparenciaZombie()
        }

        override fun haMatadoOHeMuerto() {
            TODO("Not yet implemented")
        }

    }
}