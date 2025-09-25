
package org.example.Attributes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testPredefinedColors() {
        assertNotNull(Color.WHITE, "Color.WHITE sollte nicht null sein.");
        assertNotNull(Color.BLACK, "Color.BLACK sollte nicht null sein.");
        assertEquals("white", Color.WHITE.getColorName());
        assertEquals("black", Color.BLACK.getColorName());
    }

    @Test
    void testEqualsAndHashCode() {
        Color white1 = new Color(new Hex("FFFFFF"), "white");
        Color white2 = Color.WHITE;
        Color black = Color.BLACK;

        assertEquals(white1, white2, "Farben mit demselben Namen sollten gleich sein.");
        assertNotEquals(white1, black, "Unterschiedliche Farben sollten nicht gleich sein.");
        assertEquals(white1.hashCode(), white2.hashCode(), "HashCodes von gleichen Farben sollten identisch sein.");
    }
    @Test
    void getColorName() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}