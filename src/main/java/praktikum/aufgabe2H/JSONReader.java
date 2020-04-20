package praktikum.aufgabe2H;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JSONReader {

    public JSONReader(String dateiname) {
        read(dateiname);
    }

    public static JSONObject read(String dateiname) {
        StringBuilder text = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(dateiname), StandardCharsets.UTF_8)) {
            stream.forEach(s -> text.append(s).append("\n"));
        } catch (
              IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(text.toString());
    }

    public static String getSafeString(JSONObject o, String s) {
        if (o == null || s == null || !o.has(s) ||
            o.get(s).equals(JSONObject.NULL)) {
            return "";
        }
        return o.getString(s);
    }

}
