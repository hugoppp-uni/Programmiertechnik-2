package praktikum.aufgabe1.F;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonListMapTest {

  private PersonListMap testMap = new PersonListMap();

  @Test
  void TestEinfuegen() {
    Person Frodo = new Person("Frodo", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person Legolas = new Person("Legolas", "Grünblatt",
      LocalDate.of(1000, 8, 1));
    Person Gandalf = new Person("Gandalf", "der Graue",
      LocalDate.of(1, 1, 1));
    Person Merry = new Person("Merry", "Brandybock",
      LocalDate.of(1382, 4, 24));
    Person Saruman = new Person("Saruman", "der Weiße",
      LocalDate.of(1, 1, 1));
    testMap.einfuegen("Hobbit", Frodo);
    testMap.einfuegen("Elf", Legolas);
    testMap.einfuegen("Zauberer", Gandalf);
    testMap.einfuegen("Hobbit", Merry);
    testMap.einfuegen("Zauberer", Saruman);
  }
}