package jobs;

public class JobPoster
{

  private JobRepository jobRepository;

  public JobPoster(JobRepository jobRepository)
  {
    this.jobRepository = jobRepository;
  }

  public void postAJob(Job job)
  {
    if (job == null)
      throw new NullPointerException();

    jobRepository.add(job);
  }

}
