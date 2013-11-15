package employer;

import java.util.ArrayList;
import java.util.List;

import applications.ApplicationManager;
import applications.Date;
import jobs.Job;
import jobs.JobManager;
import jobseeker.Jobseeker;

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

  public List<Job> viewPostsByMe(JobManager jobManager)
  {
    return jobManager.viewPostsByARecruiter(this);
  }

  public List<Jobseeker> viewApplicantsForJob(Job job,
                                              ApplicationManager applicationManager)
  {
    return applicationManager.viewApplicantsForJob(job);
  }

  public List<Jobseeker> viewApplicantsOnDateForJob(Date date,
                                                    Job job,
                                                    ApplicationManager applicationManager)
  {
    return applicationManager.viewApplicantsOnDateForJob(date, job);
  }

  public List<Jobseeker> viewApplicantsForMyJobs(JobManager jobManager,
                                                 ApplicationManager applicationManager)
  {
    List<Job> jobPosts = viewPostsByMe(jobManager);
    List<Jobseeker> applicantsForMyJobPosts = new ArrayList();

    for (Job job : jobPosts)
      applicantsForMyJobPosts.addAll(applicationManager.viewApplicantsForJob(job));

    return applicantsForMyJobPosts;
  }

  public List<Jobseeker> viewApplicantsOnDateForMyJobs(Date date,
                                                       JobManager jobManager,
                                                       ApplicationManager applicationManager)
  {
    List<Job> jobPosts = viewPostsByMe(jobManager);
    List<Jobseeker> applicantsForMyJobPosts = new ArrayList();

    for (Job job : jobPosts)
      applicantsForMyJobPosts.addAll(applicationManager.viewApplicantsOnDateForJob(date, job));

    return applicantsForMyJobPosts;
  }

}
