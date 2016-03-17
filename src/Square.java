import javax.swing.*;
import java.awt.*;

public class Square extends JPanel
{
    private char value;

    public Square()
    {
        value = XO.BLANK;
    }

    public void setValue(char value)
    {
        this.value = value;
        update(getGraphics());
    }

    public char getValue()
    {
        return value;
    }

    public void update(char value)
    {
        this.value = value;
        update(getGraphics());
    }

    public void paintComponent(Graphics g)
    {
        Image img = createImage(200, 200); //600 is the width/ height of the board and 3 rows/ columns and 200 is 600/3
        Graphics offScreen = img.getGraphics();

        offScreen.setFont(new Font("Courier", Font.BOLD, 50));
        switch (value)
        {
            case XO.X:
                offScreen.setColor(Color.BLUE);
                offScreen.drawString("X", 0, 0);
                break;
            case XO.O:
                offScreen.setColor(Color.RED);
                offScreen.drawString("O", 0, 0);
                break;
            default:
                break;
        }

        g.drawImage(img, 0, 0, this);
    }
}
