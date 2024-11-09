package data;

import GUI.*;
/**
 *
 * @author damtv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        //Instituto datos de prueba//
        
        Instituto insti = new Instituto();
        insti.datosPrueba();
        
        //Instituto datos de prueba// 
        
        //Incio La ventana para que se vea el GUI.
        VPrin p1 = new VPrin("InstiDAM El mejor Insti del mundo");       
        p1.setVisible(true);
        
    }
    
}
