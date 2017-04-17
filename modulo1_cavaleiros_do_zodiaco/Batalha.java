public class Batalha {
   
    private Saint player1;
    private Saint player2;
    
    public Batalha(Saint player1, Saint player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void iniciar() {
        if(this.player1.getCategoriaArmadura() >= this.player2.getCategoriaArmadura()){ 
            this.player2.perderVida(10.0); 
        }
        else {
            this.player1.perderVida(10.0);
        }
    }
}
