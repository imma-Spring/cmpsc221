package problem3;

import java.util.Scanner;

public class BinaryProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide an integer: ");
    int value = scanner.nextInt();
    String binaryString = intToBinaryString(value);
    System.out.printf("Integer [%d] -> Binary [%s]\n", value, binaryString);
    scanner.close();
  }

  private static String intToBinaryString(int value) {
    final int N_INTEGER_BITS = value < 0 ? 31 : 32;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N_INTEGER_BITS; i++) {
      final int MASK = 1 << i;
      final int BIT = value & MASK;

      sb.append(BIT == 0 ? '0' : '1');
    }

    sb.reverse();

    int firstOne = sb.indexOf("1");
    if (firstOne == -1)
      return (value < 0 ? "1" : "0") + "000";

    String bitString = sb.substring(firstOne);
    while (bitString.length() % 4 != 0) {
      bitString = "0" + bitString;
    }
    if (value < 0) {
      bitString = "1" + bitString.substring(1);
    } else if (bitString.charAt(0) == '1') {
      bitString = "0000" + bitString;
    }

    return bitString;
  }
}
