public class Batalha {

    private Saint player1;
    private Saint player2;

    public Batalha(Saint player1, Saint player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void iniciar() throws Exception{
        boolean player1Ataca = player1.getCategoriaArmadura() >= player2.getCategoriaArmadura();
        boolean ninguemMorreuAinda = player1.getStatus() == Status.MORTO || player2.getStatus() == Status.MORTO;
        if (player1.getTemGolpes() || player2.getTemGolpes()) {
            System.out.println("Algum jogador não possui golpes");
        } else {
        while (!ninguemMorreuAinda) {
            if (player1Ataca) {
                this.player1.getProximoMovimento().executar();
                player1Ataca = false;
            }
            else {
                this.player2.getProximoMovimento().executar(); 
                player1Ataca = true;
            }
        }
    }
}
}
