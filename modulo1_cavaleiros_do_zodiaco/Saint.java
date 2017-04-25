import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAOINFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtsSentidosDespertados;
    private int proximoGolpe = 0;
    private int proximoMovimento = 0;
    private ArrayList<Movimento> listaDeMovimentos = new ArrayList<>();
    private static int qtdSaints = 0, acumuladorQtdSaints = 0;
    private int id;

    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.id = ++Saint.acumuladorQtdSaints;
        Saint.qtdSaints++;
    }

    protected void finalize() throws Throwable {
        Saint.qtdSaints--;
    }
    
    public Armadura getArmadura() {
        return this.armadura;
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }

    public void perderVida (double dano) {
        if (dano < 0) {
            throw new InvalidParameterException ("Erro no dano");
        }

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

    public String getNomeConstelacao() {
        return this.armadura.getNomeConstelacao();
    }

    public String getNome() {
        return this.nome;
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

    public void setStatus(Status status) {
        if (this.status != Status.MORTO) {

            this.status = status;
        }
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

    public ArrayList<Golpe> getGolpes(){
        return this.armadura.getGolpes();
    }

    public void aprenderGolpe(Golpe golpe){
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }

    private String getConstelacao() {
        return this.armadura.getNomeConstelacao();
    }

    public Golpe getProximoGolpe(){
        ArrayList<Golpe> listaDeGolpes = getGolpes();
        int posicao = this.proximoGolpe % listaDeGolpes.size();
        this.proximoGolpe++;
        return listaDeGolpes.get(posicao);
    }

    public void adicionarMovimento(Movimento movimento) { 
        listaDeMovimentos.add(movimento);
    }
    
     public Movimento getProximoMovimento(){
        int posicao = this.proximoMovimento % listaDeMovimentos.size();
        this.proximoMovimento++;
        return listaDeMovimentos.get(posicao);
    }
    
    public boolean getTemGolpes() {
        return armadura.getConstelacao().getGolpes().isEmpty();
    }
    
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }
    
    public static int getQtdSaints() {
        return qtdSaints;
    }
    
    public int getId() {
        return this.id;
    }
    
    public static int acumuladorQtdSaints() {
        return qtdSaints;
    }
    
    public static int getAcumuladorQtdSaints() {
        return Saint.acumuladorQtdSaints;
    }
}