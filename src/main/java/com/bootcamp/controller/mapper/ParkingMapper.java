package com.bootcamp.controller.mapper;

import com.bootcamp.controller.DTO.ParkingCreateDTO;
import com.bootcamp.controller.DTO.ParkingDTO;
import com.bootcamp.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Parking toParking(ParkingCreateDTO dto){
        return MODEL_MAPPER.map(dto, Parking.class);
    }
    public ParkingCreateDTO toParkingCreatedDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingCreateDTO.class);
    }

    public ParkingDTO toParkingDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
    return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }



}
