
import java.util.concurrent.Semaphore;

public class Leitor extends Thread{
    private Semaphore roomEmpty;
    private Semaphore mutex;
    private int id;

    public Leitor(int i, Semaphore r, Semaphore m){
        roomEmpty = r;
        mutex = m;
        id = i;
    }

    @Override
    public void run(){
        while(true){
            try{mutex.acquire();}
            catch(InterruptedException ie){}
            Main.readers++;
            if(Main.readers == 1){
                try{roomEmpty.acquire();}
                catch(InterruptedException ie){}
            }
            mutex.release();

            System.out.println("\nLido por leitor " +id +": " +Main.recurso +"\n");

            try{mutex.acquire();}
            catch(InterruptedException ie){}
            Main.readers--;
            if(Main.readers == 0){
                roomEmpty.release();
            }
            mutex.release();
        }
    }
}
