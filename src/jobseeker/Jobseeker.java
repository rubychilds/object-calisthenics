package jobseeker;

import resume.Resume;
import resume.ResumeManager;
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
                        ResumeManager resumeManager)
  {
    resumeManager.addResume(resume);
  }

  public void activateResume(Resume resume,
                             ResumeManager resumeManager)
  {
    if (resume.isByJobseeker(this))
    {
      resumeManager.activateResume(resume);
    }
  }

  public Resume viewActiveResume(ResumeManager resumeManager)
  {
    return resumeManager.viewActiveResume(this);
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

  public boolean isJobseeker(Jobseeker jobseeker)
  {
    return this == jobseeker;
  }

  public String name()
  {
    return jobseekerName.name();
  }
}
