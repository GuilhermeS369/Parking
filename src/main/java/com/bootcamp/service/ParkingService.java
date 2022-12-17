package com.bootcamp.service;

import com.bootcamp.exception.ParkingNotFoundException;
import com.bootcamp.model.Parking;
import com.bootcamp.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;


        public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional
    public void delete(String id){
            findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Parking findById(String id){
        return parkingRepository.findById(id).orElseThrow(()->
                new ParkingNotFoundException(id));
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll(){
        return new ArrayList<>(parkingRepository.findAll());
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;

    }
    @Transactional
    public Parking update(String id, Parking toParking) {
        Parking parking = findById(id);
        parking.setColor(toParking.getColor());
        parkingRepository.save(parking);
        return toParking;

    }
    @Transactional
    public Parking exit(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(BillService.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
