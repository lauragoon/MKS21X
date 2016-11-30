public class Book {
  private String author;
  private String title;
  private String isbn;

  public Book(){
    author = "Laura Goon";
    title = "A Dying Third-Term Junior";
    isbn = "00123456789";
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
