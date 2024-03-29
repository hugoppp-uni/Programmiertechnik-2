package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static double getNumber(String str) {
        Pattern pattern = Pattern.compile("(\\d[.]\\d+)\\s?m.*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Math.round(Float.parseFloat(matcher.group(1)) * 100.0)
              / 100.0;
        }
        return 0.0;
    }

    public static String getNumberNotNull(JSONObject json, String key) {
        Object obj = json.get(key);
        return obj.equals(JSONObject.NULL) ? "0" : (String.valueOf(obj))
          .isEmpty() ? "0" : String.valueOf(obj);
    }

    public static StringProperty getNotNull(JSONObject json, String key) {
        if (json.has(key)) {
            Object obj = json.get(key);
            Pattern pattern = Pattern.compile("\\s+");
            Matcher matcher = pattern.matcher(String.valueOf(obj));
            if (matcher.find()) {
                obj = String.valueOf(obj).replace("  ", "");
            }
            Pattern pattern1 = Pattern.compile("(\\s?\\?)");
            Matcher matcher1 = pattern1.matcher(String.valueOf(obj));
            if (matcher1.find()) {
                obj = matcher1.replaceAll("?");
            }
            return obj.equals(JSONObject.NULL) ? null :
              (String.valueOf(obj)).isEmpty() ? null :
                new SimpleStringProperty(String.valueOf(obj));
        }
        return null;
    }

    public static StringProperty getNotNull2(JSONObject json, String key) {
        if (json.has(key)) {
            Object obj = json.get(key);
            Pattern pattern = Pattern.compile("\\s+");
            Matcher matcher = pattern.matcher(String.valueOf(obj));
            if (matcher.find()) {
                obj = String.valueOf(obj).replace("  ", "");
            }
            Pattern pattern1 = Pattern.compile("(\\s?\\?)");
            Matcher matcher1 = pattern1.matcher(String.valueOf(obj));
            if (matcher1.find()) {
                obj = matcher1.replaceAll("?");
            }
            return obj.equals(JSONObject.NULL) ? new SimpleStringProperty(
              "k. A.") : (String.valueOf(obj)).isEmpty() ?
              new SimpleStringProperty("k. A.") :
              new SimpleStringProperty(String.valueOf(obj));
        }
        return null;
    }

    public static JSONObject jObjErzeugenFigur(int objectIndex) {
        if (objectIndex < 0 || objectIndex > 932) {
            throw new IndexOutOfBoundsException("Index nicht in Range");
        }
        try (FileReader inFile = new FileReader(new File("C:/Users" +
          "/Ziska/SynologyDrive/Drive/HAW/Module/2.Semester" +
          "/PM2/pm2_vorgabe/src/main/resources/json/figuren.json"));
             StringWriter sw = new StringWriter()) {
            inFile.transferTo(sw);
            String contents = sw.toString();
            JSONObject o = new JSONObject(contents);
            JSONArray docs = o.getJSONArray("docs");
            return (JSONObject) docs.get(objectIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
