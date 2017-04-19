import java.util.ArrayList;

public class ListaSaint {
    private ArrayList<Saint> saints = new ArrayList<>();
    
    public void recebeSaint (Saint saint) {
        this.saints.add(saint);
    }
   
    public Saint getIndice(int i) {
        return saints.get(i);
    }
    
    public ArrayList<Saint> todos(){
        return saints;
    }
    
}