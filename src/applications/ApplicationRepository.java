package applications;

import java.util.ArrayList;
import java.util.Date;
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
      addApplicationForJobseeker(jobseeker, application, applicationsByJobseeker);

    return applicationsByJobseeker;
  }

  private List<Application> addApplicationForJobseeker(Jobseeker jobseeker,
                                                      Application application,
                                                      List<Application> applicationsByJobseeker)
  {
    if (application.isApplicationByJobseeker(jobseeker))
      applicationsByJobseeker.add(application);
    return applicationsByJobseeker;
  }

  public List<Application> viewApplicationsForJob(Job job)
  {
    List<Application> applicationsForJob = new ArrayList();
    for (Application application : applications)
      addApplicationForJob(job, application, applicationsForJob);

    return applicationsForJob;
  }

  private List<Application> addApplicationForJob(Job job,
                                                 Application application,
                                                 List<Application> applicationsForJob)
  {
    if (application.isApplicationForJob(job))
      applicationsForJob.add(application);

    return applicationsForJob;
  }

}
