package Java;
import java.util.*;

public class Global {
    public static Scanner scanner = new Scanner(System.in);
    public static String jogador1 = "";
    public static String jogador2 = "";
    public static String jogador3 = "";

    public static int random(int min, int max) // range : [min, max]
    {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}
