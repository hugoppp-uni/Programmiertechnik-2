package praktikum.aufgabe2F;

import org.json.JSONObject;

import static praktikum.aufgabe2F.Helper.getNotNull;
import static praktikum.aufgabe2F.Helper.getNumberNotNull;

public class Film {
    private String id;
    private String name;
    private int laufzeit;
    private int budget;
    private int oskars;

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
          "id='" + id + '\'' +
          '}';
    }
}
