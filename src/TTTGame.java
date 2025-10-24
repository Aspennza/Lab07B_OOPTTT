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

    }

    public static void generateFrame()
    {
        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;


    }
}