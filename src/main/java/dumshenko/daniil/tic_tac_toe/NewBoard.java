package dumshenko.daniil.tic_tac_toe;

public class NewBoard {

    private final int rowNum;
    private final int colNum;
    final char[][] board;

    public NewBoard(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.board = new char[rowNum][colNum];
        init();
    }

    public void init() {
        for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
            for (int colIdx = 0; colIdx < colNum; colIdx++) {
                board[rowIdx][colIdx] = ' ';
            }
        }
    }

    public void print() {
        System.out.print("   "); // відступ для нумерації зверху
        for (int colIdx = 0; colIdx < colNum; colIdx++) {
            System.out.print(" " + colIdx + " "); // нумерація колонок
            if (isNotLastCol(colIdx)) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
            System.out.print(" " + rowIdx + " "); // нумерація рядків
            for (int colIdx = 0; colIdx < colNum; colIdx++) {
                char cell = board[rowIdx][colIdx];
                if (cell == 'X') {
                    Printer.printColored(" X ", Printer.RED);
                } else if (cell == 'O') {
                    Printer.printColored(" O ", Printer.GREEN);
                } else {
                    System.out.print("   ");
                }
                if (isNotLastCol(colIdx)) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (isLastRow(rowIdx)) continue;

            System.out.print("   "); // відступ для горизонтального розділювача
            for (int colIdx = 0; colIdx < colNum; colIdx++) {
                System.out.print("---");
                if (isNotLastCol(colIdx)) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    public void setMove(int rowIdx, int colIdx, PlayerType type) {
        board[rowIdx][colIdx] = (type == PlayerType.X) ? 'X' : 'O';
    }

    public boolean checkWin(PlayerType type) {
        char symbol = (type == PlayerType.X) ? 'X' : 'O';

        // Перевірка рядків
        for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
            if (board[rowIdx][0] == symbol && board[rowIdx][1] == symbol && board[rowIdx][2] == symbol) {
                return true;
            }
        }

        // Перевірка колонок
        for (int colIdx = 0; colIdx < colNum; colIdx++) {
            if (board[0][colIdx] == symbol && board[1][colIdx] == symbol && board[2][colIdx] == symbol) {
                return true;
            }
        }

        // Перевірка діагоналей
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
            for (int colIdx = 0; colIdx < colNum; colIdx++) {
                if (board[rowIdx][colIdx] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLastRow(int rowIdx) {
        return rowIdx == rowNum - 1;
    }

    private boolean isNotLastCol(int colIdx) {
        return colIdx != colNum - 1;
    }
}
