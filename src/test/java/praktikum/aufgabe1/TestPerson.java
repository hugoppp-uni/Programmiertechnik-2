/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angwandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe1;

import org.junit.jupiter.api.Test;
import praktikum.loesung.aufgabe1.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPerson {

    @Test
    public void testEquals() {
        Person p1 = new Person("A", "B", LocalDate.of(2017, 10, 22));
        Person p1a = new Person("A", "B", LocalDate.of(2017, 10, 22));
        Person p2 = new Person("B", "C", LocalDate.of(2018, 2, 12));
        Person p2a = new Person("B", "C", LocalDate.of(2018, 2, 13));
        assertEquals(p1, p1a);
        assertEquals(p1a, p1);
        assertNotEquals(p1, p2);
        assertNotEquals(p2, p1);
        assertNotEquals(p1, null);
        assertNotEquals(p2, p2a);
        assertNotEquals(p2a, p2);
    }
}
