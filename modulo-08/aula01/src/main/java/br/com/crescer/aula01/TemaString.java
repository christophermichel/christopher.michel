package br.com.crescer.aula01;
/**
 *
 * @author chris
 */
public class TemaString implements StringUtils{
    
    @Override
    public boolean isEmpty(String string) {
        return string.length() <= 0;
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
        System.out.println(stringFinal);
        return stringFinal.toString();
        }
    }
    
    @Override
    public int contaVogais(String string) {
        int vogais = 0;
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
        return string.length() <= 0;
    }
}
