package praktikum.aufgabe2;

/**
 * Typ für das Geschlecht: Männlich oder Weiblich
 */
public enum Geschlecht {

    MAENNLICH, WEIBLICH;

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
