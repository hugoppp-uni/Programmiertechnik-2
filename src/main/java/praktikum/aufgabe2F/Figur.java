package praktikum.aufgabe2F;

import org.json.JSONObject;

import java.util.Objects;

import static praktikum.aufgabe2F.Helper.*;

public class Figur implements Comparable<Figur> {
    private String id;
    private float groesse;
    private Typ typ;
    private Geschlecht geschlecht;
    private String geburtstag;
    private String partner;
    private String todestag;
    private String haarfarbe;
    private String name;

    private Figur(String id, float groesse, Typ typ, Geschlecht geschlecht,
                  String geburtstag, String partner, String todestag, String
                    haarfarbe, String name) {
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

    public Figur(){

    }

    public static Figur fromJson(JSONObject o) {
        String id = getNotNull(o, "_id");
        float groesse = (float) getNumber(getNumberNotNull(o, "height"));
        Typ typ = getNotNull(o, "race") == null ? null :
          Typ.from(o.getString("race"));
        Geschlecht geschlecht = getNotNull(o, "gender") == null ? null :
          Geschlecht.from(o.getString("gender"));
        String geburtstag = getNotNull(o, "birth");
        String partner = getNotNull(o, "spouse");
        String todestag = getNotNull(o, "death");
        String haarfarbe = getNotNull(o, "hair");
        String name = getNotNull(o, "name");

        return new Figur(id, groesse, typ, geschlecht, geburtstag, partner,
          todestag, haarfarbe, name);
    }


    public void groesseLesen(JSONObject o, Figur f) {

    }

    @Override
    public String toString() {
        return "Figur{" +
          "Name ='" + name + '\'' +
          '}';
    }

    @Override
    public int compareTo(Figur o) {
        return getName().compareTo(o.getName());
    }

    public String getId() {
        return id;
    }

    public float getGroesse() {
        return groesse;
    }

    public Typ getTyp() {
        return typ;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public String getGeburtstag() {
        return geburtstag;
    }

    public String getPartner() {
        return partner;
    }

    public String getTodestag() {
        return todestag;
    }

    public String getHaarfarbe() {
        return haarfarbe;
    }

    public String getName() {
        return name;
    }
}
