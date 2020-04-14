package praktikum.aufgabe1.F;

import java.util.ArrayList;
import java.util.List;

public class PersonListMap extends PM2Map<String, List<Person>> {

    PersonListMap() {
        super();
    }

    /**
     * Methode zum Einfügen von einer Person mit einer Kategorie in die Map
     * <p>
     * Ist die Kategorie noch nicht in der Map vorhanden, wird eine neue Liste
     * an Personen angelegt und die Person eingefügt. Wenn es die Kategorie
     * schon gibt, wird die Person in die schon bestehende Liste eingefügt.
     *
     * @param kategorie String
     * @param person    Person
     */
    public void einfuegen(String kategorie, Person person) {
        if (!containsKey(kategorie)) {
            List<Person> newList = new ArrayList<>();
            newList.add(person);
            put(kategorie, newList);
        } else {
            get(kategorie).add(person);
        }
    }
}
