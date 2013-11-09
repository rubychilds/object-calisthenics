package jobs;

import employer.Employer;
import resume.Resume;

public class ATS extends Job
{

  public ATS(String title,
             Employer employer)
  {
    super(title, employer);
  }

  public boolean apply(Resume resume)
  {
    return false;
  }

  @Override
  public boolean apply()
  {
    return true;
  }

}
