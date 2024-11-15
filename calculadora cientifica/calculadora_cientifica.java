import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraCientifica {
    private JFrame ventana;
    private JTextField pantalla;
    private double numero1, numero2, resultado;
    private char operacion;

    public CalculadoraCientifica() {
        ventana = new JFrame("Calculadora Científica");
        ventana.setSize(400, 400);
        ventana.setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        ventana.add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 4));
        ventana.add(panelBotones, BorderLayout.CENTER);

        String[] botones = {
            "7", "8", "9", "√",
            "4", "5", "6", "sin",
            "1", "2", "3", "cos",
            "0", ".", "=", "tan",
            "log", "ln", "e", "^",
            "x^2", "x^3", "1/x", "C"
        };

        for (String boton : botones) {
            JButton btn = new JButton(boton);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String texto = e.getActionCommand();
                    if (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")) {
                        numero1 = Double.parseDouble(pantalla.getText());
                        operacion = texto.charAt(0);
                        pantalla.setText("");
                    } else if (texto.equals("=")) {
                        numero2 = Double.parseDouble(pantalla.getText());
                        switch (operacion) {
                            case '+':
                                resultado = numero1 + numero2;
                                break;
                            case '-':
                                resultado = numero1 - numero2;
                                break;
                            case '*':
                                resultado = numero1 * numero2;
                                break;
                            case '/':
                                resultado = numero1 / numero2;
                                break;
                        }
                        pantalla.setText(String.valueOf(resultado));
                    } else if (texto.equals("√")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.sqrt(num)));
                    } else if (texto.equals("sin")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.sin(Math.toRadians(num))));
                    } else if (texto.equals("cos")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.cos(Math.toRadians(num))));
                    } else if (texto.equals("tan")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.tan(Math.toRadians(num))));
                    } else if (texto.equals("log")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.log10(num)));
                    } else if (texto.equals("ln")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.log(num)));
                    } else if (texto.equals("e")) {
                        pantalla.setText(String.valueOf(Math.E));
                    } else if (texto.equals("^")) {
                        numero1 = Double.parseDouble(pantalla.getText());
                        operacion = '^';
                        pantalla.setText("");
                    } else if (texto.equals("x^2")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.pow(num, 2)));
                    } else if (texto.equals("x^3")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(Math.pow(num, 3)));
                    } else if (texto.equals("1/x")) {
                        double num = Double.parseDouble(pantalla.getText());
                        pantalla.setText(String.valueOf(1 / num));
                    } else if (texto.equals("C")) {
                        pantalla.setText("");
                    } else {
                        pantalla.setText(pantalla.getText() + texto);
                    }
                }
            });
            panelBotones.add(btn);
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraCientifica();
    }
}



