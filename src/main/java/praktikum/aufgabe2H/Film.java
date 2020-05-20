package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;

public class Film {
  String id;
  String titel;
  /**
   * laufzeit in Minuten
   */
  int laufzeit;
  /**
   * budget in Millionen
   */
  int budget;
  /**
   * gewonnene Oskars
   */
  int oskars;

  public String getTitel() {
    return titel;
  }

  public int getLaufzeit() {
    return laufzeit;
  }

  public Film(String id, String titel, int laufzeit, int budget, int oskars) {
    this.id = id;
    this.titel = titel;
    this.laufzeit = laufzeit;
    this.budget = budget;
    this.oskars = oskars;
  }

  /**
   * Generates a List of new Film from JSON file
   *
   * @param path path to json file
   * @return List of Film
   */
  public static List<Film> generateFromJson(String path) {
    ArrayList<Film> ls = new ArrayList<>();
    var JsonLs = JSONReader.getJSONObjectList(path, "docs");
    JsonLs.forEach(o -> ls.add(
        new Film(
            JSONReader.getSafeString(o, "_id"),
            JSONReader.getSafeString(o, "name"),
            JSONReader.getSafeInt(o, "runtimeInMinutes"),
            JSONReader.getSafeInt(o, "budgetInMillions"),
            JSONReader.getSafeInt(o, "academyAwardWins")
        )));
    return ls;
  }

  @Override
  public String toString() {
    return "Film{" + "id='" + id + "'\n" + ", name='" + titel + '\'' +
           ", laufzeit=" + laufzeit +
           ", budget=" + budget + ", oskars=" + oskars + '}';
  }
}
