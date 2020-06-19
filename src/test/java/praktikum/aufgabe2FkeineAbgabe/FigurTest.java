package praktikum.aufgabe2FkeineAbgabe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigurTest {

    @Test
    void testFromJson() {
        Figur f1 = Figur.fromJson(Helper.jObjErzeugenFigur(892));
        Figur f2 = new Figur("5cd99d4bde30eff6ebccfc15", 1.06f,
          Typ.HOBBIT, Geschlecht.MAENNLICH, "22 September ,TA 2968",
          null, "Unknown (Last sighting ,September 29 ,3021,) " +
          "(,SR 1421,)", "Brown", "Frodo Baggins");
        assertEquals(0, f1.nameProperty().compareTo(f2.nameProperty()));
    }

    @Test
    void testCompareTo() {
        Figur f1 = Figur.fromJson(Helper.jObjErzeugenFigur(892));
        Figur f2 = Figur.fromJson(Helper.jObjErzeugenFigur(892));
        assertEquals(0, f1.compareTo(f2));
        Figur f3 = Figur.fromJson(Helper.jObjErzeugenFigur(893));
        assertNotEquals(0, f1.compareTo(f3));
        assertThrows(NullPointerException.class, () -> f1.compareTo(null));
    }

    @Test
    void testIterator() {

    }
}