package problem4;

import java.util.Scanner;

public class CombinationProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input a positive integer: ");
    int value = scanner.nextInt();

    while (value < 0) {
      System.out.println("Input must be greater than 0:");
      value = scanner.nextInt();
    }

    int count = 0;
    for (int i = 1; i < value; i++) {
      for (int j = i + 1; j <= value; j++) {
        System.out.printf("%d %d\n", i, j);
        count++;
      }
    }

    System.out.printf("Total number of combinations is: %d\n", count);
  }
}
