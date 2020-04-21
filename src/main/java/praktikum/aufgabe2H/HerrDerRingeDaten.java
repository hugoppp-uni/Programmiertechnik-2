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

  /**
   * Finds a Figur with matching name
   *
   * @param name Figur name
   * @return random Figure with matching name.
   */
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

  /**
   * Gets all Zitate from random Figure with matching name
   *
   * @param name Figur name
   * @return list of Zitate as String
   */
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

  /**
   * Gets all Zitate from a List of Figures
   *
   * @param figurenLs List of Figures
   * @return Map with Figure name and all corresponding Zitate as List
   */
  public HashMap<String, List<String>> getZitateMap(List<Figur> figurenLs) {
    HashMap<String, List<String>> nameZitateHashmap = new HashMap<>();
    figurenLs.stream()
        .map(Figur::getName)
        .filter(name -> !getZitateOf(name).isEmpty())
        .forEach(name -> nameZitateHashmap.put(name, getZitateOf(name)));
    return nameZitateHashmap;
  }

  /**
   * Prints all Zitate from a List of Figures
   *
   * @param figurenLs List of Figures
   */
  public void printZitate(List<Figur> figurenLs) {
    getZitateMap(figurenLs).
        forEach((name, zitate) -> System.out.println(
            "\n--" + name + "--" + ":\t" +
            zitate.stream().reduce("", (s1, s2) -> s1 + "\n\t" + s2)));
  }
}
