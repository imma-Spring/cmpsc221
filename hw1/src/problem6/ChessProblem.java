package problem6;

import java.util.Arrays;
import java.util.Random;

public class ChessProblem {

  public static void main(String[] args) {
    boolean[][] board;
    do {
      board = newBoard();
      int firstCol = findFirstRowQueenColumn(board);
      board = addQueen(board, new int[] { firstCol }, 1);
    } while (board == null);
    printBoard(board);
  }

  private static boolean[][] addQueen(boolean[][] board, int[] cols, int pieceNumber) {
    for (int i = 0; i < 8; i++) {
      if (isValidSpot(pieceNumber, i, cols)) {
        boolean[][] newBoard = copyBoard(board);
        newBoard[pieceNumber][i] = true;

        if (pieceNumber == 7)
          return newBoard;

        int[] newCols = Arrays.copyOf(cols, cols.length + 1);
        newCols[cols.length] = i;
        boolean[][] finalBoard = addQueen(newBoard, newCols, pieceNumber + 1);
        if (finalBoard != null)
          return finalBoard;
      }
    }
    return null;
  }

  private static boolean isValidSpot(int r, int c, int[] cols) {
    for (int i = 0; i < cols.length; i++) {
      if (c == cols[i]) // same column
        return false;
      if (Math.abs(r - i) == Math.abs(c - cols[i]))
        return false;
    }
    return true;
  }

  private static void printBoard(boolean[][] bitboard) {
    if (bitboard == null) {
      System.out.println("No board to print.");
      return;
    }
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        System.out.print(bitboard[r][c] ? " Q " : " . ");
      }
      System.out.println();
    }
  }

  private static boolean[][] newBoard() {
    boolean[][] board = new boolean[8][8];
    for (int i = 0; i < 8; i++) {
      Arrays.fill(board[i], false);
    }
    Random random = new Random(System.nanoTime());
    int idx = random.nextInt(8);
    board[0][idx] = true;
    return board;
  }

  private static int findFirstRowQueenColumn(boolean[][] board) {
    for (int c = 0; c < 8; c++) {
      if (board[0][c])
        return c;
    }
    return -1;
  }

  private static boolean[][] copyBoard(boolean[][] board) {
    boolean[][] copy = new boolean[8][8];
    for (int i = 0; i < 8; i++) {
      copy[i] = Arrays.copyOf(board[i], 8);
    }
    return copy;
  }
}
