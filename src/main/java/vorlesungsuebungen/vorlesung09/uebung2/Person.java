/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung09.uebung2;

import java.util.Comparator;

/**
 * Eine Person mit einem Namen
 */
public class Person {
    /**
     * Name der Person.
     */
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        // Hier die anonyme innere Klasse schreiben.
        Comparator<Person> personComparator = null;

        Person mike = new Person("Mike");
        Person sue = new Person("Sue");
        System.out.println(personComparator.compare(mike, sue));
    }
}
