package employer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import applications.Application;
import applications.ApplicationRepository;
import jobs.Job;
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

  public List<Application> viewApplicationsForJob(Job job,
                                                  ApplicationRepository applicationRepo)
  {
    return applicationRepo.viewApplicationsForJob(job);
  }

  public List<Application> viewApplicationsOnDate(Date date,
                                                  ApplicationRepository applicationRepo)
  {
    return applicationRepo.viewApplicationsOnDate(date);
  }

  public List<Application> viewApplicationsOnDateForJob(Job job,
                                                        Date date,
                                                        ApplicationRepository applicationRepo)
  {
    return applicationRepo.viewApplicationsForJobOnDate(job, date);
  }

}
