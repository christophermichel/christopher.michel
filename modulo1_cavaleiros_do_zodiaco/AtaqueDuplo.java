public class AtaqueDuplo implements Movimento {
    private Saint golpeador; 
    private Saint golpeado; 

    public AtaqueDuplo (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar () {
        Sorteador comDadoD3 = new DadoD3();
        AcertoCritico acertoCritico = new AcertoCritico(comDadoD3);
        int danoDoGolpe= golpeador.getProximoGolpe().getFatorDano();
        if(golpeado.naoVaiTomarDano==false){
            if(acertoCritico.isCriticalHit()){
                if (golpeador.getArmaduraVestida() == true) {
                    danoDoGolpe  *= (1 + golpeador.getCategoriaArmadura());
                }
                this.golpeado.perderVida(2*danoDoGolpe);
            }
            else {
                golpeador.perderVida(golpeador.getVida()*0.05);
                this.golpeado.perderVida(danoDoGolpe);
            }
        }
        else {
            golpeador.perderVida(0.25*golpeador.getVida());
            golpeado.naoVaiTomarDano = false;
        }
    }
}