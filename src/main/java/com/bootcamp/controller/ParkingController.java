package com.bootcamp.controller;

import com.bootcamp.controller.DTO.ParkingCreateDTO;
import com.bootcamp.controller.DTO.ParkingDTO;
import com.bootcamp.controller.mapper.ParkingMapper;
import com.bootcamp.model.Parking;
import com.bootcamp.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private ParkingMapper parkingMapper;

    @GetMapping
    @ApiOperation("Find all parkings.")
    public ResponseEntity <List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find one parking.")
    public ResponseEntity <ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);

        return ResponseEntity.ok().body(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    @ApiOperation("Insert a parking.")
    public ResponseEntity<ParkingDTO> insert (@RequestBody ParkingCreateDTO dto){
        Parking parking2 = parkingService.create(parkingMapper.toParking(dto));
        ParkingDTO result = parkingMapper.toParkingDTO(parking2);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Delete a parking.")
    public ResponseEntity delete(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @ApiOperation("Update a parking.")
    public ResponseEntity<ParkingDTO> update (@PathVariable String id, @RequestBody ParkingCreateDTO dto){
        Parking parking2 = parkingService.update(id,parkingMapper.toParking(dto));
        ParkingDTO result = parkingMapper.toParkingDTO(parking2);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
