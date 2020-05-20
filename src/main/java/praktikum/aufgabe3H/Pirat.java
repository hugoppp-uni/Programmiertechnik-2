package praktikum.aufgabe3H;

import java.util.concurrent.ThreadLocalRandom;

public class Pirat extends ISimObjekt {
  private final String name;
  private Schiff schiff;
  private Ort ort;
  private Zustand zustand;

  private static int rumlaufDauerMin = 3;

  private static int rumlaufDauerMax = 20;

  public static void setRumlaufDauerMin(int rumlaufDauerMin) {
    Pirat.rumlaufDauerMin = rumlaufDauerMin;
  }

  public static void setRumlaufDauerMax(int rumlaufDauerMax) {
    Pirat.rumlaufDauerMax = rumlaufDauerMax;
  }

  public Pirat(Schiff schiff, String name, Ort startOrt) {
    if (startOrt!= Ort.OSTLAND &&  startOrt != Ort.WESTLAND)
      throw new IllegalArgumentException(
        "Pirat muss im Ost- oder Westland starten");
    Zustand z1 = new Zustand("Herumlaufen im Westland",
      getRandom(rumlaufDauerMin, rumlaufDauerMax),
      this,
      () -> ort = Ort.WESTLAND
    );
    Zustand z2 = new Zustand("Einschiffen am Westhafen", 1, this, () -> {
      ort = Ort.WESTHAFEN;
      schiff.einschiffen(this);
    });
    Zustand z3 = new Zustand("Übersetzen von West nach Ost", 1, this, () -> {
      ort = Ort.AUF_SCHIFF;
      schiff.ausschiffen(this, Ort.OSTHAFEN);
    });
    Zustand z4 = new Zustand("Herumlaufen im Ostland",
      getRandom(rumlaufDauerMin, rumlaufDauerMax),
      this,
      () -> ort = Ort.OSTLAND
    );
    Zustand z5 = new Zustand("Einschiffen am Osthafen", 1, this, () -> {
      ort = Ort.OSTHAFEN;
      schiff.einschiffen(this);
    });
    Zustand z6 = new Zustand("Übersetzen von Ost nach West", 1, this, () -> {
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

  @SuppressWarnings({"BusyWait", "InfiniteLoopStatement"})
  @Override
  public void run() {
    while (true) {
      zustand = (Zustand) zustand.tick();
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
        melden();
      }
    }
  }

  private int getRandom(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
}
