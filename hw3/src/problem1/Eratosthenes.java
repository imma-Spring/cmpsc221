package problem1;

import java.util.ArrayList;

import java.util.ArrayList;

public class Eratosthenes {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 2; i <= 100; i++) {
      numbers.add(i);
    }

    for (int i = 0; i < numbers.size(); i++) {
      int prime = numbers.get(i);
      for (int j = i + 1; j < numbers.size(); j++) {
        if (numbers.get(j) % prime == 0) {
          numbers.remove(j);
          j--;
        }
      }
    }
    System.out.println("Prime numbers from 2 to 100:");
    for (int prime : numbers) {
      System.out.print(prime + " ");
    }
    System.out.println();
  }
}
