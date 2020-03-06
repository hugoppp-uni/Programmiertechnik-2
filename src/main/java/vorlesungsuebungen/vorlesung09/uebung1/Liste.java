/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angwandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung09.uebung1;

/**
 * Repräsentation einer Liste von T-Objekten:
 *
 * @author Philipp Jenke
 */
public class Liste<T> {

    /**
     * Daten in einem Array
     */
    private Object[] daten = new Object[0];

    /**
     * Neues Element anfügen.
     */
    public void add(T element) {
        Object[] tmp = new Object[daten.length + 1];
        System.arraycopy(daten, 0, tmp, 0, daten.length);
        daten = tmp;
        daten[daten.length - 1] = element;
    }

    /**
     * Element an der Stelle 'index' zurückgeben.
     */
    @SuppressWarnings("unchecked")
    public T getElement(int index) {
        if (index >= daten.length) {
            throw new IndexOutOfBoundsException();
        }
        return (T) daten[index];
    }

    /**
     * Liefert die Anzahl der Elemente in der Liste.
     */
    public int size() {
        return daten.length;
    }
}
