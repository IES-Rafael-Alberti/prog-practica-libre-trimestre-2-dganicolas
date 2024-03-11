package org.practicatrim2

interface EquipablesPrecioEstadisticas{
    fun nombre():String
    fun precio():Float
    fun estadistica():Float
}
// el set de armas del jugador
// puede elegir entre espada, garra o lanza
// puedo crear una interfaz que tenga los trers metodos,
// si tiene una espada que ataque mas rapido o que como esta mas cerca que reciba mas daño que una lanza
enum class Armas: EquipablesPrecioEstadisticas{
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
    DAGA_DE_ALTÄIR {
        override fun nombre() = "Daga de ALTÄIR"
        override fun precio() = 700.0f
        override fun estadistica() = 7.5f
    }
   }
enum class Armaduras:EquipablesPrecioEstadisticas{
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

enum class Objetos: EquipablesPrecioEstadisticas{
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