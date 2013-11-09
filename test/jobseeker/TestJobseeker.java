package jobseeker;

import jobs.JReq;
import jobs.Job;
import jobs.SavedJobs;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import resume.Resume;
import resume.ResumeRepository;
import applications.ApplicationProcess;
import employer.Employer;

public class TestJobseeker
{

  private Jobseeker NAMED_JOBSEEKER;
  private String    NAME_OF_JOBSEEKER;
  private Employer  employer;
  private Job       job;

  @Test(expected = NullPointerException.class)
  public void testJobseekerWithNullName()
  {
    Jobseeker jobseeker = new Jobseeker(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobseekerWithNoStringName()
  {
    Jobseeker jobseeker = new Jobseeker("");
  }

  @Test
  public void testJobseekerWithStringName()
  {
    assertTrue(NAMED_JOBSEEKER.name().equals(NAME_OF_JOBSEEKER));
  }

  @Test
  public void testJobseekerCanSaveAJob()
  {
    Job job = mock(Job.class);

    SavedJobs savedJobs = spy(new SavedJobs());
    NAMED_JOBSEEKER.saveJob(job, savedJobs);

    verify(savedJobs).saveJob(NAMED_JOBSEEKER, job);
  }

  @Test
  public void testJobseekerCanViewAPostedJob()
  {
    SavedJobs savedJobs = new SavedJobs();

    assertTrue(savedJobs.jobsByEmployer(NAMED_JOBSEEKER).isEmpty());

    NAMED_JOBSEEKER.saveJob(job, savedJobs);

    assertTrue(savedJobs.jobsByEmployer(NAMED_JOBSEEKER).size() == 1);
    assertTrue(savedJobs.jobsByEmployer(NAMED_JOBSEEKER).contains(job));
  }

  @Test
  public void testJobseekerCanApplyForAJob()
  {
    ApplicationProcess applicationProcess = spy(new ApplicationProcess());

    NAMED_JOBSEEKER.applyForJob(job, applicationProcess);

    verify(applicationProcess).apply(NAMED_JOBSEEKER, job);
  }

  @Test
  public void testJobseekerCanAddResume()
  {
    ResumeRepository resumeRepo = spy(new ResumeRepository());

    Resume resume = new Resume("this is a resume");

    NAMED_JOBSEEKER.addResume(resume, resumeRepo);

    verify(resumeRepo).addResume(NAMED_JOBSEEKER, resume);
  }

  @Before
  public void Setup()
  {
    NAME_OF_JOBSEEKER = "Ruby";
    NAMED_JOBSEEKER = new Jobseeker(NAME_OF_JOBSEEKER);

    this.employer = new Employer("the Ladders");
    this.job = new JReq("dogWalker", employer);

  }

}
