package data;


import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class Instituto {
    private String nombre;
    private Map<Integer, Cursos> cursosMap = new TreeMap<>();

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    // Añadir curso
    public void agregarCurso() {

        String idCurso = JOptionPane.showInputDialog("Introduce el ID de este curso");
        Integer idCursoInt = Integer.parseInt(idCurso);
        String nombreCurso = JOptionPane.showInputDialog("Introduce el nombre del curso a añadir");

        cursosMap.put(idCursoInt, new Cursos(nombreCurso));
    }

    // Matricular alumno en curso
    public void matricularAlumno() {

        String idCurso = JOptionPane.showInputDialog("Introduce el ID de este curso");
        Integer idCursoInt = Integer.parseInt(idCurso);
        String dni = JOptionPane.showInputDialog("Introduce el DNI del alumno a matricular");
        String nombreAlumno = JOptionPane.showInputDialog("Introduce el nombre del alumno a matricular");

        Cursos curso = cursosMap.get(idCurso);
        if (curso != null) {
            curso.agregarAlumno(new Alumnos(dni, nombreAlumno, idCursoInt));
            JOptionPane.showMessageDialog(null, "Alumno matriculado correctamente en " + curso);
        } else {
            JOptionPane.showMessageDialog(null, "El curso con ID " + idCurso + " no existe.");
        }
    }

    // Añadir asignatura a curso
    public void añadirAsignatura() {

        String idCurso = JOptionPane.showInputDialog("Introduce el ID de este curso");
        Integer idCursoInt = Integer.parseInt(idCurso);
        String idAsignatura = JOptionPane.showInputDialog("Introduce el ID de la asignatura");
        Integer idAsignaturaInt = Integer.parseInt(idAsignatura);
        String nombreAsignatura = JOptionPane.showInputDialog("Introduce el nombre de la asignatura a añadir");
        
        Cursos curso = cursosMap.get(idCurso);
        if (curso != null) {
            curso.agregarAsignatura(new Asignaturas(nombreAsignatura, idAsignaturaInt, idCursoInt));
            JOptionPane.showMessageDialog(null, "Asignatura añadida correctamente a " + curso);
        } else {
            JOptionPane.showMessageDialog(null, "El curso con ID " + idCurso + " no existe.");
        }
    }

    // Mostrar información del curso (incluye alumnos y asignaturas)
    public void mostrarInfoCurso(int idCurso) {
        Cursos curso = cursosMap.get(idCurso);
        if (curso == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un curso con el ID " + idCurso, "Error", JOptionPane.ERROR_MESSAGE);
            return;
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

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Información del Curso", JOptionPane.INFORMATION_MESSAGE);
    }

    //* Ejemplo de carga de datos de prueba
    /*public void datosPrueba() {

        agregarCurso(101, "1 DAM");
        agregarCurso(102, "2 DAM");

        matricularAlumno(101, "12345678G", "Joselito");
        matricularAlumno(101, "12345679G", "Delmer");
        matricularAlumno(102, "12345677G", "Ruben");

        añadirAsignatura(101, 1, "Programación de Sistemas");
        añadirAsignatura(102, 2, "Acceso a Datos");
    }*/
}
