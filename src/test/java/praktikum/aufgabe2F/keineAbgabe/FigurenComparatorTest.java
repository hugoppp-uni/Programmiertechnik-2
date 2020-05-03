package praktikum.aufgabe2F.keineAbgabe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigurenComparatorTest {

    @Test
    void testCompare() {
        Figur f1 = Figur.fromJson(Helper.jObjErzeugenFigur(892));
        Figur f2 = new Figur(null, 1.06f, null, null,
          null, null, null, null, null);
        FigurenComparator f = new FigurenComparator();
        assertEquals(0, f.compare(f1, f2));
        Figur f3 = Figur.fromJson(Helper.jObjErzeugenFigur(895));
        assertEquals(-1, f.compare(f2, f3));
        assertEquals(1, f.compare(f3, f2));
    }
}