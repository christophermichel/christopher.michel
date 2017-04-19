
import java.util.ArrayList;
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
   public void adicionarUmGolpe() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> listaDeGolpes = new ArrayList<>();
       listaDeGolpes = gemeos.getGolpes();
       assertEquals(outraDimensao, listaDeGolpes.get(0));
   }
   
   @Test
   public void adicionarDoisGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> listaDeGolpes = new ArrayList<>();
       listaDeGolpes = gemeos.getGolpes();
       assertEquals(outraDimensao, listaDeGolpes.get(0));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, listaDeGolpes.get(1));
    
   }

   @Test
   public void adicionarTresGolpes() throws Exception{
       Constelacao gemeos = new Constelacao("Gemeos");
       Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
       gemeos.adicionarGolpe(outraDimensao);
       ArrayList<Golpe> listaDeGolpes = new ArrayList<>();
       listaDeGolpes = gemeos.getGolpes();
       assertEquals(outraDimensao, listaDeGolpes.get(0));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, listaDeGolpes.get(1));
       gemeos.adicionarGolpe(outraDimensao);
       assertEquals(outraDimensao, listaDeGolpes.get(2));
   }
}