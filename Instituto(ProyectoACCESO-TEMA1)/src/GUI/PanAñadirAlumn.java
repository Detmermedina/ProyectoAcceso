package GUI;

import data.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanAñadirAlumn extends JPanel {
    
    //--------------//
    
    
    private JTextField textFieldIdCurso;
    private JTextField textFieldDniAlum;
    private JTextField textFieldNombreAlum;
    private JButton buttonAgregar;
    private Instituto instituto;

    
    
    public PanAñadirAlumn(Instituto instituto) {
        this.instituto = instituto;
        
        
        
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para un diseño flexible
        setBackground(new Color(248, 249, 250)); // Fondo más suave
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre los componentes

        // Añadir ID del Curso
        JLabel labelIdCurso = new JLabel("ID del Curso:");
        labelIdCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelIdCurso.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelIdCurso, gbc);

        textFieldIdCurso = new JTextField(15);
        textFieldIdCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldIdCurso, gbc);

        // Añadir DNI del Alumno
        JLabel labelDniAlum = new JLabel("DNI del Alumno/a:");
        labelDniAlum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelDniAlum.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelDniAlum, gbc);

        textFieldDniAlum = new JTextField(15);
        textFieldDniAlum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldDniAlum, gbc);

        // Añadir Nombre del Alumno
        JLabel labelNombreAlum = new JLabel("Nombre del Alumno:");
        labelNombreAlum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelNombreAlum.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelNombreAlum, gbc);

        textFieldNombreAlum = new JTextField(15);
        textFieldNombreAlum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        add(textFieldNombreAlum, gbc);

        // Botón para agregar el alumno
        buttonAgregar = new JButton("Añadir Alumno");
        buttonAgregar.setBackground(new Color(66, 133, 244)); // Azul suave
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonAgregar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirAlumno();
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

    private void añadirAlumno() {
        try {
            // Obtenemos los valores de los campos de texto
            int idCurso = Integer.parseInt(textFieldIdCurso.getText());
            String dni = textFieldDniAlum.getText().toUpperCase();
            String nombre = textFieldNombreAlum.getText().toUpperCase();
            
            if (!ComprobarNombre(nombre)) {
              JOptionPane.showMessageDialog(this, "Por favor, ingrese correctamente el nombre del "
                      + "Alumno, no pueden ser numeros.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
            
            if(!ComprobarCurso(idCurso)){
              JOptionPane.showMessageDialog(this, "Por favor, ingrese correctamente el ID del curso.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
            
            
            if (!ComprobarDNI(dni)) {
              JOptionPane.showMessageDialog(this, "Por favor, ingrese correctamente el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
    
            // Validar que los campos no estén vacíos
            if (dni.isEmpty() || nombre.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el DNI y nombre del alumno.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto Alumno y matricularlo
            Alumnos alumno = new Alumnos(dni, nombre, idCurso);
            instituto.matricularAlumno(idCurso, alumno);

            JOptionPane.showMessageDialog(this, "Alumno matriculado correctamente en el curso " + idCurso);
            limpiarCampos(); // Limpiar los campos después de añadir al alumno
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID de curso válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
public boolean ComprobarNombre(String nom) {
       
     
    return nom.matches("[a-zA-Z\\s]+");
    }
    
   public boolean ComprobarDNI(String dni) {
       
     
    return dni.matches("\\d{8}[A-Z]");
    }
   
private boolean ComprobarCurso(int idCurso) {
    // Verificar si el curso con el ID proporcionado existe en el Instituto
    return instituto.getCursosMap().containsKey(idCurso);
}
   
    // Método para limpiar los campos de texto después de añadir un alumno
    private void limpiarCampos() {
        textFieldIdCurso.setText("");
        textFieldDniAlum.setText("");
        textFieldNombreAlum.setText("");
    }

  
}
