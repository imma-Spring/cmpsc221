package problem6;

import java.util.Scanner;

public class TriangleTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
      System.out.print("Enter three sides of a triangle: ");
      double a = input.nextDouble();
      double b = input.nextDouble();
      double c = input.nextDouble();

      Triangle t = new Triangle(a, b, c);
      System.out.println("Triangle created successfully with sides: "
          + t.getSide1() + ", " + t.getSide2() + ", " + t.getSide3());
    } catch (IllegalTriangleException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
