package data;

import java.util.Map;
import java.util.TreeMap;

public class Cursos {
    
    
    private String nombre;
    private Map<String, Alumnos> alumnosMap = new TreeMap<>();
    private Map<Integer, Asignaturas> asignaturasMap = new TreeMap<>();

    //Constructor CURSOS//
    public Cursos(String nombre) {
        this.nombre = nombre;
    }

    // Agregar alumno al curso
    public void agregarAlumno(Alumnos alumno) {
        alumnosMap.put(alumno.getDni(), alumno);
    }

    // Agregar asignatura al curso
    public void agregarAsignatura(Asignaturas asignatura) {
        asignaturasMap.put(asignatura.getIdAsignatura(), asignatura); // Asegúrate de usar el ID correcto
    }
    // Obtener alumnos
    public Map<String, Alumnos> getAlumnosMap() {
        return alumnosMap;
    }

    // Obtener asignaturas
    public Map<Integer, Asignaturas> getAsignaturasMap() {
        return asignaturasMap;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre;
    }
}