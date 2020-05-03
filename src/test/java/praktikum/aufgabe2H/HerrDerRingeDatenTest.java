package praktikum.aufgabe2H;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerrDerRingeDatenTest {

  @Test
  void herrDerRingeDatenShouldBeInstantiatable() {
    try {
      new HerrDerRingeDaten();
      assertTrue(true);
    } catch (Exception e) {
      assertFalse(false);
    }
  }
  @Test
  void findFigur() {
    HerrDerRingeDaten herrDerRingeDaten = new HerrDerRingeDaten();
    assertEquals("5cd99d4bde30eff6ebccfc15",herrDerRingeDaten.findFigur("Frodo Baggins").getId());
    assertNull(herrDerRingeDaten.findFigur("Frodo Bagginsssssssssssssssssssssss"));
  }
}