package dumshenko.daniil.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Виберіть свій символ (X або O): ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);

        Player player1, player2;
        if (choice == 'X') {
            player1 = new Player("Player 1", PlayerType.X);
            player2 = new Player("Player 2", PlayerType.O);
        } else {
            player1 = new Player("Player 1", PlayerType.O);
            player2 = new Player("Player 2", PlayerType.X);
        }

        NewBoard board = new NewBoard(3, 3);
        Player currentPlayer = player1;
        boolean gameEnded = false;

        while (!gameEnded) {
            board.print();
            System.out.println(currentPlayer.getUsername() + " (" + currentPlayer.getType() + "), ваш хід.");

            int row, col;
            while (true) {
                System.out.print("Введіть рядок (0, 1 або 2): ");
                row = scanner.nextInt();
                System.out.print("Введіть стовпець (0, 1 або 2): ");
                col = scanner.nextInt();

                if (row < 0 || row >= 3 || col < 0 || col >= 3 || board.board[row][col] != ' ') {
                    System.out.println("Неправильний хід, спробуйте ще раз.");
                } else {
                    break;
                }
            }

            board.setMove(row, col, currentPlayer.getType());

            if (board.checkWin(currentPlayer.getType())) {
                board.print();
                System.out.println("Вітаємо, " + currentPlayer.getUsername() + "! Ви перемогли.");
                gameEnded = true;
            } else if (board.isFull()) {
                board.print();
                System.out.println("Нічия! Всі клітинки заповнені.");
                gameEnded = true;
            } else {

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}
