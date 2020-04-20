package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HerrDerRingeDaten {
  String relPath = "./src/main/resources/json/";
  List<Figur> figuren = Figur.generateFromJson(relPath + "figuren.json");
  List<Zitat> zitate = Zitat.generateFromJson(relPath + "zitate.json");
  List<Film> filme = Film.generateFromJson(relPath + "filme.json");

  public Figur findFigur(String name) {
    ArrayList<Figur> figurenCopy = new ArrayList<>(figuren);
    while (!figurenCopy.isEmpty()) {
      var searchStream = figurenCopy.stream();
      Optional<Figur> result = searchStream.findAny();
      result.ifPresent(figurenCopy::remove);
      if (result.isPresent() && result.get().getName().equals(name))
        return result.get();
    }
    return null;
  }

//    figuren.forEach(e -> System.out.println(e.toString() + "\n"));
//    zitate.forEach(e -> System.out.println(e.toString() + "\n"));
//    filme.forEach(e -> System.out.println(e.toString() + "\n"));
//    figuren.forEach(e -> System.out.println(e.toString() + "\n"));


}
