package jobseeker;

import org.junit.Assert;
import org.junit.Test;

public class TestJobSeekerName
{

  @Test(expected = NullPointerException.class)
  public void TestNullName()
  {
     new JobseekerName(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestNoStringName()
  {
    new JobseekerName("");
  }

  @Test
  public void TestStringName()
  {
    String ruby = "ruby";

    JobseekerName jobseekerName = new JobseekerName(ruby);
    String name = jobseekerName.name();
    Assert.assertTrue(ruby.equals(name));
  }
}
