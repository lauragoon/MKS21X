public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String author;
    private String title;
    private String isbn;
  private String callNumber;

  public LibraryBook(String auth, String name, String code, String call){
    author = auth;
    title = name;
    isbn = code;
    callNumber = call;
  }

  public String getCall(){
    return callNumber;
  }

  public abstract void checkout(String patron, String due);
  public abstract void returned();
  public abstract String circulationStatus();

  public int compareTo(LibraryBook b){
      if (callNumber < b.getCall()) {
	  return -1;
      } else if (callNumber == b.getCall()) {
	  return 0;
      } else {
	  return 1;
      }
  }

  public String toString(){
      System.out.println(super.toString() + ", " + circulationStatus(); + ", " + callNumber);
  }
}
