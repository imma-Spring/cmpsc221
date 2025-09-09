package problem1;

import java.util.Scanner;

public class NumberingProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input an integer, the input ends if it is 0: ");

    int nPos = 0;
    double nTotal = 0;
    double totalValue = 0;
    while (true) {
      boolean hitZero = false;

      String[] inputTokens = scanner.nextLine().trim().split("\\s+");

      for (String token : inputTokens) {
        if (token.equals(" "))
          continue;

        int value = Integer.parseInt(token);

        if (value == 0) {
          hitZero = true;
          break;
        }

        final boolean isPositive = value > 0;
        if (isPositive) {
          nPos++;
        }
        nTotal++;
        totalValue += value;
      }
      if (hitZero)
        break;
    }

    scanner.close();

    System.out.printf("Number of positive numbers: %d\n", nPos);
    System.out.printf("Number of negative numbers: %d\n", (int) nTotal - nPos);
    System.out.printf("Total value: %.1f\n", totalValue);
    System.out.printf("Average: %.2f\n", totalValue / nTotal);
  }
}
