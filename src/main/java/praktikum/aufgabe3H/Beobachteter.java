/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3H;

import java.util.HashSet;
import java.util.Set;

/**
 * Ein Beobachteter kann von beliebig vielen Beobachtern beobachtet werden.
 * Bei einer Änderung werden die Beobachter
 * informiert.
 */
public abstract class Beobachteter {

  /**
   * Menge der Beobachter
   */
  private Set<Beobachter> beobachter;

  public Beobachteter() {
    beobachter = new HashSet<>();
  }

  /**
   * Ein weiterer Beobachter registriert sich.
   */
  public void hinzufuegen(Beobachter beobachter) {
    this.beobachter.add(beobachter);
  }

  /**
   * Alle registrierten werden über eine Veränderung mit Zusatzinformation
   * informiert.
   */
  public void melden(Object payload) {
    beobachter.forEach(b -> b.update(payload));
  }

  /**
   * Alle registrierten werden über eine Veränderung ohne Zusatzinformation
   * informiert.
   */
  public void melden() {
    melden(null);
  }
}
