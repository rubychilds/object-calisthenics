package jobs;

import java.util.ArrayList;

import employer.Employer;

public class JobPoster
{
  
  private final Jobs jobs;
  
  public JobPoster(Jobs jobs)
  {
    this.jobs = jobs;

  }
  
  // this adds a job to the list of ALL jobs
  // as well as creating a new Object which contains a list of jobs and employer
  public void postAJob(Job job)
  {
    if(job == null)
      throw new NullPointerException();
    
    jobs.add(job);
  }
  
  public ArrayList<Job> viewPostsByARecruiter(Employer employer)
  {
    if(employer == null)
      throw new NullPointerException();
    return jobs.jobsByEmployer(employer);
    
  }
}
