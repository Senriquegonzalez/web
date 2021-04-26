/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.servicioweb.controller;

import co.edu.ucundinamarca.servicioweb.exception.DatoUnicoException;
import co.edu.ucundinamarca.servicioweb.exception.EncontradoException;
import co.edu.ucundinamarca.servicioweb.exception.NullException;
import co.edu.ucundinamarca.servicioweb.service.Icurso;
import co.edu.ucundinamarca.servicioweb.service.Iestudiante;
import co.edu.unicundi.serviciobasicoejb.entity.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
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
 * @author Sergio Enrique Jair Gonzalez Arcos
 */
@Stateless
@Path("/estudiante")
public class EstudianteController {

// inyeccion de dependencias
    @EJB
    public Icurso Services;    
    @EJB
    public Iestudiante ServicesEstudiante;    
    
    @Path("/retornar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornar() throws IOException, FileNotFoundException, ClassNotFoundException {
        ServicesEstudiante.retornar();
        //Services.leerfichero();
        return Response.status(Response.Status.OK).entity(ServicesEstudiante.retornar()).build();
    }
    
    @Path("/retornarid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarid(@PathParam("id") int id) throws IOException, FileNotFoundException, ClassNotFoundException, NullException, EncontradoException {
        ServicesEstudiante.retornarid(id);
//Services.leerfichero();
        //Services.mostarid(id);

        return Response.status(Response.Status.CREATED).entity(ServicesEstudiante.retornarid(id)).build();
    }
    
    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregar(Estudiante estudiante) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, NullException, NullException, ConstraintViolationException, EncontradoException {
        
        ServicesEstudiante.ingresar(estudiante);
        //Services.leerfichero();
        //Services.ingresar(estudiante);
        //Services.crearfichero();
        return Response.status(Response.Status.OK).build();
        
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) throws IOException, FileNotFoundException, ClassNotFoundException, EncontradoException {
        ServicesEstudiante.eliminar(id);
        //Services.leerfichero();
        // Services.eliminar(id);
        // Services.crearfichero();
        return Response.status(Response.Status.NO_CONTENT).entity(Services.mostarTodos()).build();
    }
    
    @Path("/modificar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificar(Estudiante estu) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, EncontradoException, NullException {
        ServicesEstudiante.modificar(estu);
        //Services.leerfichero();
        //Services.actualizar(estu);
        //Services.crearfichero();
        return Response.status(Response.Status.OK).entity(Services.mostarTodos()).build();
    }
    
}
