package praktikum.aufgabe1.F;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Person {
  private String vorname;
  private String nachname;
  private LocalDate geburtsdatum;

  public Person(String vorname, String nachname, LocalDate geburtsdatum){
    this.vorname = vorname;
    this.nachname = nachname;
    this.geburtsdatum = geburtsdatum;
  }

  public Person(String firstName, String lastName, int day, int month,
                int year) {
    if (lastName == null || firstName == null) {
      throw new IllegalArgumentException("Parameters can't be null");
    }
    this.vorname = lastName;
    this.nachname = firstName;
    this.geburtsdatum = LocalDate.of(year,month,day);
  }

  void einfuegen1(String kategorie, Person person){
    Map<String, List<Person>> m = new PM2Map<>();
    if(m.containsKey(kategorie)){
      
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return Objects.equals(vorname, person.vorname) &&
      Objects.equals(nachname, person.nachname) &&
      Objects.equals(geburtsdatum, person.geburtsdatum);
  }

  @Override
  public String toString() {
    return
      '\n' +
        "first name: \t" + vorname + '\n' +
        "last name: \t" + nachname + '\n' +
        "birthday: \t" + geburtsdatum.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
        '\n';
  }

  @Override
  public int hashCode() {
    return Objects.hash(vorname, nachname, geburtsdatum);
  }
}
