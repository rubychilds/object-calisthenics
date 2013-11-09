package employer;

import java.util.ArrayList;

import jobs.Job;
import jobs.Jobs;
import jobs.JobPoster;

public class Employer
{
  private final Name name;

  public Employer(String name)
  {
    this.name = new Name(name);
  }

  public void postJob(Job job,
                      JobPoster jobPoster)
  {
    jobPoster.postAJob(job);
  }

  public ArrayList<Job> viewPostsByMe(JobPoster jobPoster)
  {
    return jobPoster.viewPostsByARecruiter(this);
  }

}
