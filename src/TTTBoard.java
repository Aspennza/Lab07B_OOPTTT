public class TTTBoard
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private final String[][] board;

    public TTTBoard()
    {
        board = new String[ROW][COL];
        clearBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    public boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

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
}
