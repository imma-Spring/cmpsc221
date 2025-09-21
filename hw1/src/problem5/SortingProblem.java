package problem5;

import java.util.Arrays;
import java.util.Scanner;

public class SortingProblem {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input a string: ");
    String input = scanner.nextLine();
    System.out.printf("Sorted string: %s\n", sort(input));
    scanner.close();
  }

  private static String sort(String input) {
    char[] inputChars = input.toCharArray();
    Arrays.sort(inputChars);
    return new String(inputChars);
  }
}
