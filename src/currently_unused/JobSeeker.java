package currently_unused;

public class JobSeeker
{

  private final JobSeekersName name;
  private final int            id;

  public JobSeeker(JobSeekersName name,
                   JobSeekerID jobSeekerID)
  {
    this.name = name;
    this.id = jobSeekerID.next();
  }

}
