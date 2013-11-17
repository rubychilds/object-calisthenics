package employer;

import static org.junit.Assert.*;
import jobs.ATS;
import jobs.JReq;
import jobs.Job;
import jobs.JobManager;
import jobs.Jobs;
import jobseeker.Jobseeker;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import resume.Resume;
import resume.ResumeService;
import applications.ApplicationService;
import applications.Date;
import employer.Employer;

public class EmployerTest
{
  private JobManager         jobManager;
  private Employer           employer;
  private Jobseeker          jobseeker;
  private ResumeService      resumeManager;
  private Date               date;
  private ApplicationService applicationManager;
  private Job                job;

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

    Jobs jobs = employer.viewPostsByMe(jobManager);

    assertTrue(jobs.contains(job));
  }

  @Test
  public void testICanViewATSJobPost()
  {
    Job job = new ATS("artist", employer);
    employer.postJob(job, jobManager);

    Jobs jobs = employer.viewPostsByMe(jobManager);

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

  @Test
  public void testICanViewNoApplicantsAfterPosintgAJobWithNoApplications()
  {
    employerPostsJob();
    assertTrue(employer.viewApplicantsForJob(job, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicantsAfterPosintgAJobWithNoApplicationsOnGivenDate()
  {
    employerPostsJob();
    assertTrue(employer.viewApplicantsOnDateForJob(date, job, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicantsAfterPosintgAJobWithNoApplicationsForMyPostings()
  {
    employerPostsJob();
    assertTrue(employer.viewApplicantsForMyJobs(jobManager, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewNoApplicantsAfterPosintgAJobWithNoApplicationsForMyPostingsOnGivenDate()
  {
    employerPostsJob();
    assertTrue(employer.viewApplicantsOnDateForMyJobs(date, jobManager, applicationManager).isEmpty());
  }

  @Test
  public void testICanViewApplicantToAJob()
  {
    employerPostsJob();
    jobseekerAppliesForJob();
    assertTrue(employer.viewApplicantsForJob(job, applicationManager).contains(jobseeker));
  }

  @Test
  public void testICanViewApplicantOnDateToJob()
  {
    jobseekerAppliesForJob();
    assertTrue(employer.viewApplicantsOnDateForJob(date, job, applicationManager).contains(jobseeker));
  }

  @Test
  public void testICanViewApplicantToMyJobs()
  {
    jobseekerAppliesForJob();
    assertTrue(employer.viewApplicantsForJob(job, applicationManager).contains(jobseeker));

    // add another job to the Job repo
    Employer alternativeEmployer = new Employer("another employer");
    Job jobByDifferentEmployer = new ATS("another job", alternativeEmployer);
    alternativeEmployer.postJob(jobByDifferentEmployer, jobManager);

    // jobseeker applies for new job by different employer
    Jobseeker jobseeker2 = new Jobseeker("alternative Jobseeker");
    jobseeker2.applyForJob(jobByDifferentEmployer, applicationManager);

    // this jobseeker did not apply to employers job - should not be present
    assertTrue(!employer.viewApplicantsForJob(job, applicationManager).contains(jobseeker2));
  }

  @Test
  public void testICanViewApplicantToMyJobsOnDate()
  {
    jobseekerAppliesForJob();
    assertTrue(employer.viewApplicantsOnDateForJob(date, job, applicationManager).contains(jobseeker));
  }

  public void employerPostsJob()
  {
    this.job = new ATS("artist", employer);
    this.jobManager = new JobManager();
    employer.postJob(job, jobManager);
  }

  public void jobseekerAppliesForJob()
  {
    employerPostsJob();
    jobseekerResumeSetup();
    this.applicationManager = new ApplicationService(resumeManager);
    jobseeker.applyForJob(job, applicationManager);
    this.date = new Date();
  }

  public void jobseekerResumeSetup()
  {
    Resume resume = new Resume("I'm a resume", jobseeker);
    this.resumeManager = new ResumeService();
    jobseeker.activateResume(resume, resumeManager);
  }

  @Before
  public void setUp()
  {
    MockitoAnnotations.initMocks(this);

    this.date = new Date();

    this.jobManager = new JobManager();

    this.employer = new Employer("Ruby");
    this.jobseeker = new Jobseeker("jobseekerMe");

    this.resumeManager = new ResumeService();
    this.applicationManager = new ApplicationService(resumeManager);
  }

}
