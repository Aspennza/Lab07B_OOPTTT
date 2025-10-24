import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToePnl extends JPanel
{
    TTTTileButton[][] boardGUI;
    TicTacToeBtnListener listener;

    public TicTacToePnl()
    {
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

    private class TicTacToeBtnListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() instanceof TTTTileButton selectedButton)
            {
                TTTGame.buttonAction(selectedButton.getRow(), selectedButton.getCol());
            }
        }
    }
}
