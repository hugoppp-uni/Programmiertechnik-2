package vorlesungsuebungen.vorlesung10.uebung2;

import java.util.regex.Pattern;

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
