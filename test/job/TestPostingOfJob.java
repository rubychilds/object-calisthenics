package job;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import jobs.ATS;
import jobs.Job;

import org.junit.Before;
import org.junit.Test;

import employer.Employer;

public class TestPostingOfJob
{
  private Employer employer;
  private Job job;
  
  @Test
  public void testCheckEmployerPostedJob()
  {
    assertTrue(job.checkEmployerPostedJob(employer));
  }
  
  @Before
  public void setUp()
  {
    this.employer = mock(Employer.class);
    job = spy(new ATS("Software Engineer", employer));
  }

}
