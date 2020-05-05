package praktikum.aufgabe2H;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
class FigurTest {
  Figur figur1 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
      "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolf");
  Figur figur2 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
      "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Bruder");
  Figur figur3 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.WEIBLICH, "morgen",
      "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Schwester");
  Figur figur3copy = new Figur("a", 1.0f, Typ.ELB, Geschlecht.WEIBLICH, "morgen",
      "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Schwester");


  @Test
  void testCompareTo() {

    assertTrue(figur1.compareTo(figur2) < 0);
    assertTrue(figur1.compareTo(figur3) < 0);

    assertTrue(figur2.compareTo(figur1) > 0);
    assertTrue(figur2.compareTo(figur3) < 0);

    assertTrue(figur3.compareTo(figur1) > 0);
    assertTrue(figur3.compareTo(figur2) > 0);

    assertEquals(0,figur3.compareTo(figur3copy));

    assertThrows(NullPointerException.class, () -> figur3.compareTo(null));
  }

  @Test
  void testIteratorShouldIterateOver9Items(){
    int i = 0;
    for (String ignored : figur1) {
      i++;
    }
    assertEquals(i, 9);
  }

}