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

  public boolean isEmpty()
  {
    return jobs.size() == 0;
  }

  public int size()
  {
    return jobs.size();
  }
}
