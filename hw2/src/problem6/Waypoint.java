package problem6;

public class Waypoint {

  public final double x, y;
  public final int t;

  public Waypoint(double x, double y, int t) {
    this.x = x;
    this.y = y;
    this.t = t;
  }

  @Override
  public String toString() {
    return String.format("(X=%f, Y=%f, T=%d)", x, y, t);
  }
}
