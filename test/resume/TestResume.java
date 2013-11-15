package resume;

import static org.junit.Assert.*;
import jobseeker.Jobseeker;

import org.junit.Before;
import org.junit.Test;

public class TestResume
{
  private Jobseeker jobseeker;

  @Test(expected = NullPointerException.class)
  public void testResumeWithNullStringArg()
  {
    new Resume(null, jobseeker);

  }

  @Test(expected = NullPointerException.class)
  public void testResumeWithNullJobseekerArg()
  {
    new Resume("my res", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestNoStringName()
  {
    new Resume("", jobseeker);
  }

  @Test
  public void TestWithString()
  {
    String resumeInfo = "this is my resume";
    Resume resume = new Resume(resumeInfo, jobseeker);

    assertTrue(resume.resumeString().equals(resumeInfo));
  }

  @Before
  public void setUp()
  {
    this.jobseeker = new Jobseeker("Ruby");
  }

}
