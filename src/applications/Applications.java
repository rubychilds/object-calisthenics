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
    if (application == null)
      throw new NullPointerException();

    if (!applications.contains(application))
      applications.add(application);
  }

  public Iterator<Application> iterator()
  {
    return applications.iterator();
  }

  public boolean isEmpty()
  {
    return applications.isEmpty();
  }

  public boolean contains(Application application)
  {
    return applications.contains(application);
  }

  public int size()
  {
    return applications.size();
  }
}
