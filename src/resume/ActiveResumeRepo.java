package resume;

import java.util.Iterator;

import jobseeker.Jobseeker;

public class ActiveResumeRepo
{

  private Resumes activeResumes;

  public ActiveResumeRepo()
  {
    this.activeResumes = new Resumes();
  }

  public void activateResume(Resume resume)
  {
    Iterator<Resume> iter = activeResumes.iterator();
    boolean resumeExists = false;
    while (iter.hasNext())
    {
      Resume currentResume = iter.next();
      resumeExists = checkIfResumeExistsForJobseekerAndReplace(resume, currentResume);
    }

    if (resumeExists == false)
      activeResumes.add(resume);

  }

  private boolean checkIfResumeExistsForJobseekerAndReplace(Resume resume,
                                                            Resume currentResume)
  {
    Jobseeker jobseekerResumeBelongsTo = resume.belongsTo();
    if (currentResume.isByJobseeker(jobseekerResumeBelongsTo))
    {
      activeResumes.remove(currentResume);
      activeResumes.add(resume);
      return true;
    }
    return false;
  }

  public Resume viewActiveResume(Jobseeker jobseeker)
  {
    Iterator<Resume> iter = activeResumes.iterator();
    Resume activeResumeForJobseeker = null;
    while (iter.hasNext())
    {
      Resume currentResume = iter.next();
      activeResumeForJobseeker = checkIfResumeIsBy(jobseeker, currentResume);
    }
    return activeResumeForJobseeker;
  }

  private Resume checkIfResumeIsBy(Jobseeker jobseeker,
                                   Resume resume)
  {
    if (resume.isByJobseeker(jobseeker))
      return resume;
    return null;
  }
}
