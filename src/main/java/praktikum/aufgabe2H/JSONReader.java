package praktikum.aufgabe2H;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JSONReader {

  public JSONReader(String dateiname) {
    readJson(dateiname);
  }

  /**
   * Get the string associated with a key.
   *
   * @param jsonObject A JSON Object
   * @param key        A key String
   * @return A String which is the value, empty String if key doesn't exist or value is NULL
   */
  public static String getSafeString(JSONObject jsonObject, String key) {
    if (jsonObject == null || key == null || !jsonObject.has(key) ||
        jsonObject.get(key).equals(JSONObject.NULL)) {
      return "";
    }
    try {
      return jsonObject.getString(key);
    } catch (JSONException e) {
      return "";
    }
  }

  /**
   * Get the int value associated with a key.
   *
   * @param jsonObject A JSON Object
   * @param key        A key String
   * @return The Integer value, -1 if key doesn't exist or is value NULL
   */
  public static int getSafeInt(JSONObject jsonObject, String key) {
    if (jsonObject == null || key == null || !jsonObject.has(key) ||
        jsonObject.get(key).equals(JSONObject.NULL)) {
      return -1;
    }
    try {
      return jsonObject.getInt(key) > 0 ? jsonObject.getInt(key) : -1;
    } catch (JSONException e) {
      return -1;
    }
  }

  /**
   * Get JSONObject List from path and key
   *
   * @param path Path to file
   * @param key  A key String
   * @return JSONObject List
   */
  public static List<JSONObject> getJSONObjectList(String path, String key) {
    List<JSONObject> ls = new ArrayList<>();
    JSONArray jsonArray = readJson(path).getJSONArray(key);
    jsonArray.forEach(s -> ls.add((JSONObject) s));
    return ls;
  }

  /**
   * Reads JSON file from path
   *
   * @param path path to file
   * @return Read file
   */
  public static JSONObject readJson(String path) {
    StringBuilder text = new StringBuilder();
    try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
      stream.forEach(s -> text.append(s).append("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new JSONObject(text.toString());
  }
}