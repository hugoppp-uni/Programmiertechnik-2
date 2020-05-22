package praktikum.aufgabe2H;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    zitate = Zitat.generateFromJson(relPath + "zitate.json")
                  .stream()
                  .filter(zitat -> zitat.getDialog().length() > 0)
                  .collect(Collectors.toList());
    figuren = Figur.generateFromJson(relPath + "figuren.json");
    filme = Film.generateFromJson(relPath + "filme.json");
  }

  public HerrDerRingeDaten() {
    this("./src/main/resources/json/");
  }

  /**
   * Filters a list of figures based on a filterstring.
   *
   * @param figurList    The list to filter
   * @param filterString FILTER &lt;key&gt &lt;operator&gt; &lt;value&gt; where <br>
   *                     key = "NAME" or "TYP" <br>
   *                     operator = "=" <br>
   *                     value = the value of the filter <br>
   * @return The filtered list or original list, if result is empty or filterstring invalid
   */
  public List<Figur> filterFiguren(List<Figur> figurList, String filterString) {
    Matcher matcher = Pattern.compile("(\\w+)\\s*=\\s*(\\w+)").matcher(filterString.trim());
    if (!matcher.find()) {
      return figurList;
    }
    String key = matcher.group(1).toLowerCase();
    String value = matcher.group(2).toLowerCase();
    List<Figur> result;

    switch (key) {
      case "name":
        result = figurList.stream()
                          .filter(figur -> figur.getName().toLowerCase().contains(value))
                          .collect(Collectors.toList());
        break;
      case ("typ"):
        result = figurList.stream()
                          .filter(figur -> figur.getTyp().name().toLowerCase().contains(value))
                          .collect(Collectors.toList());
        break;
      default:
        result = figurList;
    }
    return !result.isEmpty() ? result : figurList;
  }

  public List<Zitat> getZitate() {
    return zitate;
  }

  public List<Film> getFilme() {
    return filme;
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
    Optional<Figur> result =
      figuren.stream().filter(figur -> figur.getName().equals(name)).findAny();
    return result.orElse(null);
  }

  /**
   * Gets all Zitate from random Figure with matching name
   *
   * @param name Figur name
   * @return list of Zitate as String
   */
  public List<String> getZitateDialogOf(String name) {
    if (name == null || name.equals("")) return null;
    String id = findFigur(name).getId();
    if (id == null || id.equals("")) return null;
    return zitate.stream()
                 .filter(o -> o.getFigurId().equals(id))
                 .map(Zitat::getDialog)
                 .collect(Collectors.toList());
  }

  public List<Zitat> getZitateOfId(String id) {
    if (id == null || id.equals("")) return null;
    return zitate.stream().filter(o -> o.getFigurId().equals(id)).collect(Collectors.toList());
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
             .filter(name -> !getZitateDialogOf(name).isEmpty())
             .forEach(name -> nameZitateHashmap.put(name, getZitateDialogOf(name)));
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
