package Main;

import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1; 
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
        
        public static void main(String[] args) {
            try (Scanner scan = new Scanner(System.in)) {
				System.out.print("Ingrese la cantidad de términos de Fibonacci: ");
				int n = scan.nextInt();

				System.out.println("Serie Fibonacci hasta " + n + " términos:");

				for (int i = 0; i < n; i++) {
				    System.out.print(fibonacci(i) + " ");
				}
			}
        }

}

    
