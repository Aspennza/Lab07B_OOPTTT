import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * Allows the creation of pre-designed JPanel objects with JButton controls for a Tic Tac Toe program.
 * Also includes methods for acting on and comparing said objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ControlPnl extends JPanel
{
    //This JButton will be used to clear the Tic Tac Toe board
    JButton clearBtn;

    //This JButton will be used to quit the game instance
    JButton quitBtn;

    //This TTTGame allows the current game instance to be passed into the ControlPnl so its methods can be used
    TTTGame game;

    //This constructor gives the ControlPnl a layout, establishes the JButtons, and gives them ActionListeners for functionality
    public ControlPnl(TTTGame game)
    {
        this.game = game;
        setLayout(new GridLayout(1, 2));

        clearBtn = new JButton("Play Again");
        quitBtn = new JButton("Quit");

        add(clearBtn);

        //This ActionListener calls a function from the TTTGame to clear the board
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

    public JButton getClearBtn() {
        return clearBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }

    public TTTGame getGame() {
        return game;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ControlPnl that = (ControlPnl) o;
        return Objects.equals(clearBtn, that.clearBtn) && Objects.equals(quitBtn, that.quitBtn) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clearBtn, quitBtn, game);
    }
}
