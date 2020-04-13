package praktikum.aufgabe1.F;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonListMap {

    private final PersonListMap testMap = new PersonListMap();

    @Test
    void TestEinfuegen() {
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
        List<Person> h1List = new ArrayList<>(Collections.singletonList(Frodo));
        assertEquals(h1List, testMap.get("Hobbit"));
        testMap.einfuegen("Elf", Legolas);
        testMap.einfuegen("Zauberer", Gandalf);
        testMap.einfuegen("Hobbit", Merry);
        testMap.einfuegen("Zauberer", Saruman);
        List<Person> h2List = new ArrayList<>(Arrays.asList(Frodo, Merry));
        assertEquals(h2List, testMap.get("Hobbit"));
    }
}