package problem5;

public class Email extends Document {

  private String sender;
  private String reciever;
  private String title;

  public Email(String title, String sender, String reciever, String content) {
    super(title);

    this.sender = sender;
    this.reciever = reciever;
    this.title = title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getSender() {
    return sender;
  }

  public void setReciever(String reciever) {
    this.reciever = reciever;
  }

  public String getReciever() {
    return reciever;
  }

  @Override
  public String toString() {
    return String.format("Title: %s, Reciever: %s, Sender: %s, Content: %s", title, sender, reciever, text);
  }
}
