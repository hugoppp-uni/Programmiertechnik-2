package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.StringProperty;
import org.json.JSONObject;

public class Zitat {
    private final StringProperty id;
    private final StringProperty dialog;
    private final StringProperty filmId;
    private final StringProperty figurId;

    public Zitat(StringProperty id, StringProperty dialog,
                 StringProperty filmId,
                 StringProperty figurId) {
        this.id = id;
        this.dialog = dialog;
        this.filmId = filmId;
        this.figurId = figurId;
    }

    public static Zitat fromJson(JSONObject o) {
        StringProperty id = Helper.getNotNull2(o, "_id");
        StringProperty dialog = Helper.getNotNull2(o, "dialog");
        StringProperty filmId = Helper.getNotNull2(o, "movie");
        StringProperty figurId = Helper.getNotNull2(o, "character");

        return new Zitat(id, dialog, filmId, figurId);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty dialogProperty() {
        return dialog;
    }

    public String getDialog() {
        return dialog.get();
    }

    public StringProperty filmIdProperty() {
        return filmId;
    }

    public String getFilmId() {
        return filmId.get();
    }

    public StringProperty figurIdProperty() {
        return figurId;
    }

    public String getFigurId() {
        return figurId.get();
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
