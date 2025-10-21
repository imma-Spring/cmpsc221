package problem3;

import java.io.*;
import java.util.*;

public class CountKeywords {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Java source file: ");
    String filename = input.nextLine();

    File file = new File(filename);
    if (!file.exists()) {
      System.out.println("File not found.");
      return;
    }

    Set<String> keywords = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
        "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
        "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
        "volatile", "while", "true", "false", "null"));

    Map<String, Integer> counts = new TreeMap<>();
    for (String k : keywords)
      counts.put(k, 0);

    BufferedReader reader = new BufferedReader(new FileReader(file));
    boolean inBlockComment = false;
    String line;
    while ((line = reader.readLine()) != null) {
      StringBuilder clean = new StringBuilder();
      int i = 0;
      while (i < line.length()) {
        if (inBlockComment) {
          int end = line.indexOf("*/", i);
          if (end == -1)
            break;
          inBlockComment = false;
          i = end + 2;
        } else if (line.startsWith("/*", i)) {
          inBlockComment = true;
          i += 2;
        } else if (line.startsWith("//", i)) {
          break;
        } else if (line.charAt(i) == '"') {
          i++;
          while (i < line.length() && line.charAt(i) != '"') {
            if (line.charAt(i) == '\\')
              i++;
            i++;
          }
          i++;
        } else {
          clean.append(line.charAt(i));
          i++;
        }
      }

      String[] tokens = clean.toString().split("\\W+");
      for (String token : tokens) {
        if (keywords.contains(token)) {
          counts.put(token, counts.get(token) + 1);
        }
      }
    }
    reader.close();

    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      if (entry.getValue() > 0) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
    }
  }
}
