package applications;

import static org.junit.Assert.*;

import java.util.Iterator;

import jobs.ATS;
import jobs.Job;
import jobseeker.Jobseeker;

import org.junit.Before;
import org.junit.Test;

import employer.Employer;

public class TestApplications
{

  private Jobseeker    jobseeker;
  private Job          job;
  private Application  application;
  private Applications applications;
  private Application  application1;
  private Application  application2;
  private Application  application3;
  private Application  application4;

  @Test
  public void testApplications()
  {
    Applications applications = new Applications();
    assertTrue(applications.isEmpty());
  }

  @Test
  public void testAddApplication()
  {
    Applications applications = new Applications();
    applications.add(application);
    assertFalse(applications.isEmpty());
    assertTrue(applications.contains(application));
  }

  @Test
  public void testApplicationsIterator()
  {
    this.applications = new Applications();
    setUpApplications();

    applications.add(application1);
    applications.add(application2);
    applications.add(application3);
    applications.add(application4);

    assertEquals(applications.size(), 4);

    Iterator iterator = applications.iterator();

    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), application1);

    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), application2);

    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), application3);

    assertTrue(iterator.hasNext());
    assertEquals(iterator.next(), application4);

    assertFalse(iterator.hasNext());
  }

  public void setUpApplications()
  {
    Employer employer1 = new Employer("TheLadders");
    Employer employer2 = new Employer("BritishAirways");
    Employer employer3 = new Employer("WholeFoods");
    Employer employer4 = new Employer("BAE");

    Job job1 = new ATS("softwareEngineer", employer1);
    Job job2 = new ATS("pilot", employer2);
    Job job3 = new ATS("customerService", employer3);
    Job job4 = new ATS("projectManagement", employer4);

    this.application1 = new Application(jobseeker, job1);
    this.application2 = new Application(jobseeker, job2);
    this.application3 = new Application(jobseeker, job3);
    this.application4 = new Application(jobseeker, job4);

  }

  @Before
  public void setUp()
  {
    this.jobseeker = new Jobseeker("Ruby Childs");
    Employer employer = new Employer("TheLadders");
    this.job = new ATS("I'm a job", employer);
    this.application = new Application(jobseeker, job);
  }

}
