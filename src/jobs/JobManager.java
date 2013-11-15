package jobs;


import employer.Employer;

public class JobManager
{
  private JobPoster     jobPoster;
  private JobRepository jobRepository;

  public JobManager()
  {
    this.jobRepository = new JobRepository();
    this.jobPoster = new JobPoster(jobRepository);
  }

  public Jobs viewPostsByARecruiter(Employer employer)
  {
    return jobRepository.jobsByEmployer(employer);
  }

  public void postAJob(Job job)
  {
    jobPoster.postAJob(job);
  }

}
