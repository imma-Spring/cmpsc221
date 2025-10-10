package problem5;

public class DocumentProblem {

  public static boolean containsKeyword(Document document, String keyword) {
    return document.toString().contains(keyword);
  }

  public static void main(String[] args) {

    System.out.println("=== Testing File and Email Classes ===\n");

    // ----- Create File objects -----
    File file1 = new File("/home/user/notes.txt", "Study for exam and finish homework.");
    File file2 = new File("/documents/todo.txt", "Buy milk, clean room, pay bills.");

    System.out.println("File 1: " + file1);
    System.out.println("File 2: " + file2);
    System.out.println();

    // Test getters and setters for File
    file1.setPath("/home/user/updated_notes.txt");
    file1.setText("Finish Java project by Friday.");
    System.out.println("Updated File 1: " + file1);
    System.out.println("Path: " + file1.getPath());
    System.out.println("Content: " + file1.getText());
    System.out.println();

    // ----- Create Email objects -----
    Email email1 = new Email("Project Update", "alice@example.com", "bob@example.com", "Project meeting at 3pm today.");
    Email email2 = new Email("Dinner Plans", "carol@example.com", "dave@example.com",
        "Let’s meet at the restaurant at 7pm.");

    System.out.println("Email 1: " + email1);
    System.out.println("Email 2: " + email2);
    System.out.println();

    // Test getters and setters for Email
    email1.setTitle("Updated Project Update");
    email1.setSender("alice_new@example.com");
    email1.setReciever("bob_team@example.com");
    email1.setText("Updated content: meeting postponed to 4pm.");

    System.out.println("Updated Email 1: " + email1);
    System.out.println("Title: " + email1.getTitle());
    System.out.println("Sender: " + email1.getSender());
    System.out.println("Receiver: " + email1.getReciever());
    System.out.println("Content: " + email1.getText());
    System.out.println();

    // ----- Test containsKeyword method -----
    System.out.println("=== Testing containsKeyword() ===");
    System.out.println("Does File 1 contain 'Java'? " + containsKeyword(file1, "Java"));
    System.out.println("Does File 2 contain 'exam'? " + containsKeyword(file2, "exam"));
    System.out.println("Does Email 1 contain 'postponed'? " + containsKeyword(email1, "postponed"));
    System.out.println("Does Email 2 contain 'coffee'? " + containsKeyword(email2, "coffee"));
    System.out.println();

    // ----- Polymorphism test -----
    System.out.println("=== Polymorphism Test ===");
    Document[] documents = { file1, file2, email1, email2 };
    for (Document doc : documents) {
      System.out.println("Document: " + doc);
    }
  }
}
