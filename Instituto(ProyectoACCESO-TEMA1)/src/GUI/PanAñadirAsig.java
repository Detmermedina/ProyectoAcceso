package GUI;

import data.Asignaturas;
import data.Cursos;
import data.Instituto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAñadirAsig extends JPanel {
    private JTextField textFieldIdCurso;
    private JTextField textFieldIdAsignatura;
    private JTextField textFieldNombreAsignatura;
    private JButton buttonAgregar;
    private Instituto instituto;

    public PanAñadirAsig(Instituto instituto) {
        this.instituto = instituto;

        setLayout(new GridLayout(4, 2, 10, 10));
        setBackground(Color.CYAN);

        add(new JLabel("ID del Curso:", SwingConstants.RIGHT));
        textFieldIdCurso = new JTextField();
        add(textFieldIdCurso);

        add(new JLabel("ID de la Asignatura:", SwingConstants.RIGHT));
        textFieldIdAsignatura = new JTextField();
        add(textFieldIdAsignatura);

        add(new JLabel("Nombre de la Asignatura:", SwingConstants.RIGHT));
        textFieldNombreAsignatura = new JTextField();
        add(textFieldNombreAsignatura);

        botones();
        
    
    }
    
    private void botones(){
    
    
        buttonAgregar = new JButton("Agregar Asignatura");
        buttonAgregar.setBackground(Color.BLUE.brighter());
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAsignatura();
            }
        });
        add(new JLabel()); // Espacio vacío
        add(buttonAgregar);
    
    }

    private void añadirAsignatura() {
        try {
            Integer idCursoInt = Integer.parseInt(textFieldIdCurso.getText());
            Integer idAsignaturaInt = Integer.parseInt(textFieldIdAsignatura.getText());
            String nombreAsignatura = textFieldNombreAsignatura.getText();

            Cursos curso = instituto.getCursosMap().get(idCursoInt);
            if (curso != null) {
                curso.agregarAsignatura(new Asignaturas(nombreAsignatura, idAsignaturaInt, idCursoInt));
                JOptionPane.showMessageDialog(this, "Asignatura añadida correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El curso con ID " + idCursoInt + " no existe.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
