package GUI;

import data.Cursos;
import data.Instituto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanAñadirCurso extends JPanel {
    private JTextField idCursoField;
    private JTextField nombreCursoField;
    private JButton buttonAgregar;
    private Instituto instituto;

    public PanAñadirCurso(Instituto instituto) {
        this.instituto = instituto;

        // Diseño
        setLayout(new GridBagLayout());
        setBackground(new Color(248, 249, 250)); 
        
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

        idCursoField = new JTextField(15);
        idCursoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        idCursoField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        add(idCursoField, gbc);

        // Añadir Nombre del Curso
        JLabel labelNombreCurso = new JLabel("Nombre del Curso:");
        labelNombreCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelNombreCurso.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelNombreCurso, gbc);

        nombreCursoField = new JTextField(15);
        nombreCursoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nombreCursoField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        add(nombreCursoField, gbc);

        // Botón Agregar Curso
        buttonAgregar = new JButton("Agregar Curso");
        buttonAgregar.setBackground(new Color(66, 133, 244)); // Azul suave
        buttonAgregar.setForeground(Color.WHITE);
        buttonAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonAgregar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCurso();
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
        gbc.gridy = 2;
        gbc.gridwidth = 2; // El botón ocupa dos columnas
        add(buttonAgregar, gbc);
    }

    private void agregarCurso() {
        try {
            // Obtenemos los valores de los campos de texto
            int idCurso = Integer.parseInt(idCursoField.getText()); // Convertir el ID a entero
            String nombreCurso = nombreCursoField.getText(); // Obtener el nombre del curso
 
            
            // Verificamos que los campos no estén vacíos
            if (nombreCurso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del curso.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Creamos un nuevo curso y lo agregamos al instituto
            instituto.agregarCurso(idCurso, new Cursos(nombreCurso));

            // Confirmación al usuario
            JOptionPane.showMessageDialog(this, "Curso añadido correctamente.");
            
            // Limpiar los campos después de agregar el curso
            idCursoField.setText("");
            nombreCursoField.setText("");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
 
}
