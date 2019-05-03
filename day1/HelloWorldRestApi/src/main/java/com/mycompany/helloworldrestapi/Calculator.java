/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworldrestapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author salma
 */
@Path("/calculator")
public class Calculator {

    @GET
    @Path("/add")
    public String add(@QueryParam("firstNumber")String firstNum,@QueryParam("secondNumber")String secondNum) {
        float result;
        result=Float.parseFloat(firstNum)+Float.parseFloat(secondNum);
        return("result ="+result);
    }
    
    @GET
    @Path("/subtract")
    public String subtract(@QueryParam("firstNumber")String firstNum,@QueryParam("secondNumber")String secondNum) {
        float result;
        result=Float.parseFloat(firstNum)-Float.parseFloat(secondNum);
        return("result ="+result);
    }
    
    @GET
    @Path("/divide")
    public String divide(@QueryParam("firstNumber")String firstNum,@QueryParam("secondNumber")String secondNum) {
        float result;
        result=Float.parseFloat(firstNum)/Float.parseFloat(secondNum);
        return("result ="+result);
    }
    
    @GET
    @Path("/multiply")
    public String multiply(@QueryParam("firstNumber")String firstNum,@QueryParam("secondNumber")String secondNum) {
        float result;
        result=Float.parseFloat(firstNum)*Float.parseFloat(secondNum);
        return("result ="+result);
    }

}
