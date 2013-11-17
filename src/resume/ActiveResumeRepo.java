package resume;

import java.util.HashMap;
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

    while (iter.hasNext())
    {
      Resume currentResume = iter.next();
      checkIfResumeExistsForJobseekerAndReplace(resume, currentResume);
    }
  }

  private void checkIfResumeExistsForJobseekerAndReplace(Resume resume,
                                                         Resume currentResume)
  {
    Jobseeker jobseekerResumeBelongsTo = resume.belongsTo();
    if (currentResume.isByJobseeker(jobseekerResumeBelongsTo))
    {
      activeResumes.remove(currentResume);
      activeResumes.add(resume);
    }
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
