package applications;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDate
{
  private int year;
  private int month;
  private int day;

  @Test
  public void testConstructorWithArguments()
  {
    Date date = new Date(year, month, day);

    assertTrue(date.month() == month);
    assertTrue(date.year() == year);
    assertTrue(date.day() == day);
  }

  @Test
  public void testEmptyConstructor()
  {
    java.util.Date dateInTest = new java.util.Date();
    Date date = new Date();

    int day = dateInTest.getDay();
    int month = dateInTest.getMonth();
    int year = dateInTest.getYear();

    assertTrue(date.month() == month);
    assertTrue(date.year() == year);
    assertTrue(date.day() == day);
  }

  @Test
  public void testComparisonTwoDatesWhichAreTheSame()
  {
    Date date1 = new Date(year, month, day);
    Date date2 = new Date(year, month, day);

    assertTrue(date1.isEqual(date2));
  }

  @Test
  public void testComparisonTwoDatesWhichAreNotTheSame()
  {

    Date date1 = new Date(year, month, day);
    Date date2 = new Date(year, month, day + 1);

    assertTrue(!date1.isEqual(date2));
  }

  @Before
  public void setUp()
  {
    this.year = 2013;
    this.month = 11;
    this.day = 15;
  }

}
