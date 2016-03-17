import java.security.InvalidParameterException;

public class Board
{
    private char[][] xo = new char[3][3];

    public Board()
    {
        for (char[] row : xo)
        {
            for (char col : row)
            {
                col = XO.BLANK;
            }
        }
    }

    public boolean set(int x, int y, char c)
    {
        if (valid(x, y))
        {
            xo[y][x] = c;
            return true;
        }
        return false;
    }

    /**
     * @param x: 0 <= x <= 2
     * @param y: 0 <= y <= 2
     * @return char at position
     */
    public char get(int x, int y)
    {
        if (valid(x, y))
        {
            return xo[y][x];
        }
        throw new InvalidParameterException("Out of bounds");
    }

    private boolean valid(int x, int y)
    {
        return xo[y][x] == XO.BLANK;
    }

    public char winner()
    {
        if (winner(XO.X))
        {
            return XO.X;
        } else if (winner(XO.O))
        {
            return XO.O;
        } else
        {
            return XO.BLANK;
        }
    }

    private boolean winner(char c)
    {
        return false;
    }

}
