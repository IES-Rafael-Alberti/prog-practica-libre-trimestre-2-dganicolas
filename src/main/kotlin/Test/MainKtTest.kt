package Test

import org.junit.jupiter.api.Assertions.*
import org.practicatrim2.dividirEntreCien
import org.practicatrim2.redondear

class MainKtTest {

    @org.junit.jupiter.api.Test
    fun redondear() {
        assertEquals(10.234f.redondear(),10.23f)
        assertNotEquals(10.3453f.redondear(3),10.34f)
    }

    @org.junit.jupiter.api.Test
    fun dividirEntreCien() {
        assertEquals(10.234f.dividirEntreCien(),0.1f)
        assertNotEquals(10.3453f.dividirEntreCien(),10.34f)
    }
}