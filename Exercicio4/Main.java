
import java.util.concurrent.Semaphore;


//A questão 4 pede para que façamos uma análise testando diferentes quantidades de leitores e escritores para o mesmo recurso compartilhado. Realizando essa analise foi percebido que 
//Idependente do numero de escritores, o volume de leituras sempre vai ser maior do que de escritas realizadas, isso se da pelo fato de que N leituras podem ser realizadas ao mesmo
//portanto, é possível que seja feita mais de 1 leitura antes de realizar uma escrita, portanto a frequencia com que o recurso se altera entre uma leitura e outra é bem pequena considerando
//a frequencia com que é feita as leituras.

public class Main {
    public static String recurso;
    public static int readers = 0;
    private static final int N_LEITORES = 3;
    private static final int N_ESCRITORES = 3;

    public static void main(String [] args){
        Semaphore roomEmpty = new Semaphore(1);
        Semaphore mutex = new Semaphore(1);
        
        for(int i = 0; i < N_ESCRITORES; i++){
            (new Escritor(i, roomEmpty)).start();    // Inicializa N escritores, baseado no nro da constante N_ESCRITORES
        }
        
        for(int i = 0; i < N_LEITORES; i++){
            (new Leitor(i, roomEmpty, mutex)).start();    // Inicializa N leitores, baseado no nro da constante N_LEITORES
        }
        
    }
}
