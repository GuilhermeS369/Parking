package com.bootcamp.controller;

import com.bootcamp.controller.DTO.ParkingDTO;
import com.bootcamp.controller.mapper.ParkingMapper;
import com.bootcamp.model.Parking;
import com.bootcamp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private ParkingMapper parkingMapper;



    @GetMapping
    public List<ParkingDTO> findAll(){

        List<Parking> parkingList = parkingService.findAll();

        return parkingMapper.toParkingDTOList(parkingList);

    }

}
