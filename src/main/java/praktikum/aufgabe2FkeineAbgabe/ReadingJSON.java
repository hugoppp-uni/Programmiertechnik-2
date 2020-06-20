package praktikum.aufgabe2FkeineAbgabe;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Objects;

public class ReadingJSON {
    public static void main(String[] args) {
        HerrDerRingeDaten h = new HerrDerRingeDaten();
        String file = "figuren.json";
        JSONArray e = einlesen("src/main/resources/json/" + file);
        Figur figur = Figur.fromJson((e).getJSONObject(892));
        figur.iterator();
        h.zitatZuFigur("Frodo Baggins").forEach(System.out::println);
    }

    @NotNull
    public static JSONArray einlesen(String file) {
        try (FileReader inFile = new FileReader(new File(file));
             StringWriter sw = new StringWriter()) {
            inFile.transferTo(sw);
            String contents = sw.toString();
            JSONObject o = new JSONObject(contents);
            return o.getJSONArray("docs");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }
}
