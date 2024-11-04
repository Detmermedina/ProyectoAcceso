package GUI;

import data.Cursos;
import data.Instituto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAñadirCurso extends JPanel {
    private JTextField idCursoField;
    private JTextField nombreCursoField;
    private JButton buttonAgregar;
    private Instituto instituto;

    public PanAñadirCurso(Instituto instituto) {
        this.instituto = instituto;

        setLayout(new GridLayout(3, 2, 10, 10));
        setBackground(Color.CYAN);

        // Etiqueta y campo para ID del curso
        add(new JLabel("ID del Curso:", SwingConstants.RIGHT));
        idCursoField = new JTextField();
        add(idCursoField);

        // Etiqueta y campo para Nombre del curso
        add(new JLabel("Nombre del Curso:", SwingConstants.RIGHT));
        nombreCursoField = new JTextField();
        add(nombreCursoField);

        botones();
    }
    
    public void botones(){
    
       // Botón para añadir el curso
        buttonAgregar = new JButton("Agregar Curso");
        buttonAgregar.setBackground(Color.BLUE.brighter());
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCurso();
            }
        });
        add(new JLabel()); // Espacio vacío
        add(buttonAgregar);
  
    
    }

    private void agregarCurso() {
        try {
            int idCurso = Integer.parseInt(idCursoField.getText());
            String nombreCurso = nombreCursoField.getText();
            instituto.agregarCurso(idCurso, new Cursos(nombreCurso));
            JOptionPane.showMessageDialog(this, "Curso añadido correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
