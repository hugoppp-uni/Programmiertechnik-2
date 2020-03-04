package praktikum.aufgabe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die PM2Map-implementierung.
 */
public class TestMap {

    /**
     * Mit dieser Map wird getestet. Sie wird für jeden Test neu in der init()-Methode initialisiert.
     */
    private Map<Integer, String> testMap;

    @BeforeEach
    public void init() {
        // Achtung: hier müssen Sie Ihre Implementierung instanziieren.
        testMap = new HashMap<>();
        //testMap = new PM2Map<>();
    }

    @Test
    public void testSize() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testIsEmpty() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testContainsKey() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testContainsValue() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testGet() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testPut() {
        // TODO
        assertTrue(true);
    }

    @Test
    public void testRemove() {
        assertNull(testMap.remove(23));
        testMap.put(23, "23");
        assertEquals("23", testMap.remove(23));
        assertEquals(0, testMap.size());
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        assertEquals("42", testMap.remove(42));
        assertEquals(2, testMap.size());
        assertTrue(testMap.containsKey(23));
        assertTrue(testMap.containsKey(12));
        assertNull(testMap.remove(42));
        assertEquals("12", testMap.remove(12));
        assertEquals("23", testMap.remove(23));
        assertEquals(0, testMap.size());
    }

    @Test
    public void testPutAll() {
        Map<Integer, String> map = new HashMap<>();
        map.put(23, "23");
        map.put(42, "42");
        map.put(12, "12");
        testMap.putAll(map);
        assertEquals(3, testMap.size());
        assertTrue(testMap.containsKey(23));
        assertTrue(testMap.containsKey(42));
        assertTrue(testMap.containsKey(12));
        assertEquals("42", testMap.get(42));
    }

    @Test
    public void testClear() {
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        testMap.clear();
        assertEquals(0, testMap.size());
    }

    @Test
    public void testKeySet() {
        var schluessel = testMap.keySet();
        assertEquals(0, schluessel.size());
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        schluessel = testMap.keySet();
        assertEquals(3, schluessel.size());
        assertTrue(schluessel.contains(23));
        assertTrue(schluessel.contains(42));
        assertTrue(schluessel.contains(12));
    }

    @Test
    public void testValues() {
        var werteListe = testMap.values();
        assertEquals(0, werteListe.size());
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        werteListe = testMap.values();
        assertEquals(3, werteListe.size());
        assertTrue(werteListe.contains("23"));
        assertTrue(werteListe.contains("42"));
        assertTrue(werteListe.contains("12"));
    }

    @Test
    public void testEntrySet() {
        var eintraege = testMap.entrySet();
        assertEquals(0, eintraege.size());
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        eintraege = testMap.entrySet();
        assertEquals(3, eintraege.size());
        for (Map.Entry<Integer, String> eintrag: eintraege) {
            assertTrue(eintrag.getKey().equals(23) || eintrag.getKey().equals(42) ||
                    eintrag.getKey().equals(12));
            assertTrue(eintrag.getValue().equals("23") || eintrag.getValue().equals("42") ||
                    eintrag.getValue().equals("12"));
        }
    }
}
