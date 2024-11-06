package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanInfoAlumno extends JPanel {
    private JTextField dniAlumnoField; // Cambiado el campo a DNI de alumno
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JTextArea infoTextArea;
    private Instituto instituto;

    public PanInfoAlumno(Instituto instituto) {
        this.instituto = instituto;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.CYAN);

        // Panel superior con campo de texto y botón
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.CYAN);

        topPanel.add(new JLabel("DNI del Alumno:"));
        dniAlumnoField = new JTextField(10);
        topPanel.add(dniAlumnoField);

        mostrarButton = new JButton("Mostrar Información");
        mostrarButton.setBackground(Color.BLUE.brighter());
        mostrarButton.setForeground(Color.WHITE);
        mostrarButton.setFont(new Font("Arial", Font.BOLD, 12));
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionAlumno();
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

        // Área de texto para mostrar la información del alumno
        infoTextArea = new JTextArea(15, 30);
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        infoTextArea.setBackground(Color.WHITE);
        add(new JScrollPane(infoTextArea), BorderLayout.CENTER);
    }

    private void mostrarInformacionAlumno() {
        try {
            String dniAlumno = dniAlumnoField.getText().trim();
            // Obtener la información del alumno y mostrarla en el área de texto
            String infoAlumno = instituto.infoAlumno(dniAlumno);
            infoTextArea.setText(infoAlumno);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            infoTextArea.setText("No se encontró un alumno con el DNI especificado.");
        }
    }

    private void limpiarCampos() {
        dniAlumnoField.setText("");
        infoTextArea.setText("");
    }
}
