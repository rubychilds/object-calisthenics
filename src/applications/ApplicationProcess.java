package applications;

import resume.ActiveResumeRepo;
import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationProcess
{

  private ApplicationRepository applicationRepo;
  private ActiveResumeRepo  activeResumeRepo;

  public ApplicationProcess(ActiveResumeRepo activeResumeRepo, ApplicationRepository applicationRepo)
  {
    this.applicationRepo = applicationRepo;
    this.activeResumeRepo = activeResumeRepo;
  }

  public void apply(Jobseeker jobseeker,
                    Job job)
  {

    Application application = createApplication(jobseeker, job);
    applicationRepo.addApplication(jobseeker, application);
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
    return new Application(jobseeker, job, activeResumeRepo.viewActiveResume(jobseeker));
  }

  private Application createApplicationWithoutResume(Jobseeker jobseeker,
                                                     Job job)
  {
    return new Application(jobseeker, job);
  }

}
