/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.syncclinet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author salma
 */
public class EmpServiceConsumer {

    public EmpServiceConsumer() {
        try {
            Client client = Client.create();
            //add emp
            String addEmployeeUrl = "http://localhost:8084/Day2RestServices/rest/employees";
            WebResource webResource = client.resource(addEmployeeUrl);
            WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            Employee newEmp = new Employee("10", "salma", "01062494707", "Manager", 10000);
            ObjectMapper mapper = new ObjectMapper();
            String request = mapper.writeValueAsString(newEmp);
            ClientResponse response = builder.post(ClientResponse.class, request);
            if (response.getStatus() != 200) {
                throw new RuntimeException("HTTP Error:" + response.getStatus());
            } else {
                System.out.println("Employee Inserted!");
                System.out.println(newEmp);

            }
            
            //get employee
            String getEmployeeUrl = "http://localhost:8084/Day2RestServices/rest/employees/10";
            webResource = client.resource(getEmployeeUrl);
            builder = webResource.accept(MediaType.APPLICATION_JSON);
            response = builder.get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("HTTP Error:" + response.getStatus());
            }
            Employee retrivedEmployee = response.getEntity(Employee.class);
            System.out.println("retrived employee is:");
            System.out.println(retrivedEmployee);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EmpServiceConsumer();
    }

}
