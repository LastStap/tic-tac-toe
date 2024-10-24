package dumshenko.daniil.tic_tac_toe;

import java.util.Scanner;

public class Board {

    static void printBoard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();

        System.out.print("Введіть кількість стовпців: ");
        int columns = scanner.nextInt();

        char[][] board = new char[rows][columns];

        for (int rowsIdx = 0; rowsIdx < rows; rowsIdx++) {
            for (int columnsIdx = 0; columnsIdx < columns; columnsIdx++) {
                System.out.print(" ");

                System.out.print(board[rowsIdx][columnsIdx] = ' ');

                if (columnsIdx < columns - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println(" ");

            if (rowsIdx < rows - 1) {
                for (int i = 0; i < columns; i++) {
                    System.out.print("---");
                    if (i < columns - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
