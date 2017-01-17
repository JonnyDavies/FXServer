
import java.net.*;
import java.io.*;

public class FXHandleRequest {
  
    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;
    public int [] num = {1};

    public FXHandleRequest (Socket socket) throws IOException{
      
      this.socket = socket;
      // server -> client
      this.out = new PrintWriter(socket.getOutputStream(), true);       
     // server <- client
     try {
       this.in = new BufferedReader(
           new InputStreamReader(
               socket.getInputStream()));
     } catch (IOException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
     }  
    }
    
    public void handleRequest() {
                  
            String inputLine, outputLine;  

            // call constructor of protocol
            FXCurrencyChangeProtocolExample kkp = new FXCurrencyChangeProtocolExample();
            // get very first initial post to client which is Knock Knock when called with num
            outputLine = kkp.processInput(num);  
            // send Knock Knock! to client
            out.println(outputLine);
            
            return;
            
        } 
}




