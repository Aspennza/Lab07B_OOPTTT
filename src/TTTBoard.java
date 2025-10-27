import java.util.Arrays;
import java.util.Objects;

/**
 * Allows the creation of objects representing the logic of a Tic Tac Toe board.
 * Contains rows, columns, and the final String array. Also includes methods for acting on,
 * updating, and comparing TTTBoard objects.
 */
public class TTTBoard
{
    //This int permanently stores the number of rows in a Tic Tac Toe board
    private static final int ROW = 3;

    //This int permanently stores the number of columns in a Tic Tac Toe board
    private static final int COL = 3;

    //This String array represents the 3 by 3 board used for Tic Tac Toe
    private String[][] board;

    //This constructor establishes the board and fills it with empty spaces
    public TTTBoard()
    {
        board = new String[ROW][COL];
        clearBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    /**
     * Checks whether a space on the board is empty, then returns true (empty) or false (full).
     * @param row the player's chosen row for their move
     * @param col the player's chosen column for their move
     * @return a boolean value representing whether the space is open or not
     */
    public boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    /**
     * Sets the player's chosen space on the board to their character (X or O).
     * @param row the player's chosen row for their move
     * @param col the player's chosen column for their move
     * @param player the player's character (X or O)
     */
    public void setCellText(int row, int col, String player)
    {
        board[row][col] = player;
    }

    /**
     * Sets all indices in the board array to a String with a single space.
     */
    public void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TTTBoard tttBoard = (TTTBoard) o;
        return Objects.deepEquals(board, tttBoard.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
