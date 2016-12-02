public class Book {
  private String author;
  private String title;
  private String isbn;

  public Book(){
    author = "";
    title = "";
    isbn = "";
  }

  public Book(String auth, String name, String code) {
    author = auth;
    title = name;
    isbn = code;
  }

  public String getAuthor(){
    return author;
  }
  public String getTitle(){
    return title;
  }
  public String getISBN(){
    return isbn;
  }

  public String toString(){
    return title + ", " + author + ", " + isbn;
  }
}
