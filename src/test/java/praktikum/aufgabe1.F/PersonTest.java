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
    Person Legolas = new Person("Legolas", "Grünblatt",
      LocalDate.of(1000, 8, 1));
    Person Gandalf = new Person("Gandalf", "der Graue",
      LocalDate.of(1, 1, 1));
    Person Merry = new Person("Meriadoc", "Brandybock",
      LocalDate.of(1382, 4, 24));
    Person Saruman = new Person("Saruman", "der Weiße",
      LocalDate.of(1, 1, 1));
    testMap.einfuegen("Hobbit", Frodo);
    testMap.einfuegen("Elf", Legolas);
    testMap.einfuegen("Zauberer", Gandalf);
    testMap.einfuegen("Hobbit", Merry);
    testMap.einfuegen("Zauberer", Saruman);
    testMap.einfuegen("Hobbit", Frodo);
  }


  @Test
  void testEquals() {
    assertFalse(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(1)));
    assertTrue(testMap.get("Hobbit").get(0).equals(testMap.get("Hobbit").get(2)));
  }

  @Test
  void testHashCode() {

  }
}