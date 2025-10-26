import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ControlPnl extends JPanel
{
    JButton clearBtn;
    JButton quitBtn;
    TTTGame game;

    public ControlPnl(TTTGame game)
    {
        this.game = game;
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
