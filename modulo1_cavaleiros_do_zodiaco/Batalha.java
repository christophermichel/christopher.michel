public class Batalha {

    private Saint player1;
    private Saint player2;

    public Batalha(Saint player1, Saint player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void iniciar() throws Exception{
        int valor1 = this.player1.getCategoriaArmadura();
        int valor2 = this.player2.getCategoriaArmadura();
        double dano = 10.;
        if(valor1 >= valor2) { 
            this.player2.perderVida(dano); 
        }
        else {
            this.player1.perderVida(dano);
        }
    }
}
