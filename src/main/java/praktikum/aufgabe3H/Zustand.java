package praktikum.aufgabe3H;

public class Zustand implements IZustand {
  private final String name;
  private final int dauer;
  private final Runnable onReset;
  private final ISimObjekt simObject;

  private int zeitImZustand;
  private Zustand nachfolgeZustand;

  @Override
  public float getFortschritt() {
    return zeitImZustand / (float) dauer;
  }

  public void setNachfolgeZustand(IZustand nachfolgeZustand) {
    this.nachfolgeZustand = (Zustand)nachfolgeZustand;
  }

  public Zustand(
    String name, int dauer, ISimObjekt simObject, Runnable onReset
  ) {
    this.name = name;
    this.dauer = dauer;
    this.simObject = simObject;
    this.onReset = onReset;
  }

  @Override
  public IZustand tick() {
    if (++zeitImZustand < dauer) {
      return this;
    } else {
      nachfolgeZustand.reset();
      return nachfolgeZustand;
    }
  }

  @Override
  public void reset() {
    zeitImZustand = 0;
    onReset.run();
  }

  @Override
  public String toString() {
    return name;
  }
}
