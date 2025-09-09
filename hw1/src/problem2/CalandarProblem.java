package problem2;

import java.util.Scanner;

public class CalandarProblem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int YEAR = getYear(scanner);
    int dayOfWeek = getWeekDay(scanner);

    scanner.close();

    final boolean YEAR_IS_DIVISIBLE_BY_FOUR = YEAR % 4 == 0;
    final boolean YEAR_IS_DIVISIBLE_BY_ONE_HUNDRED = YEAR % 100 == 0;
    final boolean IS_LEAP_YEAR = YEAR_IS_DIVISIBLE_BY_FOUR && !YEAR_IS_DIVISIBLE_BY_ONE_HUNDRED;

    final int[] MONTH_LENGTHS = {
        31, IS_LEAP_YEAR ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    for (int month = 0; month < MONTH_LENGTHS.length; month++) {
      final String WEEKDAY = getDayOfWeek(dayOfWeek % 7);
      final String MONTH = getMonthName(month);

      System.out.printf("%s 1, %d is %s\n", MONTH, YEAR, WEEKDAY);

      dayOfWeek += MONTH_LENGTHS[month];
    }
  }

  private static int getYear(Scanner scanner) {
    System.out.println("Please provide the year: ");
    int year = scanner.nextInt();
    while (year < 0) {
      System.out.println("Year must be positive");
      year = scanner.nextInt();

    }
    return year;
  }

  private static int getWeekDay(Scanner scanner) {
    System.out.println("Please provide the day of the week with Sunday being 0 through to Saturday being 6: ");
    int dayOfWeek = scanner.nextInt();
    while (dayOfWeek > 6 || dayOfWeek < 0) {
      System.out.println("Day of week must be between 0 and 7");
      dayOfWeek = scanner.nextInt();
    }
    return dayOfWeek;
  }

  private static String getDayOfWeek(int weekday) {
    return switch (weekday) {
      case 0 -> "Sunday";
      case 1 -> "Monday";
      case 2 -> "Tuesday";
      case 3 -> "Wednesday";
      case 4 -> "Thursday";
      case 5 -> "Friday";
      case 6 -> "Sunday";
      default -> null;
    };
  }

  private static String getMonthName(int month) {
    return switch (month) {
      case 0 -> "January";
      case 1 -> "February";
      case 2 -> "March";
      case 3 -> "April";
      case 4 -> "May";
      case 5 -> "June";
      case 6 -> "July";
      case 7 -> "August";
      case 8 -> "September";
      case 9 -> "October";
      case 10 -> "November";
      case 11 -> "December";
      default -> null;
    };
  }
}
