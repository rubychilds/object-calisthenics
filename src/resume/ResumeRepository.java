package resume;

import java.util.HashMap;

import jobseeker.Jobseeker;

public class ResumeRepository
{
  private HashMap<Jobseeker, Resumes> resumeRepoForJobseekers;

  public ResumeRepository()
  {
    this.resumeRepoForJobseekers = new HashMap<>();
  }

  public void addResume(Jobseeker jobseeker,
                        Resume resume)
  {
    Resumes resumesForJobseeker = resumeRepoForJobseekers.get(jobseeker);

    if (resumesForJobseeker == null)
      resumesForJobseeker = new Resumes();

    resumesForJobseeker.addResume(resume);

    resumeRepoForJobseekers.put(jobseeker, resumesForJobseeker);

  }

  public Resumes resumesForJobseeker(Jobseeker jobseeker)
  {
    return resumeRepoForJobseekers.get(jobseeker);
  }
  
}
