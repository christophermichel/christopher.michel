

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContelacaoTeste {
@Test
public void criarUmaContelcao(){
    Constelacao gemeos = new Constelacao("Gêmeos");
    assertEquals("Gêmeos", gemeos.getNomeDaConstelacao());
    }
   
@Test 
public void adicionarGolpesFunciona(){
    Constelacao aries = new Constelacao("Áries");
    Golpe tempestadeNebulosa = new Golpe("Tempestade Nebulosa",25);
    Golpe meteoroNegro = new Golpe("Meteoro Negro", 10);
    Golpe coleraDoDragao = new Golpe("Cólera do Dragão", 30);
    aries.adicionarGolpe(tempestadeNebulosa);
    aries.adicionarGolpe(meteoroNegro);
    aries.adicionarGolpe(coleraDoDragao);
    Golpe[] golpesAries = aries.getGolpes();
    assertEquals(golpesAries[0], tempestadeNebulosa);
    assertEquals(golpesAries[1], meteoroNegro);
    assertEquals(golpesAries[2], coleraDoDragao);
    }


}