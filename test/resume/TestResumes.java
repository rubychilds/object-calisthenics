package resume;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResumes
{
  @Test
  public void testResumeCanBeAdded()
  {
    Resumes resumes = new Resumes();
    Resume resume = new Resume("this is a new resume");

    assertTrue(resumes.isEmpty());

    resumes.addResume(resume);

    assertTrue(resumes.contains(resume));
    assertTrue(resumes.size() == 1);
  }
}
