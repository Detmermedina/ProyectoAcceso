package GUI;

import data.Asignaturas;
import data.Cursos;
import data.Instituto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanAñadirAsig extends JPanel {
    private JTextField textFieldIdCurso;
    private JTextField textFieldIdAsignatura;
    private JTextField textFieldNombreAsignatura;
    private JButton buttonAgregar;
    private Instituto instituto;

    public PanAñadirAsig(Instituto instituto) {
        this.instituto = instituto;

        setLayout(new GridBagLayout()); // Usamos GridBagLayout para un diseño más flexible
        setBackground(new Color(248, 249, 250)); // Fondo más suave
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre los componentes

        // Añadir ID del Curso
        JLabel labelIdCurso = new JLabel("ID del Curso:");
        labelIdCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelIdCurso.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(labelIdCurso, gbc);

        textFieldIdCurso = new JTextField(15);
        textFieldIdCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldIdCurso, gbc);

        // Añadir ID de la Asignatura
        JLabel labelIdAsignatura = new JLabel("ID de la Asignatura:");
        labelIdAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelIdAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelIdAsignatura, gbc);

        textFieldIdAsignatura = new JTextField(15);
        textFieldIdAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldIdAsignatura, gbc);

        // Añadir Nombre de la Asignatura
        JLabel labelNombreAsignatura = new JLabel("Nombre de la Asignatura:");
        labelNombreAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelNombreAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelNombreAsignatura, gbc);

        textFieldNombreAsignatura = new JTextField(15);
        textFieldNombreAsignatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldNombreAsignatura, gbc);

        // Botón para agregar la asignatura
        buttonAgregar = new JButton("Agregar Asignatura");
        buttonAgregar.setBackground(new Color(66, 133, 244)); // Azul suave
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonAgregar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAsignatura();
            }
        });

        // Efecto hover sobre el botón
        buttonAgregar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonAgregar.setBackground(new Color(33, 150, 243)); // Azul oscuro
            }
            public void mouseExited(MouseEvent evt) {
                buttonAgregar.setBackground(new Color(66, 133, 244)); // Regresa al color original
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // El botón ocupa dos columnas
        add(buttonAgregar, gbc);
    }

    private void añadirAsignatura() {
        try {
            // Obtenemos los valores de los campos de texto
            int idCursoInt = Integer.parseInt(textFieldIdCurso.getText());
            int idAsignaturaInt = Integer.parseInt(textFieldIdAsignatura.getText());
            String nombreAsignatura = textFieldNombreAsignatura.getText();
            
            
           if (!ComprobarNombre(nombreAsignatura)) {
              JOptionPane.showMessageDialog(this, "Por favor, ingrese correctamente el nombre de la "
                      + "Asignatura, no pueden ser numeros.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
            
            
          
            if(!ComprobarCurso(idCursoInt)){
              JOptionPane.showMessageDialog(this, "Por favor, ingrese correctamente el ID del curso.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }

            // Validar que los campos no estén vacíos
            if (nombreAsignatura.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de la asignatura.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el curso en el instituto
            Cursos curso = instituto.getCursosMap().get(idCursoInt);
            if (curso != null) {
                // Agregar la asignatura al curso
                curso.agregarAsignatura(new Asignaturas(nombreAsignatura, idAsignaturaInt, idCursoInt));
                JOptionPane.showMessageDialog(this, "Asignatura añadida correctamente.");
                limpiarCampos(); // Limpiar los campos después de añadir la asignatura
            } else {
                JOptionPane.showMessageDialog(this, "El curso con ID " + idCursoInt + " no existe.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        
   public boolean ComprobarNombre(String nom) {
       
     
    return nom.matches("[a-zA-Z\\s]+");
    }
    
    private boolean ComprobarCurso(int idCurso) {
    // Verificar si el curso con el ID proporcionado existe en el Instituto
    return instituto.getCursosMap().containsKey(idCurso);
}

    // Método para limpiar los campos de texto después de añadir una asignatura
    private void limpiarCampos() {
        textFieldIdCurso.setText("");
        textFieldIdAsignatura.setText("");
        textFieldNombreAsignatura.setText("");
    }
}
