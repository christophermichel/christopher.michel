package br.com.crescer.aula01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
    
    Calendar calendar = Calendar.getInstance();
    
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    String dataRecebida = bufferedReader.readLine();
                    java.util.Date novaData = df.parse(dataRecebida);
                    System.out.println(novaData);
            } catch (Exception e) {
                    //...
            }
            try (final InputStreamReader input2 = new InputStreamReader(System.in)) {
                try (final BufferedReader bufferedReader = new BufferedReader(input2)) {
                    String diasAcrescentar = bufferedReader.readLine();
                    System.out.println(diasAcrescentar);
                    
                } catch (Exception e) {
                    //...
                }
            } catch (Exception e) {
                    //...
            }
        } catch (Exception e) {
            //...
        }
    }
}
