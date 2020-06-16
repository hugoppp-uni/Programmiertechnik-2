package praktikum.aufgabe2FkeineAbgabe;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;

public class Figur implements Comparable<Figur>, Iterable<String> {
    private final String id;
    private final float groesse;
    private final Typ typ;
    private final Geschlecht geschlecht;
    private final String geburtstag;
    private final String partner;
    private final String todestag;
    private final String haarfarbe;
    private final String name;

    public Figur(String id, float groesse, Typ typ, Geschlecht geschlecht,
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

    public static Figur fromJson(JSONObject o) {
        String id = Helper.getNotNull(o, "_id");
        float groesse = (float) Helper.getNumber(Helper.getNumberNotNull(o,
          "height"));
        Typ typ = Helper.getNotNull(o, "race") == null ? null :
          Typ.from(o.getString("race"));
        Geschlecht geschlecht = Helper.getNotNull(o, "gender") == null ?
          null : Geschlecht.from(o.getString("gender"));
        String geburtstag = Helper.getNotNull(o, "birth");
        String partner = Helper.getNotNull(o, "spouse");
        String todestag = Helper.getNotNull(o, "death");
        String haarfarbe = Helper.getNotNull(o, "hair");
        String name = Helper.getNotNull(o, "name");

        return new Figur(id, groesse, typ, geschlecht, geburtstag, partner,
          todestag, haarfarbe, name);
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

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Figur o) {
        return name.compareTo(o.name);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<String> iterator() {
        return (Arrays.asList(new String[]{
          id,
          String.valueOf(groesse),
          String.valueOf(typ),
          String.valueOf(geschlecht),
          geburtstag,
          partner,
          todestag,
          haarfarbe,
          name
        })).iterator();
    }

    @Override
    public String toString() {
        return "Figur{" +
          "\nid = '" + id + '\'' +
          ",\ngroesse = " + groesse + "m" +
          ",\ntyp = " + typ +
          ",\ngeschlecht = " + geschlecht +
          ",\ngeburtstag = '" + geburtstag + '\'' +
          ",\npartner = '" + partner + '\'' +
          ",\ntodestag = '" + todestag + '\'' +
          ",\nhaarfarbe = '" + haarfarbe + '\'' +
          ",\nname = '" + name + '\'' +
          "\n}\n";
    }
}
