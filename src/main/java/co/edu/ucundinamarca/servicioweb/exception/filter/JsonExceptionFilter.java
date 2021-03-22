package co.edu.ucundinamarca.servicioweb.exception.filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import co.edu.ucundinamarca.servicioweb.pojo.ErrorDto;
import java.time.LocalDate;
import javax.json.JsonException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@Provider
public class JsonExceptionFilter implements ExceptionMapper <JsonException> {

    @Override
    public Response toResponse(JsonException exception) {
      ErrorDto error= new ErrorDto(exception.getMessage(),"Fecha: " + LocalDate.now());
      error.setMensaje("error en la cosntruccion del json");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
    }

}
