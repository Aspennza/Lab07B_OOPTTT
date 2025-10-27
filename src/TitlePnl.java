import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Allows the creation of pre-designed JPanel objects for the title panel of a Tic Tac Toe program.
 * Contains a JLabel and a Font, as well as functions for acting on and comparing TitlePnl objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TitlePnl extends JPanel
{
    //This JLabel serves as the title for the TitlePnl
    JLabel titleLbl;

    //This Font sets the font of the titleLbl
    Font titleFont;

    //This constructor establishes the titleLbl and titleFont and adds them to the panel
    public TitlePnl()
    {
        titleLbl = new JLabel("Tic Tac Toe");
        titleFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titleFont);
        add(titleLbl);
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public Font getTitleFont() {
        return titleFont;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TitlePnl titlePnl = (TitlePnl) o;
        return Objects.equals(titleLbl, titlePnl.titleLbl) && Objects.equals(titleFont, titlePnl.titleFont);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleLbl, titleFont);
    }
}
