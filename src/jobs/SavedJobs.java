package jobs;

import java.util.HashMap;
import java.util.List;

import jobseeker.Jobseeker;

public class SavedJobs
{
  private List<JobseekerJob>       savedJobs;
  private HashMap<Jobseeker, Jobs> savedJobseekerJobs;

  public SavedJobs()
  {
    this.savedJobseekerJobs = new HashMap<>();
  }

  public void saveJob(Jobseeker jobseeker,
                      Job job)
  {
    if (savedJobseekerJobs.containsKey(jobseeker))
    {
      Jobs currentJobseekerJobs = savedJobseekerJobs.get(jobseeker);
      currentJobseekerJobs.add(job);
      savedJobseekerJobs.put(jobseeker, currentJobseekerJobs);
      return;
    }

    Jobs currentJobseekerJobs = new Jobs();
    currentJobseekerJobs.add(job);
    savedJobseekerJobs.put(jobseeker, currentJobseekerJobs);
  }

  public Jobs jobsByEmployer(Jobseeker jobseeker)
  {
    return savedJobseekerJobs.get(jobseeker);

  }
}
