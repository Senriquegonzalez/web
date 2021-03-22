/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.ucundinamarca.servicioweb.controller.EstudianteController.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.DatoUnicoExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.EncontradoExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.JsonExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.MetodoExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.NullExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.PeticionExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.TipoExceptionFilter.class);
        resources.add(co.edu.ucundinamarca.servicioweb.exception.filter.UrlExceptionFilter.class);
    }

}
