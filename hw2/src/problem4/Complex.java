package problem4;

public class Complex {

  private double real;
  private double imaginary;

  public Complex() {
    real = 0;
    imaginary = 0;
  }

  public Complex(double realComponent) {
    this.real = realComponent;
    imaginary = 0;
  }

  public Complex(double realComponent, double imaginaryComponent) {
    this.real = realComponent;
    this.imaginary = imaginaryComponent;
  }

  public static Complex add(Complex c1, Complex c2) {
    double realSum = c1.real + c2.real;
    double imaginarySum = c1.imaginary + c2.imaginary;

    return new Complex(realSum, imaginarySum);
  }

  public static Complex subtract(Complex c1, Complex c2) {
    double realDifference = c1.real - c2.real;
    double imaginaryDifference = c1.imaginary - c2.imaginary;

    return new Complex(realDifference, imaginaryDifference);
  }

  public static Complex multiply(Complex c1, Complex c2) {
    double realProduct = c1.real * c2.real - c1.imaginary * c2.imaginary;
    double imaginaryProduct = c1.real * c2.imaginary + c2.real * c1.imaginary;

    return new Complex(realProduct, imaginaryProduct);
  }

  public double getRealComponent() {
    return this.real;
  }

  public double getImaginaryComponent() {
    return this.imaginary;
  }

  public void setRealComponent(double value) {
    this.real = value;
  }

  public void setImaginaryComponent(double value) {
    this.imaginary = value;
  }

  @Override
  public String toString() {
    return String.format("%f %c %fi", real, (imaginary >= 0) ? '+' : '-', Math.abs(imaginary));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o instanceof Complex c) {
      return this.real == c.real && this.imaginary == c.imaginary;
    }
    return false;
  }
}
