import java.awt.Point;
import java.util.Random;

public class TestAI2 implements Iai
{
    private char myChar;
    private char oppChar;
    private Random gen = new Random();
    private Board board;

    public TestAI2(Board b)
    {
        board = b;
    }

    @Override
    public void setMyChar(char myChar)
    {
        this.myChar = myChar;
        if (myChar == XO.X)
        {
            oppChar = XO.O;
        } else
        {
            oppChar = XO.X;
        }
    }

    @Override
    public Point getMove()
    {
        int pos = canWin();
        int pos2 = block();
        if (pos != 0)
        {
            return new Point(toCoordinateX(pos), toCoordinateY(pos));
        }
        if (pos2 != 0)
        {
            return new Point(toCoordinateX(pos2), toCoordinateY(pos2));
        }
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

    public int canWin()
    {
        //diagonals
        //right diagonal
        if (board.get(1) == myChar && board.get(5) == myChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(1) == myChar && board.get(9) == myChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == myChar && board.get(9) == myChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //left diagonal
        if (board.get(3) == myChar && board.get(5) == myChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        if (board.get(3) == myChar && board.get(7) == myChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == myChar && board.get(7) == myChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        //vertical
        //first column
        if (board.get(1) == myChar && board.get(4) == myChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        if (board.get(1) == myChar && board.get(7) == myChar && board.get(4) == XO.BLANK)
        {
            return 4;
        }
        if (board.get(4) == myChar && board.get(7) == myChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //second column
        if (board.get(2) == myChar && board.get(5) == myChar && board.get(8) == XO.BLANK)
        {
            return 8;
        }
        if (board.get(2) == myChar && board.get(8) == myChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == myChar && board.get(8) == myChar && board.get(2) == XO.BLANK)
        {
            return 2;
        }
        //third column
        if (board.get(3) == myChar && board.get(6) == myChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(3) == myChar && board.get(9) == myChar && board.get(6) == XO.BLANK)
        {
            return 6;
        }
        if (board.get(6) == myChar && board.get(9) == myChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        //horizontal
        //top row
        if (board.get(1) == myChar && board.get(2) == myChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        if (board.get(1) == myChar && board.get(3) == myChar && board.get(2) == XO.BLANK)
        {
            return 2;
        }
        if (board.get(2) == myChar && board.get(3) == myChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //middle row
        if (board.get(4) == myChar && board.get(5) == myChar && board.get(6) == XO.BLANK)
        {
            return 6;
        }
        if (board.get(4) == myChar && board.get(6) == myChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == myChar && board.get(6) == myChar && board.get(4) == XO.BLANK)
        {
            return 4;
        }
        //bottom row
        if (board.get(7) == myChar && board.get(8) == myChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(7) == myChar && board.get(9) == myChar && board.get(8) == XO.BLANK)
        {
            return 8;
        }
        if (board.get(8) == myChar && board.get(9) == myChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        return 0;
    }

    public int block()
    {
        //diagonals
        //right diagonal
        if (board.get(1) == oppChar && board.get(5) == oppChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(1) == oppChar && board.get(9) == oppChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == oppChar && board.get(9) == oppChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //left diagonal
        if (board.get(3) == oppChar && board.get(5) == oppChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        if (board.get(3) == oppChar && board.get(7) == oppChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == oppChar && board.get(7) == oppChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        //vertical
        //first column
        if (board.get(1) == oppChar && board.get(4) == oppChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        if (board.get(1) == oppChar && board.get(7) == oppChar && board.get(4) == XO.BLANK)
        {
            return 4;
        }
        if (board.get(4) == oppChar && board.get(7) == oppChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //second column
        if (board.get(2) == oppChar && board.get(5) == oppChar && board.get(8) == XO.BLANK)
        {
            return 8;
        }
        if (board.get(2) == oppChar && board.get(8) == oppChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == oppChar && board.get(8) == oppChar && board.get(2) == XO.BLANK)
        {
            return 2;
        }
        //third column
        if (board.get(3) == oppChar && board.get(6) == oppChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(3) == oppChar && board.get(9) == oppChar && board.get(6) == XO.BLANK)
        {
            return 6;
        }
        if (board.get(6) == oppChar && board.get(9) == oppChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        //horizontal
        //top row
        if (board.get(1) == oppChar && board.get(2) == oppChar && board.get(3) == XO.BLANK)
        {
            return 3;
        }
        if (board.get(1) == oppChar && board.get(3) == oppChar && board.get(2) == XO.BLANK)
        {
            return 2;
        }
        if (board.get(2) == oppChar && board.get(3) == oppChar && board.get(1) == XO.BLANK)
        {
            return 1;
        }
        //middle row
        if (board.get(4) == oppChar && board.get(5) == oppChar && board.get(6) == XO.BLANK)
        {
            return 6;
        }
        if (board.get(4) == oppChar && board.get(6) == oppChar && board.get(5) == XO.BLANK)
        {
            return 5;
        }
        if (board.get(5) == oppChar && board.get(6) == oppChar && board.get(4) == XO.BLANK)
        {
            return 4;
        }
        //bottom row
        if (board.get(7) == oppChar && board.get(8) == oppChar && board.get(9) == XO.BLANK)
        {
            return 9;
        }
        if (board.get(7) == oppChar && board.get(9) == oppChar && board.get(8) == XO.BLANK)
        {
            return 8;
        }
        if (board.get(8) == oppChar && board.get(9) == oppChar && board.get(7) == XO.BLANK)
        {
            return 7;
        }
        return 0;
    }

    private int toCoordinateX(int playValue)
    {
        int x = -1;
        if ((playValue == 1) || (playValue == 4) || (playValue == 7))
        {
            x = 0;
        } else if ((playValue == 2) || (playValue == 5) || (playValue == 8))
        {
            x = 1;
        } else if ((playValue == 3) || (playValue == 6) || (playValue == 9))
        {
            x = 2;
        }
        return x;
    }

    private int toCoordinateY(int playValue)
    {
        int y = -1;
        if ((playValue == 1) || (playValue == 2) || (playValue == 3))
        {
            y = 0;
        } else if ((playValue == 4) || (playValue == 5) || (playValue == 6))
        {
            y = 1;
        } else if ((playValue == 7) || (playValue == 8) || (playValue == 9))
        {
            y = 2;
        }
        return y;
    }
}
