package applications;

import static org.junit.Assert.*;
import jobs.ATS;
import jobs.Job;
import jobseeker.Jobseeker;

import org.junit.Before;
import org.junit.Test;

import resume.Resume;
import employer.Employer;

public class TestApplication
{
  private Jobseeker jobseeker;
  private Resume    resume;
  private Job       job;
  private Employer  employer;
  private Application application;

  @Test(expected = NullPointerException.class)
  public void testWithNullJobseeker()
  {
    new Application(null, job);
    new Application(null, job, resume);
  }

  @Test(expected = NullPointerException.class)
  public void testWithNullJob()
  {
    new Application(jobseeker, null);
    new Application(jobseeker, null, resume);
  }

  @Test(expected = NullPointerException.class)
  public void testWithNullResume()
  {
    new Application(jobseeker, job, null);
  }

  @Test
  public void testApplicationIsByJobseeker()
  {
    assertTrue(application.isApplicationByJobseeker(jobseeker));
  }

  @Test
  public void testApplicationIsNotByJobseeker()
  {
    Jobseeker alternativeJobseeker = new Jobseeker("I'm another seeker");
    assertFalse(application.isApplicationByJobseeker(alternativeJobseeker));
  }

  @Test
  public void testApplicationIsForJob()
  {
    assertTrue(application.isApplicationForJob(job));
  }

  @Test
  public void testApplicationIsNotForJob()
  {
    Job alternativeJob = new ATS("I'm another job", employer);
    assertFalse(application.isApplicationForJob(alternativeJob));
  }

  @Test
  public void testApplicationIsOnDate()
  {
    Date date = new Date();
    assertTrue(application.isApplicationOnDate(date));
  }

  @Test
  public void testApplicationIsNotOnDate()
  {
    Date date = new Date(2012, 11, 15);
    assertFalse(application.isApplicationOnDate(date));
  }

  @Before
  public void setUp()
  {
    this.jobseeker = new Jobseeker("Ruby seeker");
    this.employer = new Employer("Ruby employer");
    this.resume = new Resume("I'm a resume", jobseeker);
    this.job = new ATS("I'm a job", employer);
    this.application = new Application(jobseeker, job);
  }

}
