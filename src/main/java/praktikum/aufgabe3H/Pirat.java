package praktikum.aufgabe3H;

@SuppressWarnings("CodeBlock2Expr")
public class Pirat extends ISimObjekt {
  private String name;
  private Schiff schiff;
  private Ort ort;
  private Zustand zustand;

  private Zustand z1 = new Zustand("Herumlaufen im Westland", 10, this, () -> {
    ort = Ort.WESTLAND;
  });
  private Zustand z2 = new Zustand("Einschiffen am Westhafen", 1, this, () -> {
    ort = Ort.WESTHAFEN;
    schiff.einschiffen(this);
  });
  private Zustand z3 = new Zustand("Übersetzen von West nach Ost", 1, this, () -> {
    ort = Ort.AUF_SCHIFF;
    schiff.ausschiffen(this, Ort.OSTHAFEN);
  });
  private Zustand z4 = new Zustand("Herumlaufen im Ostland", 10, this, () -> {
    ort = Ort.OSTLAND;
  });
  private Zustand z5 = new Zustand("Einschiffen am Osthafen", 1, this, () -> {
    ort = Ort.OSTHAFEN;
    schiff.einschiffen(this);
  });
  private Zustand z6 = new Zustand("Übersetzen von Ost nach West", 1, this, () -> {
    ort = Ort.AUF_SCHIFF;
    schiff.ausschiffen(this, Ort.WESTHAFEN);
  });


  public Pirat(Schiff schiff, String name) {
    this.name = name;
    this.schiff = schiff;
    ort = Ort.WESTLAND;
    this.zustand = z1;
    z1.setNachfolgeZustand(z2);
    z2.setNachfolgeZustand(z3);
    z3.setNachfolgeZustand(z4);
    z4.setNachfolgeZustand(z5);
    z5.setNachfolgeZustand(z6);
    z6.setNachfolgeZustand(z1);
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
}
