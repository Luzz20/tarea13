import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraSimple {
    private JFrame ventana;
    private JTextField pantalla;
    private double numero1, numero2, resultado;
    private char operacion;

    public CalculadoraSimple() {
        ventana = new JFrame("Calculadora Simple");
        ventana.setSize(300, 300);
        ventana.setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        ventana.add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4));
        ventana.add(panelBotones, BorderLayout.CENTER);

        String[] botones = {"7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", ".", "=", "+"};

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
        new CalculadoraSimple();
    }
}

