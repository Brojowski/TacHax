import java.awt.Point;
import java.util.Random;

public class TestAI implements Iai
{
    private char myChar;
    private Random gen = new Random();
    private Board board;

    public TestAI(Board b)
    {
        board = b;
    }

    @Override
    public void setMyChar(char myChar)
    {
        this.myChar = myChar;
    }

    @Override
    public Point getMove()
    {
        while (true)
        {
            int x = gen.nextInt(3);
            int y = gen.nextInt(3);
            if (board.get(x, y) == XO.BLANK)
            {
                return new Point(x, y);
            }
        }
    }
}
