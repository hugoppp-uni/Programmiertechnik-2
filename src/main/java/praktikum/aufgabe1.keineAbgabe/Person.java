package praktikum.aufgabe1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class Person {
    final String lastName;
    final String firstName;
    final LocalDate birthday;

    public Person(String firstName, String lastName, int day, int month,
                  int year) {
        if (lastName == null || firstName == null) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = LocalDate.of(year,month,day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!lastName.equals(person.lastName)) return false;
        if (!firstName.equals(person.firstName)) return false;
        return birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return
          '\n' +
          "first name: \t" + firstName + '\n' +
          "last name: \t" + lastName + '\n' +
          "birthday: \t" + birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
          '\n';
    }

    public static void main(String[] args) {
        List<Person> listMenschen = new ArrayList<>();
        List<Person> listGot = new ArrayList<>();
        PM2Map<String,List<Person>> map = new PM2Map<>();

        listMenschen.add(new Person("max", "mueller", 1, 12, 2001));
        listMenschen.add(new Person("peter", "mueller", 2, 11, 2000));
        listMenschen.add(new Person("norbert", "mueller", 3, 10, 2000));
        listMenschen.add(new Person("heinz", "mueller", 4, 9, 1999));

        listGot.add(new Person("jon", "snow", 4, 9, 1999));
        listGot.add(new Person("dany", "targaryen", 4, 9, 1999));
        listGot.add(new Person("arya", "stark", 4, 9, 1999));
        listGot.add(new Person("sansa", "stark", 4, 9, 1999));
        listGot.add(new Person("tyrion", "lannister", 4, 9, 1999));
        listGot.add(new Person("hodor", "hodor", 4, 9, 1999));

        map.put("menschen", listMenschen);
        map.put("got", listGot);

        System.out.println(map);
    }
}
