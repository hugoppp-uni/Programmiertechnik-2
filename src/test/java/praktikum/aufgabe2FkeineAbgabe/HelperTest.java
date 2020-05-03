package praktikum.aufgabe2FkeineAbgabe;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    public void testGetNumber() {
        assertEquals(1.06,
          Math.round(Helper.getNumber("1.06m (3'6\")") * 100.0)
            / 100.0);
        assertEquals(0.0, (float) Math.round(Helper
          .getNumber("3'6\"") * 100.0) / 100);
        assertEquals(1.06,
          Math.round(Helper.getNumber(Helper.getNumberNotNull(Objects
              .requireNonNull(Helper.jObjErzeugenFigur(892)),
            "height")) * 100.0) / 100.0);
    }

    @Test
    public void testGetNumberNotNull() {
        assertEquals("1.06m (3'6\")", Helper.getNumberNotNull(Objects
          .requireNonNull(Helper.jObjErzeugenFigur(892)), "height"));
        assertEquals("0", Helper
          .getNumberNotNull(Helper.jObjErzeugenFigur(0), "height"));
        assertEquals("0", Helper
          .getNumberNotNull(Helper.jObjErzeugenFigur(337), "height"));
    }

    @Test
    public void testGetNotNull() {
        assertNull(Helper.getNotNull(Helper.jObjErzeugenFigur(337),
          "hair")); //0, 337
        assertNull(Helper.getNotNull(Helper.jObjErzeugenFigur(0),
          "hair"));
        assertNotNull(Helper.getNotNull(Objects.requireNonNull(Helper
          .jObjErzeugenFigur(224)), "hair")); //224
    }

    @Test
    public void testJObjErzeugen() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("_id", "5cd99d4bde30eff6ebccfc15").put("height", "1" +
          ".06m (3'6\")").put("race", "Hobbit").put("gender", "Male").put(
          "birth", "22 September ,TA 2968").put("spouse", "").put("death",
          "Unknown (Last sighting ,September 29 ,3021,) (,SR 1421,)").put(
          "realm", "").put("hair", "Brown").put("name", "Frodo Baggins").put(
          "wikiUrl", "http://lotr.wikia.com//wiki/Frodo_Baggins");
        assertEquals(jsonObject.get("name").toString(),
          Helper.jObjErzeugenFigur(892).get("name").toString());
        assertThrows(IndexOutOfBoundsException.class,
          () -> Helper.jObjErzeugenFigur(933));
    }
}