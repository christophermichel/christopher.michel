import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void testaSeTemAMesmaArmadura() throws Exception {
        Saint hyoga = new SilverSaint("Hyoga", "Libra");
        Saint mu = new SilverSaint("Mu", "Libra");
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(100.0, hyoga.getVida(), 0.01);
        assertEquals(100.0, mu.getVida(), 0.01);
    }

    @Test
    public void armadura1MelhorQueArmadura2() throws Exception {
        Saint hyoga = new SilverSaint("Hyoga", "Gêmeos");
        Saint mu = new BronzeSaint("Mu", "Gêmeos");
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(100.0, hyoga.getVida(), 0.01);
        assertEquals(100.0, mu.getVida(), 0.01);
    }

    @Test
    public void armadura2MelhorQueArmadura1() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Andrômeda");
        Saint mu = new SilverSaint("Mu", "Capricórnio");
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(100.0, mu.getVida(), 0.01);
        assertEquals(100.0, hyoga.getVida(), 0.01);

    }

    @Test
    public void categoriasIguaisGanhaOPrimeiroASerChamadoParaBatalhaComecaAtacando() throws Exception {
        Saint hyoga = new SilverSaint("Hyoga", "Áries");
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        Batalha batalha1 = new Batalha(hyoga, mu);
        batalha1.iniciar();
        assertEquals(mu.getVida(),100.0, 0.01);
    }

    @Test
    public void batalhaSemGolpes() throws Exception {
        GoldSaint seiya = new GoldSaint("Seiya", "Escorpião");
        BronzeSaint mu = new BronzeSaint("Mu", "Touro");
        mu.adicionarMovimento(new Golpear(mu, seiya));
        Batalha exemploBatalha = new Batalha(seiya, mu);
        exemploBatalha.iniciar();
        assertEquals(100, seiya.getVida(), 0.01);
        assertEquals(100, mu.getVida(), 0.01);
    }

    @Test
    public void batalhaSemDano() throws Exception {
        GoldSaint seiya = new GoldSaint("Seiya", "Escorpião");
        BronzeSaint mu = new BronzeSaint("Mu", "Touro");
        Batalha exemploBatalha = new Batalha(seiya, mu);
        exemploBatalha.iniciar();
        assertEquals(100, seiya.getVida(), 0.01);
        assertEquals(100, mu.getVida(), 0.01);
    }

    // @Test
    // public void iniciarBatalhaComMovimentosDeDano() throws Exception {
        // GoldSaint milo = new GoldSaint("Milo", "Escorpião");
        // BronzeSaint ares = new BronzeSaint("Ares", "Touro");
        // Golpe basico = new Golpe("Ataque básico", 10);
        // milo.aprenderGolpe(basico);
        // milo.adicionarMovimento(new VestirArmadura(milo));
        // milo.adicionarMovimento(new Golpear(milo, ares));
        // Golpe forte = new Golpe("Ataque básico", 50);
        // ares.aprenderGolpe(forte);
        // ares.adicionarMovimento(new Golpear(ares, milo));
        // Batalha epicBattle = new Batalha(milo, ares);
        // epicBattle.iniciar();
        // assertEquals(0, milo.getVida(), 0.01);
        // assertEquals(60, ares.getVida(), 0.01);
    // }
}
