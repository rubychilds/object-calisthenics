package resume;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResume
{
  @Test(expected = NullPointerException.class)
  public void testResumeWithNullArg()
  {
    new Resume(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestNoStringName()
  {
    new Resume("");
  }

  @Test
  public void TestWithString()
  {
    String resumeInfo = "this is my resume";
    Resume resume = new Resume(resumeInfo);

    assertTrue(resume.resumeString().equals(resumeInfo));
  }

}
