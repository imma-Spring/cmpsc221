package problem3;

import java.util.Scanner;
import java.util.Stack;

public class StackProblem {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String answer;
    do {
      System.out.print("Case sensitive? [Yn]: ");
      answer = scanner.next().toLowerCase();
    } while (!answer.isEmpty() && !answer.equals("y") && !answer.equals("n"));
    boolean caseSesitive = true;
    if (answer.equals("n")) {
      caseSesitive = false;
    }

    String input;
    Stack<Character> inputStack = new Stack<>();
    do {
      System.out.print("Input a char: ");
      input = scanner.next();
      if (!input.isEmpty()) {
        char c = input.charAt(0);
        if (c == '0')
          break;
        if (!caseSesitive) {
          c = Character.toUpperCase(c);
        }
        inputStack.push(c);
      }
    } while (true);
    scanner.close();
    if (inputStack.size() <= 1) {
      String word = stackToString(inputStack);
      System.out.printf("\"%s\" is a palindrome\n", word);
    }

    Stack<Character> copyStack = new Stack<>();
    copyStack.addAll(inputStack);

    Stack<Character> checkStack = new Stack<>();
    checkStack.addAll(inputStack);

    Stack<Character> reverseStack = new Stack<>();
    while (inputStack.size() > 0) {
      reverseStack.push(inputStack.pop());
    }

    boolean isPalindrome = true;
    while (checkStack.size() > 0 && isPalindrome) {
      char a = checkStack.pop();
      char b = reverseStack.pop();
      if (a != b)
        isPalindrome = false;
    }
    String word = stackToString(copyStack);
    System.out.printf("\"%s\" is %sa palindrome\n", word, (isPalindrome) ? "" : "not ");
  }

  private static String stackToString(Stack<Character> stack) {
    StringBuilder sb = new StringBuilder();
    while (stack.size() > 0) {
      sb.append(stack.pop());
    }
    sb.reverse();
    return sb.toString();
  }
}
