package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HerrDerRingeDaten {
  String relPath = "./src/main/resources/json/";
  private final List<Figur> figuren = Figur.generateFromJson(relPath + "figuren.json");
  private final List<Zitat> zitate = Zitat.generateFromJson(relPath + "zitate.json");
  private final List<Film> filme = Film.generateFromJson(relPath + "filme.json");

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
      if (result.isPresent() && result.get().getName().equals(name)) return result.get();
    }
    return null;
  }

  public List<String> getZitateOf(String name) {
    if (name == null || name.equals("")) return null;
    var ls = new ArrayList<String>();
    String id = findFigur(name).getId();
    if (id == null || id.equals("")) return null;
    return zitate.stream()
        .filter(o -> o.getFigurId().equals(id))
        .map(o -> o.getDialog())
        .collect(Collectors.toList());
  }

  public HashMap<String, List<String>> getZitateMap(List<Figur> figurenLs) {
    HashMap<String, List<String>> nameZitateHashmap = new HashMap<>();
    figurenLs.stream()
        .map(Figur::getName)
        .filter(name -> !getZitateOf(name).isEmpty())
        .forEach(name -> nameZitateHashmap.put(name, getZitateOf(name)));
    return nameZitateHashmap;
  }

  public void printZitate(HashMap<String, List<String>> map) {
    map.forEach((name, zitate) -> System.out.println(
        "\n--" + name + "--" + ":\t" + zitate.stream().reduce("", (s1, s2) -> s1 + "\n\t" + s2)));
  }
}
