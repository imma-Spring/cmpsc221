package problem2;

import java.util.Scanner;

public class Permutation {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    permute("", str);
  }

  public static void permute(String prefix, String remaining) {
    if (remaining.length() == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < remaining.length(); i++) {
        permute(prefix + remaining.charAt(i),
            remaining.substring(0, i) + remaining.substring(i + 1));
      }
    }
  }
}
