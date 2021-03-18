package LibraryExercise;

import java.util.ArrayList;
import java.util.List;

public class Library
{

  private List<Book> books = new ArrayList<>();
  private List<Magazine> magazines = new ArrayList<>();

  public Library(){

  }
    public void addBook(Book book)
    {
      books.add(book);
    }
    public void addMagazine(Magazine magazine)
    {
      magazines.add(magazine);
    }
    public List<Book> getBooks()
    {
      return books;
    }
}
