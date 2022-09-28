package com.bootcamp.service;

import com.bootcamp.exception.ParkingNotFoundException;
import com.bootcamp.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

    public void delete(String id){
        findById(id);
        parkingMap.remove(id);
    }

    public Parking findById(String id){
        Parking parking = parkingMap.get(id);
        if(parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
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


    public Parking update(String id, Parking toParking) {
    Parking parking = findById(id);
    parking.setColor(toParking.getColor());
    parkingMap.replace(id, parking);
    return toParking;

    }

    public Parking exit(String id) {
    Parking parking = findById(id);
    parking.setExitDate(LocalDateTime.now());
    parking.setBill(BillService.calcular(parking.getEntryDate(), parking.getExitDate()));
    parkingMap.put(id,parking);
    return parking;
    }
}
