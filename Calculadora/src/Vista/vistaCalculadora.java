package Vista;

import javax.swing.*;
import java.awt.*;

public class vistaCalculadora extends JFrame {

    private JTextField pantalla;
    private String operacionActual = "";
    private double resultado = 0;
    private String operador = "";
    private boolean nuevaOperacion = true;
    
	public vistaCalculadora() {
		
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        IniciarComponentes();
    }

    private void IniciarComponentes() {
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 28));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false);
        pantalla.setText("0");
        add(pantalla, BorderLayout.NORTH);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));

        String[] botones = {
            "C", "", "", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", ""
        };
        
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 22));

            if (texto.equals("")) {
                boton.setEnabled(false);
            } else {
                boton.addActionListener(e -> botonPresionado(texto));
            }

            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    private void botonPresionado(String texto) {
    	//verifica si se presiona de 0-9 o si es un punto decimal
        if (texto.matches("[0-9\\.]")) {
            if (nuevaOperacion) {
                pantalla.setText("");
                nuevaOperacion = false;
            }
            pantalla.setText(pantalla.getText() + texto);
          //verifica el tipo de operacion
        } else if (texto.matches("[\\+\\-\\*/]")) {
        	//Guarda el primer numero 
            operacionActual = pantalla.getText();
            //Guarda el tipo de operacion que se realizara
            operador = texto;
            //Indica que el siguiente numero sera una nueva entrada
            nuevaOperacion = true;
        } else if (texto.equals("=")) {
            try {
                double num1 = Double.parseDouble(operacionActual);
                double num2 = Double.parseDouble(pantalla.getText());
                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            pantalla.setText("Error");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }
                pantalla.setText(String.valueOf(resultado));
                nuevaOperacion = true;
            } catch (Exception e) {
                pantalla.setText("Error");
                nuevaOperacion = true;
            }
        } else if (texto.equals("C")) {
            pantalla.setText("0");
            operacionActual = "";
            operador = "";
            nuevaOperacion = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new vistaCalculadora().setVisible(true);
        });
    }
}


