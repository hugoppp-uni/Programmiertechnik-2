package praktikum.aufgabe1.F;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
  private String vorname;
  private String nachname;
  private LocalDate geburtsdatum;

  public Person(String vorname, String nachname, LocalDate geburtsdatum){
    this.vorname = vorname;
    this.nachname = nachname;
    this.geburtsdatum = geburtsdatum;
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
    return super.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(vorname, nachname, geburtsdatum);
  }
}
