/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.day2restservices.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Path;

/**
 *
 * @author salma
 */

public class CrudMethods {

    static Map<String, Employee> employessList = new HashMap<String, Employee>();
    static List<Employee> emplist ;

    public static List<Employee> retriveAll() {
        emplist = new ArrayList<Employee>(employessList.values());
        return emplist;
    }

    public static Employee retriveEmployee(String ID) {
        Employee retrivedEmp = employessList.get(ID);
        return retrivedEmp;
    }

    public static Employee addEmployee(Employee emp) {
        Employee insertedEmployee = employessList.put(emp.getId(), emp);
        return insertedEmployee;
       
    }
    
    public static Employee updateEmployee (Employee emp){
        Employee updatedEmployee = employessList.replace(emp.getId(), emp);
        return updatedEmployee;
    }
    
     public static Employee deleteEmployee (String id){
        Employee removed = employessList.remove(id);
        return removed;
    }


}
    

