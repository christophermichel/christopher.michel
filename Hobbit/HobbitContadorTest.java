import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {

    @Test
    public void com1Par() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 3)));
        
        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }
    
    @Test
    public void com2Pares() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(3, 10)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 3)));
        
        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }
    
    @Test
    public void semPares() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        
        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }
}