public class Armadura {
    private Constelacao constelacao;
    public Categoria categoria;
    
    public Armadura(Constelacao constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }

   
    public Constelacao getNomeDaConstelacao() {
       return this.getNomeDaConstelacao();
    }

    public Golpe[] getGolpes(){
        return constelacao.getGolpes();
    }
}