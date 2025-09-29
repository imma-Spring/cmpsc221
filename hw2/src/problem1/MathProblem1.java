package problem1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MathProblem1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;

    do {
      System.out.println("Input a positive integer n:");
      n = scanner.nextInt();
    } while (n <= 0);

    scanner.close();

    LinkedList<int[]> list = null;
    for (int i = 1; i <= n; i++) {
      list = addFractions(i, list);
    }
    System.out.print('(');
    for (int i = 0; i < list.size(); i++) {
      var fraction = list.get(i);
      System.out.printf("%d/%d", fraction[0], fraction[1]);
      if (i < list.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.print(')');
  }

  private static LinkedList<int[]> addFractions(int n, LinkedList<int[]> list) {
    if (list == null) {
      var newList = new LinkedList<int[]>();
      newList.add(new int[] { 0, 1 });
      newList.add(new int[] { 1, 1 });
      return newList;
    }

    for (int i = 0; i < list.size() - 1; i++) {
      var a = list.get(i);
      var b = list.get(i + 1);
      if (a[1] + b[1] <= n) {
        var num = a[0] + b[0];
        var denom = a[1] + b[1];
        list.add(i + 1, new int[] { num, denom });
        i++;
      }
    }

    return list;
  }
}
