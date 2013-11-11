package applications;

import java.util.ArrayList;
import java.util.List;

import resume.ActiveResumeRepo;
import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationProcess
{

  private List<Application> applications;
  private ActiveResumeRepo  activeResumeRepo;

  public ApplicationProcess(ActiveResumeRepo activeResumeRepo)
  {
    this.applications = new ArrayList<>();
    this.activeResumeRepo = activeResumeRepo;
  }

  public void apply(Jobseeker jobseeker,
                    Job job)
  {

    Application application = createApplication(jobseeker, job);
    applications.add(application);
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
