

import java.net.*;
import java.time.Clock;
import java.io.*;

public class FXCurrencyChangeProtocol {
     
    public String processInput(int[] num) {
      
        num[0]+=1;
        num[1]+=4;
        num[2]+=2;
        num[3]+=8;
      
        String theOutput = "";       
        String temps = String.valueOf(num[0]);       
        theOutput += temps + "-";
        temps = String.valueOf(num[1]); 
        theOutput += temps + "-";
        temps = String.valueOf(num[2]);  
        theOutput += temps + "-";
        temps = String.valueOf(num[3]);       
        theOutput += temps;
        
        // we put multiple values in an array
        // to split on the client to bind to 4 labels
        // its expecting an array on the other side.
        
        return theOutput;
    }
    

}