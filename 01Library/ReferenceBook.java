public class ReferenceBook extends LibraryBook {
  private String collection;

  public ReferenceBook(String auth, String name, String code, String call, String collect) {
    super(auth, name, code, call);
    collection = collect;
  }

  public String getCollection() {
    return collection;
  }

  public void checkout(String patron, String due) {
    System.out.println("Reference books cannot be checked out. Please follow directions.");
  }

  public void returned() {
    System.out.println("Reference books should not have been checked out. --IMPOSSIBLE");
  }

  public String circulationStatus() {
    return "Reference books cannot be circulated.";
  }

  public String toString() {
    return super.toString() + ", " + collection;
  }
}
