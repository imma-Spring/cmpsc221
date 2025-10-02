package problem2;

import java.util.Scanner;

public class MathProblem2 {
  public static void main(String[] args) {
    Quaternion q1 = new Quaternion(1, 2, 3, 4);
    Quaternion q2 = new Quaternion(2, -1, 0.5, -3);

    System.out.println("q1 = " + q1);
    System.out.println("q2 = " + q2);

    System.out.println("q1 + q2 = " + q1.add(q2));
    System.out.println("q1 - q2 = " + q1.subtract(q2));
    System.out.println("q1 * q2 = " + q1.multiply(q2));
    System.out.println("q1 / q2 = " + q1.divide(q2));
    System.out.println("2 * q1 = " + q1.scale(2));

    // === User Input Test ===
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a quaternion (like 1+2i-3j+4k): ");
    String input = scanner.nextLine();
    Quaternion parsed = Quaternion.parseString(input);

    System.out.println("You entered: " + parsed);

    // === Equality Test ===
    Quaternion q3 = new Quaternion(1, 2, 3, 4);
    System.out.println("q3 = " + q3);
    System.out.println("q1.equals(q3)? " + q1.equals(q3)); // should be true
    System.out.println("q1.equals(q2)? " + q1.equals(q2)); // should be false

    // Round-trip parse + equals
    Quaternion parsedBack = Quaternion.parseString(q1.toString());
    System.out.println("q1.equals(parse(q1.toString()))? " + q1.equals(parsedBack));
  }
}
