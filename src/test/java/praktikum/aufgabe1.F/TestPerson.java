package praktikum.aufgabe1.F;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPerson {

  private final PersonListMap testMap = new PersonListMap();

  @Test
  void testEquals() {
    Person frodo = new Person("Frodo", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person frodo_gleich = new Person("Frodo", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person frodo2_vorname = new Person("falsch", "Beutlin",
      LocalDate.of(1009, 12, 3));
    Person frodo_geb = new Person("Frodo", "Beutlin",
      LocalDate.of(9999, 12, 3));
    Person frodo_nachname = new Person("Frodo", "falsch",
      LocalDate.of(9999, 12, 3));

    assertEquals(frodo, frodo_gleich);
    assertNotEquals(frodo,frodo2_vorname);
    assertNotEquals(frodo,frodo_nachname);
    assertNotEquals(frodo, frodo_geb);
  }
}