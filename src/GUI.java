import javax.swing.*;
import java.awt.*;

/**
 * Created by rossc on 3/16/2016.
 */
public class GUI extends JFrame
{
    private Square[][] board;

    public GUI(Square[][] board)
    {
        initialize();
        this.board = board;

        this.setLayout(new GridLayout(3,3));

        for(int x = 0;x<3;x++)
        {
            for(int y = 0;y<3;y++)
            {
                this.add(board[x][y]);
            }
        }
    }

    public void initialize()
    {
        this.setTitle("TicTacHack");
        this.setSize(600,600);
        this.setVisible(true);
    }
}
