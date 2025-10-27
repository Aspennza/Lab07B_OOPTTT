import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TitlePnlTest {

    TitlePnl pnl;
    TitlePnl pnl2;

    @BeforeEach
    void setUp() {
        pnl = new TitlePnl();
        pnl2 = new TitlePnl();
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getTitleLbl());
        assertNotNull(pnl.getTitleFont());
        assertEquals("Tic Tac Toe", pnl.getTitleLbl().getText());
        assertEquals("Serif", pnl.getTitleFont().getName());
        assertEquals(Font.BOLD, pnl.getTitleFont().getStyle());
        assertEquals(36, pnl.getTitleFont().getSize());
        assertSame(pnl.getTitleFont(), pnl.getTitleLbl().getFont());
    }

    @Test
    void testEquals() {
        assertFalse(pnl.equals(pnl2));
        assertTrue(pnl.equals(pnl));
    }

    @Test
    void testHashCode() {
        assertEquals(2009528314, pnl.hashCode());
    }
}