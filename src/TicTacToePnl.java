import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * Allows the creation of JPanels visually representing the board in a Tic Tac Toe program.
 * Stores TTTTileButtons, an ActionListener for the buttons, and an instance of TTTGame.
 * Also includes methods for acting on and comparing TicTacToePnl objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TicTacToePnl extends JPanel
{
    //This TTTTileButton array stores the visual representation of the Tic Tac Toe board
    TTTTileButton[][] boardGUI;

    //This TicTacToeBtnListener defines what actions to take when a button on the board is pressed
    TicTacToeBtnListener listener;

    //This TTTGame stores the game instance that will be passed into the TicTacToePnl
    TTTGame game;

    //This constructor sets the layout of TicTacToePnl and establishes boardGUI and listener
    public TicTacToePnl(TTTGame game)
    {
        this.game = game;
        setLayout(new GridLayout(3, 3));

        boardGUI = new TTTTileButton[3][3];

        listener = new TicTacToeBtnListener();

        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                boardGUI[row][col] = new TTTTileButton(row, col);
                boardGUI[row][col].setText(" ");
                boardGUI[row][col].addActionListener(listener);
                add(boardGUI[row][col]);
            }
        }
    }

    public TTTTileButton[][] getBoardGUI()
    {
        return boardGUI;
    }

    public TTTGame getGame() {
        return game;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToePnl that = (TicTacToePnl) o;
        return Objects.deepEquals(boardGUI, that.boardGUI) && Objects.equals(listener, that.listener) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(boardGUI), listener, game);
    }

    /**
     * This class creates ActionListener objects that pass data from TTTTileButtons to the game instance.
     * @author Zoe Aspenns aspennza@mail.uc.edu
     */
    private class TicTacToeBtnListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() instanceof TTTTileButton selectedButton)
            {
                game.buttonAction(selectedButton.getRow(), selectedButton.getCol());
            }
        }
    }
}
