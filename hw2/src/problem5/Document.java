package problem5;

public class Document {

  protected String text;

  public Document(String text) {
    this.text = text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return text;
  }
}
