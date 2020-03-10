/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung10.uebung2;

/**
 * Prüfklasse für URL mit der DE-Domäne
 */
public class DeUrlTester {

    /**
     * Regulärer Ausdruck für DE-URLs
     */
    private static final String regex = "https://www\\.[\\w\\d_]*\\.de";

    // Hier Methode einfügen


    public static void main(String[] args) {
        DeUrlTester tester = new DeUrlTester();
        // System.out.println(tester.istDeUrl("https://www.heise.de"));
        // System.out.println(tester.istDeUrl("www.heise.de"));
        // System.out.println(tester.istDeUrl("https://www.123_in_den_urlaub.de"));
        // System.out.println(tester.istDeUrl("https://www.123_in_den_urlaub?.de"));
    }
}
