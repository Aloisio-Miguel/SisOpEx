package Exercicio2;

import java.util.concurrent.Semaphore;


public class Consumer extends Thread{
    
    private static final String espaco = "\t\t\t\t\t\t|";
    private Buffer buffer;
    private Semaphore bAcess;
    
    public Consumer (Buffer buffer, Semaphore bAcess){
        this.buffer = buffer;
        this.bAcess = bAcess;
    }

    @Override
    public void run() {
        System.out.println(espaco + "inicia thread consumer.");
    
        while(true){
      
            try{ bAcess.acquire(); }
            catch(InterruptedException ie){}
            
         
            if(!buffer.vazio()){
                buffer.remove();
            }
          
            bAcess.release();
        }
    }
}