/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucundinamarca.servicioweb.exception.filter;

import co.edu.ucundinamarca.servicioweb.exeption.NullException;
import co.edu.ucundinamarca.servicioweb.pojo.ErrorDto;
import java.time.LocalDate;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@Provider
public class NullExceptionFilter implements ExceptionMapper<NullException> {

    @Override
    public Response toResponse(NullException exception) {
        ErrorDto error= new ErrorDto(exception.getMessage(),"Fecha: " + LocalDate.now());
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }

}
