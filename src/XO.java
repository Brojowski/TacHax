public class XO
{
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char BLANK = ' ';

    public static final boolean USE_GUI = false;
    private static final int LOOP_TIMES_GUI = 10;
    private static final int LOOP_TIMES_NO_GUI = 100000000;
    private static final int looptimes = (XO.USE_GUI) ? LOOP_TIMES_GUI : LOOP_TIMES_NO_GUI;


    public static void main(String[] args)
    {
        int one = 0, two = 0, tie = 0, err = 0;
        for (int i = 0; i < looptimes; i++)
        {
            Game game = new Game();
            game.setAi1(new AlexAI1(game.getBoard()));
            game.setAi2(new TestAI(game.getBoard()));
            switch (game.run())
            {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 0:
                    tie++;
                    break;
                default:
                    err++;
                    break;
            }
        }
        output("AI 1 goes first.", one, two, tie,looptimes);
        int one1 = one;
        int two1 = two;
        int tie1 = tie;
        one = 0;
        two = 0;
        tie = 0;
        for (int i = 0; i < looptimes; i++)
        {
            Game game = new Game();
            game.setAi1(new TestAI(game.getBoard()));
            game.setAi2(new AlexAI1(game.getBoard()));
            switch (game.run())
            {
                case 1:
                    two++;
                    break;
                case 2:
                    one++;
                    break;
                case 0:
                    tie++;
                    break;
                default:
                    err++;
                    break;
            }
        }
        output("\n\nAI 2 goes first.", one, two, tie, looptimes);
        output("\n\nOverall.", one + one1, two + two1, tie + tie1, looptimes *2);
        System.exit(0);
    }

    public static void output(String label, int one, int two, int tie, int times)
    {
        System.out.println(label+ "(x"+times+")");
        System.out.println("==========================================");
        System.out.printf("%-10s | %-10s \n", "Raw Wins", "Percentage");
        System.out.println("==========================================");
        System.out.printf("%-10s | %-10s \n", one, (double) one / ((double) times) * 100 + "%");
        System.out.printf("%-10s | %-10s \n", two, (double) two / ((double) times) * 100 + "%");
        System.out.printf("%-10s | %-10s \n", tie, (double) tie / ((double) times) * 100 + "%");
        System.out.println("==========================================");
    }
}
