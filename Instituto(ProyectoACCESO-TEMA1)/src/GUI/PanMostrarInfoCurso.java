package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanMostrarInfoCurso extends JPanel {
    private JTextField idCursoField;
    private JButton mostrarButton;
    private Instituto instituto;

    public PanMostrarInfoCurso(Instituto instituto) {
        this.instituto = instituto;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.CYAN);

        // Panel superior con campo de texto y botón
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.CYAN);
        
        topPanel.add(new JLabel("ID del Curso:"));
        idCursoField = new JTextField(10);
        topPanel.add(idCursoField);

        mostrarButton = new JButton("Mostrar Información");
        mostrarButton.setBackground(Color.BLUE.brighter());
        mostrarButton.setForeground(Color.WHITE);
        mostrarButton.setFont(new Font("Arial", Font.BOLD, 12));
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionCurso();
            }
        });
        topPanel.add(mostrarButton);
        
        add(topPanel, BorderLayout.NORTH);
    }

    private void mostrarInformacionCurso() {
        try {
            int idCurso = Integer.parseInt(idCursoField.getText());
            instituto.mostrarInfoCurso(idCurso);  // Llama al método en Instituto para mostrar la información
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID de curso válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
