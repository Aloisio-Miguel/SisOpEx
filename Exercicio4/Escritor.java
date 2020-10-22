

import java.util.concurrent.Semaphore;

public class Escritor extends Thread{
    int id;
    Semaphore roomEmpty;

    public Escritor(int i, Semaphore r){
        id = i;
        roomEmpty = r;
    }

    @Override
    public void run(){
        while(true){
            try{roomEmpty.acquire();}
            catch(InterruptedException ie){}
            Main.recurso += " Escritor " +id +" esteve aqui.";
            roomEmpty.release();
        }
    }
    
}
