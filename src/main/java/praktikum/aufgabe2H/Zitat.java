package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.List;

public class Zitat {
    private final String id;
    private final String dialog;
    private final String filmId;
    private final String figurId;

    public Zitat(String id, String dialog, String filmId, String figurId) {
        this.id = id;
        this.dialog = dialog;
        this.filmId = filmId;
        this.figurId = figurId;
    }

    public static List<Zitat> generateFromJson(String path) {
        ArrayList<Zitat> ls = new ArrayList<>();
        var JsonLs = JSONReader.getJSONObjectList(path, "docs");
        JsonLs.forEach(o -> ls.add(new Zitat(JSONReader.getSafeString(o, "_id"),
            JSONReader.getSafeString(o, "dialog"),
            JSONReader.getSafeString(o, "movie"),
            JSONReader.getSafeString(o, "character"))));
        return ls;
    }

    @Override
    public String toString() {
        return "Zitat{" + "id='" + id + "'\n" + "    dialog='" + dialog + '\'' +
               ", filmId='" + filmId + '\'' + ", figurId='" + figurId + '\'' +
               "\n}";
    }
}
