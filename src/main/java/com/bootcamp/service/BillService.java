package com.bootcamp.service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


public class BillService {
    public static Double calcular(LocalDateTime entry,LocalDateTime exit){
        double valorBase = 5.00;

        ZonedDateTime zdt = entry.atZone(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime zdt2 = exit.atZone(ZoneId.of("America/Sao_Paulo"));

       long diff = zdt2.toInstant().toEpochMilli() - zdt.toInstant().toEpochMilli();
       double hours = (double) diff / 1000 / 60 / 60;

        return hours * valorBase;
    }


}
