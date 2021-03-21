/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.servicioweb.service;

import co.edu.ucundinamarca.servicioweb.pojo.Estudiante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class Curso implements Serializable {

    private List estudiantes = new ArrayList();

    private List unestudiante = new ArrayList();

    FileOutputStream fichero = null;
    FileInputStream entrada = null;
    Estudiante x = new Estudiante();

    public Curso() {
    }

    public List mostarTodos() {
        return estudiantes;
    }

    public List mostarid(int id) {
        Estudiante estudi = new Estudiante();
        for (int i = 0; i < estudiantes.size(); i++) {
            estudi =(Estudiante) estudiantes.get(i);
            if(estudi.getId()==id){
                  unestudiante.add(estudi);
            }
            
            
        }

        

        return unestudiante;
    }

    public List getUnestudiante() {
        return unestudiante;
    }

    public void setUnestudiante(List unestudiante) {
        this.unestudiante = unestudiante;
    }

    public void ingresar(Estudiante estudiante) {

        estudiantes.add(estudiante);

    }

    public void eliminar(int id) {
        Estudiante estudi = new Estudiante();
        for (int i = 0; i < estudiantes.size(); i++) {
            x = (Estudiante) estudiantes.get(i);
            if (x.getId() == id) {
                estudi = x;

            }

        }

        if (estudi.getId() != 0) {
            estudiantes.remove(estudi);

        }
    }

    public void actualizar(Estudiante estudiante) {
        Estudiante estudi = new Estudiante();
        int contador = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            x = (Estudiante) estudiantes.get(i);
            if (x.getId() == estudiante.getId()) {
                estudi = x;
                contador = i;

            }

        }

    }

    public List getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" + "estudiantes=" + estudiantes + '}';
    }

    public void crearfichero() throws FileNotFoundException, IOException {

        fichero = new FileOutputStream("dato.txt");
        ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
        tuberia.writeUnshared(estudiantes);
    }

    public void leerfichero() throws FileNotFoundException, IOException, ClassNotFoundException {
        entrada = new FileInputStream("dato.txt");
        ObjectInputStream tuberiaEntrada = new ObjectInputStream(entrada);
        estudiantes = (List) tuberiaEntrada.readObject();
    }

}
