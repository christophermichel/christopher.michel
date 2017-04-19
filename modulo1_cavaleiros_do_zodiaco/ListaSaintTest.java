
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
        ListaSaint atenaList = new ListaSaint();
        assertEquals(null, atenaList.buscarPorNome("Sheldon"));
    }

    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaint listaSaints = new ListaSaint();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaint listaSaints = new ListaSaint();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusExistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        misty.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        shun.perderVida(100);
        june.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        assertEquals(june, listaSaints.getSaintMaiorVida());
    }
    
    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaint listaSaints = new ListaSaint();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }
}