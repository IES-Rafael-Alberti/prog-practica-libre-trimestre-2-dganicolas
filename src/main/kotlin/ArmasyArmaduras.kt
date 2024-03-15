/**

 * Interfaz que enfocada para objetos equipables o consumibles
 * con las siguientes funciones
 * fun nombre():String
 * esta funcion retorna el nombre del objeto
 * fun precio():Float
 * esta funcion retorna el precio que tendra el objeto
 * fun estadistica():Float
 * esta funcion retorna la estadistica que tendra el objeto
 *
 * @property nombre() es el nombre del objeto
 * @property precio() es el precio del objeto
 * @property estadistica() es la estadistica del objeto
 * ejemplo:
 * enum class Armaduras:EquipablesPrecioEstadisticas{
 *     ARMADURA_DE_ACHILLES {
 *         override fun nombre() = "Armadura de Achilles"
 *         override fun precio() = 2000.0f
 *         override fun estadistica() = 3.0f
 *     }
 * @author Nicolas De Gomar Almellones
 */
interface EquipablesPrecioEstadisticas{
    /**
     * es el nombre del objeto
     * @return el nombre del objeto
     * */
    fun nombre():String
    /**
     * es el precio del objeto
     * @return el precio del objeto
     * */
    fun precio():Float
    /**
     * es la estadistica del objeto
     * @return la estadistica del objeto
     * */
    fun estadistica():Float
}
/**

 * una enumeracion de clases en este caso de Armas
 * que implementa la interfaz EquipablesPrecioEstadisticas
 * las funciones de los objetos estan documentadas en la propia interfaz
 * @author Nicolas De Gomar Almellones
 */
enum class Armas: EquipablesPrecioEstadisticas {
    ESPADA_EXCALIBUR {
        override fun nombre() = "espada de Excalibur"
        override fun precio() = 1000.0f
        override fun estadistica() = 10.0f
    },
    ARCO_DE_LEGOLAS {
        override fun nombre() = "arco de Legolas"
        override fun precio() = 800.0f
        override fun estadistica() = 8.0f
    },
    ANILLO_UNICO {
        override fun nombre() = "anillo unico"
        override fun precio() = 3000.0f
        override fun estadistica() = 15.0f
    },
    VARITA_DE_SAUCO {
        override fun nombre() = "varita de Sauco"
        override fun precio() = 1500.0f
        override fun estadistica() = 12.0f
    },
    DAGA_DE_ALTAIR {
        override fun nombre() = "Daga de ALTÄIR"
        override fun precio() = 700.0f
        override fun estadistica() = 7.5f
    }
   }
/**

 * una enumeracion de clases en este caso de Armaduras
 * que implementa la interfaz EquipablesPrecioEstadisticas
 * las funciones de los objetos estan documentadas en la propia interfaz
 * @author Nicolas De Gomar Almellones
 */
enum class Armaduras: EquipablesPrecioEstadisticas {
    ARMADURA_DE_ACHILLES {
        override fun nombre() = "Armadura de Achilles"
        override fun precio() = 2000.0f
        override fun estadistica() = 3.0f
    },
    ARMADURA_DE_PLATINO {
        override fun nombre() = "armadura de platino"
        override fun precio() = 1500.0f
        override fun estadistica() = 2.0f
    },
    ARMADURA_DE_DRAGON {
        override fun nombre() = "armadura de dragon"
        override fun precio() = 3000.0f
        override fun estadistica() = 1f
    },
    ARMADURA_DE_MITHRIL {
        override fun nombre() = "armadura de Mithril"
        override fun precio() = 2500.0f
        override fun estadistica() = 4.0f
    },
    ARMADURA_DE_ADAMANTIO {
        override fun nombre() ="armadura de adamantio"
        override fun precio() = 3500.0f
        override fun estadistica() = 6.0f
    };
}
/**
 * una enumeracion de clases en este caso de Objetos
 * que implementa la interfaz EquipablesPrecioEstadisticas
 * las funciones de los objetos estan documentadas en la propia interfaz
 * @author Nicolas De Gomar Almellones
 */
enum class Objetos: EquipablesPrecioEstadisticas {
    INVESTIGARESPONDE_DE_ELOY {
        override fun nombre() = "Investigacion sobre el powershell"
        override fun precio() = 2500.0f
        override fun estadistica() = 15.0f
    },
    ESCUDO_DE_TOMAS {
        override fun nombre() = "Delete sin From"
        override fun precio() = 1500.0f
        override fun estadistica() = 12.0f
    },
    CODIGO_DE_DIEGO {
        override fun nombre() = "println(\"funcion lambda\")"
        override fun precio() = 1200.0f
        override fun estadistica() = 10.0f
    },
    APROBADO_DE_DIEGO {
        override fun nombre() = "5 puntos en prog"
        override fun precio() = 18000.0f
        override fun estadistica() = 14.0f
    },
    DAGA_DEL_SUSPENSO {
        override fun nombre() = "maldicion del programa"
        override fun precio() = 900.0f
        override fun estadistica() = 8.0f
    };
}