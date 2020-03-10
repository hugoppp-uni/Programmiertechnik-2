/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung08.uebung5;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Hier die Übung 8.5 bearbeiten
 */
public class Rechnung {
    // Variable, die Property repräsentiert
    private DoubleProperty betrag = new SimpleDoubleProperty();

    // Lesender Zugriff: Getter
    public final double getBetrag() {
        return betrag.get();
    }

    // Schreibender Zugriff: Setter
    public final void setBetrag(double value) {
        betrag.set(value);
    }

    // Zugriff auf Property-Objekt
    public DoubleProperty betragProperty() {
        return betrag;
    }

    public static void main(String[] args) {
        Rechnung rechnung = new Rechnung();
        rechnung.setBetrag(23.42);
    }
}
