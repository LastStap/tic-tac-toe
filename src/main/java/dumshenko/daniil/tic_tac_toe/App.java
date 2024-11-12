package dumshenko.daniil.tic_tac_toe;

public class App {
    public static void main(String[] args) {

        NewBoard board = new NewBoard(3, 3);

        board.init();

        board.print();

        board.setX(1, 1);
        board.setO(0, 0);
        board.setX(2, 1);

        board.print();
    }
}
