package applications;

import java.util.Iterator;

import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationRepository
{
  private Applications applications;

  public ApplicationRepository()
  {
    this.applications = new Applications();
  }

  public void addApplication(Jobseeker jobseeker,
                             Application application)
  {
    if (!applications.contains(application))
      applications.add(application);
  }

  public Applications viewApplicationsByJobseeker(Jobseeker jobseeker)
  {
    Applications applicationsByJobseeker = new Applications();
    Iterator<Application> iter = applications.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      addApplicationForJobseeker(jobseeker, application, applicationsByJobseeker);
    }
    return applicationsByJobseeker;
  }

  private Applications addApplicationForJobseeker(Jobseeker jobseeker,
                                                  Application application,
                                                  Applications applicationsByJobseeker)
  {
    if (application.isApplicationByJobseeker(jobseeker))
      applicationsByJobseeker.add(application);

    return applicationsByJobseeker;
  }

  public Applications viewApplicationsForJob(Job job)
  {
    Applications applicationsForJob = new Applications();
    Iterator<Application> iter = applications.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      addApplicationForJob(job, application, applicationsForJob);
    }
    return applicationsForJob;
  }

  private Applications addApplicationForJob(Job job,
                                            Application application,
                                            Applications applicationsForJob)
  {
    if (application.isApplicationForJob(job))
      applicationsForJob.add(application);

    return applicationsForJob;
  }

  public boolean isEmpty()
  {
    return applications.isEmpty();
  }

}
