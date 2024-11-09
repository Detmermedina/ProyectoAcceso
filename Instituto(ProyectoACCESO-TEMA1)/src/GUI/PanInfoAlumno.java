package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanInfoAlumno extends JPanel {
    private JTextField dniAlumnoField;
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JTextArea infoTextArea;
    private Instituto instituto;

    public PanInfoAlumno(Instituto instituto) {
        this.instituto = instituto;
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(248, 249, 250)); // Fondo más suave

        // Crear el panel central con GridBagLayout para centrar los componentes
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(248, 249, 250)); // Fondo del panel central

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre los componentes

        // Etiqueta y campo de texto
        JLabel dniLabel = new JLabel("DNI del Alumno:");
        dniLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        centerPanel.add(dniLabel, gbc);

        dniAlumnoField = new JTextField(15);
        dniAlumnoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dniAlumnoField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        centerPanel.add(dniAlumnoField, gbc);

        // Botón de mostrar información
        mostrarButton = new JButton("Mostrar Información");
        mostrarButton.setBackground(new Color(66, 133, 244)); // Azul suave
        mostrarButton.setForeground(Color.WHITE);
        mostrarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        mostrarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionAlumno();
            }
        });

        // Efecto hover sobre el botón
        mostrarButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                mostrarButton.setBackground(new Color(33, 150, 243)); // Azul oscuro
            }
            public void mouseExited(MouseEvent evt) {
                mostrarButton.setBackground(new Color(66, 133, 244)); // Regresa al color original
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // El botón ocupa dos columnas
        centerPanel.add(mostrarButton, gbc);

        // Botón de limpiar
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBackground(new Color(255, 87, 34)); // Naranja brillante
        limpiarButton.setForeground(Color.WHITE);
        limpiarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        limpiarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Efecto hover sobre el botón
        limpiarButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                limpiarButton.setBackground(new Color(255, 61, 0)); // Naranja oscuro
            }
            public void mouseExited(MouseEvent evt) {
                limpiarButton.setBackground(new Color(255, 87, 34)); // Regresa al color original
            }
        });
        gbc.gridy = 2;
        centerPanel.add(limpiarButton, gbc);

        // Añadir el panel central al centro del panel principal
        add(centerPanel, BorderLayout.CENTER);

        // Área de texto para mostrar la información del alumno
        infoTextArea = new JTextArea(15, 30);
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        infoTextArea.setBackground(new Color(255, 255, 255));
        infoTextArea.setForeground(new Color(50, 50, 50)); // Texto más oscuro para mejor lectura
        infoTextArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Borde sutil

        // Panel inferior para la información
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.add(new JScrollPane(infoTextArea), BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
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
