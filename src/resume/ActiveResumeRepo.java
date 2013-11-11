package resume;

import java.util.HashMap;

import jobseeker.Jobseeker;

public class ActiveResumeRepo
{

  private HashMap<Jobseeker, Resume> activeResumes;

  public ActiveResumeRepo()
  {
    this.activeResumes = new HashMap<>();
  }

  public void activateResume(Jobseeker jobseeker,
                             Resume resume)
  {
    Resume resumeInRepo = activeResumes.get(jobseeker);
    activeResumes.put(jobseeker, resume);
  }
  
  public Resume viewActiveResume(Jobseeker jobseeker)
  {
    return activeResumes.get(jobseeker);
  }

}
