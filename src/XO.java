public class XO
{
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char BLANK = ' ';

    public static void main(String[] args)
    {
        int one = 0, two = 0, tie = 0, err = 0;
        for (int i = 0; i < 10000000; i++)
        {
            Game game = new Game();
            game.setAi1(new TestAI(game.getBoard()));
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
        System.out.println(one);
        System.out.println(two);
        System.out.println(tie);
        System.out.println(err);
    }
}
