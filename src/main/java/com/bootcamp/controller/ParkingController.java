package com.bootcamp.controller;

import com.bootcamp.controller.DTO.ParkingCreateDTO;
import com.bootcamp.controller.DTO.ParkingDTO;
import com.bootcamp.controller.mapper.ParkingMapper;
import com.bootcamp.model.Parking;
import com.bootcamp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private ParkingMapper parkingMapper;

    @GetMapping
    public ResponseEntity <List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity <ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok().body(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> insert (@RequestBody ParkingCreateDTO dto){
        Parking parking2 = parkingService.create(parkingMapper.toParking(dto));
        ParkingDTO result = parkingMapper.toParkingDTO(parking2);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}
