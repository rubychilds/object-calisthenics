package resume;


public class Resume {

  public final String resume;

  public Resume(String res){
    
    if(res == null)
      throw new NullPointerException();
    if(res.equals(""))
      throw new IllegalArgumentException();
    
    this.resume = res;
  }
  
  public String resumeString()
  {
    return resume;
  }
  
}
