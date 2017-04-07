

import java.net.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

import java.io.*;

public class FXServer 
{
    private static final int NTHREADS = 6;
    private static final ScheduledExecutorService exec = Executors.newScheduledThreadPool(NTHREADS);
    private String started;
    
    public FXServer()
    {
      this.started = "done";
    }
        
    public static void main(String[] args) throws IOException 
    {
        if (args.length != 1) 
        {
            System.err.println("Usage: java FXServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);       
        FXServer fxs = new FXServer();
        fxs.startListening(portNumber);             
    } 
    
    public void startListening(int portNumber)
    {
      boolean listening = true;

      try (ServerSocket serverSocket = new ServerSocket(portNumber)) 
      { 
        FXMarketValues mv = new FXMarketValues();
        Runnable tick = new Runnable(){
          public void run (){
            mv.applyMarketValueChange();
            mv.printLeaderboard();
          }
        };
        
        exec.scheduleAtFixedRate(tick,1L,1L, TimeUnit.SECONDS);
        
        while (listening) 
        {            
           Socket connection = serverSocket.accept();
           FXHandleRequest fxh = new FXHandleRequest(connection, mv);                    
         
           Runnable task = new Runnable(){
             public void run (){
               fxh.handleRequest();
               fxh.printClient();
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