import javax.swing.*;
import java.util.Objects;

/**
 * Allows the creation of TTTTileButton objects that contain all the functionality of
 * a JButton with the addition of storing their row and column location.
 * Also includes functions for acting on and comparing TTTTileButton objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TTTTileButton extends JButton
{
    //This int stores the row location of the JButton
    private int row;

    //This int stores the column location of the JButton
    private int col;

    public TTTTileButton(int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TTTTileButton that = (TTTTileButton) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
