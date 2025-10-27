import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class TicTacToePnl extends JPanel
{
    TTTTileButton[][] boardGUI;
    TicTacToeBtnListener listener;
    TTTGame game;

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
