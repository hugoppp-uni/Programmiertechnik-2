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

    public static JSONObject readJson(String dateiname) {
        StringBuilder text = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(dateiname),
            StandardCharsets.UTF_8)) {
            stream.forEach(s -> text.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(text.toString());
    }

    public static String getSafeString(JSONObject o, String s) {
        if (o == null || s == null || !o.has(s) ||
            o.get(s).equals(JSONObject.NULL)) {
            return "";
        }
        try {
            return o.getString(s);
        } catch (JSONException e) {
            return "";
        }
    }

    public static int getSafeInt(JSONObject o, String s) {
        if (o == null || s == null || !o.has(s) ||
            o.get(s).equals(JSONObject.NULL)) {
            return -1;
        }
        try {
            return o.getInt(s) > 0 ? o.getInt(s) : -1;
        } catch (JSONException e) {
            return -1;
        }
    }

    public static List<JSONObject> getJSONObjectList(String path, String key) {
        List<JSONObject> ls = new ArrayList<>();
        JSONArray jsonArray = readJson(path).getJSONArray(key);
        jsonArray.forEach(s -> ls.add((JSONObject) s));
        return ls;
    }
}