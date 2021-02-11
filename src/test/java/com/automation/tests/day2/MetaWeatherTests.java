package com.automation.tests.day2;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MetaWeatherTests {
/*
/api/location/search/?query=san
/api/location/search/?query=london
/api/location/search/?lattlong=36.96,-122.02
/api/location/search/?lattlong=50.068,-5.316
 */

           private String baseURI="https://www.metaweather.com/api/";


        @Test
    public void test1(){

            Response response=given()
                    .baseUri(baseURI+"location/search/")
                    .queryParam("query","san")
                    .get();
            assertEquals(200,response.getStatusCode());
            System.out.println(response.prettyPrint());


        }
///users/100/  - 100 it's a path parameter
    ///users/255/   - 155 it's a path parameter
    ///users/255?name=James | name - query parameter key value, key it's a query parameter

//"Woeid"  this standns for Where on earth ID, based on this value we can get  weather info in specific place

    @Test
    public void test2(){
    Response response=given()
            .pathParam("woeid","2487956")

            .get(baseURI+"location/{woeid}");
    System.out.println(response.prettyPrint());




}



/*
To do test automation of restful web services (those that use rest api), we can use RestAssured library in java.
It sipmplfies testinf of Rest services. So we can do PUT, GET, POST DELETE...request.

 */



}
