/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.servicioweb.controller;

import co.edu.ucundinamarca.servicioweb.dto.ConsultaDto;
import co.edu.ucundinamarca.servicioweb.dto.ConsultaDto2;
import co.edu.ucundinamarca.servicioweb.exception.DatoUnicoException;
import co.edu.ucundinamarca.servicioweb.exception.EncontradoException;
import co.edu.ucundinamarca.servicioweb.exception.NullException;
import co.edu.ucundinamarca.servicioweb.service.Iconsulta;
import co.edu.unicundi.serviciobasicoejb.entity.Consulta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
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
@Stateless
@Path("/consulta")
public class ConsultaController {

    @EJB
    private Iconsulta servicesConsulta;

    @Path("/retornar/{detalle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornar(@PathParam("detalle") boolean  detalle)throws IOException, FileNotFoundException, ClassNotFoundException {
        if(detalle==true){
             List <ConsultaDto> consulta=servicesConsulta.retornar();
        return Response.status(Response.Status.OK).entity(consulta).build();
        }
        else {
            List <ConsultaDto2> consulta2=servicesConsulta.retornar2();
        return Response.status(Response.Status.OK).entity(consulta2).build();}
        
    }
     @Path("/retornarid/{id}/{detalle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornar(@PathParam("id") int id, @PathParam("detalle") boolean detalle)throws IOException, FileNotFoundException, ClassNotFoundException, EncontradoException {
       
          if(detalle==true){
              ConsultaDto consultadto = servicesConsulta.retornarid(id);
        return Response.status(Response.Status.OK).entity(consultadto).build();
        }
        else {
              ConsultaDto2 consultadto2 = servicesConsulta.retornarid2(id);
        return Response.status(Response.Status.OK).entity(consultadto2).build();
            }
        
    }
    

    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) throws IOException, FileNotFoundException, ClassNotFoundException, EncontradoException {
        servicesConsulta.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregar(Consulta consulta) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, NullException, NullException, ConstraintViolationException, EncontradoException {
        
        servicesConsulta.ingresar(consulta);
        return Response.status(Response.Status.OK).build();
        
    }
    @Path("/modificar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificar(Consulta consulta) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, EncontradoException, NullException {
        servicesConsulta.modificar(consulta);
        return Response.status(Response.Status.OK).build();
    }
}
