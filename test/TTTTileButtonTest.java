import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTTileButtonTest {

    TTTTileButton button;
    TTTTileButton button2;

    @BeforeEach
    void setUp() {
        button = new TTTTileButton(0, 0);
        button2 = new TTTTileButton(0, 1);
    }

    @Test
    void testConstructor() {
        assertNotNull(button.getRow());
        assertNotNull(button.getCol());
        assertEquals(0, button.getRow());
        assertEquals(0, button.getCol());
    }

    @Test
    void testEquals() {
        assertTrue(button.equals(button));
        assertFalse(button.equals(button2));
    }

    @Test
    void testHashCode() {
        assertEquals(961, button.hashCode());
    }
}