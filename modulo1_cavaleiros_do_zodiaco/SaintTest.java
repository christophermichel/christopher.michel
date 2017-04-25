import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    
    //Saint.zeraQtdSaints();
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        // 2. Act - Invocar a ação a ser testada
        mu.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = mu.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void danoEstaFuncionando10() throws Exception {
        //1
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        //2
        mu.perderVida(10.0);
        //3
        assertEquals(90.0, mu.getVida(), 0.01);
    }

    @Test
    public void danoEstaFuncionando100() throws Exception {
        //1
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        //2
        mu.perderVida(100.0);
        //3
        assertEquals(0, mu.getVida(), 0.01);
    }

    @Test
    public void statusMortoCom0DeVida() throws Exception {
        //1
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        //2
        mu.perderVida(100.0);
        //3
        assertEquals(Status.MORTO, mu.getStatus());
    }

    @Test
    public void danoEstaFuncionando1000() throws Exception {
        //1
        Saint mu = new SilverSaint("Mu", "Gêmeos");
        //2
        mu.perderVida(1000.0);
        //3
        assertEquals(0, mu.getVida(), 0.01);
    }

    @Test
    public void aoCriarSaintVidaIniciaEm100() throws Exception {
        //1
        Saint jabu = new BronzeSaint("Jabu", "Gêmeos");
        //3
        assertEquals(100.0, jabu.getVida(), 0.01);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        //1
        Saint saori = new SilverSaint("Saori", "Gêmeos");
        //3
        assertEquals(false, saori.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        //1
        Saint shaka = new BronzeSaint("Shaka", "Gêmeos");
        //3
        assertEquals(Genero.NAOINFORMADO, shaka.getGenero());
    }

    @Test
    public void consigoTrocarDeGenero() throws Exception {
        //1
        Saint mu = new BronzeSaint("Mu", "Gêmeos");
        mu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, mu.getGenero());
    }

    @Test
    public void naoAlteraStatusQuandoMorre() throws Exception {
        //1
        Saint mu = new BronzeSaint("Mu", "Gêmeos");
        mu.setStatus(Status.MORTO);
        mu.setStatus(Status.VIVO);
        assertEquals(Status.MORTO, mu.getStatus());
    }

    @Test
    public void aoCriarSaintStatusDeVidaEVivo() throws Exception {
        //1
        Saint ikki = new BronzeSaint("Ikki", "Gêmeos");
        //3
        assertEquals(Status.VIVO, ikki.getStatus());
    }

    @Test
    public void confirmarPesoDaArmadura() throws Exception {
        //1
        Saint jabu = new BronzeSaint("Jabu", "Gêmeos");
        //3
        assertEquals(jabu.getCategoriaArmadura(), 1);
    }

    /*@Test
    public void saintOuroTem7Sentidos() throws Exception {
    GoldSaint seiya = new GoldSaint("Seiya", new Armadura (new Constelacao("Touro"), Categoria.OURO));
    assertEquals(7, seiya.getQtdSentidosDespertados());
    }*/

    @Test
    public void saintPrataTem6Sentidos() throws Exception {
        SilverSaint seiya = new SilverSaint("Seiya", "Gêmeos");
        assertEquals(6, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void saintBronzeTem5Sentidos() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", "Gêmeos");
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test(expected = Exception.class)
    public void danoNaoPodeSerNegativo()throws Exception{
        BronzeSaint seiya = new BronzeSaint("Seiya", "Gêmeos");
        seiya.perderVida(-10);

    }
    
    @Test(expected=ArithmeticException.class)
    public void getProximoMovimentoComListaVazia() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento movimento = hyoga.getProximoMovimento();
    }

    @Test
    public void getProximoMovimentoComUmMovimento() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(vestirArmadura);
        assertEquals(vestirArmadura, hyoga.getProximoMovimento());
    }
    
    @Test
    public void getProximoMovimentoDuasVezesComUmMovimento() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(vestirArmadura);
        hyoga.getProximoMovimento();
        assertEquals(vestirArmadura, hyoga.getProximoMovimento());
    }
    
    @Test
    public void criarUmSaintQtdSaintsDeveSerUmAMais() throws Exception {
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        assertEquals(1, Saint.getQtdSaints());
    }
    
    @Test
    public void criarDoisSaintQtdSaintsDeveSerDoisAMais() throws Exception {
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        Saint mu = new BronzeSaint("Mu", "Áries");
        assertEquals(2, Saint.getQtdSaints());
    }
}

