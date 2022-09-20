package com.bootcamp.service;

import com.bootcamp.controller.DTO.ParkingDTO;
import com.bootcamp.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class ParkingService {

    private final static Map<String, Parking> parkingMap = new HashMap();

    static{
        var id = getUUID();
        var id2 = getUUID();
        var id3 = getUUID();
        var id4 = getUUID();
        Parking parking = new Parking(id, "CKU-8318", "SP", "DK150", "RED");
        Parking parking2 = new Parking(id2, "ACS-7949", "SP", "CIVIC", "BLACK");
        Parking parking3 = new Parking(id3, "DAQ-6541", "SP", "CAMARO", "YELLOW");
        Parking parking4 = new Parking(id4, "FET-7841", "SP", "MUSTANG", "WHITE");
        parkingMap.put(id, parking);
        parkingMap.put(id2, parking2);
        parkingMap.put(id3, parking3);
        parkingMap.put(id4, parking4);

    }

    public Parking findById(String id){
        return parkingMap.get(id);
    }

    public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
    }
    public Parking create(Parking parkingCreate) {
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(parkingCreate.getId(), parkingCreate);
        return parkingCreate;

    }


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }



}
