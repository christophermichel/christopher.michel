package br.com.crescer.aula03.cidade;

public class NewClass {
    
    public static void main(String[] args) {
        final CidadeDao cidadeDao = new CidadeDaoImpl();
        
        final Cidade cidade = new Cidade();
        
        cidade.setId(1l);
        cidade.setNome("Novo Hamburgo");
        
        cidadeDao.insert(cidade);
        
        
    }
    
}
