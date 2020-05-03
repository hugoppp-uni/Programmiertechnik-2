package praktikum.aufgabe2FkeineAbgabe;

import org.json.JSONObject;

import static praktikum.aufgabe2FkeineAbgabe.Helper.getNotNull;

public class Zitat {
    private final String id;
    private final String dialog;
    private final String filmId;
    private final String figurId;

    public Zitat(String id, String dialog, String filmId, String figurId){
        this.id = id;
        this.dialog = dialog;
        this.filmId = filmId;
        this.figurId = figurId;
    }

    public static Zitat fromJson(JSONObject o){
        String id = getNotNull(o, "_id");
        String dialog = getNotNull(o, "dialog");
        String filmId = getNotNull(o, "movie");
        String figurId = getNotNull(o, "character");

        return new Zitat(id, dialog, filmId, figurId);
    }

    public String getId() {
        return id;
    }

    public String getDialog() {
        return dialog;
    }

    public String getFilmId() {
        return filmId;
    }

    public String getFigurId() {
        return figurId;
    }

    @Override
    public String toString() {
        return "Zitat{" +
          "\nid ='" + id + '\'' +
          ",\ndialog ='" + dialog + '\'' +
          ",\nfilmId ='" + filmId + '\'' +
          ",\nfigurId ='" + figurId + '\'' +
          "\n}\n";
    }
}
