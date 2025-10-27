import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToePnlTest {

    TicTacToePnl pnl;
    TicTacToePnl pnl2;
    TTTGame game;
    TTTGame game2;

    @BeforeEach
    void setUp() {
        game = new TTTGame();
        game2 = new TTTGame();
        pnl = new TicTacToePnl(game);
        pnl2 = new TicTacToePnl(game2);
    }

    @Test
    void testConstructor() {
        assertNotNull(pnl.getGame());
        assertSame(game, pnl.getGame());
        assertNotNull(pnl.getBoardGUI());
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                assertNotNull(pnl.getBoardGUI()[row][col]);
                assertEquals(row, pnl.getBoardGUI()[row][col].getRow());
                assertEquals(col, pnl.getBoardGUI()[row][col].getCol());
                assertEquals(" ", pnl.getBoardGUI()[row][col].getText());
            }
        }
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(3, rows);
        assertEquals(3, cols);
    }

    @Test
    void testEquals() {
        assertFalse(pnl.equals(pnl2));
        assertTrue(pnl.equals(pnl));
    }

    @Test
    void testHashCode() {
        assertEquals(1206238906, pnl.hashCode());
    }
}