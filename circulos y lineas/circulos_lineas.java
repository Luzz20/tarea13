import javax.swing.*;
import java.awt.*;

public class DibujoPersona extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la cabeza
        g2d.drawOval(90, 20, 50, 50); // x, y, ancho, alto

        // Dibuja el torso
        g2d.drawLine(115, 70, 115, 150); // x1, y1, x2, y2

        // Dibuja los brazos
        g2d.drawLine(115, 90, 70, 120); // brazo izquierdo
        g2d.drawLine(115, 90, 160, 120); // brazo derecho

        // Dibuja las piernas
        g2d.drawLine(115, 150, 85, 200); // pierna izquierda
        g2d.drawLine(115, 150, 145, 200); // pierna derecha
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dibujo de una Persona");
        DibujoPersona panel = new DibujoPersona();
        
        frame.add(panel);
        frame.setSize(250, 300); // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


