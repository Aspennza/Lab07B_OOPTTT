import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTBoardTest {

    TTTBoard board;
    TTTBoard board2;

    @BeforeEach
    void setUp() {
        board = new TTTBoard();
        board2 = new TTTBoard();
    }

    @Test
    void testConstructor() {
        assertNotNull(board.getBoard());
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                assertEquals(" ", board.getBoard()[row][col]);
            }
        }
    }

    @Test
    void isValidMove() {
        board.setCellText(1, 1, "X");
        assertTrue(board.isValidMove(0, 0));
        assertFalse(board.isValidMove(1, 1));
    }

    @Test
    void setCellText() {
        board.setCellText(0, 0, "X");
        assertEquals("X", board.getBoard()[0][0]);
        assertEquals(" ", board.getBoard()[1][1]);
    }

    @Test
    void clearBoard() {
        board.setCellText(0, 0, "X");
        board.clearBoard();
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                assertEquals(" ", board.getBoard()[row][col]);
            }
        }
    }

    @Test
    void testEquals() {
        assertTrue(board.equals(board));
        assertTrue(board.equals(board2));
    }

    @Test
    void testHashCode() {
        assertEquals(61165822, board.hashCode());
    }
}