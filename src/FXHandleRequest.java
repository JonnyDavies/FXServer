
import java.net.*;
import java.io.*;
import java.math.BigDecimal;

public class FXHandleRequest {
  
    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;
    private FXMarketValues fm;
    private String traderName;
    private Integer currentEquity;

    public FXHandleRequest (Socket socket, FXMarketValues fm ) throws IOException
    {     
      this.socket = socket;
      this.fm = fm;
      this.out = new PrintWriter(socket.getOutputStream(), true);  
      this.traderName = "Unknown";
      this.currentEquity = 0;
      
      try 
      {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      } 
      catch (IOException e) 
      {
        e.printStackTrace();
      }  
    }
    
    public void handleRequest() 
    {               
      String outputLine;
      outputLine = this.processInput();  
      out.println(outputLine);         
      return; 
    } 
    
    public void printClient()
    {
      String inputLine = "Nothing";
      try{      
            inputLine = this.in.readLine();            
            String[] s = inputLine.split("-");
            this.fm.addTraderPosition(s[0],s[1]);
            this.traderName = s[1];
            return;
      }
      catch(IOException e){
        e.printStackTrace();

      }      
    }
    
    public String processInput() 
    { 
      
      String theOutput = "";  
      BigDecimal[] num = fm.getNum();
      String temps = String.valueOf(num[0]);       
      theOutput += temps + "-";
      temps = String.valueOf(num[1]); 
      theOutput += temps + "-";
      temps = String.valueOf(num[2]);  
      theOutput += temps + "-";
      temps = String.valueOf(num[3]);       
      theOutput += temps;       
      return theOutput;
    }
    
}




