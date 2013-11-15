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
    Iterator<Application> iterator = applications.iterator();

    return iterator;
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
  
  public Iterator<Application> applicationsIterator()
  {
    return new myIterator();
  }

  public class myIterator implements Iterator<Application>
  {

    Iterator<Application> iter = applications.iterator();

    public boolean hasNext()
    {
      return iter.hasNext();
    }

    public Application next()
    {
      return iter.next();
    }

    public void remove()
    {
      iter.remove();
    }

  }

}
