package employer;

import java.util.Iterator;

import applications.ApplicationService;
import applications.Date;
import jobs.Job;
import jobs.JobManager;
import jobs.Jobs;
import jobseeker.Jobseekers;

public class Employer
{
  private final Name name;

  public Employer(String name)
  {
    this.name = new Name(name);
  }

  public void postJob(Job job,
                      JobManager jobManager)
  {
    jobManager.postAJob(job);
  }

  public Jobs viewPostsByMe(JobManager jobManager)
  {
    return jobManager.viewPostsByARecruiter(this);
  }

  public Jobseekers viewApplicantsForJob(Job job,
                                         ApplicationService applicationManager)
  {
    return applicationManager.viewApplicantsForJob(job);
  }

  public Jobseekers viewApplicantsOnDateForJob(Date date,
                                               Job job,
                                               ApplicationService applicationManager)
  {
    return applicationManager.viewApplicantsOnDateForJob(date, job);
  }

  public Jobseekers viewApplicantsForMyJobs(JobManager jobManager,
                                            ApplicationService applicationManager)
  {
    Jobs jobPosts = viewPostsByMe(jobManager);
    Jobseekers applicantsForMyJobPosts = new Jobseekers();

    Iterator<Job> iter = jobPosts.iterator();

    while (iter.hasNext())
    {
      Job job = iter.next();
      applicantsForMyJobPosts.addAll(applicationManager.viewApplicantsForJob(job));
    }

    return applicantsForMyJobPosts;
  }

  public Jobseekers viewApplicantsOnDateForMyJobs(Date date,
                                                  JobManager jobManager,
                                                  ApplicationService applicationManager)
  {
    Jobs jobPosts = viewPostsByMe(jobManager);
    Jobseekers applicantsForMyJobPosts = new Jobseekers();

    Iterator<Job> iter = jobPosts.iterator();

    while (iter.hasNext())
    {
      Job job = iter.next();
      applicantsForMyJobPosts.addAll(applicationManager.viewApplicantsOnDateForJob(date, job));
    }
    return applicantsForMyJobPosts;
  }

}
