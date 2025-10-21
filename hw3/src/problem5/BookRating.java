package problem5;

import java.io.*;
import java.util.*;

public class BookRating {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java BookRating <ratingsFile>");
      return;
    }

    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    int count = Integer.parseInt(br.readLine().trim());

    Map<String, List<Integer>> ratings = new LinkedHashMap<>();

    for (int i = 0; i < count; i++) {
      String title = br.readLine();
      int rating = Integer.parseInt(br.readLine().trim());
      ratings.computeIfAbsent(title, k -> new ArrayList<>()).add(rating);
    }

    br.close();

    for (Map.Entry<String, List<Integer>> entry : ratings.entrySet()) {
      String title = entry.getKey();
      List<Integer> list = entry.getValue();
      double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
      int n = list.size();
      System.out.printf("%s: %d review%s, average of %.1f / 5%n",
          title, n, n == 1 ? "" : "s", avg);
    }
  }
}
