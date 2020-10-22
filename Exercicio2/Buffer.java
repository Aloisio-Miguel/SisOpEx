
public class Buffer {
    class Node{
        Node prox;
        Node ant;
        boolean value;
        public Node(){
            value = false;
            prox = null;
            ant = null;
        }

        public String toString(){
            return "value : " +value +"; ";
        }
    }

    private Node root;
    private Node end;
    private int posIns = 0;
    private int posDel = 0;
    private int tam;
    private boolean cheio = false;
    Buffer(int tam){
        end = null;
        Node aux = new Node();
        this.tam = tam;
        for(int i = 0; i < tam; i++){
            if(i == 0){
                root = aux;
            }else if(i == tam-1){
                aux.prox = end = new Node();
                end.ant = aux;
            }else{
                aux.prox = new Node();
                aux.prox.ant = aux;
                aux = aux.prox;
            }
        }
    }

    public void insere(){
        if(cheio){
            throw new ArrayStoreException("Buffer cheio");
        }
        if((posIns == tam-1) && (posDel == 0)){
            cheio = true;
        }else if(posIns+1 == posDel){
            cheio = true;
        }
        Node aux = root;
        for(int i = 0; i < posIns; i++){
            aux = aux.prox;
        }
        aux.value = true;
        if(posIns == tam-1){
            posIns = 0;
        }else{
            posIns++;;
        }
        System.out.println("adiciona " +toString());
    }

    public boolean cheio(){
        return cheio;
    }

    public boolean vazio(){
        return !cheio && posDel == posIns;
    }

    public void remove(){
        if(vazio()){
            throw new NullPointerException("Buffer vazio.");
        }else{
            Node aux = root;
            for(int i = 0; i < posDel; i++){
                aux = aux.prox;
            }
            aux.value = false;
            
            if(posDel == tam-1){
                posDel = 0;
            }else{
                posDel++;
            }
            cheio = false;
            System.out.println("remove: " +toString());
        }
    }

    public String toString(){
        String aux = "";
        Node n = root;
        while(n != null){
            aux += n.toString();
            n = n.prox;
        }
        return aux;
    }

}


