import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CalculadoraCientifica extends JPanel {
    private JTextField pantalla;
    private double numero1, numero2, resultado;
    private char operacion;
    private FunctionPlotter plotter;

    public CalculadoraCientifica() {
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 4));
        add(panelBotones, BorderLayout.CENTER);

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
                    // ...
                }
            });
            panelBotones.add(btn);
        }

        plotter = new FunctionPlotter();
        add(plotter, BorderLayout.SOUTH);

        JButton btnGraficar = new JButton("Graficar");
        btnGraficar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String funcion = pantalla.getText();
                plotter.plotFunction(funcion);
            }
        });
        add(btnGraficar, BorderLayout.EAST);
    }

    private class FunctionPlotter extends JPanel {
        private String funcion;

        public FunctionPlotter() {
            setPreferredSize(new Dimension(400, 200));
        }

        public void plotFunction(String funcion) {
            this.funcion = funcion;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar ejes
            g2d.setColor(Color.BLACK);
            g2d.drawLine(50, 50, 350, 50); // eje x
            g2d.drawLine(200, 50, 200, 150); // eje y

            // Dibujar función
            if (funcion != null) {
                g2d.setColor(Color.RED);
                double x = 0;
                double y = 0;
                for (int i = 50; i <= 350; i++) {
                    x = (i - 200) / 50.0;
                    y = evaluarFuncion(funcion, x);
                    int yi = (int) (150 - y * 50);
                    g2d.drawLine(i, yi, i, yi);
                }
            }
        }

        private double evaluarFuncion(String funcion, double x) {
            // Evaluación de la función, reemplazar con una biblioteca de expresiones matemáticas
            return x * x;
        }
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora Científica");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new CalculadoraCientifica());
        ventana.pack();
        ventana.setVisible(true);
    }
}


