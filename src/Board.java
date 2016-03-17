
public class Board
{
    private char[][] xo = new char[3][3];

    public Board()
    {
        for (int y = 0; y < xo.length; y++)
        {
            for (int x = 0; x < xo[y].length; x++)
            {
                xo[y][x] = XO.BLANK;
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
            return xo[y][x];
    }

    public char get(int pos)
    {
        return get(toCoordinateX(pos),toCoordinateY(pos));
    }

    public char[][] getXO()
    {
        return xo;
    }

    private boolean valid(int x, int y)
    {
        return xo[y][x] == XO.BLANK;
    }

    private int toCoordinateX(int playValue)
    {
        int x = -1;
        if ((playValue == 1) || (playValue == 4) || (playValue == 7))
        {
            x = 0;
        }
        else if ((playValue == 2) || (playValue == 5) || (playValue == 8))
        {
            x = 1;
        }
        else if ((playValue == 3) || (playValue == 6) || (playValue == 9))
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
        }
        else if ((playValue == 4) || (playValue == 5) || (playValue == 6))
        {
            y = 1;
        }
        else if ((playValue == 7) || (playValue == 8) || (playValue == 9))
        {
            y = 2;
        }
        return y;
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
        for (int y = 0; y < 3; y++)
        {
            if (xo[y][0] == c && xo[y][1] == c && xo[y][2] == c)
            {
                return true;
            }
        }

        for (int x = 0; x < 3; x++)
        {
            if (xo[0][x] == c && xo[1][x] == c && xo[2][x] == c)
            {
                return true;
            }
        }

        if (xo[0][0] == c && xo[1][1] == c && xo[2][2] == c)
        {
            return true;
        }

        if (xo[0][2] == c && xo[1][1] == c && xo[2][0] == c)
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        String out = "";
        for (char[] row : xo)
        {
            for (char col : row)
            {
                out += col + "\t";
            }
            out += "\n";
        }
        return out;
    }
}
