public class AtaqueDuplo implements Movimento {
    private Saint golpeador; 
    private Saint golpeado; 

    public AtaqueDuplo (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar () {
        if(new DadoD3().sortear() == 2) {
            int dano = golpeador.getProximoGolpe().getFatorDano(); 
            if (golpeador.getArmaduraVestida()) { 
                dano = dano * (1 + golpeador.getCategoria().getValor());
            } 
            this.golpeado.perderVida(2*dano); 
            if (dano == 0) {
                System.out.println("Dano do golpe é nulo");
            }
        } else {
            new Golpear(golpeador, golpeado).executar();
            golpeador.perderVida(golpeador.getVida() * 0.05);
        }
    }
}