package com.bootcamp.controller;

import com.bootcamp.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ParkingController {
    @GetMapping
    public List<Parking> findAll(){
        var parking = new Parking();
        parking.setColor("VERMELHA");
        parking.setLicense("CKU-8318");
        parking.setModel("DK150");
        parking.setState("SP");

        return Arrays.asList(parking, parking);
    }

}
