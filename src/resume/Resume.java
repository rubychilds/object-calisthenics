package resume;

import jobseeker.Jobseeker;


public class Resume {

  private String resume;
  private Jobseeker jobseeker;
  
  public Resume(String res, Jobseeker jobseeker){
    
    if(res == null || jobseeker == null)
      throw new NullPointerException();
    if(res.equals(""))
      throw new IllegalArgumentException();
    
    this.resume = res;
    this.jobseeker = jobseeker;
  }
  
  public String resumeString()
  {
    return resume;
  }
  
  public boolean byJobseeker(Jobseeker jobseeker)
  {
    return this.jobseeker == jobseeker;
  }
  
}
