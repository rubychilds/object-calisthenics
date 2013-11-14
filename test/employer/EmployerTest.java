package employer;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import jobs.ATS;
import jobs.JReq;
import jobs.Job;
import jobs.JobManager;
import jobs.Jobs;
import jobseeker.Jobseeker;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import resume.ActiveResumeRepo;
import applications.Application;
import applications.ApplicationManager;
import applications.ApplicationRepository;
import employer.Employer;

public class EmployerTest
{
  private JobManager            jobManager;
  private Employer              employer;
  private Jobseeker             jobseeker;
  private Application           application;
  private ActiveResumeRepo      activeResumeRepo;
  private ApplicationRepository applicationRepo;
  private Date                  date;
  private ApplicationManager    applicationManager;

  @Test
  public void testPost()
  {
    Job job = new ATS("ATS", employer);
    employer.postJob(job, jobManager);
  }

  @Test
  public void testICanViewJReqJobPost()
  {
    Job job = new JReq("animator", employer);
    employer.postJob(job, jobManager);

    List<Job> jobs = employer.viewPostsByMe(jobManager);

    assertTrue(jobs.contains(job));
  }

  @Test
  public void testICanViewATSJobPost()
  {
    Job job = new ATS("artist", employer);
    employer.postJob(job, jobManager);

    List<Job> jobs = employer.viewPostsByMe(jobManager);

    assertTrue(jobs.contains(job));
  }

  @Test
  public void testICanViewNoApplicationsBeforePostingAJob()
  {
    Job job = new ATS("artist", employer);
    assertTrue(employer.viewApplicantsForJob(job, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicationsBeforePostingAJobOnGivenDate()
  {
    Job job = new ATS("artist", employer);
    assertTrue(employer.viewApplicantsOnDateForJob(date, job, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicantsWithNoJobPostings()
  {
    assertTrue(employer.viewApplicantsForMyJobs(jobManager, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicantsWithNoJobPostingsOnGivenDate()
  {
    assertTrue(employer.viewApplicantsOnDateForMyJobs(date, jobManager, applicationManager).isEmpty());
  }

  @Before
  public void setUp()
  {
    MockitoAnnotations.initMocks(this);

    this.date = new Date();

    this.jobManager = new JobManager();

    this.employer = new Employer("Ruby");
    this.jobseeker = new Jobseeker("jobseekerMe");

    this.activeResumeRepo = new ActiveResumeRepo();
    this.applicationRepo = new ApplicationRepository();
    this.applicationManager = new ApplicationManager(activeResumeRepo);
  }

}
