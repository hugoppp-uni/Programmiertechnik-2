package praktikum.aufgabe2FkeineAbgabe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerrDerRingeDatenTest {

    @Test
    void testFindFigur() {
        HerrDerRingeDaten h = new HerrDerRingeDaten();
        Figur figur = h.findFigur("Frodo Baggins", h.createListFiguren());
        assertEquals((figur.idProperty()), "5cd99d4bde30eff6ebccfc15");
    }
}