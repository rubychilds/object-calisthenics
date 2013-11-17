package applications;

import resume.Resume;
import resume.ResumeManager;
import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationProcess
{

  private ApplicationRepository applicationRepo;
  private ResumeManager         resumeManager;

  public ApplicationProcess(ResumeManager resumeManager,
                            ApplicationRepository applicationRepository)
  {
    this.applicationRepo = applicationRepository;
    this.resumeManager = resumeManager;
  }

  public Application apply(Jobseeker jobseeker,
                           Job job)
  {

    Application application = createApplication(jobseeker, job);
    if (application == null)
      return null;

    applicationRepo.addApplication(jobseeker, application);
    return application;
  }

  private Application createApplication(Jobseeker jobseeker,
                                        Job job)
  {
    if (job.requiresResume())
      return createApplicationWithResume(jobseeker, job);

    return createApplicationWithoutResume(jobseeker, job);
  }

  private Application createApplicationWithResume(Jobseeker jobseeker,
                                                  Job job)
  {
    Resume resume = resumeManager.viewActiveResume(jobseeker);
    if (resume == null)
      return null;

    return new Application(jobseeker, job, resume);
  }

  private Application createApplicationWithoutResume(Jobseeker jobseeker,
                                                     Job job)
  {
    return new Application(jobseeker, job);
  }

}
