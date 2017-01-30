
import java.net.*;
import java.io.*;

public class FXHandleRequest {
  
    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;
    private FXMarketValues fm;

    public FXHandleRequest (Socket socket, FXMarketValues fm ) throws IOException
    {     
      this.socket = socket;
      this.fm = fm;
      this.out = new PrintWriter(socket.getOutputStream(), true);      
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
    
    public String processInput() 
    { 
      
      String theOutput = "";  
      int[] num = fm.getNum();
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




