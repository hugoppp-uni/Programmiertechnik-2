package praktikum.aufgabe1.F;

import java.util.ArrayList;
import java.util.List;

public class PersonListMap extends PM2Map<String, List<Person>> {

  PersonListMap(){
    super();
  }

  public void einfuegen(String kategorie, Person person){
    if(!containsKey(kategorie)){
      List<Person> newList = new ArrayList<>();
      newList.add(person);
      put(kategorie, newList);
    } else{
      get(kategorie).add(person);
    }
   }
}
