
import java.util.Random;
public class Main {
   public static double[][] matriz = null;
   private static final int N_MATRIZ = 5; //Define o valor de N, a matriz possui um tamanho de N x N.
   private static final int N_ITERACOES = 1; //Define nro de iterações com a matriz.

   public static void main(String[] args) {
        matriz = new double[N_MATRIZ][N_MATRIZ];
        Processador[][] processadores = new Processador[N_MATRIZ][N_MATRIZ];
        Random r = new Random();
        Barrier barreira = new Barrier(N_MATRIZ * N_MATRIZ);
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j] = r.nextInt(100);
                System.out.print(matriz[i][j] + " ");
                processadores[i][j] = new Processador(N_ITERACOES, barreira, i, j);
            }
            System.out.println();
        }

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){   //Tive que startar cada thread separadamente de sua criação pois quando a thread tentava calcular o valor de x+1 da celula, x+1 
                processadores[i][j].start();          //não foi inicializado ainda portanto não possui valor, e nesse caso para soma era considerado 0 
            }
           
        }



        System.out.println("Depois de todas iterações:");

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                try{processadores[i][j].join();}
                catch(InterruptedException ie){} 
                System.out.printf("%.2f ", matriz[i][j]);
            }
            System.out.println();
        }
        
        
   }
}
