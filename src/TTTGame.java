import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class TTTGame
{
    private static String player;
    private static JFrame frame;
    private static int moveCnt;
    private static final int MOVES_FOR_WIN = 5;
    private static final int MOVES_FOR_TIE = 7;
    private static boolean playing;

    public static void main(String[] args)
    {
        frame = new JFrame();
        generateFrame();

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