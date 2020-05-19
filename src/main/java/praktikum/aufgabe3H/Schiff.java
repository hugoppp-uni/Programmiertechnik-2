package praktikum.aufgabe3H;

public class Schiff extends ISimObjekt {
  private Zustand zustand;
  private final int kapazitat;
  private int beladung;
  private Ort ort;

  private Zustand z1 = new Zustand(
      "Osthafen", 10, this, () -> setOrt(Ort.OSTHAFEN));
  private Zustand z2 = new Zustand(
      "Im Fluss vom Osthafen zum Westhafen", 5, this, () -> setOrt(Ort.FLUSS));
  private Zustand z3 = new Zustand(
      "Westhafen", 10, this, () -> setOrt(Ort.WESTHAFEN));
  private Zustand z4 = new Zustand(
      "Im Fluss vom Westhafen zum Osthafen.", 5, this, () -> setOrt(Ort.FLUSS));


  public Schiff(int kapazitat) {
    this.ort = Ort.OSTHAFEN;
    this.kapazitat = kapazitat;
    zustand = z1;
    z1.setNachfolgeZustand(z2);
    z2.setNachfolgeZustand(z3);
    z3.setNachfolgeZustand(z4);
    z4.setNachfolgeZustand(z1);
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

  @Override
  public String getName() {
    return "Schiff";
  }

  @Override
  public Ort getOrt() {
    return ort;
  }

  public synchronized void setOrt(Ort ort) {
    this.ort = ort;
    this.notifyAll();
  }

  @Override
  public IZustand getZustand() {
    return zustand;
  }

  @Override
  public Typ getTyp() {
    return Typ.SCHIFF;
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
