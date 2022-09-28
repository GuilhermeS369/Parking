package com.bootcamp.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

    @LocalServerPort
    private int randomPort;

    @BeforeEach //ANOTAÇÃO JUNIT
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void wheFindAllThenCheckResult(){

    }

    @Test
    void create(){

    }

}