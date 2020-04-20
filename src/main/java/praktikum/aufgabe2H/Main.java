package praktikum.aufgabe2H;

import org.json.JSONObject;

public class Main {
  public static void main(String[] args) {
    String relPath = "./src/main/resources/json/";
    JSONReader figuren = new JSONReader(relPath + "figuren.json");

    var test = figuren.get("docs");
    JSONObject test2 = test.getJSONObject(1);
    JSONReader filme = new JSONReader(relPath + "filme.json");
    JSONReader zitate = new JSONReader(relPath + "zitate.json");
  }
}
