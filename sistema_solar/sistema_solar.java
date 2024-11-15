import javax.swing.*;
import java.awt.*;

public class SistemaSolar extends JFrame {
    
    public SistemaSolar() {
        setTitle("Sistema Solar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel principal
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarSistemaSolar(g);
            }
        };
        
        // Etiqueta de texto
        JLabel texto = new JLabel("Este es mi sistema solar", SwingConstants.CENTER);
        texto.setFont(new Font("Serif", Font.BOLD, 24));
        
        panel.setLayout(new BorderLayout());
        panel.add(texto, BorderLayout.NORTH);
        
        add(panel);
    }

    private void dibujarSistemaSolar(Graphics g) {
        // Posición y tamaño del sol y los planetas
        int xCentro = 400;
        int yCentro = 300;

        // Dibujo del Sol
        g.setColor(Color.ORANGE);
        g.fillOval(xCentro - 50, yCentro - 50, 100, 100); // Sol

        // Dibujo de planetas con órbitas
        int[] planetSizes = {8, 12, 12, 16, 20, 18, 16, 14}; // Tamaños de los planetas
        int[] orbitRadii = {90, 130, 170, 210, 260, 310, 360, 410}; // Distancias orbitales

        for (int i = 0; i < planetSizes.length; i++) {
            // Dibujar órbita
            g.setColor(Color.LIGHT_GRAY);
            g.drawOval(xCentro - orbitRadii[i], yCentro - orbitRadii[i], orbitRadii[i] * 2, orbitRadii[i] * 2);

            // Dibujar planeta
            int planetX = xCentro + orbitRadii[i] - planetSizes[i] / 2;
            int planetY = yCentro - planetSizes[i] / 2;
            g.setColor(new Color(50 + i * 20, 100 + i * 10, 150 + i * 5)); // Colores diferentes para cada planeta
            g.fillOval(planetX, planetY, planetSizes[i], planetSizes[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaSolar frame = new SistemaSolar();
            frame.setVisible(true);
        });
    }
}

