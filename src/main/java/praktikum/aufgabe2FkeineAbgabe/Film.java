package praktikum.aufgabe2FkeineAbgabe;

import org.json.JSONObject;

import static praktikum.aufgabe2FkeineAbgabe.Helper.getNotNull;
import static praktikum.aufgabe2FkeineAbgabe.Helper.getNumberNotNull;

public class Film {
    private final String id;
    private final String titel;
    private final int laufzeit;
    private final int budget;
    private final int oskars;

    public Film(String id, String titel, int laufzeit, int budget, int oskars){
        this.id = id;
        this.titel = titel;
        this.laufzeit = laufzeit;
        this.budget = budget;
        this.oskars = oskars;
    }

    public static Film fromJson(JSONObject o){
        String id = getNotNull(o, "_id");
        String titel = getNotNull(o, "name");
        int laufzeit = Integer.parseInt(getNumberNotNull(o,
          "runtimeInMinutes"));
        int budget = Integer.parseInt(getNumberNotNull(o,
          "budgetInMillions"));
        int oskars = Integer.parseInt(getNumberNotNull(o,
          "academyAwardWins"));

        return new Film(id, titel, laufzeit, budget, oskars);
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
