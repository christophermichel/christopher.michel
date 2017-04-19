
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintTest {

    @Test
    public void adicionarSaintEmLista () throws Exception {
    Saint mu = new Saint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    ListaSaint atenaList = new ListaSaint();
    atenaList.adicionaSaint(mu);
    assertEquals(mu, atenaList.getTodos().get(0));
    assertEquals(1, atenaList.getTodos().size());
    }

    @Test
    public void chamarListaCompleta () throws Exception {
    ListaSaint atenaList = new ListaSaint();
    assertEquals(0, atenaList.getTodos().size());
    }
    
    @Test
    public void removeSaintEmLista () throws Exception {
    Saint mu = new Saint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    ListaSaint atenaList = new ListaSaint();
    atenaList.adicionaSaint(mu);
    atenaList.removeSaint(mu);
    assertEquals(0, atenaList.getTodos().size());
    }

    @Test
    public void buscarSaintPorNomeEmListaCom1Saint () throws Exception {
    Saint mu = new Saint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint seiya = new Saint("Seiya", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint hyoga = new Saint("Hyoga", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    ListaSaint atenaList = new ListaSaint();
    atenaList.adicionaSaint(hyoga);
    assertEquals(hyoga, atenaList.buscarPorNome("Hyoga"));
    }

    @Test
    public void buscarSaintPorNomeComVariosSaintNaLista () throws Exception {
    Saint hyoga = new Saint("Hyoga", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint mu = new Saint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint seiya = new Saint("Seiya", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    ListaSaint atenaList = new ListaSaint();
    atenaList.adicionaSaint(seiya);
    atenaList.adicionaSaint(mu);
    atenaList.adicionaSaint(hyoga);
    assertEquals(hyoga, atenaList.buscarPorNome("Hyoga"));
    }
    
    @Test
    public void buscarSaintPorNome () throws Exception {
    Saint mu = new Saint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint seiya = new Saint("Seiya", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    Saint hyoga = new Saint("Hyoga", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
    ListaSaint atenaList = new ListaSaint();
    atenaList.adicionaSaint(hyoga);
    assertEquals(null, atenaList.buscarPorNome("Sheldon"));
    }
    
    
    
    
    
    

}