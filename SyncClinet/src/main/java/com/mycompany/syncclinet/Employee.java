package com.mycompany.syncclinet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salma
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)

public class Employee {

    private String id;
    private String name;
    private String phone;
    private String position;
    private float salary;

    public Employee() {
    }

    public Employee(String id, String name, String phone, String position, float salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        String empInfo="id is: "+this.id+" "+"name is: "+this.name+" "+"phone is: "+this.phone+" "+"position is: "+this.position+" "+"salary is: "+this.salary+" ";
        return empInfo;
    }
    
    

}