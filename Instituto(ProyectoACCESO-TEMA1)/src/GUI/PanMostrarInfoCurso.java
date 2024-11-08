package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanMostrarInfoCurso extends JPanel {
    private JTextField idCursoField;
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JTextArea infoTextArea;
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

        // Botón para limpiar
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBackground(Color.RED.brighter());
        limpiarButton.setForeground(Color.WHITE);
        limpiarButton.setFont(new Font("Arial", Font.BOLD, 12));
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        topPanel.add(limpiarButton);

        add(topPanel, BorderLayout.NORTH);

        // Área de texto para mostrar la información del curso
        infoTextArea = new JTextArea(15, 30);
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        infoTextArea.setBackground(Color.WHITE);
        add(new JScrollPane(infoTextArea), BorderLayout.CENTER);
    }

    private void mostrarInformacionCurso() {
        try {
            int idCurso = Integer.parseInt(idCursoField.getText());
            // Obtener la información del curso y mostrarla en el área de texto
            String infoCurso = instituto.mostrarInfoCurso(idCurso);
            infoTextArea.setText(infoCurso);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID de curso válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            infoTextArea.setText("No se encontró un curso con el ID especificado.");
        }
    }

    private void limpiarCampos() {
        idCursoField.setText("");
        infoTextArea.setText("");
    }
}


