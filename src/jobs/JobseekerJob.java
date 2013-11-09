package jobs;

import jobseeker.Jobseeker;

public class JobseekerJob
{
  private Job job;
  private Jobseeker jobseeker;
  
  public JobseekerJob(Job job, Jobseeker jobseeker)
  {
    this.job = job;
    this.jobseeker = jobseeker;
  }
  
  public boolean byJobseeker(Jobseeker jobseeker){
    return this.jobseeker == jobseeker;
  }
  
  public Job job(){
    return job;
  }
  
  
}
