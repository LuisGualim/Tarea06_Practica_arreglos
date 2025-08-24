package lg.interfaces.implementacion;

import lg.interfaces.Icalculadora;

public class CalculadoraImpl implements Icalculadora{

	@Override
	public String sumar(Integer a, Integer b) {
		Integer suma = a+b;
		return "La suma es; " + suma;
	}

	@Override
	public String restar(Integer a, Integer b) {
		Integer resta = a-b;
		return "La resta es; " + resta;
	}

	@Override
	public String multiplicar(Integer a, Integer b) {
		Integer producto = a*b;
		return "El producto es; " + producto;
	}

	@Override
	public String dividir(Integer a, Integer b) {
		Integer division = a/b;
		return "El producto es; " + division;
	}

	
}
