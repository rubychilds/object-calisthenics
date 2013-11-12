package applications;

import java.util.Date;
import java.util.List;

import jobs.Job;
import jobseeker.Jobseeker;
import resume.ActiveResumeRepo;

public class ApplicationManager
{
  private ApplicationProcess    applicationProcess;
  private ApplicationRepository applicationRepository;

  public ApplicationManager(ActiveResumeRepo activeResRepo)
  {
    this.applicationRepository = new ApplicationRepository();
    this.applicationProcess = new ApplicationProcess(activeResRepo, applicationRepository);
  }

  public Application apply(Jobseeker jobseeker,
                           Job job)
  {
    return applicationProcess.apply(jobseeker, job);
  }

  public List<Application> viewApplicationsByJobseeker(Jobseeker jobseeker)
  {
    return applicationRepository.viewApplicationsByJobseeker(jobseeker);
  }

  public List<Application> viewApplicationsByJob(Job job)
  {
    return applicationRepository.viewApplicationsForJob(job);
  }

  public List<Application> viewApplicationsOnDate(Date date)
  {
    return applicationRepository.viewApplicationsOnDate(date);
  }
  
  public List<Application> viewApplicationsForJobOnDate(Job job, Date date)
  {
    return applicationRepository.viewApplicationsForJobOnDate(job, date);
  }

}
