public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
  private String callNumber;

  public LibraryBook(String auth, String name, String code, String call){
    super(auth, name, code);
    callNumber = call;
  }

  public String getCall(){
    return callNumber;
  }

  public abstract void checkout(String patron, String due);
  public abstract void returned();
  public abstract String circulationStatus();

  public int compareTo(LibraryBook b){
    return callNumber.compareTo(b.getCall());
  }

  public String toString(){
    return super.toString() + ", " + circulationStatus() + ", " + callNumber;
  }
}
