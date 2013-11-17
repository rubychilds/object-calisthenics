package jobseeker;

import resume.Resume;
import resume.ResumeService;
import applications.ApplicationService;
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
                        ResumeService resumeService)
  {
    resumeService.addResume(resume);
  }

  public void activateResume(Resume resume,
                             ResumeService resumeService)
  {
    if (resume.isByJobseeker(this))
    {
      resumeService.activateResume(resume);
    }
  }

  public Resume viewActiveResume(ResumeService resumeService)
  {
    return resumeService.viewActiveResume(this);
  }

  // APPLY
  public Application applyForJob(Job job,
                                 ApplicationService applicationService)
  {
    return applicationService.apply(this, job);
  }

  public Applications viewApplications(ApplicationService applicationService)
  {
    return applicationService.viewApplicationsByJobseeker(this);
  }

  public boolean isJobseeker(Jobseeker jobseeker)
  {
    return this == jobseeker;
  }

  public String name()
  {
    return jobseekerName.name();
  }
}
