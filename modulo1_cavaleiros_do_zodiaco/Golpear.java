import java.security.InvalidParameterException;
public class Golpear implements Movimento{ 
    private Saint golpeador; 
    private Saint golpeado; 

    public Golpear(Saint golpeador, Saint golpeado) throws Exception{ 
        this.golpeador= golpeador; 
        this.golpeado = golpeado; 
    } 

    public void executar() { 
        int dano = golpeador.getProximoGolpe().getFatorDano(); 
        if (golpeador.getArmaduraVestida() == true) { 
            dano = dano * (1 + golpeador.getCategoria().getValor());
        } 
        golpeado.perderVida(dano); 
    } 

}