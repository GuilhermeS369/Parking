package com.bootcamp.controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ParkingCreateDTO {

    private String license;
    private String state;
    private String model;
    private String color;

}
