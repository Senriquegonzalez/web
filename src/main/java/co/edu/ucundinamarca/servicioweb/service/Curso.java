/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.servicioweb.service;

import co.edu.ucundinamarca.servicioweb.exeption.DatoUnicoException;
import co.edu.ucundinamarca.servicioweb.exeption.EncontradoException;
import co.edu.ucundinamarca.servicioweb.exeption.NullException;
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
            x = (Estudiante) estudiantes.get(i);
            if (x.getId() == id) {
                estudi = x;
            }
        }
        if (estudi.getId() != 0) {
            unestudiante.add(estudi);
        }

        return unestudiante;
    }

    public List getUnestudiante() {
        return unestudiante;
    }

    public void setUnestudiante(List unestudiante) {
        this.unestudiante = unestudiante;
    }

    public void ingresar(Estudiante estudiante) throws DatoUnicoException, NullException {

        int cantidadRepetido = 0;
        int cantidadRepetidoid = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            x = (Estudiante) estudiantes.get(i);
            if (x.getCedula().equals(estudiante.getCedula())) {
                cantidadRepetido++;
            } else if (x.getId() == (int) estudiante.getId()) {
                cantidadRepetidoid++;
            }

        }
        if(estudiante.getNombre().isEmpty()){
            throw new NullException("nombre no puede ir vacio ");
        }else if(estudiante.getCedula().isEmpty()){
            throw new NullException("cedula no puede ir vacia ");
        }
        else if(estudiante.getEdad()<=0 ){
            throw new NullException("campo edad ino puede ser menor a cero ");
        }
        else if (cantidadRepetido == 0 && cantidadRepetidoid == 0) {
            estudiantes.add(estudiante);
        } else if (cantidadRepetido != 0 && cantidadRepetidoid != 0) {
            throw new DatoUnicoException("cedula y id ya existen");
        } else if (cantidadRepetido != 0) {
            throw new DatoUnicoException("cedula ya existe");
        } else if (cantidadRepetidoid != 0) {
            throw new DatoUnicoException("id ya existe");
        }

    }

    public void eliminar(int id) throws EncontradoException {
        Estudiante estudi = null;
        for (int i = 0; i < estudiantes.size(); i++) {
            x = (Estudiante) estudiantes.get(i);
            if (x.getId() == (int) id) {
                estudi = x;

            }

        }

        if (estudi != null) {
            estudiantes.remove(estudi);
        } else if (estudi == null) {
            throw new EncontradoException("estudiante no existe");
        }

    }

    public void actualizar(Estudiante estudiant) throws EncontradoException, NullException {
        Estudiante estudia =new Estudiante();
        int contador = -1;
        for (int i = 0; i < estudiantes.size(); i++) {
            x = (Estudiante) estudiantes.get(i);
            if (x.getId() == (int) estudiant.getId()) {
                estudia = x;
                contador = i;
            }
        }
        if(estudiant.getNombre().isEmpty()){
            throw new NullException("nombre no puede ir vacio ");
        }else if(estudiant.getCedula().isEmpty()){
            throw new NullException("cedula no puede ir vacia ");
        }
        else if(estudiant.getEdad()<=0 ){
            throw new NullException("campo edad ino puede ser menor a cero ");
        }
        
        
        else  if (contador >= 0) {
            
            estudiantes.set(contador, estudiant);
            //throw new EncontradoException("estudiante existe "+ contador );
        } else if (contador < 0) {
            throw new EncontradoException("estudiante no existe");
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
