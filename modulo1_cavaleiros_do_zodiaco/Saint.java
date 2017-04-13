public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAOINFORMADO;
    
    public Saint(String nome, Armadura armadura, Genero genero) {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;
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
}