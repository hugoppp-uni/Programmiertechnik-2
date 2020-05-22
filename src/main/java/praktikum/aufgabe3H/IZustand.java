/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3H;

/**
 * Schnittstelle für die Implementierung des Zustands.
 */
public interface IZustand {
  /**
   * Liefert den aktuellen Fortschritt innerhalb des Zustandes.
   */
  float getFortschritt();

  /**
   * Führt den Zustand einen Schritt weiter.
   */
  IZustand tick();

  /**
   * Setzt den Zustand zurück auf den Anfangszustand.
   */
  void reset();

  /**
   * Setzt den Nachfolgezustand.
   *
   * @param nachfolgeZustand Nachfolgezustand
   */
  void setNachfolgeZustand(IZustand nachfolgeZustand);
}
