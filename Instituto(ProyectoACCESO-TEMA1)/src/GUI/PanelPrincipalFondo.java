package GUI;

import data.Instituto;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipalFondo extends JPanel {
    private Image backgroundImage;
    private Instituto instituto;

    public PanelPrincipalFondo(Instituto instituto, String imagePath) {
        this.instituto = instituto;
        
        // Carga la imagen de fondo desde la ruta especificada
        backgroundImage = new ImageIcon(imagePath).getImage();
        
        setLayout(new BorderLayout());
        
        // Texto de bienvenida con el nombre del instituto
        JLabel welcomeLabel = new JLabel("Bienvenido al " + instituto.getNombre(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
        welcomeLabel.setForeground(Color.WHITE); // Texto en blanco para destacar
        welcomeLabel.setOpaque(false);
        
        // Agregar algo de sombra o borde al texto
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Añade el texto de bienvenida al centro del panel
        add(welcomeLabel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo que ocupa todo el panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}