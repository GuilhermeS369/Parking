package com.bootcamp.service;


import com.bootcamp.model.Parking;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class BillService {
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24* ONE_HOUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;

    public static double getBill(Parking parking){
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    public static Double getBill(LocalDateTime entry,LocalDateTime exit) {

        long minutes = entry.until(exit, ChronoUnit.MINUTES);

        Double bill = 0.0;
        //Caso seja menor que uma hora, retorna valor de uma hora
        if (minutes <= ONE_HOUR) {
            return ONE_HOUR_VALUE;
        }

        //Caso seja menor que a quantidade de minutos de 24 horas então
        if (minutes <= TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_VALUE;
            //Descobrindo as horas
            int hours = (int) (minutes / ONE_HOUR);
            System.out.println(hours);
            //Para cada hora adicional, adicione;
            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }
        //Caso passe de varios dias
        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        System.out.println(days);
        for (int i = 0; i < days; i++) {
            bill += DAY_VALUE;
        }
        return bill;


    }

}
