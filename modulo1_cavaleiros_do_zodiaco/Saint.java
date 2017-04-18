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
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public void perderVida (double dano) {
        if (vida - dano < 1.0) {
            vida = 0;
            setStatus(Status.MORTO);
    }
        else {
            this.vida = this.vida - dano;
    }
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
    
    public void setStatus(Status status) {
        if (this.status != Status.MORTO) {
            this.status = status;
    }
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