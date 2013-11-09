package currently_unused;

import java.util.ArrayList;

import resume.Resume;

public class JobSeekerManager
{

  private ResumeManager        ResManager;
  private JobSeekerID          jobIDMan;
  private ArrayList<JobSeeker> seekers;

  public JobSeekerManager()
  {
    this.ResManager = new ResumeManager();
    this.jobIDMan = new JobSeekerID();
  }

  public void newJobSeeker(String name,
                           String resume)
  {
    JobSeeker js = new JobSeeker(null, jobIDMan);
    Resume res = new Resume(resume);
    ResManager.addResume(js, res);
    add(js);
  }

  private void add(JobSeeker js)
  {
    seekers.add(js);
  }

}
