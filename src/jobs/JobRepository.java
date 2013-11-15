package jobs;

import java.util.ArrayList;
import java.util.List;

import employer.Employer;

public class JobRepository
{
  private List<Job> jobs;

  public JobRepository()
  {
    this.jobs = new ArrayList<Job>();
  }

  public List<Job> jobsByEmployer(Employer employer)
  {
    List<Job> jobsByEmployer = new ArrayList<Job>();

    for (Job job : jobs)
      addJobIfByEmployer(job, employer, jobsByEmployer);

    return jobsByEmployer;
  }
  
  private List<Job> addJobIfByEmployer(Job job,
                                       Employer employer,
                                       List<Job> jobsBy)
  {
    if (job.checkEmployerPostedJob(employer))
      jobsBy.add(job);

    return jobsBy;
  }

  public boolean contains(Job job)
  {
    return jobs.contains(job);
  }

  public void add(Job job)
  {
    jobs.add(job);
  }
}
