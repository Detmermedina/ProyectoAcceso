package GUI;
import data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class VPrin extends JFrame {
    
    
    private Instituto insti = new Instituto("PALOMERAS");

    private List<JMenuItem> opciones = new ArrayList<>();
        private final JMenuItem Opcion1 = new JMenuItem("Añadir Curso");
        private final JMenuItem Opcion2 = new JMenuItem("Añadir Asignaturas");
        private final JMenuItem Opcion3 = new JMenuItem("Añadir Asignaturas");
        private final JMenuItem Opcion4 = new JMenuItem("Añadir Asignaturas");
        private final JMenuItem Opcion5 = new JMenuItem("Añadir Asignaturas");
        private final JMenuItem Opcion6 = new JMenuItem("Añadir Asignaturas");
    
    
    
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
        
        cambioDePaneles();

        // Añadir paneles al CardLayout con una clave
        //mainPanel.add(new PanAñadirCurso());
        //mainPanel.add(new PanAñadirAsig());
       //mainPanel.add(new PañadirAlumnos(), "Añadir Alumnos");
       
       
        OpcionesMenu();
   
    }
    public void OpcionesMenu() {
            // Personalizar el color y apariencia de cada opción del menú
           
            
            opciones.add(Opcion1);
            opciones.add(Opcion2);
            opciones.add(Opcion3);
            opciones.add(Opcion4);
            opciones.add(Opcion5);
            opciones.add(Opcion6);

            for (JMenuItem item : opciones) {
                item.setBackground(Color.BLUE.brighter().brighter());
                item.setForeground(Color.WHITE);
                item.setFont(new Font("Arial", Font.BOLD, 12));
                // Agregar el item al menú principal (MenuPrin)
                menuBar.add(item);
                
            }
        }
    
    public void cambioDePaneles(){
    
        Opcion1.addActionListener((ActionEvent e) -> {
            
                insti.agregarCurso();
        });
        Opcion2.addActionListener((ActionEvent e) -> {
            
            mainPanel.add(new PanAñadirAsig(insti), "Añadir Asignaturas"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Añadir Asignaturas"); // Muestra el panel correspondiente
        });
        
        Opcion3.addActionListener((ActionEvent e) -> {
            
                insti.agregarCurso();
        });
        
        Opcion4.addActionListener((ActionEvent e) -> {
            
                insti.agregarCurso();
        });
        
        Opcion5.addActionListener((ActionEvent e) -> {
            
                insti.agregarCurso();
        });
        
        Opcion6.addActionListener((ActionEvent e) -> {
            
                insti.agregarCurso();
        });
        
        
    
    }
    


}

  