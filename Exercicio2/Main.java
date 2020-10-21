package Exercicio2;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[]args){
        Semaphore bAcess = new Semaphore(1);
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer, bAcess);
        Consumer consumer = new Consumer(buffer, bAcess);
        
        producer.start();
        consumer.start();
        
    }
}
