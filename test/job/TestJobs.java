package job;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import jobs.Job;
import jobs.Jobs;

import org.junit.Before;
import org.junit.Test;

public class TestJobs
{
  
  private Jobs jobs;
  
  @Test
  public void testadd(){
    Job job = mock(Job.class);
    jobs.add(job);
    verify(jobs).add(job);
  }
  
  @Test
  public void testContains()
  {
    Job job = mock(Job.class);
    jobs.add(job);
    
    verify(jobs).contains(job);
    
    assertTrue(jobs.contains(job)); 
  }
  
  @Before
  public void SetUp()
  {
    this.jobs = spy( new Jobs());
  }
  

}
