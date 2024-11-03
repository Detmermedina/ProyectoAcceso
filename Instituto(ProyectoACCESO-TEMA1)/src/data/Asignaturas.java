/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

public class Asignaturas {
    private String nombre;
    private int idAsignatura;
    private int idCurso;

    public Asignaturas(String nombre, int idAsignatura, int idCurso) {
        this.nombre = nombre;
        this.idAsignatura = idAsignatura;
        this.idCurso = idCurso;
    }

    public int getIdCurso() { return idCurso; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Asignatura: " + nombre + " (ID: " + idAsignatura + ")";
    }
}