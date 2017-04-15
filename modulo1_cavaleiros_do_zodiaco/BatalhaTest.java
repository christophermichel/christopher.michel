import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class BatalhaTest {
    @Test
    public void simularBatalhaETestarSeAMelhorArmaduraIniciaBatalha() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.BRONZE), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.OURO), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(hyoga.getVida(),90.0, 0.01);
 
    }
 
    @Test
    public void categoriasIguaisGanhaOPrimeiroASerChamadoParaBatalhaComecaAtacando() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.PRATA), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.PRATA), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(mu.getVida(),90.0, 0.01);
    }
 
}
 