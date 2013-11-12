package applications;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationRepository
{
  private List<Application> applications;

  public ApplicationRepository()
  {
    this.applications = new ArrayList<>();
  }

  public void addApplication(Jobseeker jobseeker,
                             Application application)
  {
    applications.add(application);
  }

  public List<Application> viewApplicationsByJobseeker(Jobseeker jobseeker)
  {
    List<Application> applicationsByJobseeker = new ArrayList();
    for (Application application : applications)
    {
      if (application.isApplicationByJobseeker(jobseeker))
        applicationsByJobseeker.add(application);
    }
    return applicationsByJobseeker;
  }

  public List<Application> viewApplicationsForJob(Job job)
  {
    List<Application> applicationsForJob = new ArrayList();
    for (Application application : applications)
    {
      if (application.isApplicationForJob(job))
        applicationsForJob.add(application);
    }
    return applicationsForJob;
  }

  public List<Application> viewApplicationsOnDate(Date date)
  {
    List<Application> applicationsOnDate = new ArrayList();
    for (Application application : applications)
    {
      if (application.isApplicationOnDate(date))
        applicationsOnDate.add(application);
    }
    return applicationsOnDate;
  }

  public List<Application> viewApplicationsForJobOnDate(Job job,
                                                        Date date)
  {

    List<Application> applicationsForJob = viewApplicationsForJob(job);
    List<Application> applicationsForJobOnDate = new ArrayList<>();
    for (Application application : applications)
    {
      if (application.isApplicationOnDate(date))
        applicationsForJobOnDate.add(application);
    }
    return applicationsForJobOnDate;
  }

}
