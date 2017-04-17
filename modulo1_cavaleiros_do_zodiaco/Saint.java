public class Saint {
    public String nome;
    public Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAOINFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtsSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;
        this.status = status;
        
        if(this.getCategoria() == Categoria.PRATA) {
            this.qtsSentidosDespertados = 6;
            
        } else if (this.getCategoria() == Categoria.OURO) {
            this.qtsSentidosDespertados = 7;
            String constelacao = armadura.getConstelacao();
            if ( !constelacao.equals("Áries")
            && !constelacao.equals("Touro")
            && !constelacao.equals("Gêmeos")
            && !constelacao.equals("Câncer")
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Leão")
            && !constelacao.equals("Libra")
            && !constelacao.equals("Escorpião")
            && !constelacao.equals("Sagitário")
            && !constelacao.equals("Capricórnio")
            && !constelacao.equals("Aquário")
            && !constelacao.equals("Peixes")) {
                // dar erro
                throw new Exception("Constelação inválida");
            }
        } else {
            this.qtsSentidosDespertados = 5;
        }
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public void perderVida (double dano) {
        this.vida = this.vida - dano;
    }
    // camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    
     public Categoria getCategoria() {
        return this.armadura.categoria;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getCategoriaArmadura(){
        return this.armadura.categoria.getValor();
    }
    
    public int getQtdSentidosDespertados() {
        return this.qtsSentidosDespertados;
    }
}