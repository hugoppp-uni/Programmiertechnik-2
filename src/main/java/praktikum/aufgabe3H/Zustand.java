package praktikum.aufgabe3H;

public class Zustand implements IZustand {
  private String name;
  private int dauer;
  private int zeitImZustand;
  private Zustand nachfolgeZustand;
  private ISimObjekt simObject;
  private Runnable onReset;

  @Override
  public float getFortschritt() {
    return zeitImZustand/(float)dauer;
  }

  public Zustand(String name, int dauer, ISimObjekt simObject, Runnable onReset) {
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

  public void setNachfolgeZustand(Zustand nachfolgeZustand) {
    this.nachfolgeZustand = nachfolgeZustand;
  }
}
