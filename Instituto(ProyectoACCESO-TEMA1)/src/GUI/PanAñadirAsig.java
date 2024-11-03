package GUI;

import data.Asignaturas;
import data.Cursos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.Instituto;

public class PanAñadirAsig extends JPanel {

    private JTextField textFieldIdCurso;
    private JTextField textFieldIdAsignatura;
    private JTextField textFieldNombreAsignatura;
    private JButton buttonAgregar;

    private Instituto instituto; // Suponiendo que tienes un objeto Instituto para agregar la asignatura

    public PanAñadirAsig(Instituto instituto) {
        this.instituto = instituto;

        setLayout(new GridLayout(4, 2));

        add(new JLabel("ID del Curso:"));
        textFieldIdCurso = new JTextField();
        add(textFieldIdCurso);

        add(new JLabel("ID de la Asignatura:"));
        textFieldIdAsignatura = new JTextField();
        add(textFieldIdAsignatura);

        add(new JLabel("Nombre de la Asignatura:"));
        textFieldNombreAsignatura = new JTextField();
        add(textFieldNombreAsignatura);

        buttonAgregar = new JButton("Agregar Asignatura");
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAsignatura();
            }
        });
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
                JOptionPane.showMessageDialog(this, "Asignatura añadida correctamente a " + curso);
            } else {
                JOptionPane.showMessageDialog(this, "El curso con ID " + idCursoInt + " no existe.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido para los IDs.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

