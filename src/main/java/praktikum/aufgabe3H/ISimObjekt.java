/*
  Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
  2 im Studiengang ITS
   der Hochschule
  für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3H;

/**
 * Ein Simulationsobjekt in der Piraten-Szenerie: Entweder ein Schiff oder
 * ein Pirat.
 */
public abstract class ISimObjekt extends Beobachteter implements Runnable {

  public IZustand zustand;

  /**
   * Liefert den Namen des Objektes für die Ausgabe.
   */
  public abstract String getName();

  /**
   * Liefert den Ort an dem sich das Simulationsobjekt gerade befindet.
   */
  public abstract Ort getOrt();

  /**
   * Liefert den aktuellen Zustand des Objektes.
   */
  public abstract IZustand getZustand();

  /**
   * Liefert den Typ des Objektes (u.a. für die grafische Ausgabe notwendig).
   */
  public abstract Typ getTyp();

  @SuppressWarnings({"BusyWait", "InfiniteLoopStatement"})
  @Override
  public void run() {
    while (true) {
      zustand = zustand.tick();
      try {
        melden();
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Typ für die Orte an denen sich die Simulationsobjekte befinden können.
   */
  public enum Ort {OSTLAND, FLUSS, WESTLAND, OSTHAFEN, AUF_SCHIFF, WESTHAFEN}

  /**
   * Zwei Typen von Simulationsobjekten sind möglich: Pirat und Schiff.
   */
  public enum Typ {PIRAT, SCHIFF}
}