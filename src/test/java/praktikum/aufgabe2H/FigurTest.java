package praktikum.aufgabe2H;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FigurTest {

  @Test
  void compareTo() {
    Figur figur1 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolf");
    Figur figur2 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Bruder");
    Figur figur3 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.WEIBLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Schwester");

    assertTrue(figur1.compareTo(figur2) < 0);
    assertTrue(figur1.compareTo(figur3) < 0);

    assertTrue(figur2.compareTo(figur1) > 0);
    assertTrue(figur2.compareTo(figur3) < 0);

    assertTrue(figur3.compareTo(figur1) > 0);
    assertTrue(figur3.compareTo(figur2) > 0);

  }
}