import org.practicatrim2.*

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho

    class Jugador
        (
        override val nombre: String,
        override var totalMonedas:Float,
        override var nivel: Int,
        override var experiencia: Float,
        var dano:Float,
        override var vida: Float,
        override var vidaActual:Float,
        var armadura : EquipablesPrecioEstadisticas,
        var arma:EquipablesPrecioEstadisticas,
        var inventario:MutableList<EquipablesPrecioEstadisticas>) :
        Estadisticas,
        Peleas,
        TratamientoRecibido,
        TransaccionesObjetos,
        MostrarDarObjeto,
        RecibirObjeto,
        SubirDeNivel,
        Curarse,
        EquiparEquipables,
        TransaccionesPeleas,
        MostrarDarEquipables
    {
        override fun pagarEquipable(coste:EquipablesPrecioEstadisticas):Float {
            val deuda = coste.precio()
            totalMonedas -= deuda
            return deuda
        }
        override fun ingresoEquipable(coste:EquipablesPrecioEstadisticas):Float{
            val deuda = coste.precio()
            totalMonedas+= deuda
            return deuda
        }

        override fun medicoPreguntaPorTuCondicionFisica(): Float {
            return (vidaActual - vida)*2
        }

        override fun pagarAlmedico(coste: Float): Float {
            totalMonedas -= coste
            return coste
        }

        override fun medicoPreguntaPorTuDinero(coste: Float):Float?{
            if(coste < totalMonedas){
                val curacion = vidaActual - vida
                return curacion
            }else {return null}
        }

        override fun curar(porcentajeQueSeVaACurar:Int):Float{
            val vidaPrevia =vida
            val porcentaje= porcentajeQueSeVaACurar.toFloat().redondear(-2)
            val recuperar = (vidaActual*porcentaje).redondear()
            if (recuperar+ vida<vidaActual){
                vida += recuperar
            }else {
                vida = vidaActual
            }
            return vida - vidaPrevia
        }



        override fun recibirAtaque(ataqueRecibido: Float):Float{
            vida -= ataqueRecibido - armadura.estadistica()
            return ataqueRecibido - armadura.estadistica()
        }

        override fun saberVida()= vida

        override fun hacerAtaque():Float{
            return dano + arma.estadistica()
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
        override fun recibirobjeto(objeto: Objetos): Objetos {
            inventario.add(objeto)
            return objeto
        }

        override fun mostrarObjetos() = inventario

        override fun darObjeto(objeto: EquipablesPrecioEstadisticas): EquipablesPrecioEstadisticas {
            inventario.remove(objeto)
            return objeto
        }

        override fun equiparArma(armaNueva: EquipablesPrecioEstadisticas?): EquipablesPrecioEstadisticas? {
            if (armaNueva != null && totalMonedas > armaNueva.precio()){
                this.arma=armaNueva
                return armaNueva
            }else{return null}

        }

        override fun equiparArmadura(armaduraNueva: EquipablesPrecioEstadisticas?): EquipablesPrecioEstadisticas? {
            if (armaduraNueva!= null && totalMonedas > armaduraNueva.precio()){
                this.armadura=armaduraNueva
                return armaduraNueva
            }else{return null}
        }

        override fun pagarPelea(coste: Float): Float {
            totalMonedas += coste
            return totalMonedas
        }

        override fun ingresoPelea(coste: Float): Float {
            totalMonedas += coste
            return totalMonedas
        }

        override fun mostrarArmaduras(): List<EquipablesPrecioEstadisticas> {
            TODO("Not yet implemented")
        }

        override fun darArma(nombreArma: EquipablesPrecioEstadisticas): EquipablesPrecioEstadisticas? {
            TODO("Not yet implemented")
        }

        override fun darArmadura(nombreArmadura: EquipablesPrecioEstadisticas): EquipablesPrecioEstadisticas? {
            TODO("Not yet implemented")
        }

        override fun mostrarArmas(): List<EquipablesPrecioEstadisticas> {
            TODO("Not yet implemented")
        }

    }

    class Vendedor
        (val nombre:String,
         var monedas: Float,
         var vida: Float,
         val vidaActual: Float,
         val dano: Float,
         val armas:List<EquipablesPrecioEstadisticas>,
         val armaduras:List<EquipablesPrecioEstadisticas>):
        Peleas,
        TransaccionesObjetos,
        MostrarDarEquipables,
        EquiparEquipables,
        MostrarDarObjeto

    {
        override fun pagarEquipable(coste:EquipablesPrecioEstadisticas):Float {
            val deuda = coste.precio()
            monedas -= deuda
            return deuda

        }

        override fun ingresoEquipable(coste:EquipablesPrecioEstadisticas):Float{
            val deuda = coste.precio()
            monedas+= deuda
            return deuda
        }

        override fun mostrarArmaduras(): List<EquipablesPrecioEstadisticas> {
            val listaArmadurasAleatoria= emptyList<EquipablesPrecioEstadisticas>()
            var armaduraAleatoria = armaduras.random()
            for (i in (0..5)){
                while(armaduraAleatoria in listaArmadurasAleatoria){
                    armaduraAleatoria = armaduras.random()
                }
                listaArmadurasAleatoria.addFirst(armaduraAleatoria)
            }
            return listaArmadurasAleatoria
        }

        override fun darArma(nombreArma: EquipablesPrecioEstadisticas) = armas.find { it.precio() == nombreArma.precio() }

        override fun darArmadura(nombreArmadura: EquipablesPrecioEstadisticas) = armaduras.find { it.precio() == nombreArmadura.precio() }

        override fun mostrarArmas(): List<EquipablesPrecioEstadisticas> {
            val listaArmasAleatoria= emptyList<EquipablesPrecioEstadisticas>()
            var armaAleatoria = armas.random()
            for (i in (0..5)){
                while(armaAleatoria in listaArmasAleatoria){
                    armaAleatoria = armas.random()
                }
                listaArmasAleatoria.addFirst(armaAleatoria)
            }
            return listaArmasAleatoria
        }

        override fun saberVida() = vida

        override fun hacerAtaque()= dano

        override fun recibirAtaque(ataqueRecibido: Float): Float {
            vida -= ataqueRecibido
            return ataqueRecibido
        }

        override fun mostrarObjetos(): List<EquipablesPrecioEstadisticas> {
            TODO("Not yet implemented")
        }

        override fun darObjeto(objeto: EquipablesPrecioEstadisticas): EquipablesPrecioEstadisticas? {
            TODO("Not yet implemented")
        }

        override fun equiparArma(armaNueva: EquipablesPrecioEstadisticas?): EquipablesPrecioEstadisticas? {
            TODO("Not yet implemented")
        }

        override fun equiparArmadura(armaduraNueva: EquipablesPrecioEstadisticas?): EquipablesPrecioEstadisticas? {
            TODO("Not yet implemented")
        }

    }

    abstract class Enemigos(
        open val nombre: String,
        open val nivel: Int,
        open var vida: Float,
        open val vidaActual: Float):
        Peleas
    class Zombie
        (override var nombre: String,
         val monedas: Float,
         nivel: Int,
         var dano: Float,
         override var vida: Float,
         override var vidaActual: Float,
         override var experiencia: Float,
         override var totalMonedas: Float):
        Enemigos(nombre,nivel,vida,vidaActual),
        Curarse,
        Estadisticas,
    TransaccionesPeleas{
        override fun saberVida()= vida

        override fun hacerAtaque()= dano

        override fun recibirAtaque(ataqueRecibido: Float): Float {
            val danoReal = ataqueRecibido
            vida -= danoReal
            return dano
        }

        override fun curar(porcentajeQueSeVaACurar: Int): Float {
            vida=vidaActual
            return vida
        }
        override fun pagarPelea(coste: Float): Float {
            return totalMonedas
        }

        override fun ingresoPelea(coste: Float): Float {
            totalMonedas += coste
            return coste
        }
    }

    class Arquero
        (override var nombre: String,
         override var nivel: Int,
         var dano: Float,
         override var vida: Float,
         override var vidaActual: Float,
         override var experiencia: Float,
         override var totalMonedas: Float
    ):
        Enemigos(nombre,nivel,vida,vidaActual),Curarse,
        Estadisticas,TransaccionesPeleas{
        override fun saberVida()= vida

        override fun hacerAtaque(): Float {
            val ataque=dano + dano * (1..20).random()
            return ataque
        }

        override fun recibirAtaque(ataqueRecibido: Float): Float {
            val defensa=ataqueRecibido
            vida -= defensa
            return defensa
        }

        override fun curar(porcentajeQueSeVaACurar: Int): Float {
            vida = vidaActual
            return vida
        }

        override fun pagarPelea(coste: Float): Float {
            return totalMonedas
        }

        override fun ingresoPelea(coste: Float): Float {
            totalMonedas += coste
            return coste
        }

    }
