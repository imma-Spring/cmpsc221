package problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPSProblem {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int nWaypoints;
    do {
      System.out.print("Enter number of waypoints: ");
      nWaypoints = scanner.nextInt();
    } while (nWaypoints <= 0);

    List<Waypoint> waypoints = new ArrayList<>();

    for (int i = 0; i < nWaypoints; i++) {
      double x;
      double y;
      int t;
      System.out.println("Enter a waypoint: ");
      System.out.print("Enter x (1 = 0.1 mi): ");
      x = scanner.nextDouble() * 0.1;
      System.out.print("Enter y (1 = 0.1 mi): ");
      y = scanner.nextDouble() * 0.1;
      System.out.print("Enter t (in seconds): ");
      t = scanner.nextInt();
      while (!waypoints.isEmpty() && t <= waypoints.getLast().t) {
        System.out.printf("Timestamp must be larger that previous [%d]\n", waypoints.getLast().t);
        System.out.print("Enter t: ");
        t = scanner.nextInt();
      }

      waypoints.add(new Waypoint(x, y, t));
    }

    double totalDistance = 0;
    for (int i = 1; i < waypoints.size(); i++) {
      double xDist = waypoints.get(i - 1).x - waypoints.get(i).x;
      double yDist = waypoints.get(i - 1).y - waypoints.get(i).y;
      double dist = Math.sqrt(xDist * xDist + yDist * yDist);
      totalDistance += dist;
    }

    int tDisplacement = waypoints.getLast().t - waypoints.getFirst().t;
    double averageSpeed = totalDistance / (tDisplacement / 3600.0);

    System.out.printf("Total distance traveled: %fmi\n", totalDistance);
    System.out.printf("Average speed: %fmph\n", averageSpeed);
  }
}
