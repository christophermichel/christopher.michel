package br.com.crescer.aula03.estado;

/**
 * @author carloshenrique
 */
public class NewClass {
    
    public static void main(String[] args) {
        final EstadoDao pessoaDao = new EstadoDaoImpl();
        
        final Estado pessoa = new Estado();
        
        pessoa.setId(1l);
        pessoa.setNome("Carlos");
        
        pessoaDao.delete(pessoa);
        
        
    }
    
}
