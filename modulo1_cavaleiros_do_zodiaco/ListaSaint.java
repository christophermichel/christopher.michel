import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaint {
    private ArrayList<Saint> saints = new ArrayList<>();

    public void adicionaSaint (Saint saint) {
        this.saints.add(saint);
    }

    public Saint getIndice(int i) {
        return this.saints.get(i);
    }

    public ArrayList<Saint> getTodos(){
        return saints;
    }

    public void removeSaint (Saint saint) {
        this.saints.remove(saint);
    }

    //MÉTODO UTILIZANDO EQUALS
    public Saint buscarPorNome(String nome) {
        return this.saints.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);
        // for (Saint saint : this.saints) {
        // if (saint.getNome().equals(nome)) {
        // return saint;
        // }
        // }
        // return null;

        // MÉTODO USANDO IGUAL.
        // public Saint buscarPorString (String saint) {
        // int i;
        // for(i=0; i < saints.size(); i++) {
        // Saint saintComMesmoNome = saints.get(i);
        // if (saintComMesmoNome.getNome() == saint) {
        // return saintComMesmoNome;
        // }
        // }
        // return null;
    }

    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        return (ArrayList<Saint>)this.saints.stream()
        .filter(s -> s.getCategoria().equals(categoria))
        .collect(Collectors.toList());
        // ArrayList<Saint> subLista = new ArrayList<Saint>();
        // //
        // for (Saint saint : this.saints) {
        // if (saint.getCategoria().equals(categoria)) {
        // subLista.add(saint);
        // }
        // }
        // return subLista;
    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
        return (ArrayList<Saint>)this.saints.stream()
        .filter(s -> s.getStatus().equals(status))
        .collect(Collectors.toList());
        // ArrayList<Saint> saintsPorStatus = new ArrayList<>();
        // int i;
        // for(i=0; i < saints.size(); i++) {
        // Saint exemploSaint = saints.get(i);
        // if (status == exemploSaint.getStatus()) {
        // saintsPorStatus.add(exemploSaint);
        // }
    }

    public Saint getSaintMaiorVida() {
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

    public Saint getSaintMenorVida() {
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

    public void ordenar(){
        Saint saint = null;
        for(int i = 0; i < this.saints.size(); i++){
            for(int j = 1; j < this.saints.size(); j++){
                if ( saints.get(i).getVida() > saints.get(j).getVida()){
                    saint = saints.get(i);
                    saints.add(i, saints.get(j));
                    saints.add(j, saint);
                }
            }        
        }        
    }
}