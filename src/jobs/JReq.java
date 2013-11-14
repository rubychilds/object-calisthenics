package jobs;

import employer.Employer;

public class JReq extends Job
{

  public JReq(String title,
              Employer employer)
  {
    super(title, employer);
  }

  public boolean requiresResume()
  {
    return true;
  }

}
