package applications;

public class Date
{
  private int year;
  private int month;
  private int day;

  public Date(int year,
              int month,
              int day)
  {
    if (checkDateIsValid(year, month, day))
    {
      this.year = year;
      this.month = month;
      this.day = day;
    }
  }

  // basic checking - needs to be improved s.t. month, day and year are within their own classes
  private boolean checkDateIsValid(int year,
                                   int month,
                                   int day)
  {
    if (month < 1 || month > 12)
      return false;
    if (day < 1)
      return false;

    return true;
  }

  public Date()
  {
    java.util.Date date = new java.util.Date();
    this.year = date.getYear();
    this.month = date.getMonth();
    this.day = date.getDay();
  }

  public boolean isEqual(Date date)
  {
    return day == date.day() && month == date.month() && year == date.year();
  }

  public int day()
  {
    return this.day;
  }

  public int month()
  {
    return this.month;
  }

  public int year()
  {
    return this.year;
  }

}
