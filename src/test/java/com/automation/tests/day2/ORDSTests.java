package com.automation.tests.day2;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ORDSTests {



    private String baseURI="http://ec2-18-212-54-99.compute-1.amazonaws.com:1000/ords/hr";

    @Test
    public void test1 (){
        Response response=given().get(baseURI+"/employees");

       // System.out.println(response.getBody().asString());
        assertEquals(200, response.getStatusCode());

        System.out.println(response.prettyPrint());
       // System.out.println(response.getStatusCode());
    }



    @Test

    public void test2(){

        Response response=given().header("accept","application/json").get(baseURI+"/employees/100");

         int actualStatusCode=response.getStatusCode();
        System.out.println(response.prettyPrint());
        assertEquals(200,actualStatusCode);

        System.out.println("What kind of content server sends to you, in this response: "+response.getHeader("Content-Type"));

}
@Test
public void test3(){
        Response response = given().get(baseURI+"/regions");
        assertEquals(200,response.getStatusCode());
//to get specific header
    Header header = response.getHeaders().get("Content-Type");
    //System.out.println(header);
//print all headers one by one
    for (Header h:response.getHeaders()){
        System.out.println(h);

    }
    System.out.println("###################");
    System.out.println(response.prettyPrint());



}






}
