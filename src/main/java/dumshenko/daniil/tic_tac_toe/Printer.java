package dumshenko.daniil.tic_tac_toe;

public class Printer {
    public static void printColored(String value, String colorCode) {
        System.out.print(colorCode + value + "\033[0m");
    }

    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String DEFAULT = "\033[0m";
}
