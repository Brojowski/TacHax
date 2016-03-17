import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    private Square[][] board;
    private char[][] pieces;

    public GUI(char[][] pieces)
    {
        this.pieces = pieces;
        board = new Square[3][3];

        initialize();

        this.setLayout(new GridLayout(3,3));

        for(int y = 0;y<3;y++)
        {
            for(int x = 0;x<3;x++)
            {
                board[y][x] = new Square();
                board[y][x].setValue(pieces[y][x]);
                this.add(board[y][x]);
            }
        }
    }

    public void update()
    {
        for(int y = 0;y<3;y++)
        {
            for(int x = 0;x<3;x++)
            {
                board[y][x].update(pieces[y][x]);
            }
        }

        try
        {
            Thread.sleep(500);
        } catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }

    public void initialize()
    {
        this.setTitle("TicTacHack");
        this.setSize(600,600);
        this.setVisible(true);
    }
}
