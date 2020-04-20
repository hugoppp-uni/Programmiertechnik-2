package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Figur {
  private final String id;
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

  public static List<Figur> generateFromJson(String path) {
    ArrayList<Figur> ls = new ArrayList<>();
    var JsonLs = JSONReader.getJSONObjectList(path, "docs");
    JsonLs.forEach(o -> ls.add(new Figur(JSONReader.getSafeString(o, "_id"),
        parseSize(JSONReader.getSafeString(o, "height")),
        Typ.from((JSONReader.getSafeString(o, "race"))),
        Geschlecht.from(JSONReader.getSafeString(o, "gender")),
        JSONReader.getSafeString(o, "birth"),
        JSONReader.getSafeString(o, "spouse"),
        JSONReader.getSafeString(o, "death"),
        JSONReader.getSafeString(o, "hair"),
        JSONReader.getSafeString(o, "name"))));
    return ls;
  }

  private static float parseSize(String s) {
    Matcher matcher = Pattern.compile("\\d\\d[.]\\d[m]").matcher(s);
    if (matcher.find()) {
      String res = (matcher.group());
      return Float.parseFloat(res.substring(0, res.length() - 1));
    }
    matcher = Pattern.compile(("\\d{3}cm")).matcher(s);
    if (matcher.find()) {
      String res = (matcher.group());
      return Float.parseFloat(
          res.charAt(0) + "." + res.charAt(1) + res.charAt(2));
    }
    return 0f;
  }

  @Override
  public String toString() {
    return "Figur{" + "id='" + id + "'\n" + ", groesse=" + groesse + ", typ=" +
           typ + ", geschlecht=" + geschlecht + ", geburtstag='" + geburtstag +
           '\'' + ", partner='" + partner + '\'' + ", todestag='" + todestag +
           '\'' + ", haarfarbe='" + haarfarbe + '\'' + ", name='" + name +
           '\'' + "}";
  }
}
