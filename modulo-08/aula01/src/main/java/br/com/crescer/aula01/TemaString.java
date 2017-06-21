package br.com.crescer.aula01;

import java.text.Normalizer;

/**
 *
 * @author chris
 */
public class TemaString implements StringUtils{
    
    public static void main (String[] args) {
        TemaString testa = new TemaString();
        
        System.out.println(testa.isEmpty(""));
        System.out.println(testa.isEmpty("Hey"));
        System.out.println(testa.inverter(""));
        System.out.println(testa.inverter("Inverter"));
        System.out.println(testa.contaVogais("ABABAB"));
        System.out.println(testa.contaVogais("sdfslk"));
        System.out.println(testa.contaVogais("sdfáslk"));
        System.out.println(testa.isPalindromo("assa"));
        System.out.println(testa.isPalindromo("asasa"));
        System.out.println(testa.isPalindromo("a sasa"));
        
    }
    
    @Override
    public boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }
    
    @Override
    public String inverter(String string) {
        if (isEmpty(string)){
          return "A string fornecida é nula";
        }
        else {
          int i;
          int tamanho = string.length();
          StringBuilder stringFinal = new StringBuilder();

          for (i = (tamanho - 1); i >= 0; i--){
          stringFinal.append(string.charAt(i));
        }
        return stringFinal.toString();
        }
    }
    
    @Override
    public int contaVogais(String string) {
        int vogais = 0;
        string = 
            Normalizer
           .normalize(string, Normalizer.Form.NFD)
           .replaceAll("[^\\p{ASCII}]", "");
        
        string = string.toUpperCase();
        
        for (int i = 0; i < string.length(); i++){
            char j = string.charAt(i);
            if (j == 'A' || j == 'E' || j == 'I' || j == 'O' || j == 'U')
                vogais++;
        }
        return vogais;
    }
    
    @Override
    public boolean isPalindromo(String string) {
        string = 
            Normalizer
           .normalize(string, Normalizer.Form.NFD)
           .replaceAll(" ", "")
           .replaceAll("[^\\p{ASCII}]", "");
        
        int i;
        int tamanho = string.length()/2;
        StringBuilder metadeInicial = new StringBuilder();
        String metadeFinal;
        
        for (i = (tamanho - 1); i >= 0; i--){
            metadeInicial.append(string.charAt(i));
        }
        
        if (string.length() % 2 == 0) {
            metadeFinal = string.substring((tamanho),string.length());
        }
        
        else {
            metadeFinal = string.substring((tamanho+1),string.length());
        }

        return metadeInicial.toString().toLowerCase().equals(metadeFinal.toLowerCase());
    }
}
