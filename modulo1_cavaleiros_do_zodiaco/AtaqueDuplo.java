public class AtaqueDuplo implements Movimento {
    private Saint golpeador; 
    private Saint golpeado; 
    
    public AtaqueDuplo (Saint golpeador, Saint golpeado) {
    this.golpeador = golpeador;
    this.golpeado = golpeado;
    }
    
    public void executar () {
        if(new DadoD3().sortear() == 2) {
            
        }
    
    }
}