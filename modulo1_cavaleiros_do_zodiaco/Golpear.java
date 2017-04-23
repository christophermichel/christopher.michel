import java.security.InvalidParameterException;
public class Golpear implements Movimento{ 
    private Saint golpeador; 
    private Saint golpeado; 

    public Golpear(Saint golpeador, Saint golpeado) { 
        this.golpeador= golpeador; 
        this.golpeado = golpeado; 
    } 

    public void executar() { 
        int dano = golpeador.getProximoGolpe().getFatorDano(); 
        if (golpeador.getArmaduraVestida()) { 
            dano = dano * (1 + golpeador.getCategoria().getValor());
        } 
        golpeado.perderVida(dano); 
        if (dano == 0) {
            System.out.println("Dano do golpe é nulo");
        }
    } 

}