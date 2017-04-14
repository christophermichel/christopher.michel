public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAOINFORMADO;
    private StatusDeVida statusDeVida = StatusDeVida.VIVO;
    
    public Saint(String nome, Armadura armadura, Genero genero, StatusDeVida statusDeVida) {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;
        this.statusDeVida = statusDeVida;
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    // camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public StatusDeVida getStatusDeVida() {
        return this.statusDeVida;
    }
    
    public void setStatusDeVida(StatusDeVida statusDeVida) {
        this.statusDeVida = statusDeVida;
    }
}