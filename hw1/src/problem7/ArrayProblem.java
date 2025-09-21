package problem7;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProblem {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int value;
    do {
      System.out.println("enter a positive integer(n): ");
      value = scanner.nextInt();
    } while (value <= 0);
    scanner.close();

    var array = new int[value];
    for (int i = 0; i < value - (value % 2 == 1 ? 1 : 0); i += 2) {
      int val = i + 1;
      array[i] = val;
      array[i + 1] = -val;
    }

    System.out.printf("Array: %s\n", Arrays.toString(array));
  }
}
