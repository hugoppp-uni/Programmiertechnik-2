package praktikum.aufgabe2H;

import org.json.JSONObject;

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

  public String getId() {
    return id;
  }

  public String getDialog() {
    return dialog;
  }

  public String getFigurId() {
    return figurId;
  }

  /**
   * Generates a List of Zitat from JSON file
   *
   * @param path path to json file
   * @return List of Zitat
   */
  public static List<Zitat> generateFromJson(String path) {
    ArrayList<Zitat> ls = new ArrayList<>();
    List<JSONObject> JsonLs = JSONReader.getJSONObjectList(path, "docs");
    JsonLs.forEach(jsonObject -> ls.add(new Zitat(
        JSONReader.getSafeString(jsonObject, "_id"),
        //trims duplicate spaces of safestring
        JSONReader.getSafeString(jsonObject, "dialog").replaceAll("\\s{2,}", " ").trim(),
        JSONReader.getSafeString(jsonObject, "movie"),
        JSONReader.getSafeString(jsonObject, "character")
    )));
    return ls;
  }

  @Override
  public String toString() {
    return "Zitat{" + "id='" + id + "'\n" + "    dialog='" + dialog + '\'' + ", filmId='" + filmId +
           '\'' + ", figurId='" + figurId + '\'' + "\n}";
  }


}
