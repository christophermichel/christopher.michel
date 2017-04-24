import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void vestirArmadura() throws Exception {
        //Arrange
        Saint shaina = new SilverSaint("Shaína","Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        //Act
        movimento.executar();
        //Assert
        assertTrue(shaina.getArmaduraVestida());
    }
    
    @Test
    public void vestirArmaduraSemArmadura() throws Exception {
        //Arrange
        Saint shaina = new SilverSaint("Shaína","Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        //Assert
        assertFalse(shaina.getArmaduraVestida());
    }
}