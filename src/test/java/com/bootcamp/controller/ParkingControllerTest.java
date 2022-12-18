package com.bootcamp.controller;

import com.bootcamp.controller.DTO.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach //ANOTAÇÃO JUNIT
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }
    @Test
    void whenFindAllThenCheckResult(){
    RestAssured.given()
            .auth()
            .basic("user","@r77t068s22")
            .when()
            .get("/parking")
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract().response().body().prettyPrint();
    }

    @Test
    void whenCreateThenCheckIsCreated(){

        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("RED");
        createDTO.setLicense("cku-3902");
        createDTO.setModel("FUSCA");
        createDTO.setState("RJ");

        RestAssured.given()
                .auth()
                .basic("user","@r77t068s22")
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(201)
                .body("license", Matchers.equalTo("cku-3902"))
                .body("color", Matchers.equalTo("RED"));


    }
}