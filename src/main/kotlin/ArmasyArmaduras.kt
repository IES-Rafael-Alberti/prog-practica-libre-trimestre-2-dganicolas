package org.practicatrim2

interface ValoresEquipables{
    fun precio():Float
    fun estadistica():Float
}
// el set de armas del jugador
// puede elegir entre espada, garra o lanza
// puedo crear una interfaz que tenga los trers metodos,
// si tiene una espada que ataque mas rapido o que como esta mas cerca que reciba mas daño que una lanza
enum class Armas: ValoresEquipables{
    ESPADA_EXCALIBUR {
        override fun precio() = 1000.0f
        override fun estadistica() = 10.0f
    },
    ARCO_DE_LEGOLAS {
        override fun precio() = 800.0f
        override fun estadistica() = 8.0f
    },
    ANILLO_UNICO {
        override fun precio() = 3000.0f
        override fun estadistica() = 15.0f
    },
    VARITA_DE_SAUCO {
        override fun precio() = 1500.0f
        override fun estadistica() = 12.0f
    },
    DAGA_DE_ALTÄIR {
        override fun precio() = 700.0f
        override fun estadistica() = 7.5f
    },
    MARTILLO_DE_THOR {
        override fun precio() = 2200.0f
        override fun estadistica() = 15.0f
    },
    TRIDENTE_DE_POSEIDON {
        override fun precio() = 1800.0f
        override fun estadistica() = 13.0f
    },
    BASTON_DE_GANDALF {
        override fun precio() = 1300.0f
        override fun estadistica() = 11.0f
    },
    GEMA_DEL_INFINITO {
        override fun precio() = 5000.0f
        override fun estadistica() = 20.0f
    },
    ARMADURA_DE_ACHILLES {
        override fun precio() = 2000.0f
        override fun estadistica() = 14.0f
    },
    ESCUDO_DE_AJAX {
        override fun precio() = 900.0f
        override fun estadistica() = 7.0f
    },
    YELMO_DE_HADES {
        override fun precio() = 850.0f
        override fun estadistica() = 6.5f
    },
    CAPA_DE_INVISIBILIDAD {
        override fun precio() = 1200.0f
        override fun estadistica() = 9.0f
    },
    CORONA_DE_ARTURIA {
        override fun precio() = 1600.0f
        override fun estadistica() = 12.5f
    },
    BOTAS_DE_HERMES {
        override fun precio() = 600.0f
        override fun estadistica() = 6.0f
    },
    FLECHA_DE_EROS {
        override fun precio() = 50.0f
        override fun estadistica() = 2.5f
    },
    CUERNO_DE_GUNGNIR {
        override fun precio() = 2100.0f
        override fun estadistica() = 14.5f
    },
    CADENA_DE_ANDROMEDA {
        override fun precio() = 1100.0f
        override fun estadistica() = 10.5f
    },
    ESPEJO_DE_GALADRIEL {
        override fun precio() = 1400.0f
        override fun estadistica() = 11.5f
    },
    PIEDRA_FILOSOFAL {
        override fun precio() = 4000.0f
        override fun estadistica() = 18.0f
    };
}
enum class Armaduras:ValoresEquipables{
    ARMADURA_DE_ACHILLES {
        override fun precio() = 2000.0f
        override fun estadistica() = 14.0f
    },
    ARMADURA_DE_PLATINO {
        override fun precio() = 1500.0f
        override fun estadistica() = 12.0f
    },
    ARMADURA_DE_DRAGON {
        override fun precio() = 3000.0f
        override fun estadistica() = 15.0f
    },
    ARMADURA_DE_MITHRIL {
        override fun precio() = 2500.0f
        override fun estadistica() = 13.0f
    },
    ARMADURA_DE_ADAMANTIO {
        override fun precio() = 3500.0f
        override fun estadistica() = 16.0f
    },
    ARMADURA_DE_ORO {
        override fun precio() = 1000.0f
        override fun estadistica() = 10.0f
    },
    ARMADURA_DE_HIERRO {
        override fun precio() = 500.0f
        override fun estadistica() = 7.0f
    },
    ARMADURA_DE_CUERO {
        override fun precio() = 300.0f
        override fun estadistica() = 5.0f
    },
    ARMADURA_DE_SILICIO {
        override fun precio() = 1200.0f
        override fun estadistica() = 9.0f
    },
    ARMADURA_DE_CRISTAL {
        override fun precio() = 800.0f
        override fun estadistica() = 8.0f
    },
    ARMADURA_DE_OBSIDIANA {
        override fun precio() = 1600.0f
        override fun estadistica() = 11.0f
    },
    ARMADURA_DE_ESMERALDA {
        override fun precio() = 1800.0f
        override fun estadistica() = 12.0f
    },
    ARMADURA_DE_RUBI {
        override fun precio() = 2000.0f
        override fun estadistica() = 13.0f
    },
    ARMADURA_DE_ZAFIRO {
        override fun precio() = 2200.0f
        override fun estadistica() = 14.0f
    },
    ARMADURA_DE_DIAMANTE {
        override fun precio() = 2400.0f
        override fun estadistica() = 15.0f
    },
    ARMADURA_DE_BRONCE {
        override fun precio() = 400.0f
        override fun estadistica() = 6.0f
    },
    ARMADURA_DE_PLATA {
        override fun precio() = 600.0f
        override fun estadistica() = 7.0f
    },
    ARMADURA_DE_EBANO {
        override fun precio() = 1400.0f
        override fun estadistica() = 10.0f
    },
    ARMADURA_DE_MARMOL {
        override fun precio() = 1000.0f
        override fun estadistica() = 9.0f
    },
    ARMADURA_DE_GRANITO {
        override fun precio() = 1200.0f
        override fun estadistica() = 10.0f
    };
}

enum class Objetos(val precio:Float){
    COLLAR_DE_PERLAS(500.0f),
    ANILLO_DE_ZAFIRO(800.0f),
    GEMA_DE_RUBI(1200.0f),
    MEDALLON_DE_PLATA(300.0f),
    AMULETO_DE_ORO(700.0f),
    PENDIENTE_DE_DIAMANTE(2000.0f),
    CORONA_DE_ESMERALDA(2500.0f),
    TIARA_DE_PLATINO(1500.0f),
    BRAZALETE_DE_BRONCE(400.0f),
    PULSERA_DE_PLATA(600.0f),
    RELOJ_DE_ORO(1000.0f),
    CADENA_DE_PLATINO(1200.0f),
    ANILLO_DE_PLATA(200.0f),
    ANILLO_DE_ORO(500.0f),
    ANILLO_DE_PLATINO(800.0f),
    COLLAR_DE_DIAMANTE(2500.0f),
    PENDIENTE_DE_ESMERALDA(2200.0f),
    PULSERA_DE_RUBI(1800.0f),
    RELOJ_DE_ZAFIRO(2000.0f),
    CADENA_DE_MITHRIL(3000.0f);
}