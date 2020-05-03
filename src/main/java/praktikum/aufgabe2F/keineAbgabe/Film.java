package praktikum.aufgabe2F.keineAbgabe;

import org.json.JSONObject;

import static praktikum.aufgabe2F.keineAbgabe.Helper.getNotNull;
import static praktikum.aufgabe2F.keineAbgabe.Helper.getNumberNotNull;

public class Film {
    private final String id;
    private final String name;
    private final int laufzeit;
    private final int budget;
    private final int oskars;

    public Film(String id, String name, int laufzeit, int budget, int oskars){
        this.id = id;
        this.name = name;
        this.laufzeit = laufzeit;
        this.budget = budget;
        this.oskars = oskars;
    }

    public static Film fromJson(JSONObject o){
        String id = getNotNull(o, "_id");
        String name = getNotNull(o, "name");
        int laufzeit = Integer.parseInt(getNumberNotNull(o,
          "runtimeInMinutes"));
        int budget = Integer.parseInt(getNumberNotNull(o,
          "budgetInMillions"));
        int oskars = Integer.parseInt(getNumberNotNull(o,
          "academyAwardWins"));

        return new Film(id, name, laufzeit, budget, oskars);
    }

    @Override
    public String toString() {
        return "Film{" +
          "\nid ='" + id + '\'' +
          ",\nname ='" + name + '\'' +
          ",\nlaufzeit =" + laufzeit +
          ",\nbudget =" + budget +
          ",\noskars =" + oskars +
          "\n}\n";
    }
}
