package es.iesmz.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CompteTest {
    @BeforeEach
    public void beforeEach() {
        System.out.println("EXECUTE PROVA");
    }

    // Tests del método compruebaIBAN()
    @Test
    public void testCompruebaIBAN1() {
        Compte compte = new Compte();
        assertTrue(compte.compruebaIBAN("ES6621000418401234567891"));
    }

    @Test
    public void testCompruebaIBAN2() {
        Compte compte = new Compte();
        assertTrue(compte.compruebaIBAN("ES6000491500051234567892"));
    }

    @Test
    public void testCompruebaIBAN3() {
        Compte compte = new Compte();
        assertTrue(compte.compruebaIBAN("ES9420805801101234567891"));
    }

    @Test
    public void testCompruebaIBAN4() {
        Compte compte = new Compte();
        assertFalse(compte.compruebaIBAN("ES7600246912501234567891"));
    }

    @Test
    public void testCompruebaIBAN5() {
        Compte compte = new Compte();
        assertFalse(compte.compruebaIBAN("ES4721000418401234567891"));
    }

    @Test
    public void testCompruebaIBAN6() {
        Compte compte = new Compte();
        assertFalse(compte.compruebaIBAN("ES8200491500051234567892"));
    }

    // Tests del método generaIBAN()
    @Test
    public void testGeneraIBAN1() {
        Compte compte = new Compte();
        assertEquals("ES7100302053091234567895", compte.generaIBAN("0030", "2053", "09", "1234567895"));
    }

    @Test
    public void testGeneraIBAN2() {
        Compte compte = new Compte();
        assertEquals("ES1000492352082414205416", compte.generaIBAN("0049", "2352", "08", "2414205416"));
    }

    @Test
    public void testGeneraIBAN3() {
        Compte compte = new Compte();
        assertEquals("ES1720852066623456789011", compte.generaIBAN("2085", "2066", "62", "3456789011"));
    }

    @Test
    public void testGeneraIBAN4() {
        Compte compte = new Compte();
        assertEquals(null, compte.generaIBAN("2085", "2066", "62", "3456AE9011"));
    }

    @Test
    public void testGeneraIBAN5() {
        Compte compte = new Compte();
        assertEquals(null, compte.generaIBAN("208", "2066", "62", "3456789011"));
    }

    @Test
    public void testGeneraIBAN6() {
        Compte compte = new Compte();
        assertEquals(null, compte.generaIBAN("2080", "20A6", "62", "3456789011"));
    }

    @Test
    public void testGeneraIBAN7() {
        Compte compte = new Compte();
        assertEquals(null, compte.generaIBAN("2080", "2086", "6", "3456789011"));
    }

    @Test
    public void testGeneraIBAN8() {
        Compte compte = new Compte();
        assertEquals(null, compte.generaIBAN("2080", "2086", "63", "345678911"));
    }
}
