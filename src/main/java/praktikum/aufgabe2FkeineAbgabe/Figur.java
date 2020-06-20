package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;

public class Figur implements Comparable<Figur>, Iterable<String> {
    private final StringProperty id;
    private final float groesse;
    private final ObjectProperty<Typ> typ;
    private final ObjectProperty<Geschlecht> geschlecht;
    private final StringProperty geburtstag;
    private final StringProperty partner;
    private final StringProperty todestag;
    private final StringProperty haarfarbe;
    private final StringProperty name;

    public Figur(StringProperty id, float groesse, ObjectProperty<Typ> typ,
                 ObjectProperty<Geschlecht> geschlecht,
                 StringProperty geburtstag, StringProperty partner,
                 StringProperty todestag, StringProperty
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
        StringProperty id = Helper.getNotNull2(o, "_id");
        float groesse = (float) Helper.getNumber(Helper.getNumberNotNull(o,
          "height"));
        ObjectProperty<Typ> typ = Helper.getNotNull(o, "race") == null ?
          new SimpleObjectProperty<>(Typ.UNDEFINED) :
          new SimpleObjectProperty<>(Typ.from(o.getString("race")));
        ObjectProperty<Geschlecht> geschlecht = Helper.getNotNull(o,
          "gender") == null ?
          new SimpleObjectProperty<>(Geschlecht.UNDEFINED) :
          new SimpleObjectProperty<>(Geschlecht.from(o.getString("gender")));
        StringProperty geburtstag = Helper.getNotNull2(o, "birth");
        StringProperty partner = Helper.getNotNull2(o, "spouse");
        StringProperty todestag = Helper.getNotNull2(o, "death");
        StringProperty haarfarbe = Helper.getNotNull2(o, "hair");
        StringProperty name = Helper.getNotNull2(o, "name");

        assert name != null;
        return new Figur(id, groesse, typ, geschlecht, geburtstag, partner,
          todestag, haarfarbe, name);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getId() {
        return id.get();
    }

    public float getGroesse() {
        return groesse;
    }

    public ObjectProperty<Typ> typProperty() {
        return typ;
    }

    public Typ getTyp() {
        return typ.get();
    }

    public ObjectProperty<Geschlecht> geschlechtProperty() {
        return geschlecht;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
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
          id.get(),
          String.valueOf(groesse),
          String.valueOf(typ),
          String.valueOf(geschlecht.get()),
          geburtstag.get(),
          partner.get(),
          todestag.get(),
          haarfarbe.get(),
          name.get()
        })).iterator();
    }

    @Override
    public String toString() {
        return "Figur{" +
          "\nid = '" + id.get() + '\'' +
          ",\ngroesse = " + groesse + "m" +
          ",\ntyp = " + typ.get() +
          ",\ngeschlecht = " + geschlecht.get() +
          ",\ngeburtstag = '" + geburtstag.get() + '\'' +
          ",\npartner = '" + partner.get() + '\'' +
          ",\ntodestag = '" + todestag.get() + '\'' +
          ",\nhaarfarbe = '" + haarfarbe.get() + '\'' +
          ",\nname = '" + name.get() + '\'' +
          "\n}\n";
    }
}
