package br.com.crescer.aula03.pessoa;

/**
 * @author carloshenrique
 */
public class NewClass {
    
    public static void main(String[] args) {
        final PessoaDao pessoaDao = new PessoaDaoImpl();
        
        final Pessoa pessoa = new Pessoa();
        
        pessoa.setId(2L);
        pessoa.setNome("Chris");
        
        pessoaDao.insert(pessoa);
        
        
    }
    
}
