
public class FXMarketValues {
  
  private int [] num = {1001,6022,2983,4007};
  private String start;

  public FXMarketValues()
  {
    start = "Done";
  }
  
  public void incrementValues()
  {
    num[0]+=1;
    num[1]+=4;
    num[2]+=2;
    num[3]+=8;
  }
  
  public int [] getNum()
  {
    return num;
  }

}
