package jobs;

import java.util.Iterator;

import employer.Employer;

public class JobRepository
{
  private Jobs jobs;

  public JobRepository()
  {
    this.jobs = new Jobs();
  }

  public Jobs jobsByEmployer(Employer employer)
  {
    Jobs jobsByEmployer = new Jobs();

    Iterator<Job> iter = jobs.iterator();
    while (iter.hasNext())
    {
      Job job = iter.next();
      addJobIfByEmployer(job, employer, jobsByEmployer);
    }
    return jobsByEmployer;
  }

  private Jobs addJobIfByEmployer(Job job,
                                  Employer employer,
                                  Jobs jobsBy)
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
