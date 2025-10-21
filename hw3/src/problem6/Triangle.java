package problem6;

public class Triangle {
  private double side1;
  private double side2;
  private double side3;

  public Triangle(double s1, double s2, double s3) throws IllegalTriangleException {
    if (!isValid(s1, s2, s3))
      throw new IllegalTriangleException("Invalid triangle sides: " + s1 + ", " + s2 + ", " + s3);
    side1 = s1;
    side2 = s2;
    side3 = s3;
  }

  private static boolean isValid(double a, double b, double c) {
    return (a + b > c) && (a + c > b) && (b + c > a);
  }

  public double getSide1() {
    return side1;
  }

  public double getSide2() {
    return side2;
  }

  public double getSide3() {
    return side3;
  }

  public void setSide1(double s1) throws IllegalTriangleException {
    if (!isValid(s1, side2, side3))
      throw new IllegalTriangleException("Invalid side1: " + s1);
    side1 = s1;
  }

  public void setSide2(double s2) throws IllegalTriangleException {
    if (!isValid(side1, s2, side3))
      throw new IllegalTriangleException("Invalid side2: " + s2);
    side2 = s2;
  }

  public void setSide3(double s3) throws IllegalTriangleException {
    if (!isValid(side1, side2, s3))
      throw new IllegalTriangleException("Invalid side3: " + s3);
    side3 = s3;
  }
}
