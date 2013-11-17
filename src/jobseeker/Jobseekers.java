package jobseeker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jobseekers
{
  private List<Jobseeker> jobseekers;

  public Jobseekers()
  {
    this.jobseekers = new ArrayList<Jobseeker>();
  }

  public void add(Jobseeker jobseeker)
  {
    if (jobseeker == null)
      throw new NullPointerException();

    if (!jobseekers.contains(jobseeker))
      jobseekers.add(jobseeker);
  }

  public void addAll(Jobseekers jobseekers)
  {
    Iterator<Jobseeker> iter = jobseekers.iterator();
    while (iter.hasNext())
    {
      Jobseeker jobseeker = iter.next();
      add(jobseeker);
    }

  }

  public Iterator<Jobseeker> iterator()
  {
    return jobseekers.iterator();
  }

  public boolean isEmpty()
  {
    return jobseekers.isEmpty();
  }

  public boolean contains(Jobseeker jobseeker)
  {
    return jobseekers.contains(jobseeker);
  }

  public int size()
  {
    return jobseekers.size();
  }
}
