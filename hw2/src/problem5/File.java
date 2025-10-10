package problem5;

public class File extends Document {

  private String path;

  public File(String path, String content) {
    super(content);

    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public String toString() {
    return String.format("Path: %s, Content: %s", path, text);
  }
}
