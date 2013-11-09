package jobseeker;

public class JobseekerName
{
  private String name;

  public JobseekerName(String name)
  {
    if (name == null)
      throw new NullPointerException();
    if (name == "")
      throw new IllegalArgumentException();

    this.name = name;
  }

  public String name()
  {
    return name;
  }

}
