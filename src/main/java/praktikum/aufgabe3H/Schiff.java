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

  public synchronized void setOrt(Ort ort) {
    this.ort = ort;
    this.notifyAll();
  }

  public Schiff(int kapazitat, int hafenDauer, int flussDauer) {
    Zustand z1 = new Zustand(
      "Osthafen",
      hafenDauer,
      this,
      () -> setOrt(Ort.OSTHAFEN)
    );
    Zustand z2 = new Zustand(
      "Im Fluss vom Osthafen zum Westhafen",
      flussDauer,
      this,
      () -> setOrt(Ort.FLUSS)
    );
    Zustand z3 = new Zustand(
      "Westhafen",
      hafenDauer,
      this,
      () -> setOrt(Ort.WESTHAFEN)
    );
    Zustand z4 = new Zustand(
      "Im Fluss vom Westhafen zum Osthafen.",
      flussDauer,
      this,
      () -> setOrt(Ort.FLUSS)
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

  public synchronized void einschiffen(Pirat pirat) {
    while (beladung >= kapazitat || ort != pirat.getOrt()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    beladung++;
    notifyAll();
  }

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
