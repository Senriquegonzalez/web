/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucundinamarca.servicioweb.exception.filter;

import co.edu.ucundinamarca.servicioweb.pojo.ErrorDto;
import java.time.LocalDate;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@Provider
public class TipoExceptionFilter implements ExceptionMapper <NotSupportedException> {

    @Override
    public Response toResponse(NotSupportedException exception) {
        ErrorDto error = new ErrorDto(exception.getMessage(), "Fecha: " + LocalDate.now());
            error.setMensaje("verifique que sea tipo json  ");
            return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
    }
	

}
