import java.util.ArrayList;

public class Constelacao {
    private String nome;
    private ArrayList<Golpe> listaDeGolpes = new ArrayList<>();
    
    public Constelacao (String nome) {
        this.nome = nome;
    }   
    
    public void adicionarGolpe(Golpe golpe) { 
        listaDeGolpes.add(golpe);
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
    
    
    public String getNomeDaConstelacao(){
        return this.nome;
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.listaDeGolpes;
    }
    
}