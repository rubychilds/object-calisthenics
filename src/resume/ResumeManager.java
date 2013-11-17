package resume;

import jobseeker.Jobseeker;

public class ResumeManager
{
  
  private ActiveResumeRepo activeResumeRepository;
  private ResumeRepository resumeRepository;


  public ResumeManager()
  {
    this.resumeRepository = new ResumeRepository();
    this.activeResumeRepository = new ActiveResumeRepo();
  }

  public void activateResume(Resume resume)
  {
    activeResumeRepository.activateResume(resume);
  }
  
  
  public Resume viewActiveResume(Jobseeker jobseeker)
  {
    return activeResumeRepository.viewActiveResume(jobseeker);
  }
  
  public void addResume(Resume resume){

      activeResumeRepository.activateResume(resume);
      resumeRepository.addResume(resume);
  }

  public Resumes resumesForJobseeker(Jobseeker jobseeker)
  {
    return resumeRepository.resumesForJobseeker(jobseeker) ;
  }

}
