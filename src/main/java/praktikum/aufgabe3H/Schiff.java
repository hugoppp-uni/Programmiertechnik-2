package praktikum.aufgabe3H;

public class Schiff extends ISimObjekt {
  private Zustand zustand;
  private final int kapazitat;
  private int beladung;
  private Ort ort;

  @Override
  public String getName() {
    return "Schiff";
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
    return Typ.SCHIFF;
  }

  public synchronized void setOrtAndNotifyAll(Ort ort) {
    this.ort = ort;
    this.notifyAll();
  }

  public Schiff(int kapazitat, int hafenDauer, int flussDauer) {
    Zustand z1 = new Zustand("Osthafen",
      hafenDauer,
      this,
      () -> setOrtAndNotifyAll(Ort.OSTHAFEN)
    );
    Zustand z2 = new Zustand("Im Fluss vom Osthafen zum Westhafen",
      flussDauer,
      this,
      () -> ort = Ort.FLUSS
    );
    Zustand z3 = new Zustand("Westhafen",
      hafenDauer,
      this,
      () -> setOrtAndNotifyAll(Ort.WESTHAFEN)
    );
    Zustand z4 = new Zustand("Im Fluss vom Westhafen zum Osthafen.",
      flussDauer,
      this,
      () -> ort = Ort.FLUSS
    );
    z1.setNachfolgeZustand(z2);
    z2.setNachfolgeZustand(z3);
    z3.setNachfolgeZustand(z4);
    z4.setNachfolgeZustand(z1);

    this.ort = Ort.OSTHAFEN;
    this.kapazitat = kapazitat;
    zustand = z1;
  }

  public Schiff(int kapazitat) {
    this(kapazitat, 10, 5);
  }

  /**
   * Increments beladung if schiff is not full and schiff and pirat have same
   * ort. Notifies all.
   * Waits otherwise.
   *
   * @param pirat Pirat to einschiffen.
   */
  public synchronized void einschiffen(Pirat pirat) {
    while (beladung >= kapazitat || ort != pirat.getOrt()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    beladung++;
   // notifyAll(); //TODO warum hier notify? Die Threads sind ja in Warteschleife
  }

  /**
   * Decrements beladung if pirat is AUF_SCHIFF and pirat.ort is ziel.
   * Notifies all.
   * Waits otherwise.
   *
   * @param pirat Pirat to ausschiffen.
   * @param ziel  Ziel of pirat.
   */
  public synchronized void ausschiffen(Pirat pirat, Ort ziel) {
    while (!(pirat.getOrt() == Ort.AUF_SCHIFF) || !(ort == ziel)) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    beladung--;
    notifyAll();
  }

  @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
  @Override
  public void run() {
    while (true) {
      zustand = (Zustand) zustand.tick();
      melden();
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
