package jobs;

import employer.Employer;

public abstract class Job
{

  private JobTitle jobTitle;
  private Employer employer;

  public Job(String title,
             Employer employer)
  {

    if (employer == null)
      throw new NullPointerException();

    this.jobTitle = new JobTitle(title);
    this.employer = employer;
  }

  public boolean checkEmployerPostedJob(Employer employer)
  {
    return this.employer == employer;
  }

  public abstract boolean requiresResume();

}
