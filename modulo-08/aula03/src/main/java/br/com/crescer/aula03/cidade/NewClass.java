package br.com.crescer.aula03.cidade;

public class NewClass {
    
    public static void main(String[] args) {
        final CidadeDao pessoaDao = new CidadeDaoImpl();
        
        final Cidade pessoa = new Cidade();
        
        pessoa.setId(1l);
        pessoa.setNome("Carlos");
        
        pessoaDao.delete(pessoa);
        
        
    }
    
}
