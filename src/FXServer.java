

import java.net.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

import java.io.*;

public class FXServer {
  
  
    private static final int NTHREADS = 5;
    private static final ScheduledExecutorService  exec = Executors.newScheduledThreadPool(NTHREADS);
    
    
    public static void main(String[] args) throws IOException {

          if (args.length != 1) {
              System.err.println("Usage: java KKMultiServer <port number>");
              System.exit(1);
          }
          
          // Testing changes
          
        // port number from command line
        int portNumber = Integer.parseInt(args[0]); 
        
        // loop flag
        boolean listening = true;
        
        
        
        // SERVERSOCKET
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
          
          
        // loop forever 
          while (listening) {
            
             Socket connection = serverSocket.accept();
             FXHandleRequest fxh = new FXHandleRequest(connection);                    
            // call MultiserverThread class
            Runnable task = new Runnable(){
              public void run (){
                fxh.handleRequest();
              }
            };
                 
            exec.scheduleAtFixedRate(task,1L,1L, TimeUnit.SECONDS);    
                        
          }
        } 
        
           
        catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
    
}