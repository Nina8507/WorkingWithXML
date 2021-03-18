package LibraryExercise;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunLibrary
{
  public static void main(String[] args)
  {
    Library library = new Library();
    library.addBook(
        new Book(new String[] {"Donald Knuth"}, "Art of Computer Programming",
            "978-020189683", 672));
    library.addBook(new Book(
        new String[] {"Thomas Cormen", "Charles Leiserson", "Ronald Rivest"},
        "Introduction to Algorithms", "978-0262531962", 1184));
    library.addMagazine(
        new Magazine("Scientific American", "John Rennie", 2009, 7));

    try
    {
      serializeToXml(library, "library.xml");
      deserializeFromXml("library.xml");

      serializeToXml(
          new Book(new String[] {"Donald Knuth"}, "Art of Computer Programming",
              "978-020189683", 672), "book.xml");
      deserializeFromXml("book.xml");

      serializeToXml(
          new Magazine("Scientific American", "John Rennie", 2009, 7),
          "magazine.xml");
      deserializeFromXml("magazine.xml");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void serializeToXml(Object obj, String fileName)
      throws IOException
  {
    try
    {
      Library library = null;
      Book book = null;
      Magazine magazine = null;

      XmlMapper xmlMapper = new XmlMapper();
      String xmlString;
      if (obj instanceof Library)
      {
        library = (Library) obj;
        xmlString = xmlMapper.writeValueAsString(library);
      }
      else if (obj instanceof Book)
      {
        book = (Book) obj;
        xmlString = xmlMapper.writeValueAsString(book);
      }
      else if (obj instanceof Magazine)
      {
        magazine = (Magazine) obj;
        xmlString = xmlMapper.writeValueAsString(magazine);
      }
      else
      {
        throw new RuntimeException("NOT SOLID!!!!");
      }

      File fileOutput = new File(fileName);
      FileWriter fileWriter = new FileWriter(fileOutput);
      fileWriter.write(xmlString);
      fileWriter.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private static void deserializeFromXml(String fileName) throws IOException
  {
    try
    {
      XmlMapper xmlMapper = new XmlMapper();
      String read = new String(Files.readAllBytes(Paths.get(fileName)));
      if (fileName.contains("library"))
      {
        Library library = xmlMapper.readValue(read, Library.class);
        System.out.println(library.getBooks().size());
      }
      else if (fileName.contains("book"))
      {
        Book book = xmlMapper.readValue(read, Book.class);
        System.out.println(book.getTitle());
      }
      else if (fileName.contains("magazine"))
      {
        Magazine mag = xmlMapper.readValue(read, Magazine.class);
        System.out.println(mag.getYear());
      }
      else
      {
        throw new RuntimeException("MAYBE SOLID???!!!");
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
