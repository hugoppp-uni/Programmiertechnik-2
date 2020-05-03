/*
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe2FkeineAbgabe;

/**
 * Typ für das Geschlecht: Männlich oder Weiblich
 */
public enum Geschlecht {

    MAENNLICH, WEIBLICH, UNDEFINED;

    /**
     * Liefert die Konstante für einen String. Liefert null, wenn keine passende Konstante gefunden wurde.
     */
    public static Geschlecht from(String text) {
        switch (text) {
            case "Male":
                return MAENNLICH;
            case "Female":
                return WEIBLICH;
            default:
                return null;
        }
    }
}
