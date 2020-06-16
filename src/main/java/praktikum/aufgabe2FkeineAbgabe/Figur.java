package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;

public class Figur implements Comparable<Figur>, Iterable<String> {
    private final String id;
    private final float groesse;
    private final ObjectProperty<Typ> typ;
    private final ObjectProperty<Geschlecht> geschlecht;
    private final String geburtstag;
    private final String partner;
    private final String todestag;
    private final String haarfarbe;
    private final StringProperty name;

    public Figur(String id, float groesse, ObjectProperty<Typ> typ,
                 ObjectProperty<Geschlecht> geschlecht,
                 String geburtstag, String partner, String todestag, String
                   haarfarbe, StringProperty name) {
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
        ObjectProperty<Typ> typ = Helper.getNotNull(o, "race") == null ? null :
          new SimpleObjectProperty<>(Typ.from(o.getString("race")));
        ObjectProperty<Geschlecht> geschlecht = Helper.getNotNull(o,
          "gender") == null ?
          null : new SimpleObjectProperty<>(Geschlecht.from(o.getString(
            "gender")));
        String geburtstag = Helper.getNotNull(o, "birth");
        String partner = Helper.getNotNull(o, "spouse");
        String todestag = Helper.getNotNull(o, "death");
        String haarfarbe = Helper.getNotNull(o, "hair");
        StringProperty name = Helper.getNotNullName(o, "name");

        return new Figur(id, groesse, typ, geschlecht, geburtstag, partner,
          todestag, haarfarbe, name);
    }

    public void propertyListener() {
        name.addListener((beobachter, alt, neu) -> System.out.println(alt));
    }

    public String getId() {
        return id;
    }

    public float getGroesse() {
        return groesse;
    }

    public ObjectProperty<Typ> getTyp() {
        return typ;
    }

    public ObjectProperty<Geschlecht> getGeschlecht(){
        return geschlecht;
    }

    public StringProperty getName() {
        return name;
    }

    @Override
    public int compareTo(Figur o) {
        return name.get().compareTo(o.name.get());
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
          name.get()
        })).iterator();
    }

    @Override
    public String toString() {
        return "Figur{" +
          "\nid = '" + id + '\'' +
          ",\ngroesse = " + groesse + "m" +
          ",\ntyp = " + typ.get() +
          ",\ngeschlecht = " + geschlecht.get() +
          ",\ngeburtstag = '" + geburtstag + '\'' +
          ",\npartner = '" + partner + '\'' +
          ",\ntodestag = '" + todestag + '\'' +
          ",\nhaarfarbe = '" + haarfarbe + '\'' +
          ",\nname = '" + name.get() + '\'' +
          "\n}\n";
    }
}
