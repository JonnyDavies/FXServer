import java.math.BigDecimal;
import java.util.Random;

public class FXMarketValues {
  
  private BigDecimal[] num = new BigDecimal[4];
  private String start;

  public FXMarketValues()
  {
    start = "Done";    
    num[0] = new BigDecimal("1.001");
    num[1] = new BigDecimal("1.002");
    num[2] = new BigDecimal("1.001");
    num[3] = new BigDecimal("2.001");
  }
  
  public void applyMarketValueChange()
  {
    this.getMarcketValueOperation(0);
    this.getMarcketValueOperation(1);
    this.getMarcketValueOperation(2);
    this.getMarcketValueOperation(3);
    //num[2] = num[2].add(new BigDecimal ("0.00002"));
   // num[3] = num[3].add(new BigDecimal ("0.00008"));
  }
  
  public void getMarcketValueOperation(int index)
  {
    Random rdm = new Random();
    
    switch (rdm.nextInt(3))
    {
      case 0 :
        addMarketValue(index);
        break;
      case 1 :  
        subtractMarketValue(index);
        break;
      default : 
        // market value stays the same
        break;
    }
    
  }
  
  public void addMarketValue(int index)
  {
    Random rdm = new Random();
    
    switch (rdm.nextInt(6))
    {
      case 0 :
        num[index] = num[index].add(new BigDecimal ("0.001"));
        break;
      case 1 :  
        num[index] = num[index].add(new BigDecimal ("0.002"));
        break;
      case 2 :
        num[index] = num[index].add(new BigDecimal ("0.003"));
        break;
      case 3 :  
        num[index] = num[index].add(new BigDecimal ("0.004"));
        break;
      case 4 :
        num[index] = num[index].add(new BigDecimal ("0.005"));
        break;
      case 5 :  
        num[index] = num[index].add(new BigDecimal ("0.006"));
        break;
    }
    
  }
  
  public void subtractMarketValue(int index)
  {
    Random rdm = new Random();
    
    switch (rdm.nextInt(3))
    {
      case 0 :
        num[index] = num[index].subtract(new BigDecimal ("0.001"));
        break;
      case 1 :  
        num[index] = num[index].subtract(new BigDecimal ("0.002"));
        break;
      case 2 :
        num[index] = num[index].subtract(new BigDecimal ("0.003"));
        break;
      case 3 :  
        num[index] = num[index].subtract(new BigDecimal ("0.004"));
        break;
      case 4 :
        num[index] = num[index].subtract(new BigDecimal ("0.005"));
        break;
      case 5 :  
        num[index] = num[index].subtract(new BigDecimal ("0.006"));
        break;
    }
    
  }
  
  public BigDecimal[] getNum()
  {
    return num;
  }

}
