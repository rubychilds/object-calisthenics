package employer;

import employer.Name;

import org.junit.Assert;
import org.junit.Test;

public class TestName
{

  @Test(expected = NullPointerException.class)
  public void TestNullName()
  {
    Name testEmployerName = new Name(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestNoStringName()
  {
    Name testEmployerName = new Name("");
  }

  @Test
  public void TestStringName()
  {
    String ruby = "ruby";
    Name testEmployerName = new Name(ruby);
    String name = testEmployerName.toString();
    Assert.assertTrue(ruby.equals(name));
  }

}
