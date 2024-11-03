package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author damtv
 */
public class PanAñadirCurso extends JPanel{
    
    
    public PanAñadirCurso() {
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());

        
        JLabel label = new JLabel("Añadir Curso", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);    
    }
}
