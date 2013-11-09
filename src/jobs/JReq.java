package jobs;

import employer.Employer;
import resume.Resume;


public class JReq extends Job{

  public JReq(String title, Employer employer) {
    super(title, employer);
  }

  @Override
  public boolean apply(Resume resume) {
    return true;
  }

  @Override
  public boolean apply() {
    return false;
  }

}
