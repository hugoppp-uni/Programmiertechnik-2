package praktikum.aufgabe2H;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    String relPath = "./src/main/resources/json/";
    List<Figur> figuren = Figur.generateFromJson(relPath + "figuren.json");
    List<Zitat> zitate = Zitat.generateFromJson(relPath + "zitate.json");
    List<Film> filme = Film.generateFromJson(relPath + "filme.json");

//    figuren.forEach(e -> System.out.println(e.toString() + "\n"));
//    zitate.forEach(e -> System.out.println(e.toString() + "\n"));
//    filme.forEach(e -> System.out.println(e.toString() + "\n"));
    figuren.forEach(e -> System.out.println(e.toString() + "\n"));


  }
}
