package jobseeker;


import resume.ActiveResumeRepo;
import resume.Resume;
import resume.ResumeRepository;
import applications.ApplicationManager;
import applications.Application;
import applications.Applications;
import jobs.Job;
import jobs.Jobs;
import jobs.SavedJobs;

public class Jobseeker
{

  private JobseekerName jobseekerName;

  public Jobseeker(String name)
  {

    this.jobseekerName = new JobseekerName(name);
  }

  // SAVE JOBS
  public void saveJob(Job job,
                      SavedJobs savedJobs)
  {
    savedJobs.saveJob(this, job);
  }

  public Jobs viewJobsPostedByMe(SavedJobs savedJobs)
  {
    return savedJobs.jobsByEmployer(this);
  }

  // RESUME
  public void addResume(Resume resume,
                        ResumeRepository resumeRepository)
  {
    resumeRepository.addResume(resume);
  }

  public void activateResume(Resume resume,
                             ActiveResumeRepo activeResumeRepo)
  {
    activeResumeRepo.activateResume(this, resume);
  }

  public Resume viewActiveResume(ActiveResumeRepo activeResumeRepo)
  {
    return activeResumeRepo.viewActiveResume(this);
  }

  // APPLY
  public Application applyForJob(Job job,
                                 ApplicationManager applicationManager)
  {
    return applicationManager.apply(this, job);
  }

  public Applications viewApplications(ApplicationManager applicationManager)
  {
    return applicationManager.viewApplicationsByJobseeker(this);
  }

  public String name()
  {
    return jobseekerName.name();
  }
}
