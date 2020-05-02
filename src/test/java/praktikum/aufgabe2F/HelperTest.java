package praktikum.aufgabe2F;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static praktikum.aufgabe2F.Helper.*;

class HelperTest {

    @Test
    public void testGetNumber() {
        assertEquals(1.06,
          Math.round(getNumber("1.06m (3'6\")") * 100.0) / 100.0);
        assertEquals(1.06,
          Math.round(getNumber(getNumberNotNull(jObjErzeugen(),
            "height"))*100.0)/100.0);
    }

    @Test
    public void testGetNotNull() {
        //assertNull(Helper.getNotNull(jObjErzeugen(), "height")); //0, 337
        assertNotNull(getNotNull(jObjErzeugen(), "height")); //242
    }

    @Test
    public void testGetNumberNotNull() {
        assertEquals("1.06m (3'6\")", getNumberNotNull(jObjErzeugen(),
          "height"));
    }
}