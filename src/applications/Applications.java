package applications;

import java.util.ArrayList;
import java.util.List;

public class Applications
{
  private List<Application> applications;
  
  public Applications()
  {
    this.applications = new ArrayList();
  }
  
  public void addApplication(Application application)
  {
    applications.add(application);
  }
  
}
