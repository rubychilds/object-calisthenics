package jobs;

import java.util.HashMap;

import jobseeker.Jobseeker;

public class SavedJobs
{ 
  private HashMap<Jobseeker, Jobs> savedJobseekerJobs;

  public SavedJobs()
  {
    this.savedJobseekerJobs = new HashMap<>();
  }

  public void saveJob(Jobseeker jobseeker,
                      Job job)
  {

    Jobs currentJobseekerJobs = savedJobseekerJobs.get(jobseeker);

    if (currentJobseekerJobs == null)
      currentJobseekerJobs = new Jobs();

    currentJobseekerJobs.add(job);
    savedJobseekerJobs.put(jobseeker, currentJobseekerJobs);
  }

  public Jobs jobsByEmployer(Jobseeker jobseeker)
  {
    return savedJobseekerJobs.get(jobseeker);
  }
}
