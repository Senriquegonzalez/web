/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucundinamarca.servicioweb.pojo;

import java.io.Serializable;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class Estudiante implements Serializable {
    private int id;
    private int edad;
    private String cedula;
    private String nombre;

    public Estudiante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(int id, int edad, String cedula, String nombre) {
        this.id = id;
        this.edad = edad;
        this.cedula = cedula;
        this.nombre = nombre;
    }

   
    

}
