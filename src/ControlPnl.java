import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPnl extends JPanel
{
    JButton clearBtn;
    JButton quitBtn;
    TTTGame game;

    public ControlPnl(TTTGame game)
    {
        setLayout(new GridLayout(1, 2));

        clearBtn = new JButton("Play Again");
        quitBtn = new JButton("Quit");

        add(clearBtn);
        clearBtn.addActionListener((ActionEvent ae) -> game.clearBoard());

        add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            //This int tracks whether the user confirmed or denied they wanted to quit the program
            int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //This algorithm determines whether to quit the program based on the user's input
            if(selection == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Quitting the program...");
                System.exit(0);
            } else
            {
                JOptionPane.showMessageDialog(null, "The program will remain open.");
            }
        });
    }
}
