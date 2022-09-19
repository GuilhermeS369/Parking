package com.bootcamp.service;

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
        Parking parking = new Parking(id, "CKU-8318", "SP", "DK150", "RED");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
