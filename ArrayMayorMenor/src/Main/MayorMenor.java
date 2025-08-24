package Main;

import java.util.Scanner;

public class MayorMenor {

	public static void main(String[] args) {

		int[] numeros = new int[10];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Se ordenaran los numeros de mayor a menor");
		System.out.println("Escriba los numeros que desee ordenar:");
		
		 for (int i = 0; i < 10; i++) {
	            System.out.print("Número " + (i + 1) + ": ");
	            numeros[i] = scanner.nextInt();
	        }
		
		 	int mayor = numeros[0];
	        int menor = numeros[0];
	        int suma = 0;
	        
	        for (int i = 0; i < 10; i++) {
	            if (numeros[i] > mayor) {
	                mayor = numeros[i];
	            }
	            if (numeros[i] < menor) {
	                menor = numeros[i];
	            }
	            suma += numeros[i];
	        }
	        
	        double promedio = suma / 10.0;

	        System.out.println("\nNúmero mayor: " + mayor);
	        System.out.println("Número menor: " + menor);
	        System.out.println("Promedio: " + promedio);

	        scanner.close();
	}

}
