public class CirculatingBook extends LibraryBook {
  private String currentHolder;
  private String dueDate;

  public CirculatingBook(String auth, String name, String code, String call) {
    super(auth, name, code, call);
    currentHolder = "";
    dueDate = "";
  }

  public String getHolder() {
    return currentHolder;
  }

  public String getDueDat() {
    return dueDate;
  }

  public void checkout(String patron, String due) {
    System.out.println("Successfully checked out " + this);
    currentHolder = patron;
    dueDate = due;
  }

  public void returned() {
    System.out.println("Successfully returned " + this);
    currentHolder = "";
    dueDate = "";
  }

  public String circulationStatus() {
    try {
      return currentHolder + ", " + dueDate;
    }
    catch (NullPointerException e) {
      return "Book available on shelves";
    }
  }

  public String toString() {
    try {
      return super.toString() + ", " + currentHolder + ", " + dueDate;
    }
    catch (NullPointerException e) {
      return super.toString();
    }
  }
}
