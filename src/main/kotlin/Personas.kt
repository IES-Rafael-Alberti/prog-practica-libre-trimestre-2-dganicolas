import org.practicatrim2.*

// esta clase seran los ennemigos, segun el nivel del jugador, hara mas o menos daños
// o lo hare daño estatico, segun el mobs o entidad, hara un daño fijo
// de aqui saldra nuevas clases de especialidades, como zombies, arañas o cualquier bicho

    class Jugador
        (
        override val nombre: String,
        override var totalMonedas:Float,
        override var dano:Float,
        override var vida: Float,
        override var vidaActual:Float,
        override var armadura : EquipablesPrecioEstadisticas,
        override var arma:EquipablesPrecioEstadisticas,
        override var inventario:MutableList<EquipablesPrecioEstadisticas>) :
        Player
    {
        override fun pagar(coste:Float):Float {
            totalMonedas -= coste
            return coste
        }
        override fun ingreso(coste:Float):Float{
            totalMonedas+= coste
            return coste
        }

        override fun medicoPreguntaPorTuCondicionFisica(): Float {
            return (vidaActual - vida)*2
        }

        override fun pagarAlmedico(coste: Float): Float {
            totalMonedas -= coste
            return coste
        }

        override fun medicoPreguntaPorTuDinero(coste: Float):Float?{
            return if(coste < totalMonedas){
                val curacion = vidaActual - vida
                curacion
            }else {
                null
            }
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
            vida -= ataqueRecibido + armadura.estadistica()
            return ataqueRecibido + armadura.estadistica()
        }

        override fun saberVida()= vida

        override fun hacerAtaque():Float{
            return dano + arma.estadistica()
        }

    }

    class Vendedor
        (
        override val nombre: String,
        override var monedas: Float,
        override val armas: List<EquipablesPrecioEstadisticas>,
        override val armaduras: List<EquipablesPrecioEstadisticas>
    ):
        Seller

    {
        override fun pagar(coste: Float): Float {
            monedas += coste
            return coste
        }

        override fun ingreso(coste: Float): Float {
            monedas += coste
            return coste
        }

    }
    class Zombie
        (
        override val nombre: String,
        override var vida: Float,
        override val vidaActual: Float,
        override var objeto: EquipablesPrecioEstadisticas,
        override var totalMonedas: Float,
        override var dano: Float
    ):
        Enemigo{
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
        override fun pagar(coste: Float): Float {
            return totalMonedas
        }

        override fun ingreso(coste: Float): Float {
            totalMonedas += coste
            return coste
        }
    }

    class Arquero
        (
        override val nombre: String,
        override var vida: Float,
        override val vidaActual: Float,
        override var objeto: EquipablesPrecioEstadisticas,
        override var totalMonedas: Float,
        override var dano: Float
    ):
        Enemigo{
        override fun saberVida()= vida

        override fun hacerAtaque(): Float {
            val ataque=dano + dano * (1..20).random().toFloat().dividirEntreCien()
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

        override fun pagar(coste: Float): Float {
            return totalMonedas
        }

        override fun ingreso(coste: Float): Float {
            totalMonedas += coste
            return coste
        }

    }
