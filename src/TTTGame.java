import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

//maybe there should be a separate runner class?

//make TTTGame a class that makes objects (remove static); create a separate runner
//create a start method with:
//        frame = new JFrame();
//        generateFrame();
//        board = new TTTBoard();



//write javadoc
//WRITE JUNIT TESTS
//finish the CRC cards
//create UML


public class TTTGame
{
    //An int for setting the permanent row count of the board array
    private static final int ROW = 3;
    //An int for setting the permanent column count of the board array
    private static final int COL = 3;
    private static String player = "X";
    private static JFrame frame;
    private static TitlePnl titlePnl;
    private static TicTacToePnl ticTacToePnl;
    private static ControlPnl controlPnl;
    private static TTTBoard board;
    private static int moveCnt;
    private static final int MOVES_FOR_WIN = 5;
    private static final int MOVES_FOR_TIE = 7;
    private static boolean playing = true;

    public static void main(String[] args)
    {

        generateFrame();
        board = new TTTBoard();
    }

    /**
     * A method for checking if the current player has achieved a win.
     * @param player the current player (X or O)
     * @return a boolean representing whether a win was achieved
     */
    private boolean isWin(String player)
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
    private boolean isColWin(String player)
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
    private boolean isRowWin(String player)
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

    /**
     * A method for checking if a diagonal win was achieved by the current player.
     * @param player the current player (X or O)
     * @return a boolean representing whether the current player has achieved a diagonal win
     */
    private boolean isDiagonalWin(String player)
    {
        // checks for a diagonal win for the specified player

        if(board.getBoard()[0][0].equals(player) &&
                board.getBoard()[1][1].equals(player) &&
                board.getBoard()[2][2].equals(player) )
        {
            return true;
        }
        if(board.getBoard()[0][2].equals(player) &&
                board.getBoard()[1][1].equals(player) &&
                board.getBoard()[2][0].equals(player) )
        {
            return true;
        }
        return false;
    }

    /**
     * A method for testing if a tie has been achieved because the board is full (in the absence of a win or earlier tie).
     * @return a boolean representing whether a full board tie was achieved.
     */
    private boolean isFullBoardTie()
    {
        //A boolean for checking if there is an empty space on the board
        boolean emptyVal = false;

        //An algorithm for checking if any empty spaces remain on the board
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                if(board.getBoard()[row][col].equals(" "))
                {
                    emptyVal = true;
                }
            }
        }

        //An algorithm determining that if there are no empty values, a full board tie is achieved
        if(!emptyVal)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * A method for checking whether a tie has occurred before the board is full.
     * @return a boolean representing whether the players have tied.
     */
    private boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;

        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties

        for(int row=0; row < ROW; row++)
        {
            if(board.getBoard()[row][0].equals("X") ||
                    board.getBoard()[row][1].equals("X") ||
                    board.getBoard()[row][2].equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(board.getBoard()[row][0].equals("O") ||
                    board.getBoard()[row][1].equals("O") ||
                    board.getBoard()[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < COL; col++)
        {
            if(board.getBoard()[0][col].equals("X") ||
                    board.getBoard()[1][col].equals("X") ||
                    board.getBoard()[2][col].equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(board.getBoard()[0][col].equals("O") ||
                    board.getBoard()[1][col].equals("O") ||
                    board.getBoard()[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(board.getBoard()[0][0].equals("X") ||
                board.getBoard()[1][1].equals("X") ||
                board.getBoard()[2][2].equals("X") )
        {
            xFlag = true;
        }
        if(board.getBoard()[0][0].equals("O") ||
                board.getBoard()[1][1].equals("O") ||
                board.getBoard()[2][2].equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(board.getBoard()[0][2].equals("X") ||
                board.getBoard()[1][1].equals("X") ||
                board.getBoard()[2][0].equals("X") )
        {
            xFlag =  true;
        }
        if(board.getBoard()[0][2].equals("O") ||
                board.getBoard()[1][1].equals("O") ||
                board.getBoard()[2][0].equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }

        // Checked every vector so I know I have a tie
        return true;
    }

    private void switchPlayer()
    {
        if(player.equals("X"))
        {
            player = "O";
        }
        else
        {
            player = "X";
        }
    }

    /**
     * A method for taking input from the GUI and calling all other in-game methods to log moves and check for wins and ties.
     * @param row the row selected by the player in the GUI
     * @param col the column selected by the player in the GUI
     */
    public void buttonAction(int row, int col)
    {
        //A String for tracking which player played last (i.e., before the current players were switched)
        String prevPlayer = player;

        //This algorithm takes input from the player and checks whether the move is valid
        if(!playing)
        {
            JOptionPane.showMessageDialog(frame, "The game is over. Select Play Again to replay!");
        } else if (!board.isValidMove(row, col))
        {
            JOptionPane.showMessageDialog(frame, "This space is already occupied. Please select a different space.");
        } else
        {
            board.getBoard()[row][col] = player;
            board.setCellText(row, col, player);
            moveCnt++;

            //This algorithm switches between the players
            switchPlayer();
        }

        //This algorithm checks if enough moves have passed for a potential win, then checks for wins
        if(moveCnt >= MOVES_FOR_WIN)
        {
            //This algorithm checks for wins, and, if one is achieved, announces it and shuts down the game
            if(isWin(prevPlayer))
            {
                JOptionPane.showMessageDialog(frame, "Player " + prevPlayer + " Wins!");
                playing = false;
                JOptionPane.showMessageDialog(null, "Click Play Again to clear the board and play the game again!");
            }
        }

        //This algorithm checks if enough moves have passed for a potential tie, then checks for full board ties
        if(moveCnt >= MOVES_FOR_TIE && playing)
        {
            //This algorithm checks for full board ties, and, if one is achieved, announces it and shuts down the game
            if(isFullBoardTie())
            {
                JOptionPane.showMessageDialog(frame ,"The game has tied! The board is full.");
                JOptionPane.showMessageDialog(null, "Click Play Again to clear the board and play the game again!");
                playing = false;
            }
        }

        //This algorithm checks if enough moves have passed for a potential tie, then checks for non-full-board ties
        if(moveCnt >= MOVES_FOR_TIE && playing)
        {
            //This algorithm checks for non-full-board ties, and, if one is achieved, announces it and shuts down the game
            if(isTie())
            {
                JOptionPane.showMessageDialog(frame, "The game has come to a tie before the board is full!");
                playing = false;
                JOptionPane.showMessageDialog(null, "Click Play Again to clear the board and play the game again!");
            }
        }
    }

    public void generateFrame()
    {
        frame = new JFrame();

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

        titlePnl = new TitlePnl();
        mainPnl.add(titlePnl, BorderLayout.NORTH);

        ticTacToePnl = new TicTacToePnl();
        mainPnl.add(ticTacToePnl, BorderLayout.CENTER);

        controlPnl = new ControlPnl();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        frame.setSize(screenWidth * 3/4, screenHeight * 3/4);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setVisible(true);
    }

    public void setFrameButton(int row, int col)
    {
        ticTacToePnl.getBoardGUI()[row][col].setText(player);
    }

    public void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                ticTacToePnl.getBoardGUI()[row][col].setText(" ");
            }
        }

        board.clearBoard();
        playing = true;
        player = "X";
    }
}