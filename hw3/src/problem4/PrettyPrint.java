package problem4;

import java.io.*;
import java.util.*;

public class PrettyPrint {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java PrettyPrint <JavaSourceFile>");
      return;
    }

    String src = readFile(args[0]);
    String normalized = collapseSpaces(src);

    String splitControls = splitControlBodies(normalized);
    String withLineBreaks = placeLineBreaks(splitControls);

    List<String> lines = collectNonEmptyLines(withLineBreaks);
    printWithIndentation(lines);
  }

  private static String readFile(String path) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
    }
    return sb.toString();
  }

  private static String collapseSpaces(String s) {
    return s.replaceAll("\\s+", " ").trim();
  }

  private static boolean startsWord(String s, int pos, String word) {
    int end = pos + word.length();
    if (end > s.length())
      return false;
    if (!s.substring(pos, end).equals(word))
      return false;
    boolean beforeOk = (pos == 0) || !Character.isJavaIdentifierPart(s.charAt(pos - 1));
    boolean afterOk = (end == s.length()) || !Character.isJavaIdentifierPart(s.charAt(end));
    return beforeOk && afterOk;
  }

  private static String splitControlBodies(String s) {
    StringBuilder out = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      // handle if/for/while that have parentheses: copy up to matching ')' and if
      // body is unbraced, insert newline
      if (startsWord(s, i, "if") || startsWord(s, i, "for") || startsWord(s, i, "while")) {
        // copy the keyword
        int start = i;
        while (i < s.length() && !Character.isWhitespace(s.charAt(i)) && s.charAt(i) != '(') {
          out.append(s.charAt(i));
          i++;
        }
        // copy spaces until '('
        while (i < s.length() && s.charAt(i) != '(') {
          out.append(s.charAt(i));
          i++;
        }
        // if no '(', continue normally
        if (i >= s.length() || s.charAt(i) != '(')
          continue;
        // copy from '(' until matching ')'
        int depth = 0;
        while (i < s.length()) {
          char c = s.charAt(i);
          out.append(c);
          if (c == '(')
            depth++;
          else if (c == ')') {
            depth--;
            if (depth == 0) {
              i++;
              break;
            }
          }
          i++;
        }
        // skip spaces
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
          i++;
        if (i < s.length()) {
          char next = s.charAt(i);
          // if next starts a block, do nothing special
          if (next == '{') {
            // continue (do not insert newline)
          } else {
            // insert newline so the unbraced statement goes on next line
            out.append('\n');
          }
        } else {
          out.append('\n');
        }
        continue;
      }

      // handle 'else' (but keep 'else if' together: don't newline between else and
      // if)
      if (startsWord(s, i, "else")) {
        // copy "else"
        out.append("else");
        i += 4;
        // skip spaces
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
          i++;
        if (i < s.length() && startsWord(s, i, "if")) {
          out.append(" ");
          // let the loop process the "if" in next iterations (it will see it)
          continue;
        } else {
          // if next is '{', leave as is; otherwise newline before the statement
          if (i < s.length() && s.charAt(i) == '{') {
            // nothing
          } else {
            out.append('\n');
          }
          continue;
        }
      }

      // default copy character
      out.append(s.charAt(i));
      i++;
    }
    return out.toString();
  }

  private static String placeLineBreaks(String s) {
    // Put { and } and ; each on their own line (closing brace on its own line)
    s = s.replace("{", "{\n");
    s = s.replace("}", "\n}\n");
    // semicolons end statements -> newline after ;
    s = s.replace(";", ";\n");
    // collapse any multiple newlines to single
    s = s.replaceAll("\\n\\s*\\n+", "\n");
    return s;
  }

  private static List<String> collectNonEmptyLines(String s) {
    List<String> lines = new ArrayList<>();
    for (String ln : s.split("\n")) {
      String t = ln.trim();
      if (!t.isEmpty())
        lines.add(t);
    }
    return lines;
  }

  private static boolean isControlStart(String line) {
    return line.startsWith("if ") || line.startsWith("if(") ||
        line.startsWith("for ") || line.startsWith("for(") ||
        line.startsWith("while ") || line.startsWith("while(") ||
        line.startsWith("else");
  }

  private static void printWithIndentation(List<String> lines) {
    int indent = 0;
    for (int i = 0; i < lines.size(); i++) {
      String cur = lines.get(i);

      if (cur.startsWith("}")) {
        indent = Math.max(0, indent - 1);
      }

      // determine applied indent: base indent plus one if this line is a statement
      // that belongs to a prior brace-less control
      // we detect that by checking previous line was a control and did NOT end with
      // '{' and we didn't already consume its next line.
      int applied = indent;
      // if previous line existed and was an unbraced control, and this line is not a
      // '}' or '{', then indent+1
      if (i > 0) {
        String prev = lines.get(i - 1);
        if (isControlStart(prev) && !prev.endsWith("{") && !prev.startsWith("else if") && !prev.startsWith("else")) {
          applied = indent + 1;
        }
        // handle 'else' that was placed on its own line: its body should be indented
        if (prev.startsWith("else") && !prev.endsWith("{") && !prev.equals("else if")) {
          applied = indent + 1;
        }
        // handle "else if" — body belongs to the "if" part; but we already split "else
        // if" together in splitControlBodies
        if (prev.startsWith("else if") && !prev.endsWith("{")) {
          applied = indent + 1;
        }
      }

      for (int k = 0; k < applied; k++)
        System.out.print("    ");
      System.out.println(cur);

      if (cur.endsWith("{"))
        indent++;
    }
  }
}
