/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucundinamarca.servicioweb.controller;

import co.edu.ucundinamarca.servicioweb.dto.DetalleConsultaDto;
import co.edu.ucundinamarca.servicioweb.dto.DetalleConsultaDto2;
import co.edu.ucundinamarca.servicioweb.exception.DatoUnicoException;
import co.edu.ucundinamarca.servicioweb.exception.EncontradoException;
import co.edu.ucundinamarca.servicioweb.exception.NullException;
import co.edu.ucundinamarca.servicioweb.service.Iconsulta;
import co.edu.ucundinamarca.servicioweb.service.IdetalleConsulta;
import co.edu.unicundi.serviciobasicoejb.entity.DetalleConsulta;
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
@Path("/detalleConsulta")
public class DetalleConsultaController {
     @EJB
    private IdetalleConsulta servicesDetalleConsulta;
     

    @Path("/retornar/{detalle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornar(@PathParam("detalle") boolean  detalle)throws IOException, FileNotFoundException, ClassNotFoundException {
        if(detalle==true){
             List <DetalleConsultaDto2> consulta=servicesDetalleConsulta.retornar2(detalle);
        return Response.status(Response.Status.OK).entity(consulta).build();
        }
        else {           
        List <DetalleConsultaDto> consulta=servicesDetalleConsulta.retornar(detalle);
        return Response.status(Response.Status.OK).entity(consulta).build();
    }
    }
    
    @Path("/retornarid/{id}/{detalle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornar(@PathParam("id") int id, @PathParam("detalle") boolean detalle)throws IOException, FileNotFoundException, ClassNotFoundException, EncontradoException {
       
          if(detalle==true){
              DetalleConsultaDto2 detalleconsultadto2 = servicesDetalleConsulta.retornarid2(id);
        return Response.status(Response.Status.OK).entity(detalleconsultadto2).build();
        }
        else {
              DetalleConsultaDto detalleconsultadto = servicesDetalleConsulta.retornarid(id);
        return Response.status(Response.Status.OK).entity(detalleconsultadto).build();
            }
        
    }
    
    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregar(DetalleConsulta detalleConsulta) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, NullException, NullException, ConstraintViolationException, EncontradoException {
        servicesDetalleConsulta.ingresar(detalleConsulta);
        return Response.status(Response.Status.OK).build();
        
    }
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) throws IOException, FileNotFoundException, ClassNotFoundException, EncontradoException {
         servicesDetalleConsulta.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    @Path("/modificar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificar(DetalleConsulta detalleConsulta) throws IOException, FileNotFoundException, ClassNotFoundException, DatoUnicoException, EncontradoException, NullException {
        servicesDetalleConsulta.modificar(detalleConsulta);
        return Response.status(Response.Status.OK).build();
    }
    

}
