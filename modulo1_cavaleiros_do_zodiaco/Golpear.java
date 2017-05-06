public class Golpear implements Movimento{ 
    private Saint golpeador; 
    private Saint golpeado; 

    public Golpear(Saint golpeador, Saint golpeado) { 
        this.golpeador= golpeador; 
        this.golpeado = golpeado; 
    } 

    public void executar() {
        int danoDoGolpe = golpeador.getProximoGolpe().getFatorDano();
        if(golpeado.naoVaiTomarDano == false){
            if (golpeador.getArmaduraVestida() == true) {
                danoDoGolpe  = danoDoGolpe*(1 + golpeador.getCategoriaArmadura());
            }
            this.golpeado.perderVida(danoDoGolpe);
        }
        else{ 
            this.golpeador.perderVida(golpeador.getVida() * 0.25);
            golpeado.naoVaiTomarDano = false;
        }
    }

    public boolean equals(Object outro){
        Golpear outroGolpear =(Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador) && this.golpeado.equals(outroGolpear.golpeado);
    }    
}