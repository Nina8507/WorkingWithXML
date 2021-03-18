package LibraryExercise;

public class Magazine
{
  private String title;
  private String editor;
  private int year;
  private int issue;

  public Magazine(){}

  public Magazine(String title, String editor, int year, int issue)
  {
    this.title = title;
    this.editor = editor;
    this.year = year;
    this.issue = issue;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getEditor()
  {
    return editor;
  }

  public void setEditor(String editor)
  {
    this.editor = editor;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getIssue()
  {
    return issue;
  }

  public void setIssue(int issue)
  {
    this.issue = issue;
  }
}
