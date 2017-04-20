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
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
        // Saint saint = null;
        // for(int i = 0; i < this.saints.size(); i++){
        // for(int j = 1; j < this.saints.size(); j++){
        // if ( saints.get(i).getVida() > saints.get(j).getVida()){
        // saint = saints.get(i);
        // saints.add(i, saints.get(j));
        // saints.add(j, saint);
        // }
        // }        
        // }
    }   

    public void ordenar(TipoOrdenacao tipoOrdenacao) {

        if (tipoOrdenacao.equals(TipoOrdenacao.DESCENDENTE)) {
            boolean posicoesSendoTrocadas;
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < this.saints.size() - 1; i++) {
                    Saint atual = this.saints.get(i);
                    Saint proximo = this.saints.get(i + 1);
                    boolean precisaTrocar = atual.getVida() > proximo.getVida();
                    if (precisaTrocar) {
                        this.saints.set(i, proximo);
                        this.saints.set(i + 1, atual);
                        posicoesSendoTrocadas = true;
                    }
                }
            } while (posicoesSendoTrocadas);  
        } else {
            ordenar();
        }
    }

    public ArrayList<Saint> unir (ArrayList listaNova) {
        int i, j, k;
        ArrayList<Saint> listaUnida = new ArrayList<>();
        for (i=0; i<listaNova.size(); i++) {
            boolean encontrado = false;
            for (j=0; j<saints.size(); j++) {
                if (listaNova.get(i).equals(saints.get(j))) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                listaUnida.add(saints.get(i));
            }
        }
        for (k=0; k<listaNova.size(); k++) {
            adicionaSaint(saints.get(k));
        
        }
        return listaUnida;
    }

    public ArrayList<Saint> intersec (ArrayList listaNova) {
        int i, j;
        ArrayList<Saint> listaIguais = new ArrayList<>();
        for (i=0; i<saints.size(); i++) {
            boolean encontrado = false;
            for (j=0; j<listaNova.size(); j++) {
                if (saints.get(i).equals(listaNova.get(j))) {
                    encontrado = true;
                }
            }
            if (encontrado) {
                listaIguais.add(saints.get(i));
            }
        }
        return listaIguais;
    }

    public ArrayList<Saint> diff (ArrayList listaNova) {
        int i, j;
        ArrayList<Saint> listaDiferentes = new ArrayList<>();
        for (i=0; i<saints.size(); i++) {
            boolean encontrado = false;
            for (j=0; j<listaNova.size(); j++) {
                if (saints.get(i).equals(listaNova.get(j))) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                listaDiferentes.add(saints.get(i));
            }
        }
        return listaDiferentes;
    }

}