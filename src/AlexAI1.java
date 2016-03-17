/**
 * ************************************Responsibilities of a <<AI>> object:**************************************
 * <purpose: to create a computer opponent that cannot be beaten>
 * A <<AI>>:
 * -Stores <<AI's char, opponent char, board,AI's moves>>
 * -Can calculate and return <<move>>
 * -Can modify itself by <<none>>
 * A <<AI>> knows how to: <<LIST ONLY THE ONES YOU HAVE DEFINED>>
 * -create memory space for a <<AI>> object
 * <p/>
 * -create an instance of a <<AI>> object initialized with user provided instance
 * variable values.
 * <p/>
 * *****************************************************************************************************************
 */

import java.awt.Point;
import java.util.Random;

public class AlexAI1 implements Iai
{
    private char myChar;
    private char oppChar;
    private Board board;
    private int moveNumber;

    private int move1;
    private int move2;
    private int move3;
    private int move4;
    private int move5;


    public AlexAI1(Board b)
    {
        board = b;
        moveNumber = 0;
    }

    /**
     * -1-check for the ability to win
     * -2-check for need to block
     * -3-use move based on turn number
     */

    public int chooseMove(int moveNum)
    {
        switch (moveNum)
        {
            case 1:
                move1 = chooseCorner();
                return move1;
            case 2:
                if (board.get(1, 1) == oppChar)
                {
                    move2 = chooseOppositeCorner();
                } else
                {
                    move2 = chooseCorner();
                }
                return move2;
            case 3:
                if (canWin() != 0)
                {
                    move3 = canWin();
                } else if (block() != 0)
                {
                    move3 = block();
                } else
                {
                    move3 = chooseCorner();
                }
                return move3;
            case 4:
                if (canWin() != 0)
                {
                    move4 = canWin();
                } else if (block() != 0)
                {
                    move4 = block();
                }else
                {
                    move4 = randomMove();
                }
                return move4;
            default:
                if (canWin() != 0)
                {
                    move5 = canWin();
                } else if (block() != 0)
                {
                    move5 = block();
                } else
                {
                    move5 = randomMove();
                }
                return move5;
        }
    }

    public int randomMove()
    {
        Random gen = new Random();
        return gen.nextInt(9) + 1;
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

    public int chooseCorner()
    {
        int move = 0;
        Random rnd = new Random();
        int corner = rnd.nextInt(4) + 1;
        switch (corner)
        {
            case 1:
                move = 1;
                break;
            case 2:
                move = 3;
                break;
            case 3:
                move = 7;
                break;
            case 4:
                move = 9;
                break;
        }
        return move;
    }

    public int chooseOppositeCorner()
    {
        switch (move1)
        {
            case 1:
                return 9;
            case 3:
                return 7;
            case 7:
                return 3;
            case 9:
                return 1;
            default:
                return randomMove();
        }
    }

    @Override
    public void setMyChar(char myChar)
    {
        this.myChar = myChar;
        if (myChar == XO.O)
        {
            oppChar = XO.X;
        } else if (myChar == XO.X)
        {
            oppChar = XO.O;
        }
    }

    @Override
    public Point getMove()
    {
        moveNumber++;
        int move;
        while ((move = chooseMove(moveNumber)) == 0);
        return new Point(toCoordinateX(move),toCoordinateY(move)) ;
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
        if (x == -1)
        {
            assert false;
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
        if (y == -1)
        {
            assert false;
        }
        return y;
    }
}
