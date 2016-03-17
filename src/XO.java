public class XO
{
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char BLANK = ' ';

    public static final boolean USE_GUI = false;
    private static final int LOOP_TIMES_GUI = 10;
    private static final int LOOP_TIMES_NO_GUI = 10000000;


    public static void main(String[] args)
    {
        int one = 0, two = 0, tie = 0, err=0;
        int looptimes = (XO.USE_GUI) ? LOOP_TIMES_GUI : LOOP_TIMES_NO_GUI;
        for (int i = 0; i < looptimes; i++)
        {
            Game game = new Game();
            game.setAi1(new TestAI(game.getBoard()));
            game.setAi2(new TestAI2(game.getBoard()));
            switch (game.run())
            {
                case 1: one++; break;
                case 2: two++; break;
                case 0: tie++; break;
                default: err++; break;
            }
        }
        for (int i = 0; i < looptimes; i++)
        {
            Game game = new Game();
            game.setAi1(new TestAI2(game.getBoard()));
            game.setAi2(new TestAI(game.getBoard()));
            switch (game.run())
            {
                case 1: two++; break;
                case 2: one++; break;
                case 0: tie++; break;
                default: err++; break;
            }
        }
        System.out.printf(one + "\t" + (double)one/((double)looptimes*2)*100+"%");
        System.out.printf(two + "\t" + (double)two/((double)looptimes*2)*100+"%");
        System.out.printf(tie + "\t" + (double)tie/((double)looptimes*2)*100+"%");
        System.exit(0);
    }
}
