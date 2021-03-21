/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucundinamarca.servicioweb.controller;

import co.edu.ucundinamarca.servicioweb.pojo.Estudiante;
import co.edu.ucundinamarca.servicioweb.service.Curso;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
  @Path("/estudiante")
public class EstudianteController {

  


    Curso curso = new Curso();
    
    @Path("/retornar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  Response retornar() throws IOException, FileNotFoundException, ClassNotFoundException  {
     
       
           curso.leerfichero();
        return Response.status(Response.Status.OK).entity(curso.mostarTodos()).build();                                                                                       
    }
    
    @Path("/retornarid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     public Response retornarid ( @PathParam ("id" )int id ) throws IOException, FileNotFoundException, ClassNotFoundException {
        curso.leerfichero();
        curso.mostarid(id);
        
        return Response.status(Response.Status.CREATED).entity( curso.getUnestudiante()).build();
    }

    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  agregar(Estudiante estudiante) throws IOException, FileNotFoundException, ClassNotFoundException{
        
         
            curso.leerfichero();
            curso.ingresar(estudiante);
            curso.crearfichero();
            return Response.status(Response.Status.OK).build();
        
           
            
        
            
      
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response  eliminar(@PathParam ("id" )int id ) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        curso.leerfichero();
        curso.eliminar(id);
        curso.crearfichero();
      return Response.status(Response.Status.NO_CONTENT).entity( curso.mostarTodos()).build();
    }
    
    @Path("/modificar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  modificar(    Estudiante estudiante) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        curso.leerfichero();
        curso.actualizar(estudiante);
        curso.crearfichero();
        return Response.status(Response.Status.OK).entity( curso.mostarTodos()).build();
    }

}

