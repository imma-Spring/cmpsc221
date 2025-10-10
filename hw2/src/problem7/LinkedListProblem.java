package problem7;

import java.awt.List;
import java.util.LinkedList;

public class LinkedListProblem {

  public static LinkedList<Integer> reverseKGroup(LinkedList<Integer> list, int k) {
    if (k <= 1 || list.size() < k)
      return list;

    int n = list.size();
    for (int start = 0; start + k <= n; start += k) {
      reverseSubList(list, start, start + k - 1);
    }

    return list;
  }

  private static void reverseSubList(LinkedList<Integer> list, int left, int right) {
    while (left < right) {
      int temp = list.get(left);
      list.set(left, list.get(right));
      list.set(right, temp);
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    // Example 1
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    System.out.println("Original list: " + list1);
    reverseKGroup(list1, 2);
    System.out.println("Reversed in groups of 2: " + list1);

    // Example 2
    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(4);
    list2.add(5);
    System.out.println("\nOriginal list: " + list2);
    reverseKGroup(list2, 3);
    System.out.println("Reversed in groups of 3: " + list2);

    // Example 3 (non-multiple)
    LinkedList<Integer> list3 = new LinkedList<>();
    list3.add(10);
    list3.add(20);
    list3.add(30);
    list3.add(40);
    list3.add(50);
    list3.add(60);
    list3.add(70);
    System.out.println("\nOriginal list: " + list3);
    reverseKGroup(list3, 4);
    System.out.println("Reversed in groups of 4: " + list3);
  }
}
