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
        Saint hyoga = new Saint("Hyoga", capricornio, Genero.NAOINFORMADO, StatusDeVida.VIVO);
        // 2. Act - Invocar a ação a ser testada
        hyoga.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = hyoga.getArmaduraVestida();
       assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() {
        Saint saori = new Saint("Saori", new Armadura("Cisne", Categoria.OURO), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        assertEquals(false, saori.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.BRONZE), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        assertEquals(Genero.NAOINFORMADO, shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusDeVidaEVivo() {
        Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE), Genero.NAOINFORMADO, StatusDeVida.VIVO);
        assertEquals(StatusDeVida.VIVO, ikki.getStatusDeVida());
    }
}

