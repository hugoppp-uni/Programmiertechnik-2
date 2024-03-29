/*
  Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2
  im Studiengang ITS der Hochschule für Angewandte Wissenschaften Hamburg von
  Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe1.F;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die PM2Map-implementierung.
 */
public class TestMap {

    /**
     * Mit dieser Map wird getestet. Sie wird für jeden Test neu in der init()
     * -Methode initialisiert.
     */
    private Map<Integer, String> testMap;

    @BeforeEach
    public void init() {
        // Achtung: hier müssen Sie Ihre Implementierung instanziieren.
        //testMap = new HashMap<>();
        testMap = new PM2Map<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, testMap.size());

        testMap.put(1, "Hello");
        assertEquals(1, testMap.size());

        testMap.put(1, "Hello");
        assertEquals(1, testMap.size());

        testMap.put(2, "Nihao");
        testMap.put(3, "Konnichiha");
        assertEquals(3, testMap.size());

        testMap.remove(1, "Hello");
        assertEquals(2, testMap.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testMap.isEmpty());
        testMap.put(23, "23");
        assertFalse(testMap.isEmpty());
        testMap.remove(23);
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void testContainsKey() {
        assertFalse(testMap.containsKey(23));
        testMap.put(23, "23");
        assertTrue(testMap.containsKey(23));
        testMap.remove(23);
        assertFalse(testMap.containsKey(23));
    }

    @Test
    public void testContainsValue() {
        assertFalse(testMap.containsValue("23"));
        testMap.put(23, "23");
        assertTrue(testMap.containsValue("23"));
        testMap.remove(23);
        assertFalse(testMap.containsValue("23"));
        testMap.put(24, "23");
        assertTrue(testMap.containsValue("23"));
        testMap.put(24, "24");
        assertFalse(testMap.containsValue("23"));
    }

    @Test
    public void testGet() {
        assertNull(testMap.get(23));
        testMap.put(23, "23");
        assertNotNull(testMap.get(23));
        assertEquals("23", testMap.get(23));
    }

    @Test
    public void testPut() {
        assertNull(testMap.put(2, "Hello"));
        assertEquals("Hello", testMap.get(2));

        assertEquals("Hello", testMap.put(2, "Moin"));
        assertEquals("Moin", testMap.get(2));
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
        var entrySet = testMap.entrySet();
        assertEquals(0, entrySet.size());
        testMap.put(23, "23");
        testMap.put(42, "42");
        testMap.put(12, "12");
        entrySet = testMap.entrySet();
        assertEquals(3, entrySet.size());
        for (Map.Entry<Integer, String> eintrag : entrySet) {
            assertTrue(
              eintrag.getKey().equals(23) || eintrag.getKey().equals(42) ||
              eintrag.getKey().equals(12));
            assertTrue(eintrag.getValue().equals("23") ||
                       eintrag.getValue().equals("42") ||
                       eintrag.getValue().equals("12"));
        }
    }

    public static void main(String[] args) {
        PM2Map<String, String> map = new PM2Map<>();

        map.put("eins", "1");
        map.put("zwei", "2");

        System.out.println(map);
    }
}
