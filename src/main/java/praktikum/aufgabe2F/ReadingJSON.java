package praktikum.aufgabe2F;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class ReadingJSON {
    public static void main(String[] args) {
        //reader();
        einlesen("src/main/resources/json/figuren.json");
    }

    public static void reader() {
        //TODO relativer pfad bsp: src/main/resources/json/figuren.json
        new File("../").toPath().toAbsolutePath();
        try (FileReader inFile = new FileReader(new File(
          "src/main/resources/json/figuren.json"));
             StringWriter sw = new StringWriter()) {
            inFile.transferTo(sw);
            String contents = sw.toString();
            JSONObject o = new JSONObject(contents);
            JSONArray docs = o.getJSONArray("docs");
            JSONObject figur = (JSONObject) docs.get(0);
            System.out.println(figur.getString("race"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject wurzel = new JSONObject();
        String dateiname = "C:/Users/Ziska/SynologyDrive/Drive/HAW/Module/2" +
          ".Semester/PM2/pm2_vorgabe/src/main/resources/json/figuren.json";
        StringBuilder text = new StringBuilder();
        try (Stream<String> stream =
               Files.lines(Paths.get(dateiname), StandardCharsets.UTF_8)) {
            stream.forEach(s -> text.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wurzel = new JSONObject(text.toString());
        //Figur f = Figur.fromJson(wurzel);
    }

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
        return null;
    }

    public static List<Figur> createListFiguren(JSONArray j){
        List<Figur> figurenListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject figur = (JSONObject) j.get(i);
            Figur f = Figur.fromJson(figur);
            figurenListe.add(f);
        }
        return figurenListe;
    }

    public static List<Zitat> createListZitat(JSONArray j){
        List<Zitat> zitatListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject zitat = (JSONObject) j.get(i);
            Zitat z = Zitat.fromJson(zitat);
            zitatListe.add(z);
        }
        return zitatListe;
    }

    public static List<Film> createListFilm(JSONArray j){
        List<Film> filmListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject film = (JSONObject) j.get(i);
            Film f = Film.fromJson(film);
            filmListe.add(f);
        }
        return filmListe;
    }
}
