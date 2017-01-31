import java.math.BigDecimal;

public class FXMarketValues {
  
  private BigDecimal[] num = new BigDecimal[4];
  private String start;

  public FXMarketValues()
  {
    start = "Done";
    
    num[0] = new BigDecimal("1.00001");
    num[1] = new BigDecimal("1.00002");
    num[2] = new BigDecimal("1.00003");
    num[3] = new BigDecimal("2.00001");
  }
  
  public void incrementValues()
  {
    num[0] = num[0].subtract(new BigDecimal ("0.00001"));
    num[1] = num[1].add(new BigDecimal ("0.00004"));
    num[2] = num[2].add(new BigDecimal ("0.00002"));
    num[3] = num[3].add(new BigDecimal ("0.00008"));
  }
  
  public BigDecimal[] getNum()
  {
    return num;
  }

}
