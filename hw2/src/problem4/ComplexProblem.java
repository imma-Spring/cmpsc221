package problem4;

public class ComplexProblem {
  public static void main(String[] args) {
    // Test constructors
    Complex c1 = new Complex();
    Complex c2 = new Complex(3);
    Complex c3 = new Complex(3, 4);
    Complex c4 = new Complex(1, -2);

    System.out.println("=== Constructor Tests ===");
    System.out.println("c1 = " + c1); // Expect 0 + 0i
    System.out.println("c2 = " + c2); // Expect 3 + 0i
    System.out.println("c3 = " + c3); // Expect 3 + 4i
    System.out.println("c4 = " + c4); // Expect 1 - 2i
    System.out.println();

    // Test addition
    System.out.println("=== Addition Tests ===");
    Complex sum = Complex.add(c3, c4);
    System.out.println(c3 + " + " + c4 + " = " + sum); // Expect (3+1) + (4-2)i = 4 + 2i
    System.out.println();

    // Test subtraction
    System.out.println("=== Subtraction Tests ===");
    Complex diff = Complex.subtract(c3, c4);
    System.out.println(c3 + " - " + c4 + " = " + diff); // Expect (3-1) + (4-(-2))i = 2 + 6i
    System.out.println();

    // Test multiplication
    System.out.println("=== Multiplication Tests ===");
    Complex prod = Complex.multiply(c3, c4);
    // (3 + 4i) * (1 - 2i) = 3 - 6i + 4i - 8i^2 = 11 - 2i
    System.out.println(c3 + " * " + c4 + " = " + prod); // Expect 11 - 2i
    System.out.println();

    // Test getters and setters
    System.out.println("=== Getter/Setter Tests ===");
    Complex c5 = new Complex();
    c5.setRealComponent(2.5);
    c5.setImaginaryComponent(-1.5);
    System.out.println("c5 = " + c5); // Expect 2.5 - 1.5i
    System.out.println("Real part: " + c5.getRealComponent());
    System.out.println("Imaginary part: " + c5.getImaginaryComponent());
    System.out.println();

    // Test equality
    System.out.println("=== Equality Tests ===");
    Complex c6 = new Complex(3, 4);
    Complex c7 = new Complex(3, 4);
    Complex c8 = new Complex(3, -4);
    System.out.println(c6 + " equals " + c7 + "? " + c6.equals(c7)); // true
    System.out.println(c6 + " equals " + c8 + "? " + c6.equals(c8)); // false
    System.out.println();

    // Test toString formatting with negatives
    System.out.println("=== toString Formatting Tests ===");
    Complex c9 = new Complex(-5, -3.2);
    System.out.println("c9 = " + c9); // Expect "-5.000000 - 3.200000i"
  }
}
