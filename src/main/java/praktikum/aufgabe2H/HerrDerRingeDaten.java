package praktikum.aufgabe2H;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HerrDerRingeDaten {
  private final List<Figur> figuren;
  private final List<Zitat> zitate;
  private final List<Film> filme;

  /**
   * Create HerrDerRingeDaten from JSON Data
   *
   * @param relPath Must contain zitate.json, figuren.json, filme.json
   */
  public HerrDerRingeDaten(String relPath) {
    zitate = Zitat.generateFromJson(relPath + "zitate.json");
    figuren = Figur.generateFromJson(relPath + "figuren.json");
    filme = Film.generateFromJson(relPath + "filme.json");
  }

  public HerrDerRingeDaten() {
    this("./src/main/resources/json/");
  }

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
    Optional<Figur> result = figuren.stream()
        .filter(figur -> figur.getName().equals(name))
        .findAny();
    return result.orElse(null);
  }

  /**
   * Gets all Zitate from random Figure with matching name
   *
   * @param name Figur name
   * @return list of Zitate as String
   */
  public List<String> getZitateOf(String name) {
    if (name == null || name.equals("")) return null;
    String id = findFigur(name).getId();
    if (id == null || id.equals("")) return null;
    return zitate.stream()
        .filter(o -> o.getFigurId().equals(id))
        .map(Zitat::getDialog)
        .collect(Collectors.toList());
  }

  /**
   * Gets a Map of Zitate corresponding to a Figur, from a List of Figures
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
