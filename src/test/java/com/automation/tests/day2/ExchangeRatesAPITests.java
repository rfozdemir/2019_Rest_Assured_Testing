package com.automation.tests.day2;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ExchangeRatesAPITests {

private String baseURI="https://api.openrates.io/";


@Test
public void test1(){
    Response response=given().get(baseURI+"latest");
     assertEquals(200,response.getStatusCode());
    System.out.println(response.prettyPrint());
}

@Test
public void test2(){
    Response response=given().get(baseURI+"latest");
    //verify that content type is json

assertEquals(200,response.getStatusCode());
// verify that data is coming as json
    assertEquals("application/json",response.getHeader("Content-Type"));
    //or like this
    assertEquals("application/json",response.getContentType());



}

@Test
    public void test3(){

   // Response response=given().get(baseURI+"latest?base=USD");

    Response response= given().baseUri(baseURI)
                              .basePath("latest")
                              .queryParam("base","USD")
                              .get();


assertEquals(200,response.getStatusCode());
    System.out.println(response.prettyPrint());


}

//    #Task: Verify that response body, for latest currency rates, contains today's date
@Test
public void test4(){

              Response response=given()
                                       .baseUri(baseURI+"latest")
                                       .queryParam("base","GBP")
                                       .get();

              String todaysDate= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    System.out.println(todaysDate);

    assertEquals(200,response.getStatusCode());
              assertTrue(response.getBody().asString().contains(todaysDate));



}


//let's get currency exchange rate for year 2000
// GET:  https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01&symbols=ILS,JPY
    @Test
public void test5(){
    Response response =given().
            baseUri(baseURI+"history").
            queryParam("start_at","2018-01-01").
            queryParam("end_at","2018-09-01").
            queryParam("symbols","ILS,JPY,TRY").get();

        System.out.println(response.prettyPrint());
}

/*
Given request  parameter "base" is "USD"
When user sends request to "api.openrates.io"
Then response code should be 200
And response body must contain "base":"USD"
 */
@Test
public void test6(){

    Response response=given()
            .baseUri(baseURI+"latest")
            .queryParam("base","USD")
            .get();




}




}