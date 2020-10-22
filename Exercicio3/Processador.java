


public class Processador extends Thread{
    int iteracoes;
    Barrier barreira;
    int x; //i
    int y; //j

    Processador(int i, Barrier b, int x, int y){
        iteracoes = i;
        barreira = b;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for(int i = 0; i<iteracoes; i++){
        double soma = 0;
        int count = 0;
        if(x-1 >=0){
            soma += Main.matriz[x-1][y];
            count++;
        }
        if(x+1 < Main.matriz.length){
            soma += Main.matriz[x+1][y];
            count++;
        }
        if(y+1 < Main.matriz.length){
            soma += Main.matriz[x][y+1];
            count++;
        }
        if(y-1 >=0){
            soma += Main.matriz[x][y-1];
            count++;
        }

        try{barreira.arrive();}
        catch(InterruptedException ie){}

        Main.matriz[x][y] = soma/count; 
        
        try{barreira.leave();}
        catch(InterruptedException ie){}
        
        }
    }
}
