import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ControlPnlTest {

    ControlPnl pnl;
    ControlPnl pnl2;
    TTTGame game;
    TTTGame game2;

    @BeforeEach
    void setUp() {
        game = new TTTGame();
        game2 = new TTTGame();
        pnl = new ControlPnl(game);
        pnl2 = new ControlPnl(game2);
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getGame());
        assertSame(game, pnl.getGame());
        assertNotNull(pnl.getClearBtn());
        assertEquals("Play Again", pnl.getClearBtn().getText());
        assertNotNull(pnl.getQuitBtn());
        assertEquals("Quit", pnl.getQuitBtn().getText());
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(1, rows);
        assertEquals(2, cols);
    }

    @Test
    void testEquals() {
        assertFalse(pnl.equals(pnl2));
        assertTrue(pnl.equals(pnl));
    }

    @Test
    void testHashCode() {
        assertEquals(-1505291823, pnl.hashCode());
    }
}