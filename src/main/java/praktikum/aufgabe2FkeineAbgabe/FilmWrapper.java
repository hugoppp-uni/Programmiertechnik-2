package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class FilmWrapper extends Film {
    private StringProperty propertyTitel;
    private IntegerProperty propertyLaufzeit;

    public FilmWrapper(String id, StringProperty propertyTitel,
                       IntegerProperty propertyLaufzeit, int budget,
                       int oskars) {
        super(id, propertyTitel.get(), propertyLaufzeit.get(), budget, oskars);
    }
}
