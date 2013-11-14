package jobs;

public class JobTitle
{
  private String jobTitle;

  public JobTitle(String jobTitle)
  {
    if (jobTitle.equals(""))
      throw new IllegalArgumentException();
    if (jobTitle == null)
      throw new NullPointerException();

    this.jobTitle = jobTitle;
  }

  public String toString()
  {
    return this.jobTitle;
  }

}
