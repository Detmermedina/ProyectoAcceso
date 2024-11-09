package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanMostrarInfoCursos extends JPanel {
    private JButton limpiarButton;
    private JTextArea infoTextArea;
    private Instituto instituto;

    public PanMostrarInfoCursos(Instituto instituto) {
        this.instituto = instituto;
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(248, 249, 250)); // Fondo suave

        // Crear panel central con GridBagLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(248, 249, 250)); // Fondo del panel central
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre los componentes

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
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(limpiarButton, gbc);

        // Añadir el panel central al panel principal
        add(centerPanel, BorderLayout.CENTER);

        // Área de texto para mostrar la información de los cursos
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

        // Llamada inicial para mostrar toda la información de los cursos
        mostrarInformacionCursos();
    }

    private void mostrarInformacionCursos() {
        String infoCursos = instituto.mostrarInfoCursos();
        infoTextArea.setText(infoCursos);
    }

    private void limpiarCampos() {
        infoTextArea.setText("");
    }
}
