
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintTest {

    @Test
    public void adicionarSaintEmLista () throws Exception {
        Saint mu = new BronzeSaint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
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
        Saint mu = new SilverSaint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        ListaSaint atenaList = new ListaSaint();
        atenaList.adicionaSaint(mu);
        atenaList.removeSaint(mu);
        assertEquals(0, atenaList.getTodos().size());
    }

    @Test
    public void buscarSaintPorNomeEmListaCom1Saint () throws Exception {
        Saint mu = new SilverSaint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        Saint seiya = new SilverSaint("Seiya", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        Saint hyoga = new SilverSaint("Hyoga", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        ListaSaint atenaList = new ListaSaint();
        atenaList.adicionaSaint(hyoga);
        assertEquals(hyoga, atenaList.buscarPorNome("Hyoga"));
    }

    @Test
    public void buscarSaintPorNomeComVariosSaintNaLista () throws Exception {
        Saint hyoga = new SilverSaint("Hyoga", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        Saint mu = new SilverSaint("Mu", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
        Saint seiya = new SilverSaint("Seiya", new Armadura (new Constelacao("Gêmeos"), Categoria.PRATA));
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
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
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
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
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
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusExistente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new SilverSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
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
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
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
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(june);
        assertEquals(june, listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
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

    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        shun.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new BronzeSaint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarListaEmModoDescendente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint mu = new BronzeSaint("Mu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        listaSaints.adicionaSaint(mu);
        listaSaints.adicionaSaint(seiya);
        listaSaints.adicionaSaint(hyoga);
        mu.perderVida(10);
        seiya.perderVida(60);
        hyoga.perderVida(80);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();

        assertEquals(hyoga, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(mu, resultadoOrdenacao.get(2));
    }
    
    @Test
    public void ordenarListaEmModoAscendente() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        listaSaints.adicionaSaint(shiryu);
        listaSaints.adicionaSaint(seiya);
        listaSaints.adicionaSaint(hyoga);
        shiryu.perderVida(10);
        seiya.perderVida(20);
        hyoga.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultadoOrdenacao = listaSaints.getTodos();

        assertEquals(hyoga, resultadoOrdenacao.get(0));
        assertEquals(seiya, resultadoOrdenacao.get(1));
        assertEquals(shiryu, resultadoOrdenacao.get(2));
    }
    
    @Test
    public void getCSVComUmSaint() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint mu = new SilverSaint("Mu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        listaSaints.adicionaSaint(mu);
        listaSaints.getCSV();
        //assertEquals("Mu,100.0,Dragão,BRONZE,VIVO,NAOINFORMADO,false", listaSaints.getCSV());
    }
    
    @Test
    public void getCSVComDoisSaint() throws Exception {
        ListaSaint listaSaints = new ListaSaint();
        Saint mu = new BronzeSaint("Mu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        Saint mu2 = new BronzeSaint("Mu2", new Armadura(new Constelacao("Áries"), Categoria.BRONZE));
        listaSaints.adicionaSaint(mu);
        listaSaints.getCSV();
        //assertEquals("Mu,100.0,Dragão,Armadura@1e09bf8,VIVO,NAOINFORMADO,false", listaSaints.getCSV());
        //assertEquals("Mu2,100.0,Áries,Armadura@1e09bf8,VIVO,NAOINFORMADO,false", listaSaints.getCSV());
    }
}