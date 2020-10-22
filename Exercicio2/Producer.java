
import java.util.concurrent.Semaphore;

public class Producer extends Thread{
 
    private static final String espaco = "";
 
    private Buffer buffer;
    private Semaphore bAcess;

    public Producer (Buffer buffer, Semaphore bAcess){
        this.buffer = buffer;
        this.bAcess = bAcess;
    }


    @Override
    public void run() {
        System.out.println(espaco + "Inicia thread producer:");            
        boolean still = false;

        while(true){
                
            try{ bAcess.acquire(); }
            catch(InterruptedException ie){}

            if(!buffer.cheio()){
                buffer.insere();
            } 
            bAcess.release();
        }
    }
}