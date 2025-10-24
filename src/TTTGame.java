import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

//CONTINUE TRANSFERRING OLD METHODS TO TTTGAME STARTING WITH ISDIAGONALWIN

public class TTTGame
{
    //An int for setting the permanent row count of the board array
    private static final int ROW = 3;
    //An int for setting the permanent column count of the board array
    private static final int COL = 3;
    private static String player;
    private static JFrame frame;
    private static TTTBoard board;
    private static int moveCnt;
    private static final int MOVES_FOR_WIN = 5;
    private static final int MOVES_FOR_TIE = 7;
    private static boolean playing;

    public static void main(String[] args)
    {
        frame = new JFrame();
        generateFrame();
        board = new TTTBoard();
    }

    /**
     * A method for checking if the current player has achieved a win.
     * @param player the current player (X or O)
     * @return a boolean representing whether a win was achieved
     */
    private static boolean isWin(String player)
    {
        //An algorithm for running through possible win conditions
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }

        return false;
    }

    /**
     * A method for checking whether the current player has achieved a column win.
     * @param player the current player (X or O)
     * @return a boolean representing whether a column win was achieved
     */
    private static boolean isColWin(String player)
    {
        // checks for a col win for specified player
        for(int col=0; col < COL; col++)
        {
            if(board.getBoard()[0][col].equals(player) &&
                    board.getBoard()[1][col].equals(player) &&
                    board.getBoard()[2][col].equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }

    /**
     * A method for checking if the current player has achieved a row win.
     * @param player the current player (X or O)
     * @return a boolean representing whether a row win was achieved
     */
    private static boolean isRowWin(String player)
    {
        // checks for a row win for the specified player
        for(int row=0; row < ROW; row++)
        {
            if(board.getBoard()[row][0].equals(player) &&
                    board.getBoard()[row][1].equals(player) &&
                    board.getBoard()[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }

    public static void generateFrame()
    {
        JPanel mainPnl = new JPanel();

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl.setLayout(new BorderLayout());
        frame.add(mainPnl);

        JPanel titlePnl = new TitlePnl();
        mainPnl.add(titlePnl, BorderLayout.NORTH);

        JPanel ticTacToePnl = new TicTacToePnl();
        mainPnl.add(ticTacToePnl, BorderLayout.CENTER);

        JPanel controlPnl = new ControlPnl();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        frame.setSize(screenWidth * 3/4, screenHeight * 3/4);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setVisible(true);
    }
}