package com.mycarservice.services;

import com.mycarservice.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {
    private static List<CarDto> carInstances = new ArrayList<>(Arrays.asList(
            new CarDto(2101, "VAZ", "Lada 2101")));
//TODO: clarify mutable imutable object ArrayList

    public static List<CarDto> getCarInstances() {
        return carInstances;
    }

    public void addCarInstance(CarDto carDto) {
        carInstances.add(carDto);
    }
}