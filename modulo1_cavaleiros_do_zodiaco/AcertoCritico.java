public class AcertoCritico{

    private Sorteador sorteador;
    public AcertoCritico(Sorteador sorteador){
        this.sorteador = sorteador;
    }

    public boolean isCriticalHit(){
        int numero = this.sorteador.sortear();
        return numero % 2 == 0;
    }
}