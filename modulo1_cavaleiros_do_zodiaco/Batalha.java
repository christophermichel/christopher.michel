public class Batalha {

    private Saint player1;
    private Saint player2;

    public Batalha(Saint player1, Saint player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void iniciar() {
        int valor1 = this.player1.getCategoria().getValor();
        int valor2 = this.player2.getCategoria().getValor();
        final double dano = 10;
        Saint saintEmAcao = null;

        if (valor1 >= valor2) {
            saintEmAcao = this.player1;
            this.player2.perderVida(dano);
        } else {
            saintEmAcao = this.player2;
            this.player1.perderVida(dano);
        }

        boolean nenhumMorto = true;
        while (nenhumMorto) {
            // 1. definindo quem vai atuar no round
            saintEmAcao = saintEmAcao == this.player1 ? this.player2 : this.player1;
            // 2. executando próximo movimento
            Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
            proximoMovimento.executar();
            // 3. verificando se a batalha acabou
            nenhumMorto = this.player1.getStatus() != Status.MORTO &&
            this.player2.getStatus() != Status.MORTO;
        }
    }
}
