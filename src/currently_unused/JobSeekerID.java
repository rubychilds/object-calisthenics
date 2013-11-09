package currently_unused;

public class JobSeekerID {

  private int idNumber;

  public JobSeekerID(){
    this.idNumber = 0;
  }

  public int next(){
    return idNumber++;	
  }
}
