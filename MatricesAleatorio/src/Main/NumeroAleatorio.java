package Main;

import java.util.Random;

public class NumeroAleatorio {

	public static void main(String[] args) {
		
		int[][] matriz = new int[3][3];
		 Random rand = new Random();

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                matriz[i][j] = rand.nextInt(9) + 1;
	            }
	        }
	        
	        System.out.println("Matriz 3x3:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(matriz[i][j] + "\t");
	            }
	            System.out.println();
	        }
	        
	        System.out.println("\nSuma de cada fila:");
	        for (int i = 0; i < 3; i++) {
	            int sumaFila = 0;
	            for (int j = 0; j < 3; j++) {
	                sumaFila += matriz[i][j];
	            }
	            System.out.println("Fila " + (i + 1) + ": " + sumaFila);
	        }
	        
	        System.out.println("\nSuma de cada columna:");
	        for (int j = 0; j < 3; j++) {
	            int sumaColumna = 0;
	            for (int i = 0; i < 3; i++) {
	                sumaColumna += matriz[i][j];
	            }
	            System.out.println("Columna " + (j + 1) + ": " + sumaColumna);
	        }
	}

}
