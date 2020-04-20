package praktikum.aufgabe2H;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JSONReader {
    private JSONObject wurzel;

    public JSONReader(String dateiname) {
        read(dateiname);
    }

    public void read(String dateiname) {
        StringBuilder text = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(dateiname), StandardCharsets.UTF_8)) {
            stream.forEach(s -> text.append(s).append("\n"));
        } catch (
              IOException e) {
            e.printStackTrace();
        }
        wurzel = new JSONObject(text.toString());
    }

    public JSONArray get(String s) {
        return wurzel.getJSONArray(s);
    }
}
