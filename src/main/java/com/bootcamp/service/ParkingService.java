package com.bootcamp.service;

import com.bootcamp.exception.ParkingNotFoundException;
import com.bootcamp.model.Parking;
import com.bootcamp.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;


        public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public void delete(String id){
            findById(id);
        parkingRepository.deleteById(id);
    }

    public Parking findById(String id){
        return parkingRepository.findById(id).orElseThrow(()->
                new ParkingNotFoundException(id));

    }

    public List<Parking> findAll(){
        return new ArrayList<>(parkingRepository.findAll());
    }

    public Parking create(Parking parkingCreate) {
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;

    }
    public Parking update(String id, Parking toParking) {
        Parking parking = findById(id);
        parking.setColor(toParking.getColor());
        parkingRepository.save(parking);
        return toParking;

    }

    public Parking exit(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(BillService.calcular(parking.getEntryDate(), parking.getExitDate()));
        parkingRepository.save(parking);
        return parking;
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
