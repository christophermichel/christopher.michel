import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest
{
    @Test
    public void golpearArmaduraVestidaSaintOuro() throws Exception {
        GoldSaint mu = new GoldSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        new VestirArmadura(mu).executar();
        golpear.executar();
        
        assertEquals(60, june.getVida(), 0.01);
    }
    
    @Test
    public void golpearArmaduraNaoVestidaSaintOuro() throws Exception {
        GoldSaint mu = new GoldSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        golpear.executar();
        
        assertEquals(90, june.getVida(), 0.01);
    }
    
    @Test
    public void golpearArmaduraVestidaSaintPrata() throws Exception {
        SilverSaint mu = new SilverSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        new VestirArmadura(mu).executar();
        golpear.executar();
        
        assertEquals(70, june.getVida(), 0.01);
    }
    
    @Test
    public void golpearArmaduraNaoVestidaSaintPrata() throws Exception {
        SilverSaint mu = new SilverSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        golpear.executar();
        
        assertEquals(90, june.getVida(), 0.01);
    }
    
    @Test
    public void golpearArmaduraVestidaSaintBronze() throws Exception {
        BronzeSaint mu = new BronzeSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        new VestirArmadura(mu).executar();
        golpear.executar();
        
        assertEquals(80, june.getVida(), 0.01);
    }
    
    @Test
    public void golpearArmaduraNaoVestidaSaintBronze() throws Exception {
        BronzeSaint mu = new BronzeSaint("Mu", "Escorpião");
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa", 10);
        Movimento golpear = new Golpear(mu, june);
        
        mu.aprenderGolpe(tempestadeNebulosa);
        golpear.executar();
        
        assertEquals(90, june.getVida(), 0.01);
    }
    
    @Test(expected=ArithmeticException.class)
    public void naoGolpear() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Movimento golpear = new Golpear(aldebaran, seiya);
        golpear.executar();
    }
}