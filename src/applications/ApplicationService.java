package applications;

import java.util.Iterator;

import jobs.Job;
import jobseeker.Jobseeker;
import jobseeker.Jobseekers;
import resume.ResumeService;

public class ApplicationService
{
  private ApplicationProcess    applicationProcess;
  private ApplicationRepository applicationRepository;

  public ApplicationService(ResumeService resumeManager)
  {
    this.applicationRepository = new ApplicationRepository();
    this.applicationProcess = new ApplicationProcess(resumeManager, applicationRepository);
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

  public Jobseekers viewApplicantsForJob(Job job)
  {

    Applications applicationsForJob = applicationRepository.viewApplicationsForJob(job);
    Jobseekers applicantsForJob = new Jobseekers();

    Iterator<Application> iter = applicationsForJob.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      applicantsForJob.add(application.applicant());
    }

    return applicantsForJob;
  }

  public Jobseekers viewApplicantsOnDateForJob(Date date,
                                               Job job)
  {
    Applications applicationsForJob = applicationRepository.viewApplicationsForJob(job);

    Jobseekers applicantsOnDateForJob = new Jobseekers();

    Iterator<Application> iter = applicationsForJob.iterator();
    while (iter.hasNext())
    {
      Application application = iter.next();
      addApplicantForJobIfApplicationOnDate(date, application, applicantsOnDateForJob);
    }

    return applicantsOnDateForJob;
  }

  private Jobseekers addApplicantForJobIfApplicationOnDate(Date date,
                                                           Application application,
                                                           Jobseekers applicantsOnDateForJob)
  {
    if (application.isApplicationOnDate(date))
      applicantsOnDateForJob.add(application.applicant());
    return applicantsOnDateForJob;
  }

}
