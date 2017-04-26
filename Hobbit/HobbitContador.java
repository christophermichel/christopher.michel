import java.util.*;
public class HobbitContador {

    private int produtoMenosMMC = 0;
    private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();

    public HobbitContador(ArrayList<ArrayList<Integer>> arrayDePares) {
        this.arrayDePares = arrayDePares;
    }

    public int arrayDePares(ArrayList<ArrayList<Integer>> arrayDePares) {
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
}
