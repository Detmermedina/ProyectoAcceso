package GUI;
import data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class VPrin extends JFrame {
    
    private Instituto insti = new Instituto("PALOMERAS");

    private List<JMenuItem> opciones = new ArrayList<>();
        private final JMenuItem Opcion1 = new JMenuItem("Añadir Curso");
        private final JMenuItem Opcion2 = new JMenuItem("Añadir Asignaturas");
        private final JMenuItem Opcion3 = new JMenuItem("Añadir Alumnos");
        private final JMenuItem Opcion4 = new JMenuItem("Informacion de Alumno");
        private final JMenuItem Opcion5 = new JMenuItem("Informacion de Curso");
        private final JMenuItem Opcion6 = new JMenuItem("Informacion de Cursos");
    
    
    
    private javax.swing.JMenuBar menuBar;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VPrin(String title) throws HeadlessException {
        super(title);

        setSize(1000, 600);  // Establece el tamaño inicial de la ventana
        setMinimumSize(new Dimension(1000, 600));  // Establece el tamaño mínimo
        setResizable(false);  // Evita que la ventana se pueda redimensionar
        
        insti.datosPrueba(); 
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    

    private void initComponents() {
         
        // Crear el menú y el panel principal con CardLayout
        menuBar = new JMenuBar();
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
         
        setJMenuBar(menuBar);
        mainPanel.setLayout(cardLayout);
        
        PanelPrincipalFondo panBienvenida = new PanelPrincipalFondo(insti, ".//img//InstitutoFondo.jpg");
        mainPanel.add(panBienvenida, "Bienvenida"); // Agregar al panel principal de CardLayout
        cardLayout.show(mainPanel, "Bienvenida");   // Mostrar el panel de bienvenida

        // Añadir el mainPanel al JFrame
        add(mainPanel, BorderLayout.CENTER);
        
        cambioDePaneles();
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
                
                
            
            // Efecto de hover
            item.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    item.setBackground(new Color(33, 150, 243)); // Azul oscuro
                }
                public void mouseExited(MouseEvent evt) {
                    item.setBackground(new Color(66, 133, 244)); // Regresa al color original
                }
            });
            menuBar.add(item);
        }

            
        }
    
    public void cambioDePaneles(){
    
        Opcion1.addActionListener((ActionEvent e) -> {
            
            mainPanel.add(new PanAñadirCurso(insti), "Añadir Curso"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Añadir Curso"); // Muestra el panel correspondiente    
            
        });
        Opcion2.addActionListener((ActionEvent e) -> {
            
            mainPanel.add(new PanAñadirAsig(insti), "Añadir Asignaturas"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Añadir Asignaturas"); // Muestra el panel correspondiente
        });
        
        Opcion3.addActionListener((ActionEvent e) -> {
                mainPanel.add(new PanAñadirAlumn(insti), "Añadir Alumno"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Añadir Alumno"); // Muestra el panel correspondiente
        });

        Opcion4.addActionListener((ActionEvent e) -> {
            
              //INFORMACION DE ALUMNOS      
            mainPanel.add(new PanInfoAlumno(insti), "Mostrar Informacion de Alumno"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Mostrar Informacion de Alumno"); // Muestra el panel correspondiente
            
     
        });

        Opcion5.addActionListener((ActionEvent e) -> {
            
            mainPanel.add(new PanMostrarInfoCurso(insti), "Mostrar Informacion de Curso"); // Pasa la instancia de Instituto
            cardLayout.show(mainPanel, "Mostrar Informacion de Curso"); // Muestra el panel correspondiente
            
               
        });
        
        
      Opcion6.addActionListener((ActionEvent e) -> {
            mainPanel.add(new PanMostrarInfoCursos(insti), "Mostrar toda Info Cursos"); // Usa el mismo nombre en ambas partes
            cardLayout.show(mainPanel, "Mostrar toda Info Cursos"); // Usa el mismo nombre aquí
        });
        
        
    
    }
    


}

  