import java.util.Scanner;

class HelloWorldApp {

    public static void main(String[] args) {
		
		int x = 0;
		
        try (final Scanner scanner = new Scanner(System.in)) {
			x = scanner.nextInt();
        } catch (Exception e) {
            //...
        }
		if (x % 2 == 0) {
			System.out.println("O número é par");
		}
		else {
			System.out.println("O númeor é ímpar");
		}
    }
}