package employer;

public class Name
{

  private final String name;

  public Name(String name)
  {
    if(name.equals(""))
      throw new IllegalArgumentException();
    if(name == null)
      throw new NullPointerException();
    
    this.name = name;
  }
  
  public String toString()
  {
    return this.name;
  }
  
}
