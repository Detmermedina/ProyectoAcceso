package GUI;

import data.Alumnos;

import data.Instituto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanAñadirAlumn extends JPanel {
    private JTextField textFieldIdCurso;
    private JTextField textFieldDniAlum;
    private JTextField textFieldNombreAlum;
    private JButton buttonAgregar;
    private Instituto instituto;

    public PanAñadirAlumn(Instituto instituto) {
        this.instituto = instituto;

        setLayout(new GridLayout(4, 2, 10, 10));
        setBackground(Color.CYAN);

        add(new JLabel("ID del Curso donde se matriculara:", SwingConstants.RIGHT));
        textFieldIdCurso = new JTextField();
        add(textFieldIdCurso);

        add(new JLabel("DNI del Alumno/a:", SwingConstants.RIGHT));
        textFieldDniAlum = new JTextField();
        add(textFieldDniAlum);

        add(new JLabel("Nombre del Alumno:", SwingConstants.RIGHT));
        textFieldNombreAlum = new JTextField();
        add(textFieldNombreAlum);

        botones();
        
    
    }
    
    private void botones(){
    
    
        buttonAgregar = new JButton("Añadir Alumno");
        buttonAgregar.setBackground(Color.BLUE.brighter());
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAlumno();
            }
        });
        add(new JLabel()); // Espacio vacío
        add(buttonAgregar);
    
    }

    private void añadirAlumno() {
        try {
            int idCurso = Integer.parseInt(textFieldIdCurso.getText());
            String dni = textFieldDniAlum.getText();
            String nombre = textFieldNombreAlum.getText();

            Alumnos alumno = new Alumnos(dni, nombre, idCurso);
            instituto.matricularAlumno(idCurso,alumno);

            JOptionPane.showMessageDialog(this, "Alumno matriculado correctamente en el curso " + idCurso);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID de curso válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
