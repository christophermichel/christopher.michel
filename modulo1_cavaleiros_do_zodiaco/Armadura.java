import java.util.ArrayList;

public class Armadura {
    private Constelacao constelacao;
    public Categoria categoria;

    public Armadura(Constelacao constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }

    public Constelacao getConstelacao () {
        return this.constelacao;
    }

    public String getNomeConstelacao() {
        return this.constelacao.getNomeDaConstelacao();
    }

    public ArrayList<Golpe> getGolpes(){
        return constelacao.getGolpes();
    }
    
}