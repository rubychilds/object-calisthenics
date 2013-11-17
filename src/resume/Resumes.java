package resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Resumes
{
  private List<Resume> resumes;

  public Resumes()
  {
    this.resumes = new ArrayList<>();
  }

  public void add(Resume resume)
  {
    if (resume == null)
      throw new NullPointerException();
    if (!resumes.contains(resume))
      resumes.add(resume);
  }

  public int size()
  {
    return resumes.size();
  }

  public boolean isEmpty()
  {
    return resumes.size() == 0;
  }

  public boolean contains(Resume resume)
  {
    return resumes.contains(resume);
  }
  
  public void remove(Resume resume)
  {
    resumes.remove(resume);
  }
  
  public Iterator<Resume> iterator()
  {
    return resumes.iterator();
  }

}
