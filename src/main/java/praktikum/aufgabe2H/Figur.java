package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;

public class Figur implements XmlLoadable<Figur> {
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

  @Override
  public List<Figur> loadFromXml(String path) {
    ArrayList<Figur> ls = new ArrayList<>();
    JSONReader figurenReader = new JSONReader(path);
//    for (Object figur : figurenReader.get("docs")) {
//      ls.add(new Figur(figur.));

//    }
    return ls;
  }
}
