package employer;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import jobs.Job;
import jobs.Jobs;
import jobs.JobPoster;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import employer.Employer;

public class TestEmployer
{

  private JobPoster jobPoster;

  @Test
  public void testPost()
  {
    Employer employer = new Employer("ruby");
    Job job = mock(Job.class);
    employer.postJob(job, jobPoster);

    verify(jobPoster).postAJob(job);
  }

  @Test
  public void testViewPostsByMe()
  {
    Employer employer = new Employer("ruby");
    
    ArrayList<Job> jobs = employer.viewPostsByMe(jobPoster);
    
    verify(jobPoster).viewPostsByARecruiter(employer);
  }

  @Before
  public void setUp()
  {
    MockitoAnnotations.initMocks(this);

    Jobs jobs = new Jobs();
    jobPoster = spy(new JobPoster(jobs));
    
  }



}
