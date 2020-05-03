package praktikum.aufgabe2H;

import java.util.Comparator;

/**
 * Vergleicht Figuren anhand der Groesse
 */
public class FigurComparator implements Comparator<Figur> {
  @Override
  public int compare(Figur o1, Figur o2) {
    return Float.compare(o1.getGroesse(), o2.getGroesse());
  }
}
