package LibraryExercise;

public class Book
{
  private String[] authors;
  private String title;
  private String ISBN;
  private int pages;

  public Book(){}

  public Book(String[] authors, String title, String ISBN, int pages)
  {
    this.authors = authors;
    this.title = title;
    this.ISBN = ISBN;
    this.pages = pages;
  }

  public String[] getAuthors()
  {
    return authors;
  }

  public void setAuthors(String[] authors)
  {
    this.authors = authors;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getISBN()
  {
    return ISBN;
  }

  public void setISBN(String ISBN)
  {
    this.ISBN = ISBN;
  }

  public int getPages()
  {
    return pages;
  }

  public void setPages(int pages)
  {
    this.pages = pages;
  }
}
