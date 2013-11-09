package job;

import jobs.JobTitle;

import org.junit.Assert;
import org.junit.Test;

import employer.Name;

public class TestJobTitle
{

  @Test
  public void TestStringTitle()
  {
    JobTitle jobTitle = new JobTitle("software engineer");
    String title = jobTitle.toString();
    Assert.assertTrue("software engineer".equals(title));
  }
  
  @Test(expected = NullPointerException.class)
  public void TestNullName()
  {
    JobTitle jobTitle = new JobTitle(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestNoStringName()
  {
    JobTitle jobTitle = new JobTitle("");
  }

}
