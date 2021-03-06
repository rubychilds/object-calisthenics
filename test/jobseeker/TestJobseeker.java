package jobseeker;

import jobs.ATS;
import jobs.JReq;
import jobs.Job;
import jobs.SavedJobs;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import resume.Resume;
import resume.ResumeService;
import applications.Application;
import applications.ApplicationService;
import applications.Applications;
import employer.Employer;

public class TestJobseeker
{

  private Jobseeker          NAMED_JOBSEEKER;
  private String             NAME_OF_JOBSEEKER;
  private Resume             RESUME;
  private Employer           employer;
  private Job                job;

  private ResumeService      resumeManager;
  private ApplicationService applicationManager;

  @Test(expected = NullPointerException.class)
  public void testJobseekerWithNullName()
  {
    new Jobseeker(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testJobseekerWithNoStringName()
  {
    new Jobseeker("");
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
  public void testJobseekerCanViewASavedJob()
  {
    SavedJobs savedJobs = new SavedJobs();

    NAMED_JOBSEEKER.saveJob(job, savedJobs);

    assertTrue(savedJobs.jobsByEmployer(NAMED_JOBSEEKER).size() == 1);
    assertTrue(savedJobs.jobsByEmployer(NAMED_JOBSEEKER).contains(job));
  }

  @Test
  public void testJobseekerCanAddResume()
  {
    ResumeService resumeManager = spy(new ResumeService());

    NAMED_JOBSEEKER.addResume(RESUME, resumeManager);

    verify(resumeManager).addResume(RESUME);
  }

  @Test
  public void testJobseekerCanActivateResume()
  {
    ResumeService resumeManager = spy(new ResumeService());

    NAMED_JOBSEEKER.activateResume(RESUME, resumeManager);

    verify(resumeManager).activateResume(RESUME);
  }

  @Test
  public void testJobseekerCanViewActiveResume()
  {
    ResumeService resumeManager = spy(new ResumeService());

    NAMED_JOBSEEKER.activateResume(RESUME, resumeManager);

    assertTrue(NAMED_JOBSEEKER.viewActiveResume(resumeManager) == RESUME);
  }

  @Test
  public void testJobseekerCanViewAnAddedResume()
  {
    ResumeService resumeManager = spy(new ResumeService());

    NAMED_JOBSEEKER.addResume(RESUME, resumeManager);

    assertTrue(resumeManager.resumesForJobseeker(NAMED_JOBSEEKER).size() == 1);
    assertTrue(resumeManager.resumesForJobseeker(NAMED_JOBSEEKER).contains(RESUME));
  }

  @Test
  public void testJobseekerCanApplyForATSJobWithoutCV()
  {
    setupApplicationSystem();

    this.job = new ATS("dogWalker", this.employer);

    Application application = NAMED_JOBSEEKER.applyForJob(job, applicationManager);

    Applications applications = NAMED_JOBSEEKER.viewApplications(applicationManager);

    assertTrue(applications.contains(application));
  }

  @Test
  public void testJobseekerCanApplyForAJReqJobWithCV()
  {
    setupApplicationSystem();

    this.job = new JReq("dogWalker", this.employer);

    NAMED_JOBSEEKER.activateResume(RESUME, resumeManager);

    Application application = NAMED_JOBSEEKER.applyForJob(job, applicationManager);

    Applications applications = NAMED_JOBSEEKER.viewApplications(applicationManager);

    assertTrue(applications.contains(application));
  }

  @Test
  public void testJobseekerCannotApplyForAJReqJobWithoutCV()
  {
    setupApplicationSystem();

    this.job = new JReq("dogWalker", this.employer);

    Application application = NAMED_JOBSEEKER.applyForJob(job, applicationManager);

    Applications applications = NAMED_JOBSEEKER.viewApplications(applicationManager);

    assertTrue(applications.isEmpty());
    assertTrue(!applications.contains(application));
  }

  private void setupApplicationSystem()
  {
    this.resumeManager = new ResumeService();
    this.applicationManager = new ApplicationService(resumeManager);
  }

  @Before
  public void Setup()
  {
    this.NAME_OF_JOBSEEKER = "Ruby";
    this.NAMED_JOBSEEKER = new Jobseeker(NAME_OF_JOBSEEKER);

    this.employer = new Employer("the Ladders");
    this.job = new JReq("dogWalker", this.employer);
    this.RESUME = new Resume("this is a resume", NAMED_JOBSEEKER);
  }

}
