package applications;

import jobs.Job;
import jobseeker.Jobseeker;

public class Application
{
  private Jobseeker jobseeker;
  private Job job;
  
  public Application(Jobseeker jobseeker, Job job)
  {
    this.jobseeker = jobseeker;
    this.job = job;
    
  }
}
