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
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
    ArrayList<Saint> saintsPorCategoria = new ArrayList<>();
    int i;
    for(i=0; i < saints.size(); i++) {
        Saint exemploSaint = saints.get(i);
            if (categoria == exemploSaint.getCategoria()) {
                saintsPorCategoria.add(exemploSaint);
            }
    }
    return saintsPorCategoria;
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
    ArrayList<Saint> saintsPorStatus = new ArrayList<>();
    int i;
    for(i=0; i < saints.size(); i++) {
        Saint exemploSaint = saints.get(i);
            if (status == exemploSaint.getStatus()) {
                saintsPorStatus.add(exemploSaint);
            }
    }
    return saintsPorStatus;
    }
    
    public Saint getSaintComMaiorVida() {
    int i;
    Saint exemploSaint = null;
    for(i=0; i < saints.size(); i++) {
    Saint atual = saints.get(i);
        if (i == 0) {
        exemploSaint = atual;
        }
        else if (exemploSaint.getVida() >= atual.getVida()) {
            exemploSaint = exemploSaint;
        }
        else {
            exemploSaint = atual;
        }        
    }
    return exemploSaint;
    }
    
    public Saint getSaintComMenorVida() {
    int i;
    Saint exemploSaint = null;
    for(i=0; i < saints.size(); i++) {
    Saint atual = saints.get(i);
        if (i == 0) {
        exemploSaint = atual;
        }
        else if (exemploSaint.getVida() <= atual.getVida()) {
            exemploSaint = exemploSaint;
        }
        else {
            exemploSaint = atual;
        }        
    }
    return exemploSaint;
    }
}