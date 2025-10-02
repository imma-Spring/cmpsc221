package problem2;

public class Quaternion {

  // public because we dont need to worry about changing a, b, c, or d as they are
  // immutable
  public final double a, b, c, d;

  public Quaternion() {
    this(0);
  }

  public Quaternion(double n) {
    this(n, n, n, n);
  }

  public Quaternion(double a, double b, double c, double d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  public Quaternion(Quaternion q) {
    this(q.a, q.b, q.c, q.d);
  }

  public Quaternion scale(double n) {
    double scaled_a = n * this.a;
    double scaled_b = n * this.b;
    double scaled_c = n * this.c;
    double scaled_d = n * this.d;

    return new Quaternion(scaled_a, scaled_b, scaled_c, scaled_d);
  }

  public Quaternion add(Quaternion q) {
    double sum_a = this.a + q.a;
    double sum_b = this.b + q.b;
    double sum_c = this.c + q.c;
    double sum_d = this.d + q.d;

    return new Quaternion(sum_a, sum_b, sum_c, sum_d);
  }

  public Quaternion subtract(Quaternion q) {
    double difference_a = this.a - q.a;
    double difference_b = this.b - q.b;
    double difference_c = this.c - q.c;
    double difference_d = this.d - q.d;

    return new Quaternion(difference_a, difference_b, difference_c, difference_d);
  }

  public Quaternion multiply(Quaternion q) {
    double product_a = (this.a * q.a) - (this.b * q.b) - (this.c * q.c) - (this.d * q.d);
    double product_b = (this.a * q.b) + (this.b * q.a) + (this.c * q.d) - (this.d * q.c);
    double product_c = (this.a * q.c) - (this.b * q.d) + (this.c * q.a) + (this.d * q.b);
    double product_d = (this.a * q.d) + (this.b * q.c) - (this.c * q.b) + (this.d * q.a);

    return new Quaternion(product_a, product_b, product_c, product_d);
  }

  public Quaternion divide(Quaternion q) {
    Quaternion conjugate_q = new Quaternion(q.a, -q.b, -q.c, -q.d);
    double norm = (q.a * q.a) + (q.b * q.b) + (q.c * q.c) + (q.d * q.d);
    Quaternion inverse_q = conjugate_q.scale(1 / norm);

    return this.multiply(inverse_q);
  }

  @Override
  public String toString() {
    StringBuilder representation = new StringBuilder();

    if (this.a != 0) {
      representation.append(this.a);
    }
    if (this.b != 0) {
      if (representation.length() > 0) {
        representation.append(this.b > 0 ? " + " : " - ");
      } else if (this.b < 0) {
        representation.append("-");
      }
      representation.append(Math.abs(this.b)).append("i");
    }
    if (this.c != 0) {
      if (representation.length() > 0) {
        representation.append(this.c > 0 ? " + " : " - ");
      } else if (this.c < 0) {
        representation.append("-");
      }
      representation.append(Math.abs(this.c)).append("j");
    }
    if (this.d != 0) {
      if (representation.length() > 0) {
        representation.append(this.d > 0 ? " + " : " - ");
      } else if (this.d < 0) {
        representation.append("-");
      }
      representation.append(Math.abs(this.d)).append("k");
    }

    if (representation.length() == 0) {
      return "0";
    }
    return representation.toString();
  }

  public static Quaternion parseString(String s) {
    s = s.replace(" ", "");

    double a = 0, b = 0, c = 0, d = 0;
    int i = 0;

    if (!s.startsWith("+") && !s.startsWith("-")) {
      s = "+" + s;
    }

    while (i < s.length()) {
      int sign = 1;
      while (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        if (s.charAt(i) == '-')
          sign *= -1;
        i++;
      }

      int start = i;
      while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') {
        i++;
      }
      String term = s.substring(start, i);

      if (term.isEmpty())
        continue;

      double value;
      if (term.endsWith("i")) {
        value = Double.parseDouble(term.substring(0, term.length() - 1));
        b += sign * value;
      } else if (term.endsWith("j")) {
        value = Double.parseDouble(term.substring(0, term.length() - 1));
        c += sign * value;
      } else if (term.endsWith("k")) {
        value = Double.parseDouble(term.substring(0, term.length() - 1));
        d += sign * value;
      } else {
        value = Double.parseDouble(term);
        a += sign * value;
      }
    }

    return new Quaternion(a, b, c, d);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;

    if (o instanceof Quaternion q) {
      return this.a == q.a && this.b == q.b && this.c == q.c && this.d == q.d;
    }

    return false;
  }
}
