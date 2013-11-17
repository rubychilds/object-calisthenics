package resume;

import java.util.Iterator;

import jobseeker.Jobseeker;

public class ResumeRepository
{
  private Resumes resumes;
  private ActiveResumeRepo activeResumeRepo;

  public ResumeRepository()
  {
    this.resumes = new Resumes();
    this.activeResumeRepo =  new ActiveResumeRepo();
  }

  public void addResume(Resume resume)
  {
    if(resume == null)
      throw new NullPointerException();
    if(!resumes.contains(resume))
      resumes.add(resume); 
  }

  public Resumes resumesForJobseeker(Jobseeker jobseeker)
  {
    
    Resumes resumesForJobseeker = new Resumes();
    Iterator<Resume> iter = resumes.iterator();
    while(iter.hasNext()){
      Resume resume = iter.next();
      addResumeIfForJobseer(jobseeker, resume, resumesForJobseeker);
    
    }       
    return resumesForJobseeker;
  }
  
  public Resumes addResumeIfForJobseer(Jobseeker jobseeker, Resume resume, Resumes resumesForJobseeker)
  {
    if(resume.isByJobseeker(jobseeker))
      resumesForJobseeker.add(resume);
    
    return resumesForJobseeker;
  }

  public Resume viewActiveResume(Jobseeker jobseeker)
  {
    return activeResumeRepo.viewActiveResume(jobseeker);
  }
}
