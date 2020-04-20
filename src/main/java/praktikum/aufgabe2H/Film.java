package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;

public class Film {
    String id;
    String name;
    /**
     * laufzeit in Minuten
     */
    int laufzeit;
    /**
     * budget in Millionen
     */
    int budget;
    /**
     * gewonnene Oskars
     */
    int oskars;

    public Film(String id, String name, int laufzeit, int budget, int oskars) {
        this.id = id;
        this.name = name;
        this.laufzeit = laufzeit;
        this.budget = budget;
        this.oskars = oskars;
    }

    public static List<Film> generateFromJson(String path) {
        ArrayList<Film> ls = new ArrayList<>();
        var JsonLs = JSONReader.getJSONObjectList(path, "docs");
        JsonLs.forEach(o -> ls.add(new Film(JSONReader.getSafeString(o, "_id"),
            JSONReader.getSafeString(o, "name"),
            JSONReader.getSafeInt(o, "runtimeInMinutes"),
            JSONReader.getSafeInt(o, "budgetInMillions"),
            JSONReader.getSafeInt(o, "academyAwardWins"))));
        return ls;
    }

    @Override
    public String toString() {
        return "Film{" + "id='" + id + "'\n" + ", name='" + name + '\'' +
               ", laufzeit=" + laufzeit + ", budget=" + budget + ", oskars=" +
               oskars + '}';
    }
}
