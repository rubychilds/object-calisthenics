package currently_unused;


public class JobSeekersName{
  private final String name;
  private final int jobSeekerID;

  public JobSeekersName(String name, JobSeekerID jsID){

    if(name == null|| name.equals("")) throw new IllegalArgumentException("the name cannot be null");
    this.name = name;
    this.jobSeekerID = jsID.next();
  }

}
