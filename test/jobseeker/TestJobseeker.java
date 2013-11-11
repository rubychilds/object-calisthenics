package jobseeker;

import jobs.JReq;
import jobs.Job;
import jobs.SavedJobs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import resume.ActiveResumeRepo;
import resume.Resume;
import resume.ResumeRepository;
import applications.ApplicationProcess;
import employer.Employer;

public class TestJobseeker
{

  private Jobseeker NAMED_JOBSEEKER;
  private String    NAME_OF_JOBSEEKER;
  private Resume    RESUME;
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
  public void testJobseekerCanApplyForAJob()
  {
    ActiveResumeRepo activeResumeRepo = new ActiveResumeRepo();
    ApplicationProcess applicationProcess = spy(new ApplicationProcess(activeResumeRepo));

    NAMED_JOBSEEKER.applyForJob(job, applicationProcess);

    verify(applicationProcess).apply(NAMED_JOBSEEKER, job);
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
    ResumeRepository resumeRepo = spy(new ResumeRepository());

    NAMED_JOBSEEKER.addResume(RESUME, resumeRepo);

    verify(resumeRepo).addResume(NAMED_JOBSEEKER, RESUME);
  }

  @Test
  public void testJobseekerCanActivateResume()
  {
    ActiveResumeRepo resumeRepo = spy(new ActiveResumeRepo());

    NAMED_JOBSEEKER.activateResume(RESUME, resumeRepo);

    verify(resumeRepo).activateResume(NAMED_JOBSEEKER, RESUME);
  }

  @Test
  public void testJobseekerCanViewActiveResume()
  {
    ActiveResumeRepo resumeRepo = spy(new ActiveResumeRepo());

    NAMED_JOBSEEKER.activateResume(RESUME, resumeRepo);

    assertTrue(NAMED_JOBSEEKER.viewActiveResume(resumeRepo) == RESUME);
  }

  @Test
  public void testJobseekerCanViewAnAddedResume()
  {
    ResumeRepository resumeRepo = new ResumeRepository();

    NAMED_JOBSEEKER.addResume(RESUME, resumeRepo);

    assertTrue(resumeRepo.resumesForJobseeker(NAMED_JOBSEEKER).size() == 1);
    assertTrue(resumeRepo.resumesForJobseeker(NAMED_JOBSEEKER).contains(RESUME));
  }

  @Before
  public void Setup()
  {
    this.NAME_OF_JOBSEEKER = "Ruby";
    this.NAMED_JOBSEEKER = new Jobseeker(NAME_OF_JOBSEEKER);

    this.employer = new Employer("the Ladders");
    this.job = new JReq("dogWalker", this.employer);
    this.RESUME = new Resume("this is a resume");

  }

}
