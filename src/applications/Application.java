package applications;

import resume.Resume;
import jobs.Job;
import jobseeker.Jobseeker;

public class Application
{
  private Jobseeker jobseeker;
  private Job       job;
  private Resume    resume = null;

  public Application(Jobseeker jobseeker,
                     Job job)
  {
    this.jobseeker = jobseeker;
    this.job = job;
  }

  public Application(Jobseeker jobseeker,
                     Job job,
                     Resume resume)
  {
    this(jobseeker, job);
    this.resume = resume;
  }

}
