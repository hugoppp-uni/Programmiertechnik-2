package praktikum.aufgabe2H;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Figur implements Comparable<Figur>, Iterable<String> {
  private final String id;
  /**
   * Groesse in metern
   */
  private final float groesse;
  private final Typ typ;
  private final Geschlecht geschlecht;
  private final String geburtstag;
  private final String partner;
  private final String todestag;
  private final String haarfarbe;
  private final String name;

  public Figur(String id,
               float groesse,
               Typ typ,
               Geschlecht geschlecht,
               String geburtstag,
               String partner,
               String todestag,
               String haarfarbe,
               String name) {
    this.id = id;
    this.groesse = groesse;
    this.typ = typ;
    this.geschlecht = geschlecht;
    this.geburtstag = geburtstag;
    this.partner = partner;
    this.todestag = todestag;
    this.haarfarbe = haarfarbe;
    this.name = name;
  }

  public float getGroesse() {
    return groesse;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public Typ getTyp() {
    return typ;
  }

  /**
   * Generates a List of new Figur from JSON file
   *
   * @param path path to json file
   * @return List of Figure
   */
  public static List<Figur> generateFromJson(String path) {
    ArrayList<Figur> ls = new ArrayList<>();
    List<JSONObject> JsonLs = JSONReader.getJSONObjectList(path, "docs");
    JsonLs.forEach(o -> ls.add(new Figur(
        JSONReader.getSafeString(o, "_id"),
        parseSize(JSONReader.getSafeString(o, "height")),
        Typ.from((JSONReader.getSafeString(o, "race"))),
        Geschlecht.from(JSONReader.getSafeString(o, "gender")),
        JSONReader.getSafeString(o, "birth"),
        JSONReader.getSafeString(o, "spouse"),
        JSONReader.getSafeString(o, "death"),
        JSONReader.getSafeString(o, "hair"),
        JSONReader.getSafeString(o, "name")
    )));
    return ls;
  }

  /**
   * Parses float out of String, must one of the following formats:
   * \d\d[.]\dm
   * \d\d\dcm
   *
   * @param s String to be parsed
   * @return parsed float
   */
  private static float parseSize(String s) {
    Matcher matcher = Pattern.compile("\\d[.]\\d\\dm").matcher(s);
    if (matcher.find()) {
      String res = (matcher.group());
      return Float.parseFloat(res.substring(0, res.length() - 1));
    }
    matcher = Pattern.compile(("\\d{3}cm")).matcher(s);
    if (matcher.find()) {
      String res = (matcher.group());
      return Float.parseFloat(res.charAt(0) + "." + res.charAt(1) + res.charAt(2));
    }
    return 0f;
  }

  @Override
  public int compareTo(Figur o) {
    return name.compareTo(o.name);
  }

  @Override
  @NotNull
  public Iterator<String> iterator() {
    return (Arrays.asList(new String[]{
        name,
        id,
        Double.toString(groesse),
        typ.toString(),
        geschlecht.toString(),
        geburtstag,
        partner,
        todestag,
        haarfarbe
    })).iterator();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Figur strings = (Figur) o;

    return id.equals(strings.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Figur{" + "id='" + id + "'\n" + ", groesse=" + groesse + ", typ=" + typ +
           ", geschlecht=" + geschlecht + ", geburtstag='" + geburtstag + '\'' + ", partner='" +
           partner + '\'' + ", todestag='" + todestag + '\'' + ", haarfarbe='" + haarfarbe + '\'' +
           ", name='" + name + '\'' + "}";
  }
}
