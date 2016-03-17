import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by rossc on 3/16/2016.
 */
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

    public void paintComponent(Graphics g)
    {
        Image img = createImage(600 / 3, 600 / 3); //600 is the width/ height of the board and 3 rows/ columns
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

        g.drawImage(img,0,0,this);
    }
}
