package praktikum.aufgabe1.F;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  private final PersonListMap testMap = new PersonListMap();

  @BeforeEach
  public void init() {
    Person Frodo = new Person("Frodo", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person Frodo1 = new Person("Frodo", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person Frodo2 = new Person("Frodolin", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person Frodo3 = new Person("Frodo", "Beutlin",
      LocalDate.of(1008, 12, 3));
    Person Merry = new Person("Meriadoc", "Brandybock",
      LocalDate.of(1382, 4, 24));
    testMap.einfuegen("Hobbit", Frodo);
    testMap.einfuegen("Hobbit", Merry);
    testMap.einfuegen("Hobbit", Frodo1);
    testMap.einfuegen("Hobbit", Frodo2);
    testMap.einfuegen("Hobbit", Frodo3);
  }


  @Test
  void testEquals() {
    assertFalse(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(1)));
    assertTrue(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(2)));
    assertFalse(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(3)));
    assertFalse(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(4)));
  }
}