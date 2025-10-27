import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TTTGameTest {

    TTTGame game;
    TTTGame game2;

    @BeforeEach
    void setUp() {
        game = new TTTGame();
        game2 = new TTTGame();
    }

    @Test
    void constructorTest()
    {
        assertEquals("X", game.getPlayer());
        assertTrue(game.isPlaying());
        assertEquals(0, game.getMoveCnt());
        assertNull(game.getFrame());
        assertNull(game.getBoard());
        assertNull(game.getTitlePnl());
        assertNull(game.getTicTacToePnl());
        assertNull(game.getControlPnl());
    }

    @Test
    void startGame() {
        game.startGame();
        game.getFrame().setVisible(false);
        assertNotNull(game.getFrame());
        assertNotNull(game.getBoard());
        assertTrue(game.isPlaying());
    }

    @Test
    void generateFrame()
    {
        game.generateFrame();
        game.getFrame().setVisible(false);
        assertNotNull(game.getFrame());
        assertEquals("Tic Tac Toe", game.getFrame().getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE, game.getFrame().getDefaultCloseOperation());
        assertNotNull(game.getTitlePnl());
        assertNotNull(game.getTicTacToePnl());
        assertNotNull(game.getControlPnl());
    }

    @Test
    void setFrameButton() {
        game.startGame();
        game.getFrame().setVisible(false);
        game.setFrameButton(0, 0);
        assertEquals("X", game.getTicTacToePnl().getBoardGUI()[0][0].getText());
        assertEquals(" ", game.getTicTacToePnl().getBoardGUI()[0][1].getText());
    }

    @Test
    void clearBoard() {
        game.startGame();
        game.getFrame().setVisible(false);
        game.clearBoard();
        assertEquals(" ", game.getTicTacToePnl().getBoardGUI()[0][0].getText());
        assertEquals(" ", game.getBoard().getBoard()[0][0]);
        assertTrue(game.isPlaying());
        assertEquals("X", game.getPlayer());
    }

    @Test
    void testEquals()
    {
        assertTrue(game.equals(game2));
    }

    @Test
    void testHashCode()
    {
        assertEquals(1236000888, game.hashCode());
    }
}