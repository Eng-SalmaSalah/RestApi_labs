/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asynchclient;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author salma
 */
public class EmpServicesConsumer {

    public EmpServicesConsumer() {

        try {
            // add employee
            ClientConfig cc = new DefaultNonBlockingClientConfig();
            cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
            Client client = NonBlockingClient.create(cc);
            String addEmployeeUrl = "http://localhost:8084/Day2RestServices/rest/employees";
            AsyncWebResource asyncWebResource = client.asyncResource(addEmployeeUrl);
            AsyncWebResource.Builder builder = asyncWebResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            Employee newEmp = new Employee("10", "salma", "01062494707", "Manager", 10000);

            ObjectMapper mapper = new ObjectMapper();
            String request = mapper.writeValueAsString(newEmp);
            builder.post(new TypeListener<ClientResponse>(ClientResponse.class) {
                @Override
                public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                    try {
                        ClientResponse clientResponse = future.get();
                        //System.out.println(clientResponse.getStatus());
                        if (clientResponse.getStatus() != 200) {
                            throw new RuntimeException("HTTP Error:" + clientResponse.getStatus());
                        } else {
                            System.out.println("Employee Inserted!");
                            System.out.println(newEmp);

                        }

                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
            }, request);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //get all employess
        ClientConfig cc = new DefaultNonBlockingClientConfig();
        cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client client = NonBlockingClient.create(cc);
        String getAllEmpsUrl = "http://localhost:8084/Day2RestServices/rest/employees";
        AsyncWebResource asyncWebResource = client.asyncResource(getAllEmpsUrl);
        AsyncWebResource.Builder builder = client.asyncResource(getAllEmpsUrl).accept(MediaType.APPLICATION_JSON);
        builder.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                try {
                    ClientResponse clientResponse = future.get();
                    if (clientResponse.getStatus() != 200) {
                        throw new RuntimeException("HTTP Error:" + clientResponse.getStatus());
                    } else {
                        System.out.println("Employees are:");
                        List<Employee> employees = clientResponse.getEntity(new GenericType<List<Employee>>() {
                        });
                        employees.forEach((emp) -> {
                            System.out.println(emp);
                        });
                    }
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {

        new EmpServicesConsumer();
    }

}
