package br.com.crescer.aula03.pais;

/**
 * @author carloshenrique
 */
public class NewClass {
    
    public static void main(String[] args) {
        final PaisDao paisDao = new PaisDaoImpl();
        
        final Pais pais = new Pais();
        
        pais.setId(1l);
        pais.setNome("Carlos");
        
        paisDao.delete(pais);
        
        
    }
    
}
