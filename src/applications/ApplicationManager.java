package applications;

import java.util.ArrayList;
import java.util.Iterator;
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

  public Applications viewApplicationsByJobseeker(Jobseeker jobseeker)
  {
    return applicationRepository.viewApplicationsByJobseeker(jobseeker);
  }

  public List<Jobseeker> viewApplicantsForJob(Job job)
  {

    Applications applicationsForJob = applicationRepository.viewApplicationsForJob(job);
    List<Jobseeker> applicantsForJob = new ArrayList<Jobseeker>();

    Iterator<Application> iter = applicationsForJob.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      applicantsForJob.add(application.applicant());
    }

    return applicantsForJob;
  }

  public List<Jobseeker> viewApplicantsOnDateForJob(Date date,
                                                    Job job)
  {
    Applications applicationsForJob = applicationRepository.viewApplicationsForJob(job);

    List<Jobseeker> applicantsOnDateForJob = new ArrayList<Jobseeker>();
    
    Iterator<Application> iter = applicationsForJob.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      addApplicantForJobIfApplicationOnDate(date, application, applicantsOnDateForJob);
    }
    
    return applicantsOnDateForJob;
  }

  private List<Jobseeker> addApplicantForJobIfApplicationOnDate(Date date,
                                                                Application application,
                                                                List<Jobseeker> applicantsOnDateForJob)
  {
    if (application.isApplicationOnDate(date))
      applicantsOnDateForJob.add(application.applicant());
    return applicantsOnDateForJob;
  }

}
