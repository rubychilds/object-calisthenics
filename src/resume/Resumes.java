package resume;

import java.util.ArrayList;
import java.util.List;

public class Resumes
{
  private List<Resume> resumes;
  
  public Resumes()
  {
    this.resumes = new ArrayList<>();
  }
  
  public void addResume(Resume resume)
  {
    resumes.add(resume) ;
  }
  
}
