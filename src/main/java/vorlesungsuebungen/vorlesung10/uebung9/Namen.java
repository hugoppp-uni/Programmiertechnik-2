/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung10.uebung9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extrahiert Vor- und Nachname aus Namens-Strings.
 */
public class Namen {

    // Hier Methode einfügen
    private void vorUndNachnameExtrahieren(String name) {
        String regex = "(?<vorname>[A-Z][a-z]+)\\s(?<nachname>[A-Z][a-z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            System.out.println("Vorname: " + matcher.group("vorname"));
            System.out.println("Nachname: " + matcher.group("nachname"));
        } else {
            System.out.println("Keine gültige eingabe: " + name);
        }
    }

    public static void main(String[] args) {
        Namen tester = new Namen();
        tester.vorUndNachnameExtrahieren("Mike Hansen");
        tester.vorUndNachnameExtrahieren("Sue Allen");
    }
}
