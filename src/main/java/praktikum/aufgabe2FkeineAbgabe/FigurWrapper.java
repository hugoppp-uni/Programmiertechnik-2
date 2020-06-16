package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class FigurWrapper extends Figur {
    private StringProperty propertyName;
    private ObjectProperty<Typ> propertyTyp;
    private ObjectProperty<Geschlecht> propertyGeschlecht;

    public FigurWrapper(String id, float groesse,
                        ObjectProperty<Typ> propertyTyp,
                        ObjectProperty<Geschlecht> propertyGeschlecht,
                        String geburtstag, String partner, String todestag,
                        String haarfarbe, StringProperty propertyName) {
        super(id, groesse, propertyTyp.get(), propertyGeschlecht.get(),
          geburtstag, partner, todestag, haarfarbe, propertyName.get());
    }

    public void propertyListener() {
        propertyName.addListener((beobachter, alt, neu) -> System.out.println(alt));
    }
}
