package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class VPrin extends JFrame {

    private List<JMenuItem> opciones = new ArrayList<>();
    
    private javax.swing.JMenuBar menuBar;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VPrin() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
    }

    private void initComponents() {
        // Crear el menú y el panel principal con CardLayout
        menuBar = new JMenuBar();
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        
        
        setJMenuBar(menuBar);
        

       
        
        mainPanel.setLayout(cardLayout);

        // Añadir el mainPanel al JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Añadir paneles al CardLayout con una clave
        mainPanel.add(new PanAñadirCurso(), "Añadir Cursos");
       // mainPanel.add(new PañadirAsignaturas(), "Añadir Asignaturas");
       //mainPanel.add(new PañadirAlumnos(), "Añadir Alumnos");
       
       
        OpcionesMenu();
   
    }
    public void OpcionesMenu() {
            // Personalizar el color y apariencia de cada opción del menú
            opciones.add(new JMenuItem("Añadir Cursosddd"));
            opciones.add(new JMenuItem("Añadir Asignaturas"));
            opciones.add(new JMenuItem("Añadir Alumnos"));
            opciones.add(new JMenuItem("Eliminar Cursos"));
            opciones.add(new JMenuItem("Eliminar Asignaturas"));
            opciones.add(new JMenuItem("Eliminar Alumnos"));

            for (JMenuItem item : opciones) {
                item.setBackground(Color.BLUE.brighter().brighter());
                item.setForeground(Color.WHITE);
                item.setFont(new Font("Arial", Font.BOLD, 12));

                // Agregar el item al menú principal (MenuPrin)
                menuBar.add(item);
                
            }
        }

    // Clase interna para manejar el cambio de paneles
    private class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JMenuItem) e.getSource()).getText();
            cardLayout.show(mainPanel, command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}