
package br.com.crescer.aula01;
import java.util.Scanner;
/**
 *
 * @author christopher.michel
 */
public class NovoClass {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello World! - " + scanner.nextLine());
        } catch (Exception e) {
            //...
        }
    }
    
}
