package job;

import static org.junit.Assert.*;
import jobs.ATS;
import jobs.Job;

import org.junit.Test;

import employer.Employer;

public class TestJob
{
  @Test(expected = NullPointerException.class)
  public void testWithNullEmployer()
  {
    new ATS(null, null);
  }

  @Test
  public void testCheckEmployerPostedThisJob()
  {
    Employer employer = new Employer("Ruby");
    Job job = new ATS("hello", employer);

    assertTrue(job.checkEmployerPostedJob(employer));

    Employer bademployer = new Employer("badEmployer");
    assertFalse(job.checkEmployerPostedJob(bademployer));
  }
}
