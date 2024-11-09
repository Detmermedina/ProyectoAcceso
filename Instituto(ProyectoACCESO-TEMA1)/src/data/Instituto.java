package data;


import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class Instituto {
    private String nombre;
    private Map<Integer, Cursos> cursosMap = new TreeMap<>();
    private Map<String, Alumnos> MatriAlum = new TreeMap<>();

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    public Instituto() {
    }
    
    //--------Getters y Setters------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

    public Map<Integer, Cursos> getCursosMap() {
        return cursosMap;
    }

    public Map<String, Alumnos> getMatriAlum() {
        return MatriAlum;
    }

    
    //--------Fin Getters y Setters------//
    
    
    // Añadir curso
    public void agregarCurso(int idCursoInt, Cursos curso) {
        
        cursosMap.put(idCursoInt, curso);   
    }
    
    
    
 public void agregarAsignatura(int idCursoInt, Asignaturas asignatura) {
        Cursos curso = cursosMap.get(idCursoInt);
        if (curso != null) {
            curso.agregarAsignatura(asignatura);
        } else {
            JOptionPane.showMessageDialog(null, "El curso con ID " + idCursoInt + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    // Matricular alumno en curso
public void matricularAlumno(int idCursoInt,Alumnos alumno) {
    Cursos curso = cursosMap.get(idCursoInt);
    MatriAlum.put(alumno.getDni(), alumno);  // Matricular el alumno en el instituto
    curso.agregarAlumno(alumno);       

}
    
public String infoAlumno(String dniA){
    
    Alumnos alumno = MatriAlum.get(dniA); // Busca el alumno usando el DNI
    if (alumno == null) {
        return "No se encontró un alumno con el DNI " + dniA;
    }

    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Información del Alumno:\n")
           .append(alumno)
           .append("\n\nCursos en los que está matriculado:\n");

    // Recorrer los cursos para buscar el alumno y sus asignaturas

    

    for (Cursos curso : cursosMap.values()) {
        if (curso.getAlumnosMap().containsKey(dniA)) { // Verifica si el alumno está en el curso
            mensaje.append(curso.toString()).append("\n"); // Agrega información del curso

            // Añadir asignaturas del curso
            mensaje.append("Asignaturas:\n");
            for (Asignaturas asignatura : curso.getAsignaturasMap().values()) {
                mensaje.append(asignatura).append("\n");
            }
        }
    }
    
    return mensaje.toString();
}   
    


    // Mostrar información del curso (incluye alumnos y asignaturas)
public String mostrarInfoCurso(int idCurso) {
           Cursos curso = cursosMap.get(idCurso);
    if (curso == null) {
        return "No se encontró un curso con el ID " + idCurso;
    }

    StringBuilder mensaje = new StringBuilder();
    mensaje.append(curso).append("\n\nAlumnos:\n");

    for (Alumnos alumno : curso.getAlumnosMap().values()) {
        mensaje.append(alumno).append("\n");
    }

    mensaje.append("\nAsignaturas:\n");
    for (Asignaturas asignatura : curso.getAsignaturasMap().values()) {
        mensaje.append(asignatura).append("\n");
    }

    return mensaje.toString();
}


public String mostrarInfoCursos() {
    StringBuilder mensaje = new StringBuilder();
    
    for (Map.Entry<Integer, Cursos> entry : cursosMap.entrySet()) {
        int idCurso = entry.getKey();
        Cursos curso = entry.getValue();
        
        mensaje.append("Curso ").append(idCurso).append(" - Nombre: ").append(curso).append("\n");

        // Mostrar número de alumnos y sus nombres
        Map<String, Alumnos> alumnos = curso.getAlumnosMap();
        mensaje.append("Alumnos (").append(alumnos.size()).append("):\n");
        for (Alumnos alumno : alumnos.values()) {
            mensaje.append(" - ").append(alumno).append("\n");
        }

        // Mostrar asignaturas del curso
        Map<Integer, Asignaturas> asignaturas = curso.getAsignaturasMap();
        mensaje.append("Asignaturas:\n");
        for (Asignaturas asignatura : asignaturas.values()) {
            mensaje.append(" - ").append(asignatura).append("\n");
        }
        
        mensaje.append("\n"); // Espacio entre cursos
    }
    
    if (mensaje.length() == 0) {
        mensaje.append("No hay cursos matriculados.");
    }
    
    return mensaje.toString();
}

    // Ejemplo de carga de datos de prueba
public void datosPrueba() {
    // Crear algunos cursos y asignarlos al TreeMap de cursos
    Cursos curso1 = new Cursos("1 DAM");
    Cursos curso2 = new Cursos("2 DAM");
    agregarCurso(101, curso1);
    agregarCurso(102, curso2);

    // Crear y matricular algunos alumnos en los cursos
    Alumnos alumno1 = new Alumnos("12345678G", "Joselito", 101);
    Alumnos alumno2 = new Alumnos("12345679G", "Delmer", 101);
    Alumnos alumno3 = new Alumnos("12345677G", "Ruben", 102);

    // Agregar alumnos al TreeMap MatriAlum y a cada curso correspondiente
    matricularAlumno(101, alumno1);
    matricularAlumno(101, alumno2);
    matricularAlumno(102, alumno3);

    // Crear asignaturas con idAsignatura y idCurso
    Asignaturas asignatura1 = new Asignaturas("Programación de Sistemas", 1, 101);
    Asignaturas asignatura2 = new Asignaturas("Acceso a Datos", 2, 102);

    // Agregar asignaturas a los cursos en el TreeMap cursosMap
    agregarAsignatura(101, asignatura1);
    agregarAsignatura(102, asignatura2);
}





}
