package GUI;

import data.Instituto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanMostrarInfoCursos extends JPanel {
    private JTextField idCursoField;
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JTextArea infoTextArea;
    private Instituto instituto;

    public PanMostrarInfoCursos(Instituto instituto) {
     this.instituto = instituto;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.CYAN);
        
        

        // Panel superior con botón para limpiar
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.CYAN);

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