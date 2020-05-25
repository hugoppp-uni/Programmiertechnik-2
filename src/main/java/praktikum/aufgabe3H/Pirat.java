package praktikum.aufgabe3H;

import java.util.concurrent.ThreadLocalRandom;

public class Pirat extends ISimObjekt {
  private static int rumlaufDauerMin = 3;
  private static int rumlaufDauerMax = 20;
  private final String name;
  // private IZustand zustand;
  private final Schiff schiff;
  private Ort ort;

  /**
   * Erstellt einen Piraten.
   *
   * @param schiff   Referenz auf das Schiff
   * @param name     Name
   * @param startOrt Startort des Piraten. Muss
   *                 {@link praktikum.aufgabe3H.ISimObjekt.Ort#WESTLAND} oder
   *                 {@link praktikum.aufgabe3H.ISimObjekt.Ort#OSTLAND} sein.
   */
  public Pirat(Schiff schiff, String name, Ort startOrt) {
    if (startOrt != Ort.OSTLAND && startOrt != Ort.WESTLAND)
      throw new IllegalArgumentException("Pirat muss im Ost- oder Westland starten");
    IZustand z1 =
      new Zustand("Herumlaufen im Westland", generateRandom(rumlaufDauerMin, rumlaufDauerMax), this,
        () -> ort = Ort.WESTLAND
      );
    IZustand z2 = new Zustand("Einschiffen am Westhafen", 1, this, () -> {
      ort = Ort.WESTHAFEN;
      schiff.einschiffen(this);
    });
    IZustand z3 = new Zustand("Übersetzen von West nach Ost", 1, this, () -> {
      ort = Ort.AUF_SCHIFF;
      schiff.ausschiffen(this, Ort.OSTHAFEN);
    });
    IZustand z4 =
      new Zustand("Herumlaufen im Ostland", generateRandom(rumlaufDauerMin, rumlaufDauerMax), this,
        () -> ort = Ort.OSTLAND
      );
    IZustand z5 = new Zustand("Einschiffen am Osthafen", 1, this, () -> {
      ort = Ort.OSTHAFEN;
      schiff.einschiffen(this);
    });
    IZustand z6 = new Zustand("Übersetzen von Ost nach West", 1, this, () -> {
      ort = Ort.AUF_SCHIFF;
      schiff.ausschiffen(this, Ort.WESTHAFEN);
    });
    z1.setNachfolgeZustand(z2);
    z2.setNachfolgeZustand(z3);
    z3.setNachfolgeZustand(z4);
    z4.setNachfolgeZustand(z5);
    z5.setNachfolgeZustand(z6);
    z6.setNachfolgeZustand(z1);
    this.name = name;
    this.schiff = schiff;
    if (startOrt == Ort.WESTLAND) {
      this.zustand = z1;
      this.ort = Ort.WESTLAND;
    } else {
      this.zustand = z4;
      this.ort = Ort.OSTLAND;
    }
  }

  /**
   * Sets the minimum amount of ticks a pirat will spend in Ost- / Westland.
   *
   * @param rumlaufDauerMin Amount of time in ticks.
   */
  public static void setRumlaufDauerMin(int rumlaufDauerMin) {
    Pirat.rumlaufDauerMin = rumlaufDauerMin;
  }

  /**
   * Sets the maximal amount of ticks a pirat will spend in Ost- / Westland.
   *
   * @param rumlaufDauerMax Amount of time in ticks.
   */
  public static void setRumlaufDauerMax(int rumlaufDauerMax) {
    Pirat.rumlaufDauerMax = rumlaufDauerMax;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Ort getOrt() {
    return ort;
  }

  @Override
  public IZustand getZustand() {
    return zustand;
  }

  @Override
  public Typ getTyp() {
    return Typ.PIRAT;
  }


  //moved into super
  //  @SuppressWarnings({"BusyWait", "InfiniteLoopStatement"})
  //  @Override
  //  public void run() {
  //    while (true) {
  //      zustand =  zustand.tick();
  //      try {
  //        Thread.sleep(300);
  //      } catch (InterruptedException e) {
  //        e.printStackTrace();
  //        melden();
  //      }
  //    }
  //  }

  private int generateRandom(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
}
