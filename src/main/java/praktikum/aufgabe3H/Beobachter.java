/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3H;

/**
 * Ein Beobachter registriert sich als solcher bei einem
 */
public interface Beobachter {

  /**
   * Diese Methode wird aufgerufen, wenn der Beobachter über eine Änderung
   * informiert wird.
   *
   * @param payload Es können Informationen zu der Änderungen mitgegeben
   *                werden. Wenn keine
   *                Information mitgegeben wird, dann ist payload null.
   */
  void update(Object payload);
}
