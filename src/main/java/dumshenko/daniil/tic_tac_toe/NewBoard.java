package dumshenko.daniil.tic_tac_toe;

import java.util.Scanner;

public class NewBoard {

    public static final char X_CHAR = 'X';

    public static final char O_CHAR = 'O';

    private final int rowNum;
    private final int colNum;

    private final char[][] board;

    public NewBoard(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;

        this.board = new char[rowNum][colNum];
    }

    public void init() {
        for (int rowsIdx = 0; rowsIdx < rowNum; rowsIdx++) {
            for (int columnsIdx = 0; columnsIdx < colNum; columnsIdx++) {
                System.out.print(" ");

                board[rowsIdx][columnsIdx] = ' ';
            }
        }
    }

    public void print() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків: ");
        int rowNum = scanner.nextInt();

        System.out.print("Введіть кількість стовпців: ");
        int colNum = scanner.nextInt();

        for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
            for (int colIdx = 0; colIdx < colNum; colIdx++) {

                char cell = board[rowIdx][colIdx];
                System.out.print(" " + cell + " ");

                if (isNotLastCol(colIdx)) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (isLastRow(rowIdx)) {
                continue;
            }

            for (int colIdx = 0; colIdx < colNum; colIdx++) {
                System.out.print("---");

                if (isNotLastCol(colIdx)) {
                    System.out.print("+");
                }
            }
            System.out.println();

        }
    }

    public void setX(int rowIdx, int colIdx) {
        board[rowIdx][colIdx] = X_CHAR;
    }

    public void setO(int rowIdx, int colIdx) {
        board[rowIdx][colIdx] = O_CHAR;
    }

    private boolean isLastRow(int rowIdx) {
        return rowIdx == rowNum - 1;
    }

    private boolean isNotLastRow(int rowIdx) {
        return !isLastRow(rowIdx);
    }

    private boolean isLastCol(int colIdx) {
        return colIdx == colNum - 1;
    }

    private boolean isNotLastCol(int colIdx) {
        return !isLastCol(colIdx);
    }
}

