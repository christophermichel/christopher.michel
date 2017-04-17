import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class BatalhaTest {
    @Test
    public void testaSeTemAMesmaArmadura() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.OURO));
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.OURO));
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(100.0, hyoga.getVida(), 0.01);
        assertEquals(90.0, mu.getVida(), 0.01);
    }
    
    @Test
    public void armadura1MelhorQueArmadura2() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.OURO));
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.BRONZE));
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(100.0, hyoga.getVida(), 0.01);
        assertEquals(90.0, mu.getVida(), 0.01);
    }
    
    @Test
    public void armadura2MelhorQueArmadura1() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.OURO));
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.BRONZE));
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(90.0, mu.getVida(), 0.01);
        assertEquals(100.0, hyoga.getVida(), 0.01);
 
    }
 
    @Test
    public void categoriasIguaisGanhaOPrimeiroASerChamadoParaBatalhaComecaAtacando() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Gêmeos",Categoria.PRATA));
        Saint mu = new Saint("Mu", new Armadura("Touro", Categoria.PRATA));
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(mu.getVida(),90.0, 0.01);
    }
 
}
 