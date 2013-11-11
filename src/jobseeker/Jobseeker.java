package jobseeker;

import resume.ActiveResumeRepo;
import resume.Resume;
import resume.ResumeRepository;
import applications.ApplicationProcess;
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

  public void saveJob(Job job,
                      SavedJobs savedJobs)
  {
    savedJobs.saveJob(this, job);
  }

  public Jobs viewJobsPostedByMe(SavedJobs savedJobs)
  {
    return savedJobs.jobsByEmployer(this);
  }

  public void applyForJob(Job job,
                          ApplicationProcess applicationProcess)
  {
    applicationProcess.apply(this, job);
  }
  
  public void addResume(Resume resume, ResumeRepository resumeRepository)
  {
    resumeRepository.addResume(this, resume);
  }
  
  public void activateResume(Resume resume, ActiveResumeRepo  activeResumeRepo)
  {
    activeResumeRepo.activateResume(this, resume);
  }
  
  public Resume viewActiveResume(ActiveResumeRepo  activeResumeRepo)
  {
    return activeResumeRepo.viewActiveResume(this);
  }
  

  public String name()
  {
    return jobseekerName.name();
  }
}
