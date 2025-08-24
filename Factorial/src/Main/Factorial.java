package Main;

import java.util.Scanner;

public class Factorial {

    public static int calcFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcFactorial(n - 1); 
        }
    }
    
	public static void main(String[] args) {
		
		int numero;
		int resultado;
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Ingrese un número para calcular su factorial: ");
	     numero = scanner.nextInt();
	     resultado = calcFactorial(numero);
	     System.out.println("El factorial de " + numero + " es: " + resultado);
	     scanner.close();
	}

}
