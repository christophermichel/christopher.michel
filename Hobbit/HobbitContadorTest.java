import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {

    @Test
    public void CalculaDiferencaCom1Par() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 3)));

        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }

    @Test
    public void calculaDiferencaCom2Pares() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(3, 10)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(2, 3)));

        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }

    @Test
    public void calculaDiferencaSemPares() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();

        assertEquals(0, bilbo.calculaDiferenca(arrayDePares));
    }

    @Test
    public void maiorMultiploNumeroMaiorQueTres() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        int teste = bilbo.maiorMultiploDeTres(20);

        assertEquals(18, teste);
    }

    @Test
    public void maiorMultiploNumeroTres() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        int teste = bilbo.maiorMultiploDeTres(3);

        assertEquals(3, teste);
    }

    @Test
    public void maiorMultiploNumeroMenorQueTres() {
        HobbitContador bilbo = new HobbitContador("Bilbo");
        int teste = bilbo.maiorMultiploDeTres(2);

        assertEquals(0, teste);
    }

}