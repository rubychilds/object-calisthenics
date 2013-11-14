package jobs;

import java.util.List;

import employer.Employer;

public class JobRepository
{
  private Jobs jobs;

  public JobRepository()
  {
    this.jobs = new Jobs();
  }

  public List<Job> jobsByEmployer(Employer employer)
  {
    return jobs.jobsByEmployer(employer);
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
