// File [Logic_java_4.1.html] MAS - last created: Fri 28 Apr 2017 21:40:21 BST

public class Logic extends GUI
{
  private Counter counter = null;
  
  public Logic( Counter aCounter )
  {
    counter = aCounter;
  }
 
  public long getValue()
  {
    return counter.getValue();
  }
 
  public void process( String button )
  {
    switch ( button )
    {
      case "Inc" :
        counter.inc();
        break;
      case "Dec" :
        counter.dec();
        break;
      case "Zero" :
        counter.reset();
        break;
      case "+5" :
        counter.add5();
        break;
      case "+10" :
        counter.add10();
        break;
    }
  }

}
