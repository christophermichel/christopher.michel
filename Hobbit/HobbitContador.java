import java.util.*;
public class HobbitContador {

    private int produtoMenosMMC = 0;
    private String nome;
    private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();

    public HobbitContador(String nome) {
        this.nome = nome;
    }

    public int calculaDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        ArrayList<Integer> resultados = new ArrayList<>();
        int resultado;
        int MMC;
        for(int i=0;i<arrayDePares.size();i++) {
            ArrayList<Integer> par = arrayDePares.get(i);
            boolean achouMMC = false;
            int produto = par.get(0) * par.get(1);
            int j=1;
            while (!achouMMC) {
                if (j%par.get(0)== 0 && j!=par.get(0) && j%par.get(1)==0 && j!=par.get(1)) {
                    MMC = j;
                    achouMMC = true;
                    resultado = produto - MMC;
                    resultados.add(resultado);
                } else {
                    j++;
                }
            }
        }

        for(int k=0; k<resultados.size();k++) {
            produtoMenosMMC = produtoMenosMMC + resultados.get(k);
        }
        return produtoMenosMMC;
    }

    public int maiorMultiploDeTres (int numero) {
        boolean multiploDeTres = false;
        int maiorMultiplo = 0;
        if (numero < 3) {
            System.out.println("Número inválido");
        }
        else{
            while (!multiploDeTres) {
                if (numero%3 == 0) {
                    maiorMultiplo = numero;
                    multiploDeTres = true;
                } else {
                    numero--;
                }
            }
        }
        return maiorMultiplo;
    }

    public ArrayList<Integer> multiplosDeTres (Integer numero) {
        ArrayList<Integer> multiplosReunidos = new ArrayList<>();
        numero = numero;
        for(int i=0; i <= numero; i++) {
            if (numero%3 == 0 && numero > 2) {
                multiplosReunidos.add(numero);
            }
        }    
        return multiplosReunidos;
    }
}
