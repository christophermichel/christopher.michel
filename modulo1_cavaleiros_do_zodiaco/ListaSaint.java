import java.util.ArrayList;

public class ListaSaint {
    private ArrayList<Saint> saints = new ArrayList<>();
    
    public void recebeSaint (Saint saint) {
        this.saints.add(saint);
    }
   
    public Saint getIndice(int i) {
        return saints.get(i);
    }
    
    public ArrayList<Saint> getTodos(){
        return saints;
    }
    
    public void removeSaint (Saint saint) {
        this.saints.remove(saint);
    }
    
    public Saint buscarPorString (String saint) {
    int i;
    for(i=0; i < saints.size(); i++) {
    Saint saintComMesmoNome = saints.get(i);
        if (saintComMesmoNome.getNome() == saint) {
        return saintComMesmoNome;
        }
    }
    return null;
    }
}