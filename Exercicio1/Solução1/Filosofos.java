

/* 
   Implementacao do Jantar dos Filosofos com Semaforo
   PUCRS - Escola Politecnica
   Prof: Fernando Dotti
*/
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
// ============= Filosofo ==============
class Filosofo extends Thread {
    
	private int i;
	private Semaphore g1, g2;
	private String espaco;

    public Filosofo(int _i, Semaphore _g1, Semaphore _g2){		
		i = _i;   g1 = _g1;    g2 = _g2;	
		espaco = "  ";
		for (int k=0; k<i; k++){
			espaco = espaco + "                       ";
		}
    }

    public void run() {
       while (true) {	   
		   // pensa
   		   System.out.println(espaco+ i + ": Pensa ");
		   
		   // pega um garfo
		   try{g1.acquire();
		       }catch(InterruptedException ie){}
			System.out.println(espaco+ i + ": Pegou um ");
			
			
		   
		
			  
		   // pega outro garfo
		   try{
			   if(!g2.tryAcquire(1, TimeUnit.NANOSECONDS)){
					g1.release(); 
					System.out.println(espaco +i +": Soltou os dois garfos");
			   }else{
				   System.out.println(espaco+ i + ": Pegou dois, come ");		   
				// come
				// solta garfos
				g1.release();
				g2.release();

			   }
			}catch(InterruptedException ie){
					System.out.println();
			   }
				   
      }
    }
}

class JantaFilosofos {	
	public static void main(String[] args) {
	    int FIL = 5;
		 
        Semaphore garfo[] = new Semaphore[FIL]; 
		for (int i=0; i< FIL; i++) {
		   garfo[i]= new Semaphore(1); 
	    }
        for (int i = 0; i < FIL; i++) {
			 	 (new Filosofo(i,garfo[i],garfo[(i+1)%(FIL)])).start();	
		}		
	}	  
}
	
