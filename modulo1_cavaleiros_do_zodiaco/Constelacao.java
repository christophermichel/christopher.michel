public class Constelacao {
    private String nome;
    private Golpe[] listaDeGolpes = new Golpe[3];
    private int limite = 0;
    
    public void adicionarGolpe(Golpe golpe) {
 
        if(limite<listaDeGolpes.length){
 
            this.listaDeGolpes[limite] = golpe;
            this.limite++;
 
        }else System.out.println("Não foi possível cadastrar o golpe");
    }
    
    public Constelacao (String nome) {
        this.nome = nome;
    }
    
    public String getNomeDaConstelacao(){
        return this.nome;
    }
    
    public Golpe[] getGolpes(){
        return this.listaDeGolpes;
    }
    
}