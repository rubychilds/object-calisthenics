package jobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Jobs
{

  private List<Job> jobs;

  public Jobs()
  {
    this.jobs = new ArrayList<Job>();
  }

  public void add(Job job)
  {
    if (job == null)
      throw new NullPointerException();

    if (!jobs.contains(job))
      jobs.add(job);
  }

  public Iterator<Job> iterator()
  {
    return jobs.iterator();
  }

  public boolean isEmpty()
  {
    return jobs.size() == 0;
  }

  public boolean contains(Job job)
  {
    return jobs.contains(job);
  }

  public int size()
  {
    return jobs.size();
  }

}
