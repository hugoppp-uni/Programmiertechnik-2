package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONObject;

import static praktikum.aufgabe2FkeineAbgabe.Helper.*;

public class Film {
    private final String id;
    private final StringProperty titel;
    private final IntegerProperty laufzeit;
    private final int budget;
    private final int oskars;

    public Film(String id, StringProperty titel, IntegerProperty laufzeit,
                int budget, int oskars) {
        this.id = id;
        this.titel = titel;
        this.laufzeit = laufzeit;
        this.budget = budget;
        this.oskars = oskars;
    }

    public static Film fromJson(JSONObject o) {
        String id = getNotNull(o, "_id");
        StringProperty titel = getNotNullName(o, "name");
        IntegerProperty laufzeit = new SimpleIntegerProperty(Integer
          .parseInt(getNumberNotNull(o, "runtimeInMinutes")));
        int budget = Integer.parseInt(getNumberNotNull(o,
          "budgetInMillions"));
        int oskars = Integer.parseInt(getNumberNotNull(o,
          "academyAwardWins"));

        return new Film(id, titel, laufzeit, budget, oskars);
    }

    public String getTitel() {
        return titel.get();
    }

    public StringProperty titelProperty() {
        return titel;
    }

    public int getLaufzeit() {
        return laufzeit.get();
    }

    public IntegerProperty laufzeitProperty() {
        return laufzeit;
    }

    @Override
    public String toString() {
        return "Film{" +
          "\nid ='" + id + '\'' +
          ",\nname ='" + titel + '\'' +
          ",\nlaufzeit =" + laufzeit +
          ",\nbudget =" + budget +
          ",\noskars =" + oskars +
          "\n}\n";
    }
}
