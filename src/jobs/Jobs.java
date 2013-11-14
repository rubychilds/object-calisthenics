package jobs;

import java.util.ArrayList;
import java.util.List;

import employer.Employer;

public class Jobs
{

  private ArrayList<Job> jobs;

  public Jobs()
  {
    this.jobs = new ArrayList<Job>();
  }

  public boolean add(Job job)
  {
    if (job == null)
      throw new NullPointerException();

    return jobs.add(job);
  }

  public boolean contains(Job job)
  {
    return jobs.contains(job);
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

  public boolean isEmpty()
  {
    return jobs.size() == 0;
  }

  public int size()
  {
    return jobs.size();
  }
}
