import javax.swing.*;
import java.awt.*;

public class TitlePnl extends JPanel
{
    JLabel titleLbl;
    Font titleFont;

    public TitlePnl()
    {
        titleLbl = new JLabel("Tic Tac Toe");
        titleFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titleFont);
        add(titleLbl);
    }
}
