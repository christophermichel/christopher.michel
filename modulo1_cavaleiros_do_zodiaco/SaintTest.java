import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura capricornio = new Armadura("Capricórnio",Categoria.OURO);
        Saint hyoga = new Saint("Hyoga", capricornio);
        // 2. Act - Invocar a ação a ser testada
        hyoga.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = hyoga.getArmaduraVestida();
       assertEquals(true, resultado);
    }
    
    @Test
    public void perderVidaEstaFuncionando(){
        //1
        Saint mu = new Saint("Mu", new Armadura("Aries", Categoria.OURO));
        //2
        mu.perderVida(30.0);
        //3
        assertEquals(mu.getVida(),70.0, 30.0);
    }
    
    @Test
    public void aoCriarSaintVidaIniciaEm100(){
        //1
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        //3
        assertEquals(jabu.getVida(),100.0, 0);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() {
        //1
        Saint saori = new Saint("Saori", new Armadura("Cisne", Categoria.OURO));
        //3
        assertEquals(false, saori.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        //1
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.BRONZE));
        //3
        assertEquals(Genero.NAOINFORMADO, shaka.getGenero());
    }
    
    @Test
    public void consigoTrocarDeGenero() {
        //1
        Saint mu = new Saint("Mu", new Armadura("Áries", Categoria.BRONZE));
        mu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, mu.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusDeVidaEVivo() {
        //1
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
        //3
        assertEquals(Status.VIVO, ikki.getStatus());
    }
    
    @Test
    public void confirmarPesoDaArmadura() {
        //1
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        //3
        assertEquals(jabu.getCategoriaArmadura(), 1);
    }
}

