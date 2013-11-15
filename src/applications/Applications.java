package applications;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Applications
{
  private List<Application> applications;

  public Applications()
  {
    this.applications = new ArrayList<Application>();

  }

  public void add(Application application)
  {
    applications.add(application);
  }

  public Iterator<Application> iterator()
  {
    return applications.iterator();
  }
}
