package com.lg.main;

import lg.interfaces.Icalculadora;
import lg.interfaces.implementacion.CalculadoraImpl;

public class Main {

	public static void main(String[] arg) {
		Icalculadora calculadora = new CalculadoraImpl();
		System.out.println(calculadora.sumar(3,2));
		System.out.println(calculadora.restar(3,2));
		System.out.println(calculadora.multiplicar(3,2));
		System.out.println(calculadora.dividir(10,2));
	}
}
