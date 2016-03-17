import java.awt.Point;

public class Game
{
    Board b;
    Iai ai1;
    Iai ai2;

    public Game()
    {
        b = new Board();
    }

    /**
     * @return winner player (1 || 2 || 0)
     */
    public int run()
    {
        ai1.setMyChar(XO.X);
        ai2.setMyChar(XO.O);

        for (int move = 0; move <= 9; move++)
        {
            if (move % 2 != 0)
            {
                Point play = ai1.getMove();
                b.set(play.x, play.y, XO.X);
            } else
            {
                Point play = ai2.getMove();
                b.set(play.x, play.y, XO.O);
            }

            char w = b.winner();
            switch (w)
            {
                case XO.X:
                    return 1;
                case XO.O:
                    return 2;
                default:
                    break;
            }
        }
        return 0;
    }
}
