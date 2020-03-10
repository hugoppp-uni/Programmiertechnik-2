/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung11.uebungen;

/**
 * Ein Bruch besteht aus einem Zähler und einem Nenner.
 */
public class Bruch {

    /**
     * Zähler.
     */
    private int zaehler;

    /**
     * Nenner.
     */
    private int nenner;

    /**
     * Initialisierung des Zustandes des Bruches (der Objektvariablen).
     */
    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    /**
     * Initialisierung des Zustandes des Bruches (der Objektvariablen) auf einen
     * konkrete (ganzzahligen) Wert.
     */
    public Bruch(int wert) {
        this.zaehler = wert;
        this.nenner = 1;
    }

    /**
     * Beschreibung des Objektzustands auf der Konsole ausgeben.
     */
    @Override
    public String toString() {
        return String.format("%d/%d\n", zaehler, nenner);
    }

    /**
     * Vereinfache den Bruch soweit möglich (durch Division durch den GGT).
     */
    public void vereinfache() {
        int gcd = berechneGgt(zaehler, nenner);
        zaehler /= gcd;
        nenner /= gcd;
    }

    /**
     * Erweiterung des Bruches um einen Faktor (Multiplikation von Zaehler und
     * Nenner).
     */
    public void erweitere(int faktor) {
        zaehler *= 2;
        nenner *= 2;
    }

    /**
     * Berechnet den GGT (größten gemeinsamen Teiler) zweier Zahlen mit dem
     * Algorithmus von Euklid. Liefert das Ergebnis zurück.
     */
    public static int berechneGgt(int zahl1, int zahl2) {
        // Sicherstellung, dass beide Zahlen positiv sind
        zahl1 = Math.abs(zahl1);
        zahl2 = Math.abs(zahl2);

        // Algorithmus von Euklid
        int ergebnis = 0;
        if (zahl1 == 0) {
            ergebnis = zahl2;
        } else {
            while (zahl2 != 0) {
                if (zahl1 > zahl2) {
                    zahl1 = zahl1 - zahl2;
                } else {
                    zahl2 = zahl2 - zahl1;
                }
            }
            ergebnis = zahl1;
        }
        return ergebnis;
    }

    /**
     * Addiere zweiten Bruch zum this-Objekt, speichere Ergebnis im this-Objekt.
     */
    public void addiereDazu(Bruch andererBruch) {
        zaehler = zaehler * andererBruch.nenner + andererBruch.zaehler * nenner;
        nenner = nenner * andererBruch.nenner;
        vereinfache();
    }

    /**
     * Liefert den (Fließkomma-)Wert des Bruches.
     */
    public double getWert() {
        return (double) zaehler / (double) nenner;
    }

    /**
     * Verdoppelt den Wert des Bruchs (Verdeopplung des Zählers).
     */
    public void verdopple() {
        zaehler *= 2;
    }

    /**
     * Subtrahiere zweiten Bruch vom this-Objekt, speichere Ergebnis im
     * this-Objekt.
     */
    public void subtrahiereDavon(Bruch andererBruch) {
        zaehler = zaehler * andererBruch.nenner - andererBruch.zaehler * nenner;
        nenner = nenner * andererBruch.nenner;
        vereinfache();
    }

    /**
     * Prädikat, das wahr liefert, wenn der Bruch einen kleinern Wert hat, als der
     * Bruch, der sich aus den Parametern ergibt.
     */
    public boolean istKleiner(int zaehler, int nenner) {
        return getWert() < (double) zaehler / (double) nenner;
    }

    /**
     * Prädikat, das wahr liefert, wenn der Bruch einen kleineren Wert hat, als
     * die Parameter-Zahl.
     */
    public boolean istKleiner(int zahl) {
        return istKleiner(zahl, 1);
    }

}
