package applications;

import java.util.Date;

import resume.Resume;
import jobs.Job;
import jobseeker.Jobseeker;

public class Application
{
  private Jobseeker jobseeker;
  private Job       job;
  private Resume    resume = null;
  private Date      date;

  public Application(Jobseeker jobseeker,
                     Job job)
  {
    if (jobseeker == null || job == null)
      throw new NullPointerException();

    this.jobseeker = jobseeker;
    this.job = job;
    this.date = new Date();
  }

  public Application(Jobseeker jobseeker,
                     Job job,
                     Resume resume)
  {
    this(jobseeker, job);
    if (resume == null)
      throw new NullPointerException();
    this.resume = resume;
  }

  public boolean isApplicationByJobseeker(Jobseeker jobseeker)
  {
    return this.jobseeker == jobseeker;
  }

  public boolean isApplicationForJob(Job job)
  {
    return this.job == job;
  }

  public boolean isApplicationOnDate(Date date)
  {
    return this.date == date;
  }

  public Jobseeker applicant()
  {
    return jobseeker;
  }

}
