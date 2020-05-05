package praktikum.aufgabe2H;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JSONReaderTest {
  @Test
  void testGenerateFromJSON() {
    Figur testFigur0 = new Figur(
        "testSubject0",
        1.11f,
        Typ.MENSCH,
        Geschlecht.MAENNLICH,
        "heute",
        "Unnamed wife",
        "morgen",
        "keins",
        "Test Subject 0"
    );
    Figur testFigur1 = new Figur(
        "testSubject1",
        1.12f,
        Typ.MENSCH,
        Geschlecht.MAENNLICH,
        "heute",
        "Unnamed wife",
        "morgen",
        "keins",
        "Test Subject 1"
    );
    Figur testFigurLeer = new Figur(
        "testSubjectLeer",
        0f,
        Typ.UNDEFINED,
        Geschlecht.UNDEFINED,
        "",
        "",
        "",
        "",
        ""
    );

    List<Figur> figuren = Figur.generateFromJson("./src/main/resources/test/figuren.json");
    assertEquals(4, figuren.size());
    assertTrue(allFieldsOfFigureAreEquals(testFigur0, figuren.get(0)));
    assertTrue(allFieldsOfFigureAreEquals(testFigur1, figuren.get(1)));

    assertFalse(allFieldsOfFigureAreEquals(testFigur0, figuren.get(1)));
    assertFalse(allFieldsOfFigureAreEquals(testFigur1, figuren.get(0)));

    assertTrue(allFieldsOfFigureAreEquals(testFigurLeer, figuren.get(2)));
    assertTrue(allFieldsOfFigureAreEquals(testFigurLeer, figuren.get(3)));
  }

  private boolean allFieldsOfFigureAreEquals(Figur testFigur, Figur listFigur) {
    Iterator<String> testFigurIter = testFigur.iterator();
    Iterator<String> listFigurIter = listFigur.iterator();
    while (listFigurIter.hasNext() || testFigurIter.hasNext()) {
      if ((!listFigurIter.next().equals(testFigurIter.next()))) {
        return false;
      }
    }
    return true;
  }
}
