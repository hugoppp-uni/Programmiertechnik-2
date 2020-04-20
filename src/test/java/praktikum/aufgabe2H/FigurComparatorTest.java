package praktikum.aufgabe2H;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FigurComparatorTest {

  @Test
  void compare() {
    Figur figur1 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolf");
    Figur figur2 = new Figur("a", 1.0f, Typ.ELB, Geschlecht.MAENNLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Bruder");
    Figur figur3 = new Figur("a", 0.1f, Typ.ELB, Geschlecht.WEIBLICH, "morgen",
        "rechte Hand", "uebermorgen", "glänzende Glatze", "Rudolfs Schwester");
    FigurComparator comparator = new FigurComparator();
    assertEquals(0, comparator.compare(figur1, figur2));
    assertTrue(comparator.compare(figur1, figur3) > 0);
    assertTrue(comparator.compare(figur3, figur1) < 0);
  }

}