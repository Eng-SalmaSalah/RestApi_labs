/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.day2restservices.services;

import com.mycompany.day2restservices.utilities.CrudMethods;
import com.mycompany.day2restservices.utilities.Employee;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author salma
 */
@Path("/employees")
public class EmployeeServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> retriveAll() {
        return (CrudMethods.retriveAll());
    }

    @GET
    @Path("/{empID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee retriveEmployee(@PathParam("empID") String ID) {
        Employee retrivedEmp = CrudMethods.retriveEmployee(ID);
        return retrivedEmp;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(Employee emp) {
        Employee addedEmployee = CrudMethods.addEmployee(emp);
        return addedEmployee;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(Employee emp) {
        Employee updatedEmployee = CrudMethods.updateEmployee(emp);
        return updatedEmployee;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{empID}")
    public Employee deleteEmployee(@PathParam("empID") String ID) {
        Employee deletedEmp = CrudMethods.deleteEmployee(ID);
        return deletedEmp;
    }

}
