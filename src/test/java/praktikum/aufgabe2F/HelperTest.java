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
        assertNotNull(Helper.getNumber("Unknown (book) 1.66m (5'5\\\") " +
          "(film)"));
        assertEquals("1.66", Helper.getNumber("Unknown (book) 1.66m " +
          "(5'5\\\") (film)"));
    }

    @Test
    public void testGetNotNull(){
        //assertNull(Helper.getNotNull(jObjErzeugen(), "height")); //0, 337
        assertNotNull(getNotNull(jObjErzeugen(), "height")); //242
    }
}