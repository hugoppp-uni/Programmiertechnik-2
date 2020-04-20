package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HerrDerRingeDaten {
  String relPath = "./src/main/resources/json/";
  private final List<Figur> figuren =
      Figur.generateFromJson(relPath + "figuren.json");
  private final List<Zitat> zitate =
      Zitat.generateFromJson(relPath + "zitate.json");
  private final List<Film> filme =
      Film.generateFromJson(relPath + "filme.json");

  public List<Figur> getFiguren() {
    return figuren;
  }

  public List<Zitat> getZitate() {
    return zitate;
  }

  public List<Film> getFilme() {
    return filme;
  }


  public Figur findFigur(String name) {
    ArrayList<Figur> figurenCopy = new ArrayList<>(figuren);
    while (!figurenCopy.isEmpty()) {
      var searchStream = figurenCopy.stream();
      Optional<Figur> result = searchStream.findAny();
      result.ifPresent(figurenCopy::remove);
      if (result.isPresent() && result
          .get()
          .getName()
          .equals(name)) return result.get();
    }
    return null;
  }

  public List<String> getZitateOf(String name) {
    var ls = new ArrayList<String>();
    String id = findFigur(name).getId();
    if (id == null) return null;
    return zitate
        .stream()
        .filter(o -> o
            .getFigurId()
            .equals(id))
        .map(o -> o.getDialog())
        .collect(Collectors.toList());
  }
//    figuren.forEach(e -> System.out.println(e.toString() + "\n"));
//    zitate.forEach(e -> System.out.println(e.toString() + "\n"));
//    filme.forEach(e -> System.out.println(e.toString() + "\n"));
//    figuren.forEach(e -> System.out.println(e.toString() + "\n"));


}
