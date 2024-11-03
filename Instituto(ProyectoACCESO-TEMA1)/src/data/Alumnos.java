/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

public class Alumnos {
    private String dni;
    private String nombre;
    private int idCurso;

    public Alumnos(String dni, String nombre, int idCurso) {
        this.dni = dni;
        this.nombre = nombre;
        this.idCurso = idCurso;
    }
    

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public int getIdCurso() { return idCurso; }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " (DNI: " + dni + ")";
    }
}
