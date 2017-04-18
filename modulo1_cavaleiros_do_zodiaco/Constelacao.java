public class Constelacao {
    private String nome;
    private Golpe[] listaDeGolpes = new Golpe[3];
    private int limite = 0;
    
    public void adicionarGolpe(Golpe golpe) {
        listaDeGolpes[limite++] = golpe;        
    }
    //SOLUÇÃO BERNARDO COM FOR
    // public void adicionarGolpe(Golpe golpe) {
        // for (int i = 0; i < this.listaDeGolpes.length; i++){
            // Golpe golpeAtual = listaDeGolpes[i];
            // if (golpeAtual == null) {
                // listaDeGolpes[1] = golpe;
                // break;
            // }
        // }
    // }
    //   MINHA SOLUÇÃO COM IF
        // if(limite<listaDeGolpes.length){
            // this.listaDeGolpes[limite] = golpe;
            // this.limite++;
        // }else System.out.println("Não foi possível cadastrar o golpe");
    // } 
    
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