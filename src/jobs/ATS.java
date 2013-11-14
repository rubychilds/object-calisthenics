package jobs;

import employer.Employer;

public class ATS extends Job
{

  public ATS(String title,
             Employer employer)
  {
    super(title, employer);
  }

  public boolean requiresResume()
  {
    return false;
  }

}
