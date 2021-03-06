import java.awt.Point;

public class Game
{
    private Board b;
    private Iai ai1;
    private Iai ai2;
    private GUI gui;

    public Game()
    {
        b = new Board();
        if (XO.USE_GUI)
        {
            gui = new GUI(b.getXO());
        }
    }

    public void setAi1(Iai ai1)
    {
        this.ai1 = ai1;
    }

    public void setAi2(Iai ai2)
    {
        this.ai2 = ai2;
    }

    public Board getBoard()
    {
        return b;
    }

    /**
     * @return 1 || 2 || 0 || -1
     * 1 || 2 : Player number
     * 0 : Tie
     * -1 : Error
     */
    public int run()
    {
        if (ai1 == null || ai2 == null)
        {
            return -1;
        }

        ai1.setMyChar(XO.X);
        ai2.setMyChar(XO.O);

        for (int move = 1; move <= 9; move++)
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

            if (XO.USE_GUI)
            {
                gui.update();
            }

            char w = b.winner();
            switch (w)
            {
                case XO.X:
                    if (XO.USE_GUI)
                    {
                        gui.setVisible(false);
                    }
                    return 1;
                case XO.O:
                    if (XO.USE_GUI)
                    {
                        gui.setVisible(false);
                    }
                    return 2;
                default:
                    break;
            }
        }
        if (XO.USE_GUI)
        {
            gui.setVisible(false);
        }
        return 0;
    }
}
