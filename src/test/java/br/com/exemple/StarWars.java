package br.com.exemple;

import org.junit.Test;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class StarWars {
    
    @Test
    public void nameTest() {

        given()  
            .log().all()
            .contentType(ContentType.JSON)
        .when()
            .get("https://swapi.dev/api/people/1")
        .then()
            .log().all()
            .statusCode(200) 
            .contentType(ContentType.JSON) 
            .body("name", Matchers.is("Luke Skywalker"))
            .body("height", Matchers.is("172"))
            .body("hair_color", Matchers.is("blond")) 
            .body("eye_color", Matchers.is("blue")) 
        ;
        
    }
}
